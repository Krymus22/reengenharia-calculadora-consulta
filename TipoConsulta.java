public enum TipoConsulta {
    CONVENIO(1),
    PARTICULAR(2),
    OUTRO(0);

    private final int codigoLegado;

    TipoConsulta(int codigoLegado) {
        this.codigoLegado = codigoLegado;
    }

    public static TipoConsulta doCodigoLegado(int codigo) {
        for (TipoConsulta tipo : values()) {
            if (tipo.codigoLegado == codigo) {
                return tipo;
            }
        }
        return OUTRO;
    }
}
