package pack;

public class Aluno {

    private String nome;
    private long matricula;
    private int idade;

    private Prova[] provas = new Prova[3];

    public static int qtdAlunos = 0;

    public Aluno (String nome, int idade, Aluno[] listaAlunos) {
        this.nome = nome;
        this.idade = idade;
        qtdAlunos ++;

        boolean repete = false;
        boolean matriculaInvalida = true;
        long matricula;

        if (listaAlunos[0] == null)
            this.matricula = (long) (Math.random() * (999999 - 100000 + 1)) + 1;

        while (matriculaInvalida && listaAlunos[0] != null) {
            matricula = (long) (Math.random() * (999999 - 100000 + 1)) + 1;
            for (int i = 0; i < qtdAlunos - 1; i++) {
                if (matricula == listaAlunos[i].getMatricula()) {
                    repete = true;
                    break;
                }
            }
            if (!repete) {
                this.matricula = matricula; //Como garantir exclusividade da matrícula?
                matriculaInvalida = false;
            }

        }

    }

    public long getMatricula() {
        return this.matricula;
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void adicionaNota(int tipo, ConteudoProva conteudoProva, float nota) {
        provas[tipo] = new Prova(nota, conteudoProva);
//        qtdProvas++;
    }

    public float calculaMedia() {
        float somaNotas = 0;

        for (int i = 0; i < 2; i++)
            somaNotas += provas[i].getNota();

        return somaNotas/2;
    }

    public boolean verificaProvaFinal() {
        return calculaMedia() < 6.0f;
    }

    public String listarNotas () {
        String lista = "";

        for(Prova p : provas) {
            if (p == null) continue;
            lista += p + "\t";
        }

        return lista;
    }

    @Override
    public String toString() {
        return String.format("Matrícula: %d\nNome: %s\nIdade: %d",
                this.matricula, this.nome, this.idade);
    }
}
