public class Main {
    public static void main(String[] args) {
        CalculadoraDeConsulta calculadora = new CalculadoraDeConsulta();
        x_Mgr_F legado = new x_Mgr_F();

        // Simulação pedida: paciente tipo 1 (convênio), procedimentos [200, 100], status verdadeiro
        double[] procedimentos = {200.0, 100.0};
        double valorNovo = calculadora.calcularValorFinal(TipoConsulta.CONVENIO, procedimentos, true);
        double valorLegado = legado.calc(1, procedimentos, true);

        System.out.println("Valor do código novo:   " + valorNovo);
        System.out.println("Valor do código legado: " + valorLegado);
        System.out.println(valorNovo == valorLegado ? "IGUAIS: comportamento preservado" : "DIFERENTES: regressão!");

        System.out.println();
        System.out.println("Outros cenários:");
        int falhas = 0;
        falhas += comparar(calculadora, legado, 1, new double[]{200.0, 100.0}, false);
        falhas += comparar(calculadora, legado, 2, new double[]{400.0, 200.0}, false);
        falhas += comparar(calculadora, legado, 2, new double[]{300.0, 200.0}, false);
        falhas += comparar(calculadora, legado, 2, new double[]{100.0}, true);
        falhas += comparar(calculadora, legado, 3, new double[]{100.0, 50.0}, true);
        falhas += comparar(calculadora, legado, 1, new double[]{}, true);
        falhas += comparar(calculadora, legado, 1, new double[]{0.1, 0.2, 33.33}, true);
        System.out.println(falhas == 0 ? "Todos os cenários batem com o legado." : falhas + " cenário(s) diferente(s)!");
    }

    private static int comparar(CalculadoraDeConsulta calculadora, x_Mgr_F legado,
                                int codigoTipo, double[] procedimentos, boolean possuiTaxa) {
        TipoConsulta tipo = TipoConsulta.doCodigoLegado(codigoTipo);
        double valorNovo = calculadora.calcularValorFinal(tipo, procedimentos, possuiTaxa);
        double valorLegado = legado.calc(codigoTipo, procedimentos, possuiTaxa);
        boolean iguais = valorNovo == valorLegado;
        System.out.printf("  tipo=%d (%s), taxa=%b -> novo=%s, legado=%s %s%n",
                codigoTipo, tipo, possuiTaxa, valorNovo, valorLegado, iguais ? "OK" : "DIFERENTE");
        return iguais ? 0 : 1;
    }
}
