public class SemDesconto implements RegraDeDesconto {
    @Override
    public double aplicar(double valorTotal, boolean possuiTaxaAdministrativa) {
        return valorTotal;
    }
}
