package pack;

public class Prova {

    private float nota;
    private final ConteudoProva conteudoProva;

    public Prova(float nota, ConteudoProva conteudoProva) {
        this.nota = nota;
        this.conteudoProva = conteudoProva;
    }

    public float getNota() {
        return this.nota;
    }

    @Override
    public String toString() {
        return String.format("Prova: %s  Nota: %.2f",
                this.conteudoProva.getTipoProva(), this.nota);
    }
}
