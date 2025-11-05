import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Alumno {
    
    // --- Atributos ---
    private int CUI;
    private String email;
    // Este mapa es clave: relaciona un Curso con la Nota final del alumno en ESE curso
    private Map<Curso, Nota> notas; 
    private Carrera carrera;

    // --- Constructor ---
    public Alumno(int CUI, String email, Carrera carrera) {
        this.CUI = CUI;
        this.email = email;
        this.carrera = carrera;
        this.notas = new HashMap<>(); // Inicializar el mapa de notas
    }

    // --- Getters y Setters (Ejemplo) ---
    public int getCUI() {
        return CUI;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    // --- Métodos del Diagrama ---

    /**
     * Matricula al alumno en un curso.
     * Añade el curso al mapa de notas, inicialmente sin nota.
     */
    public void matricular(Curso c) {
        if (!notas.containsKey(c)) {
            notas.put(c, null); // O se podría poner una Nota por defecto (ej. new Nota(0))
            System.out.println("Alumno " + CUI + " matriculado en " + c.getNombre());
        } else {
            System.out.println("El alumno ya está matriculado en " + c.getNombre());
        }
    }

    /**
     * Registra o actualiza la nota de un curso en el que el alumno está matriculado.
     */
    public void registrarNota(Curso c, Nota n) {
        if (notas.containsKey(c)) {
            notas.put(c, n); // Asigna el objeto Nota al Curso
            System.out.println("Nota registrada para el curso " + c.getNombre());
        } else {
            System.out.println("Error: El alumno no está matriculado en " + c.getNombre());
        }
    }

    /**
     * Calcula el promedio general del alumno basado en las notas de todos sus cursos.
     */
    public double promedioGeneral() {
        if (notas.isEmpty()) {
            return 0.0;
        }

        double sumaTotal = 0.0;
        int cursosConNota = 0;

        for (Nota n : notas.values()) {
            if (n != null) {
                // Asumimos que 'getValor()' de la Nota es la nota final del curso
                sumaTotal += n.getValor(); 
                cursosConNota++;
            }
        }

        return (cursosConNota > 0) ? (sumaTotal / cursosConNota) : 0.0;
    }

    /**
     * Obtiene la nota (como un valor double) para un curso específico.
     */
    public double obtenerNotaCurso(Curso c) {
        Nota n = notas.get(c); // Busca la Nota asociada al Curso
        if (n != null) {
            return n.getValor(); // Devuelve el valor de la nota
        }
        // Devuelve 0 o maneja el error si no hay nota o no está matriculado
        return 0.0; 
    }

    /**
     * Devuelve una lista de todos los cursos en los que el alumno está matriculado.
     */
    public List<Curso> listarCursos() {
        // Devuelve una nueva lista con las "llaves" (Cursos) del mapa
        return new ArrayList<>(notas.keySet());
    }

    /**
     * Muestra la información básica del alumno.
     */
    public void mostrarInformacion() {
        System.out.println("--- Información del Alumno ---");
        System.out.println("CUI: " + CUI);
        System.out.println("Email: " + email);
        if (carrera != null) {
            System.out.println("Carrera: " + carrera.getNombre());
        }
        System.out.println("Cursos Matriculados: " + notas.size());
        System.out.println("Promedio General: " + this.promedioGeneral());
    }
}
