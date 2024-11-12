package model;

public abstract class Pessoa {
    private String nome;
    private String dataNascimento;
    private String cpf;

    public Pessoa(String nome, String dataNascimento, String cpf) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s, Data de Nascimento: %s, CPF: %s", nome, dataNascimento, cpf);
    }
}
