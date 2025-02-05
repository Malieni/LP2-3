package model;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class HistoricoAdotante {

    private String descricaoAdotante;
    private int numeroAdocoes;
    private LocalDate dataUltimaAdocao;
    private List<Animal> animaisAdotados;

    public HistoricoAdotante(String descricaoAdotante, int numeroAdocoes, LocalDate dataUltimaAdocao, List<Animal> animaisAdotados) {
        this.descricaoAdotante = descricaoAdotante;
        this.numeroAdocoes = numeroAdocoes;
        this.dataUltimaAdocao = dataUltimaAdocao;
        this.animaisAdotados = animaisAdotados;
    }

    // Getters e Setters
    public String getDescricaoAdotante() {
        return descricaoAdotante;
    }

    public void setDescricaoAdotante(String descricao) {
        this.descricaoAdotante = descricao;
    }

    public int getNumeroAdocoes() {
        return numeroAdocoes;
    }

    public void setNumeroAdocoes(int numeroAdocoes) {
        this.numeroAdocoes = numeroAdocoes;
    }

    public LocalDate getDataUltimaAdocao() {
        return dataUltimaAdocao;
    }

    public void setDataUltimaAdocao(LocalDate dataUltimaAdocao) {
        this.dataUltimaAdocao = dataUltimaAdocao;
    }

    public List<Animal> getAnimaisAdotados() {
        return animaisAdotados;
    }

    public void setAnimaisAdotados(List<Animal> animaisAdotados) {
        this.animaisAdotados = animaisAdotados;
    }

    public void editarHistorico(Scanner scanner) {
        System.out.println("Digite os novos detalhes do histórico:");
        String novoHistorico = scanner.nextLine();
        this.setDescricaoAdotante(novoHistorico);
    }

    public String exibirHistoricoAdotante() {
        return String.format(
                "%-25s %-30s\n%-25s %-30d\n%-25s %-30s\n%-25s %-30s",
                "Descrição do Histórico:", this.getDescricaoAdotante(),
                "Número de adoções:", this.getNumeroAdocoes(),
                "Data Última Adoção:", this.getDataUltimaAdocao() != null ? this.getDataUltimaAdocao().toString() : "N/A",
                "Animais adotados:", this.getAnimaisAdotados() != null ? this.getAnimaisAdotados().toString() : "N/A"
        );
    }

    @Override
    public String toString() {
        return "Histórico de Adoções: "
                + "\nDescrição: " + descricaoAdotante
                + "\nNúmero de adoções: " + numeroAdocoes
                + "\nData da última adoção: " + dataUltimaAdocao
                + "\nAnimais adotados: " + animaisAdotados;
    }
}
