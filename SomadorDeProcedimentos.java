public class SomadorDeProcedimentos {
    public double somar(double[] procedimentosRealizados) {
        if (procedimentosRealizados == null) {
            throw new IllegalArgumentException("A lista de procedimentos não pode ser nula");
        }
        double valorTotal = 0;
        for (double valorProcedimento : procedimentosRealizados) {
            valorTotal += valorProcedimento;
        }
        return valorTotal;
    }
}
