import pack.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //teria que salvar os dados em algum lugar, como os dados não vão ser salvos, vai perguntar a quantidade de alunos sempre
        System.out.println("Insira a quantidade de alunos:");
        int qtdAlunos = sc.nextInt();
        Turma turminha = new Turma(qtdAlunos);


        menu(turminha);

    }

    public static void menu (Turma turma) {

        Scanner sc = new Scanner(System.in);

        ConteudoProva[] provas = new ConteudoProva[3];

        while (true) {
            System.out.println("""
                            O que deseja fazer?
                            (1) Listar todos os alunos
                            (2) Adicionar um novo aluno
                            (3) Deletar um aluno existente
                            (4) Ler os atributos de um aluno
                            (5) Alterar a idade de um aluno
                            (6) Criar prova
                            (7) Adicionar nota de aluno
                            (8) Verificar situação da prova final de aluno
                            (9) Listar notas dos alunos
                            (10) Listar notas de aluno
                            (0) Sair do sistema"""
                            );

            int resposta = sc.nextInt();

            switch (resposta) {
                case 1 -> System.out.println(turma.listarAlunos());

                case 2 -> {
                    sc.nextLine();
                    System.out.println("Insira o nome do aluno:");
                    String nome = sc.nextLine();
                    System.out.println("Insira a idade do aluno:");
                    int idade = sc.nextInt();

                    long matricula = turma.novoAluno(nome, idade);
                    System.out.printf("Aluno cirado com sucesso!\nMatrícula: %d\n\n", matricula);
                }

                case 3 -> {
                    System.out.println("Insira a matrícula do aluno a ser deletado:");
                    long matricula = sc.nextLong();
                    boolean achou = turma.deletarAluno(matricula);
                    if (achou)
                        System.out.println("Aluno deletado com sucesso\n");
                    else System.out.println("Não foi possível localizar o aluno\n");
                }

                case 4 -> {
                    System.out.println("Insira a matrícula do aluno para leitura de atributos:");
                    long matricula = sc.nextLong();
                    System.out.println(turma.atributosAluno(matricula) + "\n");
                }

                case 5 -> {
                    System.out.println("Insira a matrícula do aluno a ser deletado:");
                    long matricula = sc.nextLong();
                    System.out.println("Insira a nova idade do aluno:");
                    int idade = sc.nextInt();
                    boolean achou = turma.alterarIdade(matricula, idade);
                    if (achou)
                        System.out.println("Idade alterada com sucesso\n");
                    else System.out.println("Não foi possível localizar o aluno\n");
                }

                case 6 -> {
                    System.out.println("""
                                        Selecione o tipo da prova
                                        (0) Avaliação 1
                                        (1) Avaliação 2
                                        (2) Prova Final""");
                    int opTipoProva = sc.nextInt();
                    System.out.println("Insira o conteúdo da prova:");
                    sc.nextLine();
                    String textoProva = sc.nextLine();
                    provas[opTipoProva] = new ConteudoProva(
                            TipoProva.values()[opTipoProva], textoProva);
                    System.out.println("Prova adicionada com sucesso\n");
                }

                case 7 -> {
                    System.out.println("""
                                        Selecione o tipo da prova
                                        (0) Avaliação 1
                                        (1) Avaliação 2
                                        (2) Prova Final""");
                    int opTipoProva = sc.nextInt();

                    if (provas[opTipoProva] == null) {
                        System.out.println("Prova não adicionada!");
                        continue;
                    }

                    System.out.println("Insira a matrícula do aluno:");
                    long matricula = sc.nextLong();
                    System.out.println("Insira a nota do aluno:");
                    float nota = sc.nextFloat();
                    if (!turma.adicionaNotaAluno(matricula, opTipoProva, provas[opTipoProva], nota))
                        System.out.println("Não foi possível localizar o aluno\n");
                    else System.out.println("Nota adicinada com sucesso\n");
                }

                case 8 -> {
                    System.out.println("Insira a matrícula do aluno:");
                    long matricula = sc.nextLong();
                    int index = turma.achaMatricula(matricula);
                    if (index == -1) {
                        System.out.println("Não foi possível localizar o aluno\n");
                    } else {
                        float media = turma.calculaMediaAluno(matricula);
                        if (turma.verificaProvaFinalAluno(matricula))
                            System.out.printf("Aluno precisará realizar nota final, média %.2f\n",
                                                media);
                        else System.out.printf("Aluno precisará realizar nota final, média %.2f\n",
                                                media);
                    }
                }

                case 9 -> //FALTA A VERIFICAÇÃO SE O ALUNO ESTÁ EM PROVA FINAL
                        System.out.println(turma.listarNotas());

                case 10 -> {
                    System.out.println("Insira a matrícula do aluno:");
                    long matricula = sc.nextLong();
                    System.out.println(turma.listarNota(matricula) + "\n");
                }


                case 0 -> {
                    System.out.println("\nPrograma finalizado!");
                    return;
                }
                default -> System.out.println("Opção inválida\n");
            }
        }
    }
}
