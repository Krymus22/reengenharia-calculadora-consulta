public class DescontoParticular implements RegraDeDesconto {
    private static final double PERCENTUAL_DESCONTO = 0.05;
    private static final double VALOR_MINIMO_PARA_DESCONTO = 500.0;

    @Override
    public double aplicar(double valorTotal, boolean possuiTaxaAdministrativa) {
        // Estritamente maior: exatamente 500 não recebe desconto
        if (valorTotal > VALOR_MINIMO_PARA_DESCONTO) {
            return valorTotal - (valorTotal * PERCENTUAL_DESCONTO);
        }
        return valorTotal;
    }
}
