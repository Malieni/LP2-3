package model;
import java.time.LocalDate;
import java.util.Scanner;

public class Tutores extends Pessoa implements Papel {

    // Atributos privados da classe Tutores
    private int idTutor;
    private int animaisCustodia;
    private HistoricoTutor historicoTutor;
    private Boolean status;

    // Construtor da classe Tutores
    public Tutores(String nome, LocalDate nascimento, String genero, String CPF, String logradouro, String numero, String bairro, String cidade, String estado, String pais, String telefone, String email, String hashsenha, int idTutor, int animaisCustodia, HistoricoTutor historicoTutor, Boolean status) {

        // Chama o construtor da classe Pessoa para inicializar os atributos que foram herdados
        super(nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade, estado, pais, telefone, email, hashsenha);

        this.idTutor = idTutor;
        this.animaisCustodia = animaisCustodia;
        this.historicoTutor = historicoTutor;
        this.status = status;
    }

    @Override
    public void exibirDetalhes() {
        System.out.printf("%-25s %-30s\n", "Tutor ID: ", idTutor);
        System.out.printf("%-25s %-30s\n", "Animais sob Custódia: ", animaisCustodia);
        System.out.printf(historicoTutor.exibirHistoricoTutor());
        System.out.printf("%-25s %-30s\n", "O status eh:", status ? "Ativo" : "Inativo");
        //Perguntar a diferença pro Quirino de usar status e de usar o construtor com o this.getStatus()
    }

    @Override
    public void editarDetalhes(Scanner scanner) {
        System.out.println("Editando informações de Tutor");
        System.out.println("1 - Número de animais sob custódia");
        System.out.println("2 - Histórico");
        System.out.println("3 - Status (ativo/inativo)");
        System.out.println();
        System.out.printf("Escolha o atributo que deseja editar: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        switch (opcao) {
            case 1:
                System.out.println("Digite o novo número de animais sob custódia:");
                int animaisCustodia = scanner.nextInt();
                this.setAnimaisCustodia(animaisCustodia);
                break;

            case 2:
                System.out.print("Digite a nova descrição do histórico: ");
                String descricaoHistoricoT = scanner.nextLine();
                System.out.print("Digite o novo número de adoções: ");
                int numeroAdocoesT = Integer.parseInt(scanner.nextLine());

                HistoricoTutor historico_tutor = new HistoricoTutor(descricaoHistoricoT, numeroAdocoesT);

                this.setHistoricoTutor(historico_tutor);

                break;

            case 3:
                System.out.println("Digite o novo status (ativo/inativo):");
                String resposta = scanner.nextLine();
                boolean novoStatus = resposta.equalsIgnoreCase("ativo");
                this.setStatus(novoStatus);
                break;

            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    @Override
    public String getNomePapel() {
        return "Tutor";
    }

    // Chama o construtor
    public int getIdTutor() {
        return idTutor;
    }

    // Getters e Setters 
    public void setIdTutor(int id_tutor) {
        this.idTutor = id_tutor;
    }

    public int getAnimaisCustodia() {
        return animaisCustodia;
    }

    public void setAnimaisCustodia(int animais_custodia) {
        this.animaisCustodia = animais_custodia;
    }

    public HistoricoTutor getHistoricoTutor() {
        return historicoTutor;
    }

    public void setHistoricoTutor(HistoricoTutor historico_tutor) {
        this.historicoTutor = historico_tutor;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
