package model;

public class Animal {

    private Integer idAnimal;
    private String nome;
    private String especie;
    private Integer idade;
    private HistoricoMedico historicoMed;
    private Boolean statusAdocao;
    private String tutor;

    public Animal(Integer idAnimal, Integer idade, String nome, String especie, HistoricoMedico historicoMed, Boolean statusAdocao, String tutor) {
        this.idAnimal = idAnimal;
        this.nome = nome;
        this.especie = especie;
        this.historicoMed = historicoMed;
        this.statusAdocao = statusAdocao;
        this.tutor = tutor;
        this.idade = idade;
    }

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public HistoricoMedico getHistoricoMed() {
        return historicoMed;
    }

    public void setHistoricoAdotante(HistoricoMedico historicoMed) {
        this.historicoMed = historicoMed;
    }

    public Boolean getStatusAdocao() {
        return statusAdocao;
    }

    public void setStatusAdocao(Boolean statusAdocao) {
        this.statusAdocao = statusAdocao;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    @Override
    public String toString() {
        return "Animal: " + nome
                + "especie: " + especie
                + ", idade: " + idade
                + ", historico: " + historicoMed
                + ", statusAdocao: " + statusAdocao
                + ", tutor: " + tutor;
    }
}
