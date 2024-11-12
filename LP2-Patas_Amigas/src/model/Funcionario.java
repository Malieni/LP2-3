package model;

public class Funcionario extends Pessoa {
    private String cargo;

    public Funcionario(String nome, String dataNascimento, String cpf, String cargo) {
        //Estou testando esse super pra ver como funciona se der bom mantém :)
        super(nome, dataNascimento, cpf);
        this.cargo = cargo;
        // cargo seria se ele é adotante ou tutor etc...
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return super.toString() + ", Cargo: " + cargo;
    }
}
