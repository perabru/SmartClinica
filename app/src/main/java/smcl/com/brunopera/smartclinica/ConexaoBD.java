package smcl.com.brunopera.smartclinica;

import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import smcl.com.brunopera.smartclinica.helper.Base64Custom;

public class ConexaoBD {

    //FiREBASE - vai no nó raiz do firebase
    static DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    //adiciona a child cadastro em um objeto
    static DatabaseReference prontuario = referencia.child("prontuario");

   public static String uniquePK = prontuario.push().getKey();



    private static FirebaseAuth autenticacao;


    Cadastro cad = new Cadastro();

    String[] parts;

    //String newPK;

       /* public void quebrarString (String teste){
            String [] partes = teste.split("-");
             newPK = partes[2];
        }*/


   // public  String uniquePK = Base64Custom.codificarBase64(cad.getEmail());

    public void inserirNomeBD(String nome) {

        cad.setNome(nome);
        //cad.setDataAtual(cad.getDataAtual());
        prontuario.child(uniquePK).child("Nome").setValue(cad);
    }

    public void inserirIdadeBD(ArrayList<String> idade) {

        //corta o array para gravar apenas o numero da idade no banco
        String[] str = new String[idade.size()];
        idade.toArray(str);
        parts = str[0].split("\\s+");


        prontuario.child(uniquePK).child("Idade").setValue(Integer.parseInt(parts[0]));

    }


    public void inserirIdadeBDCorreacao(String idade) {

             prontuario.child(uniquePK).child("Idade").setValue(cad);

    }
    public void inserirDataNasc(String dataNascimento) {

        cad.setDataAniversario(dataNascimento);
        prontuario.child(uniquePK).child("Data Nascimento").setValue(cad);

    }

    public void inserirEstadoCivil(String estadoCivil) {

        cad.setEstadoCivil(estadoCivil);
        prontuario.child(uniquePK).child("Estado Civil").setValue(cad);

    }

    public void inserirEndereco(String endereco) {

        cad.setEndereco(endereco);
        prontuario.child(uniquePK).child("Endereço").setValue(cad);

    }

    public void inserirBairro(String bairro) {

        cad.setEndereco(bairro);
        prontuario.child(uniquePK).child("Bairro").setValue(cad);

    }


    public void inserirCidade(String cidade) {

        cad.setEndereco(cidade);
        prontuario.child(uniquePK).child("Cidade").setValue(cad);

    }

    public void inserirCEP(String CEP) {

        cad.setEndereco(CEP);
        prontuario.child(uniquePK).child("CEP").setValue(cad);

    }

    public void inserirTelefone(String telefone) {

        cad.setTelefone(telefone);
        prontuario.child(uniquePK).child("Telefone").setValue(cad);

    }


    public void inserirCelular(String celular) {

        cad.setCelular(celular);
        prontuario.child(uniquePK).child("Celular").setValue(cad);

    }

    public void inserirProfissao(String profissao) {

        cad.setProfissao(profissao);
        prontuario.child(uniquePK).child("Profissao").setValue(cad);

    }

    public void inserirEmail(String email) {

        //email.replaceAll("arroba","@");
        cad.setEmail(email.replaceAll("\\s+",""));
        prontuario.child(uniquePK).child("E-mail").setValue(cad);

    }

    public void inserirData() {
        Calendar data = Calendar.getInstance();
        String dataAtual = DateFormat.getDateInstance().format(data.getTime());

        prontuario.child(uniquePK).child("Data").setValue(dataAtual);

    }

    public void inserirLocalizacao(String localizacaoAtual) {


        prontuario.child(uniquePK).child("Localização Atual").setValue(localizacaoAtual);

    }


    //retorna instancia do fb
    public static FirebaseAuth getFirebaseAutenicacao(){

        if(autenticacao == null) {
            autenticacao = FirebaseAuth.getInstance();
        }
        return autenticacao;

    }


}