package pack;

public class ConteudoProva {

    private final String texto;

    private final TipoProva tipoProva;

    public ConteudoProva(TipoProva tipoProva, String texto) {
        this.texto = texto;
        this.tipoProva = tipoProva;
    }

    public TipoProva getTipoProva() {
        return this.tipoProva;
    }
}
