import java.util.List;

public class Nota {

    // --- Atributos ---
    private double valor;     // Podría ser la nota final (ej. 14)
    private double promedio;  // Podría ser el promedio de parciales (ej. 13.5)

    // --- Constructor ---
    public Nota(double valor) {
        this.valor = valor;
        this.promedio = 0.0; // Inicializado en 0
    }

    // --- Getters y Setters ---
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    // --- Métodos del Diagrama ---

    /**
     * Calcula el promedio de una lista de notas.
     * Nota: Es un método extraño para esta clase, pero estaba en el diagrama.
     * Podría usarse para calcular el promedio (ej. this.promedio) a partir
     * de una lista de notas de parciales.
     */
    public double calcularPromedio(List<Nota> notasParciales) {
        if (notasParciales == null || notasParciales.isEmpty()) {
            return 0.0;
        }
        
        double suma = 0.0;
        for (Nota n : notasParciales) {
            suma += n.getValor(); // Suma los 'valores' de las notas
        }
        
        double promCalculado = suma / notasParciales.size();
        this.promedio = promCalculado; // Asigna el resultado al atributo 'promedio'
        return promCalculado;
    }

    /**
     * Muestra la información de esta nota.
     */
    public void mostrarNota() {
        System.out.println("Valor (Nota Final): " + valor);
        System.out.println("Promedio (de Prácticas): " + promedio);
    }
}
