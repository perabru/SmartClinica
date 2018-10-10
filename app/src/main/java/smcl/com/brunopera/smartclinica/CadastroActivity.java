package smcl.com.brunopera.smartclinica;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

import java.text.SimpleDateFormat;
import java.util.Date;

import smcl.com.brunopera.smartclinica.helper.Base64Custom;

public class CadastroActivity extends AppCompatActivity {

    private EditText campoNome, campoEmail, campoSenha;
    private Button botaoCadastrar;
    private FirebaseAuth autenticacao;


    public static TextView txtID;



    private Cadastro usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        txtID = findViewById(R.id.txtID);

        campoNome = findViewById(R.id.editNome);
        campoEmail = findViewById(R.id.editEmail);
        campoSenha = findViewById(R.id.editSenha);
        botaoCadastrar = findViewById(R.id.buttonCadastrar);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoNome = campoNome.getText().toString();
                String textoEmail = campoEmail.getText().toString();
                String textoSenha = campoSenha.getText().toString();

                //Validar se os campos foram digitados.
                if(!textoNome.isEmpty()){
                    if(!textoEmail.isEmpty()){
                        if(!textoSenha.isEmpty()){
                            //Realizar o cadastro do usuario

                            usuario = new Cadastro();
                            usuario.setNome(textoNome);
                            usuario.setEmail(textoEmail);
                            usuario.setSenha(textoSenha);

                            txtID.setText(Base64Custom.codificarBase64(textoEmail));





                            cadastrarUsuario();

                            ConexaoBD conexaoBD = new ConexaoBD();
                            conexaoBD.inserirNomeBD(usuario.getNome());
                            conexaoBD.inserirEmail(usuario.getEmail());
                            conexaoBD.inserirData();



                        }else{
                            Toast.makeText(CadastroActivity.this,"Preencha a senha", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(CadastroActivity.this,"Preencha o email", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(CadastroActivity.this,"Preencha o nome", Toast.LENGTH_SHORT).show();

                }




            }
        });

    }



    public  void cadastrarUsuario(){
        autenticacao = ConexaoBD.getFirebaseAutenicacao();

        autenticacao.createUserWithEmailAndPassword(
                usuario.getEmail(), usuario.getSenha()

        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if( task.isSuccessful()){
                    Toast.makeText(CadastroActivity.this,"Sucesso ao cadastrar usuário", Toast.LENGTH_SHORT).show();


                    /*String pk = Base64Custom.codificarBase64(usuario.getEmail());
                    usuario.setChavePrimaria(pk);*/

                    startActivity(new Intent(getApplicationContext(), PrincipalActivity.class));
                    finish();
                }else{

                    String excecao ="";
                    try{
                        throw task.getException();
                    } catch(FirebaseAuthWeakPasswordException e){
                        excecao ="Digite uma senha mais forte";

                    } catch (FirebaseAuthInvalidCredentialsException e){
                        excecao = "Por favor, digite um email válido";
                    }
                    catch (FirebaseAuthUserCollisionException e){
                        excecao = "Essa conta ja foi cadastrada";
                    }
                    catch (Exception e){
                        excecao ="Erro ao cadastrar usuário: "+e.getMessage();
                        e.printStackTrace();
                    }
                    Toast.makeText(CadastroActivity.this,excecao, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public static TextView getTxtID() {
        return txtID;
    }

    public EditText getCampoEmail() {
        return campoEmail;
    }

    public void setCampoEmail(EditText campoEmail) {
        this.campoEmail = campoEmail;
    }
}
