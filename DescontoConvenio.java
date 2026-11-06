public class DescontoConvenio implements RegraDeDesconto {
    private static final double PERCENTUAL_DESCONTO = 0.12;
    private static final double TAXA_ADMINISTRATIVA = 15.50;

    @Override
    public double aplicar(double valorTotal, boolean possuiTaxaAdministrativa) {
        // Mesma fórmula do legado: "total * 0.88" daria outro resultado em double
        double valorComDesconto = valorTotal - (valorTotal * PERCENTUAL_DESCONTO);
        if (possuiTaxaAdministrativa) {
            valorComDesconto += TAXA_ADMINISTRATIVA;
        }
        return valorComDesconto;
    }
}
