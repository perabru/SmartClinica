package smcl.com.brunopera.smartclinica;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class LoginActivity extends AppCompatActivity {

    private EditText campoEmail, campoSenha;
    private Button botaEntrar;
    private Cadastro cadastro;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        campoEmail = findViewById(R.id.editEmail);
        campoSenha = findViewById(R.id.editSenha);
        botaEntrar = findViewById(R.id.buttonEntrar);

        botaEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Validar se o email e a senha foram digitados

                String textoEmail = campoEmail.getText().toString();
                String textoSenha = campoSenha.getText().toString();

                if(!textoEmail.isEmpty()){
                    if(!textoSenha.isEmpty()){

                    cadastro = new Cadastro();
                    cadastro.setEmail(textoEmail);
                    cadastro.setSenha(textoSenha);
                    validarLogin();


                    }else{

                        Toast.makeText(LoginActivity.this,"Preencha a senha", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(LoginActivity.this,"Preencha o email", Toast.LENGTH_SHORT).show();
                }


            }
        });



    }


    public void validarLogin(){

        autenticacao = ConexaoBD.getFirebaseAutenicacao();
        autenticacao.signInWithEmailAndPassword(
          cadastro.getEmail(),
          cadastro.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){

                    Toast.makeText(LoginActivity.this,"Sucesso fazer login", Toast.LENGTH_SHORT).show();

                    abrirTelaPrincipal();


                }else {

                    String excecao ="";
                    try{
                        throw task.getException();
                    }
                    catch (FirebaseAuthInvalidUserException e){
                        excecao = "Usuário inexistente ou inválido";
                    }
                    catch (FirebaseAuthInvalidCredentialsException e){
                        excecao = "E-mail e senha não correspondem a um usuário cadastrado";
                    }
                    catch (Exception e){
                        excecao =excecao +e.getMessage();
                        e.printStackTrace();
                    }

                    Toast.makeText(LoginActivity.this,"Erro ao fazer login", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

        public void abrirTelaPrincipal(){
            startActivity(new Intent(this, PrincipalActivity.class));
            //fechar activity de login
            finish();

        }

}
