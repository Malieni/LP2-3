package model;

public class Comentario {
    private String texto;
    private Usuario usuario;
    private int avaliacao; // De 1 a 5

    public Comentario(String texto, Usuario usuario, int avaliacao) {
        this.texto = texto;
        this.usuario = usuario;
        this.avaliacao = avaliacao;
    }

    public String getTexto() {
        return texto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    @Override
    public String toString() {
        return String.format("Comentário: %s, Avaliação: %d, Usuário: %s", texto, avaliacao, usuario.getNome());
    }
}