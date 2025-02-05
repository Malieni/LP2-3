package model;

public class HistoricoMedico {

    private String descricao;
    private String tratamento;
    private Double peso;
    private String medicacao;
    private String observacoes;

    public HistoricoMedico(String descricao, String tratamento, Double peso, String medicacao, String observacoes) {
        this.descricao = descricao;
        this.tratamento = tratamento;
        this.peso = peso;
        this.medicacao = medicacao;
        this.observacoes = observacoes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getMedicacao() {
        return medicacao;
    }

    public void setMedicacao(String medicacao) {
        this.medicacao = medicacao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Descrição do histórico médico: " + descricao
                + ", " + tratamento
                + ", " + peso
                + ", " + medicacao
                + ", " + observacoes;
    }
}
