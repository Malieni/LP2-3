package model;

public class Animal {
    private String nome;
    private String especie; // Ex: Cachorro, Gato, Coelho
    private String raca;
    private int idade; // Idade em anos
    private String tamanho; // Ex: Pequeno, Médio, Grande

    public Animal(String nome, String especie, String raca, int idade, String tamanho) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaca() {
        return raca;
    }

    public int getIdade() {
        return idade;
    }

    public String getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s, Espécie: %s, Raça: %s, Idade: %d anos, Tamanho: %s", 
                             nome, especie, raca, idade, tamanho);
    }
    
}
