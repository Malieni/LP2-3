package model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    private String nome, genero, CPF, logradouro, numero, bairro, cidade, estado, pais, telefone, email, hashsenha;
    private LocalDate nascimento;
    private List<Papel> papeis;

    // Construtor da classe Pessoa
    public Pessoa(String nome, LocalDate nascimento, String genero, String CPF, String logradouro, String numero,
            String bairro, String cidade, String estado, String pais, String telefone, String email, String hashsenha) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.genero = genero;
        this.CPF = CPF;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.telefone = telefone;
        this.email = email;
        this.hashsenha = hashsenha;
        this.papeis = new ArrayList<>();

    }

    public void adicionarPapel(Papel papel) {
        papeis.add(papel); // Adiciona cada papel na lista 
    }

    // Acessar a lista de papeis
    public List<Papel> getPapeis() {
        return papeis;
    }

    // Chama o construtor
    public Pessoa() {

    }

    // Sobreescrita Tostring para exibir os dados da pessoa cadastrada
    @Override
    public String toString() {
        return "Nome: " + nome
                + "\nNascimento: " + nascimento
                + "\nGênero: " + genero
                + "\nCPF: " + CPF
                + "\nEndereço: " + logradouro + ", " + numero + ", " + bairro + ", " + cidade + ", " + estado + ", " + pais
                + "\nTelefone: " + telefone
                + "\nEmail: " + email
                + "\nHash da senha: " + hashsenha;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashsenha() {
        return hashsenha;
    }

    public void setHashsenha(String hashsenha) {
        this.hashsenha = hashsenha;
    }

}
