package model;
import java.time.LocalDate;
import java.util.Scanner;

public class Funcionarios extends Pessoa implements Papel {

    // Atributos privados da classe Funcionarios
    private int idFuncionario;
    private LocalDate dataContratacao;
    private String cargo, departamento;
    private Float salario;

    // Construtor da classe Funcionarios
    public Funcionarios(String nome, LocalDate nascimento, String genero, String CPF, String logradouro, String numero, String bairro, String cidade, String estado, String pais, String telefone, String email, String hashsenha, int idFuncionario, LocalDate dataContratacao, String cargo, Float salario, String departamento) {

        // Chama o construtor da classe Pessoa para inicializar os atributos que foram herdados
        super(nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade, estado, pais, telefone, email, hashsenha);

        this.idFuncionario = idFuncionario;
        this.dataContratacao = dataContratacao;
        this.cargo = cargo;
        this.salario = salario;
        this.departamento = departamento;
    }

    @Override
    public void exibirDetalhes() {
        System.out.printf("%-25s %-30s\n", "ID do Funcionário:", idFuncionario);
        System.out.printf("%-25s %-30s\n", "Data de contratação: ", dataContratacao);
        System.out.printf("%-25s %-30s\n", "Cargo: ", cargo);
        System.out.printf("%-25s R$%-30.2f\n", "Salário:", salario);
        System.out.printf("%-25s %-30s\n", "Departamento: ", departamento);

    }

    @Override
    public void editarDetalhes(Scanner scanner) {
        System.out.println("Editando informações de Funcionário");
        System.out.println("1 - Cargo");
        System.out.println("2 - Salário");
        System.out.println("3 - Departamento");
        System.out.println();
        System.out.printf("Escolha o atributo que deseja editar: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        switch (opcao) {
            case 1:
                System.out.println("Digite o novo cargo:");
                this.setCargo(scanner.nextLine());
                break;
            case 2:
                System.out.println("Digite o novo salário:");
                this.setSalario(scanner.nextFloat());
                scanner.nextLine(); // Consumir a nova linha
                break;
            case 3:
                System.out.println("Digite o novo departamento:");
                this.setDepartamento(scanner.nextLine());
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    @Override
    public String getNomePapel() {
        return "Funcionário";
    }

    // Chama o construtor
    public int getIdFuncionario() {
        return idFuncionario;
    }

    // Getters e Setters
    public void setIdFuncionario(int id_funcionario) {
        this.idFuncionario = id_funcionario;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate data_contratacao) {
        this.dataContratacao = data_contratacao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

}
