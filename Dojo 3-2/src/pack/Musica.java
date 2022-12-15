package pack;

public class Musica {

    private String nome;
    private String artista;
    private float duracao;

    public Musica(String nome, String artista, float duracao) {
        this.nome = nome;
        this.artista = artista;
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public String getArtista() {
        return artista;
    }

    public float getDuracao() {
        return duracao;
    }
}
