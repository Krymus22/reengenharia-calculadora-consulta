public class CalculadoraDeConsulta {
    private final SomadorDeProcedimentos somador = new SomadorDeProcedimentos();

    public double calcularValorFinal(TipoConsulta tipo, double[] procedimentosRealizados,
                                     boolean possuiTaxaAdministrativa) {
        double valorTotal = somador.somar(procedimentosRealizados);
        RegraDeDesconto regra = RegraDeDescontoFactory.criar(tipo);
        return regra.aplicar(valorTotal, possuiTaxaAdministrativa);
    }
}
