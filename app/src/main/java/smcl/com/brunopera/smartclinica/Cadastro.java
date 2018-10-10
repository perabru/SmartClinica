package smcl.com.brunopera.smartclinica;

import android.util.Log;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Cadastro {

    private String nome;
     private Calendar data = Calendar.getInstance();
      private String dataAtual = DateFormat.getDateInstance().format(data.getTime());
    private String dataAniversario;
    private String estadoCivil;
    private String endereco;
    private String bairro;
    private String cidade;
    private String CEP;
    private String telefone;
    private String celular;
    private String profissao;
    private String email;
    private String senha;
    private String idUsuario;
    private String diagnostico;
    private String medicoResponsavel;
    private String historia;
    private String medicamentos;
    private String orteseDispositivoAuxilio;
    private String pressaoArterial;
    private String frequenciaCardiaca;
    private String reflexosOsteotendineos;
    private String tonusMuscular;
    private String sensibilidadeSuperficial;
    private String sensibilidadeProfunda;
    private String trocasPosturais;
    private String forcaMuscularPorSeguimento;
    private String encurtamentoPorSeguimento;
    private String complicacoesEDeformidadesPorSeguimento;
    private String conclusao;
    private String metas;


    private String chavePrimaria;


    public Cadastro() {

    }

    public String getChavePrimaria() {
        return chavePrimaria;
    }

    public void setChavePrimaria(String chavePrimaria) {
        this.chavePrimaria = chavePrimaria;
    }

    public String getTrocasPosturais() {
        return trocasPosturais;
    }

    public void setTrocasPosturais(String trocasPosturais) {
        this.trocasPosturais = trocasPosturais;
    }

    public String getForcaMuscularPorSeguimento() {
        return forcaMuscularPorSeguimento;
    }

    public void setForcaMuscularPorSeguimento(String forcaMuscularPorSeguimento) {
        this.forcaMuscularPorSeguimento = forcaMuscularPorSeguimento;
    }

    public String getEncurtamentoPorSeguimento() {
        return encurtamentoPorSeguimento;
    }

    public void setEncurtamentoPorSeguimento(String encurtamentoPorSeguimento) {
        this.encurtamentoPorSeguimento = encurtamentoPorSeguimento;
    }

    public String getComplicacoesEDeformidadesPorSeguimento() {
        return complicacoesEDeformidadesPorSeguimento;
    }

    public void setComplicacoesEDeformidadesPorSeguimento(String complicacoesEDeformidadesPorSeguimento) {
        this.complicacoesEDeformidadesPorSeguimento = complicacoesEDeformidadesPorSeguimento;
    }

    public String getConclusao() {
        return conclusao;
    }

    public void setConclusao(String conclusao) {
        this.conclusao = conclusao;
    }

    public String getMetas() {
        return metas;
    }

    public void setMetas(String metas) {
        this.metas = metas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public void setMedicoResponsavel(String medicoResponsavel) {
        this.medicoResponsavel = medicoResponsavel;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getOrteseDispositivoAuxilio() {
        return orteseDispositivoAuxilio;
    }

    public void setOrteseDispositivoAuxilio(String orteseDispositivoAuxilio) {
        this.orteseDispositivoAuxilio = orteseDispositivoAuxilio;
    }

    public String getPressaoArterial() {
        return pressaoArterial;
    }

    public void setPressaoArterial(String pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    public String getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    public void setFrequenciaCardiaca(String frequenciaCardiaca) {
        this.frequenciaCardiaca = frequenciaCardiaca;
    }

    public String getTonusMuscular() {
        return tonusMuscular;
    }

    public void setTonusMuscular(String tonusMuscular) {
        this.tonusMuscular = tonusMuscular;
    }

    public String getSensibilidadeSuperficial() {
        return sensibilidadeSuperficial;
    }

    public void setSensibilidadeSuperficial(String sensibilidadeSuperficial) {
        this.sensibilidadeSuperficial = sensibilidadeSuperficial;
    }

    public String getSensibilidadeProfunda() {
        return sensibilidadeProfunda;
    }

    public void setSensibilidadeProfunda(String sensibilidadeProfunda) {
        this.sensibilidadeProfunda = sensibilidadeProfunda;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(String dataAniversario) {
        this.dataAniversario = dataAniversario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }



    public String getReflexosOsteotendineos() {
        return reflexosOsteotendineos;
    }

    public void setReflexosOsteotendineos(String reflexosOsteotendineos) {
        this.reflexosOsteotendineos = reflexosOsteotendineos;
    }


}
