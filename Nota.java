public class Nota {
    private double valor;

    public Nota(double valor) {
        this.valor = valor;
    }

    public void asignarValor(double v) {
        this.valor = v;
    }

    public boolean esAprobado() {
        // Asumiendo 10.5 como nota aprobatoria
        return this.valor >= 10.5;
    }

    public void mostrarInformacion() {
        System.out.println("====== NOTA ======");
        System.out.println("Valor: " + valor);
        System.out.println("Aprobado: " + (esAprobado() ? "Sí" : "No"));
    }

    // Getters
    public double getValor() {
        return valor;
    }
}