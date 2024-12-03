package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String email;
    private List<Animal> historicoAdocoes;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.historicoAdocoes = new ArrayList<>();
    }

    public void adicionarAoHistorico(Animal animal) {
        historicoAdocoes.add(animal);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public List<Animal> getHistoricoAdocoes() {
        return historicoAdocoes;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s, E-mail: %s", nome, email);
    }
}