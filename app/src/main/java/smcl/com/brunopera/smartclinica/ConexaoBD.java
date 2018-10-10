package smcl.com.brunopera.smartclinica;

import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import smcl.com.brunopera.smartclinica.helper.Base64Custom;

import static android.content.Context.MODE_PRIVATE;



public class ConexaoBD {


        String idUsuario;

//    static String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();


    //FiREBASE - vai no nó raiz do firebase
    static DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    //adiciona a child cadastro em um objeto
   static DatabaseReference prontuario = referencia.child("prontuario");
   // static DatabaseReference prontuario = referencia.child(currentuser);


    static CadastroActivity ca = new CadastroActivity();
    private static String uniquePK = prontuario.push().getKey();

   // public static String uniquePK =FirebaseAuth.getInstance().getCurrentUser().getUid();

    private static FirebaseAuth autenticacao;

     Cadastro cad = new Cadastro();
    //public  String uniquePK = this.cad.getChavePrimaria();

    String[] parts;

    //String newPK;

       /* public void quebrarString (String teste){
            String [] partes = teste.split("-");
             newPK = partes[2];
        }*/


   // public  String uniquePK = Base64Custom.codificarBase64(cad.getEmail());


    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }



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



    public void inserirDiagnostico() {
      // cad.setDiagnostico("AGUARDANDO ATUALIZAÇÃO");
        prontuario.child(uniquePK).child("Diagnóstico");

    }

    public void inserirMedicoResponsavel() {
       // cad.setMedicoResponsavel("AGUARDANDO ATUALIZAÇÃO");
        prontuario.child(uniquePK).child("Médico Responsável");

    }

    public void inserirHistoria() {
        //cad.setHistoria("AGUARDANDO ATUALIZAÇÃO");
        prontuario.child(uniquePK).child("História");

    }

    public void inserirMedicamentos(String medicamentos) {
        cad.setMedicamentos(medicamentos);
        prontuario.child(uniquePK).child("Medicamentos").setValue(cad);

    }


    public void inserirOrteses(String orteses) {
       cad.setOrteseDispositivoAuxilio(orteses);
        prontuario.child(uniquePK).child("Órteses ou dispositivo de auxilio").setValue(cad);

    }


    public void inserirPA() {
       // cad.setPressaoArterial("AGUARDANDO ATUALIZAÇÃO");
        prontuario.child(uniquePK).child("PA (mmHG)").setValue("AGUARDANDO ATUALIZAÇÃO");

    }

    public void inserirFC() {
        cad.setFrequenciaCardiaca("AGUARDANDO ATUALIZAÇÃO");
        prontuario.child(uniquePK).child("FC (bpm)").setValue("AGUARDANDO ATUALIZAÇÃO");

    }

    public void reflexosOsteotendineos() {
      //  cad.setReflexosOsteotendineos("AGUARDANDO ATUALIZAÇÃO");
        prontuario.child(uniquePK).child("Reflexos Osteotendineos").setValue("AGUARDANDO ATUALIZAÇÃO");

    }

    public void tonusMuscular() {
        //cad.setTonusMuscular("AGUARDANDO ATUALIZAÇÃO");
        prontuario.child(uniquePK).child("Tonus Muscular").setValue("AGUARDANDO ATUALIZAÇÃO");

    }

    public void sensibilidadeSuperficial() {
        //cad.setSensibilidadeSuperficial("AGUARDANDO ATUALIZAÇÃO");
        prontuario.child(uniquePK).child("Sensibilidade Superficial").setValue("AGUARDANDO ATUALIZAÇÃO");

    }


    public void sensibilidadeProfunda() {
        //cad.setSensibilidadeProfunda("AGUARDANDO ATUALIZAÇÃO");
        prontuario.child(uniquePK).child("Sensibilidade Profunda").setValue("AGUARDANDO ATUALIZAÇÃO");

    }

    public void trocasPosturais() {
        cad.setTrocasPosturais("AGUARDANDO ATUALIZAÇÃO");
        prontuario.child(uniquePK).child("Trocas Posturais").setValue("AGUARDANDO ATUALIZAÇÃO");

    }

    public void forcaMuscularPorSeguimento() {
        //cad.setForcaMuscularPorSeguimento("AGUARDANDO ATUALIZAÇÃO");
        prontuario.child(uniquePK).child("Força Muscular por segmento").setValue("AGUARDANDO ATUALIZAÇÃO");

    }
    public void encurtamentoPorSegmento() {
        //cad.setEncurtamentoPorSeguimento("AGUARDANDO ATUALIZAÇÃO");
        prontuario.child(uniquePK).child("Encurtamento por seguimento").setValue("AGUARDANDO ATUALIZAÇÃO");

    }

    public void complicacoesEDeformidadesPorSeguimento() {
       // cad.setComplicacoesEDeformidadesPorSeguimento("AGUARDANDO ATUALIZAÇÃO");
        prontuario.child(uniquePK).child("Complicações e deformidades por seguimento").setValue("AGUARDANDO ATUALIZAÇÃO");

    }

    public void conclusao() {
        //cad.setConclusao("AGUARDANDO ATUALIZAÇÃO");
        prontuario.child(uniquePK).child("Conclusão").setValue("AGUARDANDO ATUALIZAÇÃO");

    }

    public void metas() {
        //cad.setMetas("AGUARDANDO ATUALIZAÇÃO");
        prontuario.child(uniquePK).child("Metas").setValue("AGUARDANDO ATUALIZAÇÃO");

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


    public static String getUniquePK() {
        return uniquePK;
    }

    public static void setUniquePK(String uniquePK) {
        ConexaoBD.uniquePK = uniquePK;
    }




    //Recuperar usuario para tela inicial
    public void recuperar ( TextView user){





/*
        DatabaseReference prontuario2 = referencia.child("prontuario").child("-LOE0R5FbhIyeG1fbV0e").child("Nome").child("nome");
        prontuario2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                user.setText("Olá, "+dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/
    }


}