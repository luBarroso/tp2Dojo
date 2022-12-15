import pack.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("** Criação do album **");
        System.out.println("Insira o título do álbum:");
        String titulo = sc.nextLine();
        System.out.println("Insira o nome do artista:");
        String artista = sc.nextLine();

        /*
        //Se for implementar o ArrayList, não seria necessário o tamanho do álbum

        System.out.println("Insira o tamanho total do álbum:");
        int tamanho = sc.nextInt();

        AlbumVetor album = new AlbumVetor(titulo, artista, tamanho);
        */

        AlbumList album = new AlbumList(titulo, artista);


        /*  ****Testes***
        Musica[] musicas = new Musica[12];

        Album album = new Album("Lemonade", "Beyoncé", 12);

        musicas[0] = new Musica("Pray you catch me", "Beyoncé", 3);
        musicas[1] = new Musica("Hold up", "Beyoncé", 3);
        musicas[2] = new Musica("Don't hurt yourself", "Beyoncé", 3);

        album.adicionaMusica(musicas[0]);
        album.adicionaMusica(musicas[1]);
        album.adicionaMusica(musicas[2]);

        System.out.println(album);*/

        menu(sc, album);
    }

    private static void menu(Scanner sc, /*AlbumVetor album*/ AlbumList album) {

        while (true) {
            System.out.println("""
                    1 - Adicionar Música
                    2 - Remover Música
                    3 - Verificar presença de música
                    4 - Nome da música na n-ésima poscição
                    5 - Imprimir dados do álbum
                    6 - Alterar posição de uma música
                    7 - Sair do programa""");

            int opcao = sc.nextInt();
            sc.nextLine(); //buffer

            switch (opcao) {
                case 1 -> {
                    System.out.println("Insira o nome da música:");
                    String nome = sc.nextLine();
                    System.out.println("Insira o artista:");
                    String artista = sc.nextLine();
                    System.out.println("Insira a duração da música: (formato 3,33)");
                    float duracao = sc.nextFloat();

                    Musica musica = new Musica(nome, artista, duracao);
                    album.adicionaMusica(musica);

                    System.out.println("Música adicionada com sucesso!\n");
                }

                case 2 -> {
                    System.out.println("Insira o nome da música a ser excluída:");
                    String nome = sc.nextLine();

                    if(album.removeMusica(nome)) System.out.println("Música removida com sucesso!\n");
                    else System.out.println("Música não encontrada\n");
                }

                case 3 -> {
                    System.out.println("Insira o nome da música:");
                    String nome = sc.nextLine();

                    if(album.verificaMusica(nome)) System.out.println("Música está presente no álbum!\n");
                    else System.out.println("Música não encontrada");
                }

                case 4 -> {
                    System.out.println("Insira a posição:");
                    int posicao = sc.nextInt();
                    String nome = album.nomeDaPosicao(posicao-1);

                    if (nome != null)
                        System.out.println(nome);
                    else System.out.println("Não existe música na posição selecionada!\n");
                }

                case 5 -> {
                    System.out.println(album);
                }

                case 6 -> {
                    System.out.println("Insira o nome da música:");
                    String nome = sc.nextLine();
                    System.out.println("Insira a nova posição:");
                    int posicao = sc.nextInt();

                    if(album.alteraPosicaoMusica(nome, posicao-1))
                        System.out.println("Posição alterada com sucesso!\n");
                    else System.out.println("Valor inválido\n");
                }

                case 7 -> {
                    System.out.println("Programa finalizado\n");
                    return;
                }

                default -> {
                    System.out.println("Opção inválida!\n");
                }
            }
        }
    }
}
