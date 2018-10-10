package smcl.com.brunopera.smartclinica;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;

public class PrincipalActivity extends AppCompatActivity {

    private FirebaseAuth autenticacao;
    private TextView txtOla;

    ConexaoBD conexaoBD = new ConexaoBD();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;

        txtOla = findViewById(R.id.txtOla);

        //txtOla.setText();
        Log.i("USER",currentFirebaseUser.toString() );



    }

    public void desconectarUsuario(View view) {

        autenticacao = ConexaoBD.getFirebaseAutenicacao();


        autenticacao.signOut();
        startActivity(new Intent(this, LoginActivity.class));
        Toast.makeText(PrincipalActivity.this, "Usuario desconectado!", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void iniciarChat(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("CHAT");
        builder.setMessage("Ainda não está disponível o chat");
        builder.setCancelable(false);
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void enviarEmail(View view) {

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","brunomichel00@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Contato - ");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Bom dia...");
        startActivity(Intent.createChooser(emailIntent, "Enviar e-mail..."));
    }

  public void iniciarProntuario(View view) {

      startActivity(new Intent(this, Idade.class));
     // finish();

    }





}
