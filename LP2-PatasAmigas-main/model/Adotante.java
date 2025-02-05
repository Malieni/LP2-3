package model;

import java.time.LocalDate;
import java.util.Scanner;

public class Adotante extends Pessoa implements Papel {

    // Atributos privados da classe Adotantes
    private int idAdotante;
    private PreferenciaAdocao preferenciaAdocao;
    private HistoricoAdotante historicoAdotante;
    private Boolean status;

    // Construtor da classe Adotante
    public Adotante(String nome, LocalDate nascimento, String genero, String CPF, String logradouro, String numero,
            String bairro, String cidade, String estado, String pais, String telefone, String email, String hashsenha,
            int idAdotante, PreferenciaAdocao preferenciaAdocao, HistoricoAdotante historicoAdotante, Boolean status) {

        super(nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade, estado, pais, telefone, email,
                hashsenha);

        // Inicializa os atributos específicos de Adotante
        this.idAdotante = idAdotante;
        this.preferenciaAdocao = preferenciaAdocao;
        this.historicoAdotante = historicoAdotante;
        this.status = status;
    }

    @Override
    public void exibirDetalhes() {
        System.out.printf("%-25s %-30s\n", "ID do Adotante:", idAdotante);
        System.out.println(preferenciaAdocao.exibirPreferenciaAdocao());
        System.out.println(historicoAdotante.exibirHistoricoAdotante());
        System.out.printf("%-25s %-30s\n", "Status:", status ? "Ativo" : "Inativo");
    }

    @Override
    public void editarDetalhes(Scanner scanner) {
        System.out.println("Editando informações de Adotante");
        System.out.println("1 - Preferência de Adoção");
        System.out.println("2 - Histórico de Adoção");
        System.out.println("3 - Status (ativo/inativo)");
        System.out.printf("Escolha o atributo que deseja editar: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        switch (opcao) {
            case 1:
                this.preferenciaAdocao.editarPreferencia(scanner);
                break;

            case 2:
                this.historicoAdotante.editarHistorico(scanner);
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
        return "Adotante";
    }

    // Chama o construtor
    public int getIdAdotante() {
        return idAdotante;
    }

    // Getters e Setters
    public void setIdAdotante(int id_adotante) {
        this.idAdotante = id_adotante;
    }

    public PreferenciaAdocao getPreferenciaAdocao() {
        return preferenciaAdocao;
    }

    public void setPreferenciaAdocao(PreferenciaAdocao preferencia_adocao) {
        this.preferenciaAdocao = preferencia_adocao;
    }

    public HistoricoAdotante getHistorico_Adotante() {
        return historicoAdotante;
    }

    public void setHistoricoAdotante(HistoricoAdotante historico_adotante) {
        this.historicoAdotante = historico_adotante;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
