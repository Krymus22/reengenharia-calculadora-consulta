public class RegraDeDescontoFactory {
    public static RegraDeDesconto criar(TipoConsulta tipo) {
        switch (tipo) {
            case CONVENIO:
                return new DescontoConvenio();
            case PARTICULAR:
                return new DescontoParticular();
            default:
                return new SemDesconto();
        }
    }
}
