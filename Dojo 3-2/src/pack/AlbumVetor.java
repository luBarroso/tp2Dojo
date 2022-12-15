package pack;

import java.util.ArrayList;
import java.util.List;

public class AlbumVetor {
    /*CD, possuindo um título, artista, quantidade de músicas e lista de músicas.*/
    /* - Implementar métodos para adicionar e remover músicas ao Album. */

    private String titulo;
    private String artista;
    private int qtdMusicasTotal;
    private int qtdMusicas = 0;
    private Musica[] musicas;

    //Poderia criar o album com uma lista de músicas, mas como temos a
    //interação com o usuária, não implementei. No dojo talvez seria necessário

    public AlbumVetor(String titulo, String artista, int qtdMusicasTotal) {
        this.titulo = titulo;
        this.artista = artista;
        this.qtdMusicasTotal = qtdMusicasTotal;
        musicas = new Musica[this.qtdMusicasTotal];
    }

    public boolean verificaMusica(String nome) {
        int index = this.indexMusica(nome);
        return index != -1;
    }

    public String nomeDaPosicao(int index) {
        if (index <= qtdMusicas - 1 && index >= 0)
            return musicas[index].getNome();
        else return "Não existe música na posição selecionada!\n";
    }

    public boolean alteraPosicaoMusica(String nome, int indexNovo) {
        int indexAntigo = this.indexMusica(nome);
        if (indexAntigo == -1) return false;

        if (indexNovo <= qtdMusicas - 1 && indexNovo >= 0) {
            Musica temp = musicas[indexAntigo];
            musicas[indexAntigo] = musicas[indexNovo];
            musicas[indexNovo] = temp;
            return true;
        } else return false; //não é possível alcançar esse index

    }

    public void adicionaMusica(Musica musica) {
        musicas[qtdMusicas] = musica;
        qtdMusicas++;
    }

    public boolean removeMusica (String nome) {
        int index = this.indexMusica(nome);

        if (index == -1)
            return false;
        else {
            for (int i = 0; i < qtdMusicas - 1; i++) {
                musicas[i] = musicas[i+1];
            }
            qtdMusicas--;
            return true;
        }
    }

    public int indexMusica (String nome) {
        for (int i = 0; i < qtdMusicas; i++) {
            if (musicas[i].getNome().equals(nome))
                return i;
        }

        return -1;
    }

    @Override
    public String toString() {
        String listaMusicas = "";

        for (int i = 0; i < qtdMusicas; i++) {
            listaMusicas += (i+1) + ". " + musicas[i].getNome() + "\n";
        }

        return String.format("Título: %s\nArtista: %s\nLista de Músicas:\n",
                            this.titulo, this.artista) + listaMusicas;
    }
}
