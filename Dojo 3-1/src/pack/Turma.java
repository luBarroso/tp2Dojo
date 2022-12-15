package pack;

public class Turma {

    private final int qtdTotal;
    private int qtdMatriculados;
    private Aluno[] alunos;

    public Turma (int qtdTotal) {
        this.qtdTotal = qtdTotal;
        alunos = new Aluno[qtdTotal];
    }


    public long novoAluno (String nome, int idade) {
        if (qtdMatriculados >= qtdTotal)
            return -1;
        alunos[qtdMatriculados] = new Aluno(nome, idade, alunos);
        qtdMatriculados ++;
        return alunos[qtdMatriculados-1].getMatricula();
    }

    public int achaMatricula(long matricula) {

        for (int i = 0; i < qtdMatriculados; i++) {
            if (matricula == alunos[i].getMatricula()) {
                return i;
            }
        }

        return -1;

    }

    public boolean deletarAluno (long matricula) {
        int index = this.achaMatricula(matricula);

        if (index == -1)
            return false;
        else {
            /*
            for (int i = index; i < qtdMatriculados - 1; i++) {
                alunos[i] = alunos[i + 1];
            }
            */

            alunos[index] = alunos[qtdMatriculados-1];
            qtdMatriculados--;
            return true;
        }
    }

    public String atributosAluno (long matricula) {

        int index = achaMatricula(matricula);

        if (index == -1)
            return "Não foi possível localizar o aluno";
        else
            return alunos[index].toString();

    }

    public boolean alterarIdade (long matricula, int idade) {

        int index = this.achaMatricula(matricula);

        if (index == -1)
            return false;
        else {
            alunos[index].setIdade(idade);
            return true;
        }
    }

    public boolean adicionaNotaAluno (long matricula, int tipo, ConteudoProva cp, float nota) {
        int index = this.achaMatricula(matricula);

        if (index == -1)
            return false;
        else {
            alunos[index].adicionaNota(tipo, cp, nota);
            return true;
        }
    }

    public boolean verificaProvaFinalAluno (long matricula) {
        int index = this.achaMatricula(matricula);

        return alunos[index].verificaProvaFinal();
    }

    public float calculaMediaAluno(long matricula) {
        int index = this.achaMatricula(matricula);

        return alunos[index].calculaMedia();
    }

    public String listarNotas() {
        String lista = "";

        for (int i = 0; i < qtdMatriculados; i++) {
            lista += alunos[i] + "\n" + alunos[i].listarNotas() + "\n\n";
        }

        return lista;
    }

    public String listarNota(long matricula) {
        int index = achaMatricula(matricula);

        if (index == -1)
            return "Não foi possível localizar o aluno\n";
        else return alunos[index].listarNotas();

    }

    public String listarAlunos () {
        String lista = "";

        for (int i = 0; i < qtdMatriculados; i++)
            lista += alunos[i].toString() + "\n\n";

        return lista;
    }
}
