package pack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlbumList {

    private String titulo;
    private String artista;
    private List<Musica> musicasList = new ArrayList<>();

    //Poderia criar o album com uma lista de músicas, mas como temos a
    //interação com o usuária, não implementei. No dojo talvez seria necessário

     public AlbumList(String titulo, String artista) {
        this.titulo = titulo;
        this.artista = artista;
     }

     public boolean verificaMusica (String nome) {
         for (Musica musica : musicasList) {
             if (musica.getNome().equals(nome))
                 return true;
         }
        return false;
     }

     public String nomeDaPosicao (int index) {
        return musicasList.get(index).getNome();
     }

     public boolean alteraPosicaoMusica (String nome, int indexNovo) {
        if (indexNovo <= musicasList.size() -1 && indexNovo >= 0) {
            for (Musica musica : musicasList) {
                if (musica.getNome().equals(nome)) {
                    int indexAntigo = musicasList.indexOf(musica);
                    Musica temp = musicasList.get(indexNovo);
                    musicasList.set(indexAntigo, temp);
                    musicasList.set(indexNovo, musica);
                    return true;
                }
            }
        }
        return false;
     }

    public void adicionaMusica (Musica musica) {
        musicasList.add(musica);
    }

    public boolean removeMusica (String nome) {
        Iterator<Musica> it = musicasList.iterator();
        while (it.hasNext()) {
            Musica musica = it.next();
            if (musica.getNome().equals(nome)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String listaMusicas = "";

        for (int i = 0; i < musicasList.size(); i++) {
            listaMusicas += (i+1) + ". " + musicasList.get(i).getNome() + "\n";
        }

        return String.format("Título: %s\nArtista: %s\nLista de Músicas:\n",
                            this.titulo, this.artista)  + listaMusicas;
    }

}
