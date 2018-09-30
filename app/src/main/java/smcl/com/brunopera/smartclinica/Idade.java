package smcl.com.brunopera.smartclinica;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Idade extends AppCompatActivity {

    //https://www.youtube.com/watch?v=ND6a4V-xdjI
    //https://pt.stackoverflow.com/questions/50773/como-usar-onactivityresult-quando-h%C3%A1-mais-de-um-startactivityforresult

    private final int REQ_CODE_SPEECH_OUTPUT = 1;


    //classe cadastro
    private Cadastro cad = new Cadastro();
    //Array que recebe primeiramente o que foi falado (nome, sobrenome e idade)
    private ArrayList<String> voiceInText;
    EditText editIdade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idade);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        editIdade = (EditText)findViewById(R.id.editIdadeT);
        editIdade.setEnabled(false);
        openMic();

    }

    private void openMic() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Olá, qual a sua idade?");
        intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_MINIMUM_LENGTH_MILLIS, 20000000);

        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_OUTPUT);
        } catch (ActivityNotFoundException tim) {

            Toast.makeText(getApplicationContext(), "Opa! seu aparelho não suporta reconhecimento de voz para aplicativos", Toast.LENGTH_SHORT).show();
        }

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_OUTPUT: {
                if (resultCode == RESULT_OK && null != data) {


                    try {
                        voiceInText = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                        editIdade.setText(voiceInText.get(0).toString());

                        Log.i("AQUI", voiceInText.toString());


                      //  ConexaoBD cbd = new ConexaoBD();
                      //  cbd.inserirIdadeBD(voiceInText);
                      // Toast.makeText(getApplicationContext(), "Dados cadastrados com sucesso!", Toast.LENGTH_SHORT).show();



                    }catch(Exception ex){
                        Toast.makeText(getApplicationContext(), "Não foi possível gravar a idade, tente de novo", Toast.LENGTH_SHORT).show();
                        openMic();
                        break;
                    }
                }

                //Intent myIntent = new Intent(getApplicationContext(), Teste.class);
               // startActivityForResult(myIntent, 0);
                break;

                //final do case
            }
        }
    }


    public void abrirMic(View view){
        openMic();

    }

    public void editarIdade(View view){
        editIdade.setEnabled(true);
        ConexaoBD cbd = new ConexaoBD();
        cbd.inserirIdadeBDCorreacao(editIdade.getText().toString());
    }

    public void proximaTela(View view){


        ConexaoBD cbd = new ConexaoBD();
        cbd.inserirIdadeBD(voiceInText);
        Toast.makeText(getApplicationContext(), "Dados cadastrados com sucesso!", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(this, Aniversario.class));
        //fechar activity de login
       // finish();





    }

}
