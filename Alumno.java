import java.util.HashMap;
import java.util.Map;

public class Alumno {
    //ATRIBUTOS
    private int cui;
    private String nombre;
    private String email;
    private Map<Curso, Nota> cursos;
    private Carrera carrera; //Asosiación

    //Constructor de Instancia
    public Alumno(int cui, String nombre, String email) {
        this.cui = cui;
        this.nombre = nombre;
        this.email = email;
        this.cursos = new HashMap<>();
    }

    // Método para inscribir al alumno en un curso
    public boolean matricularCurso(Curso c) {
        //Verificamos si ya existe el curso
        if (!this.cursos.containsKey(c)) {
            this.cursos.put(c, new Nota(0.0)); // Inicia con nota 0
            return true;
        }
        return false; // Ya estaba matriculado
    }

    public void registrarNota(Curso c, double valorNota) {
        Nota nota;
        // Verificamos si el alumno tiene ese curso matriculado
        if (this.cursos.containsKey(c)) {
            nota = this.cursos.get(c);
            nota.asignarValor(valorNota);
        } else {
            nota = new Nota(valorNota);
            this.cursos.put(c, nota);
        }
        // Registra la nota en el curso para el promedio del curso
        c.agregarNota(nota);
    }

    public double calcularPromedioGeneral() {
        // Validación de seguridad
        if (cursos.isEmpty()) return 0.0;
        double suma = 0;
        for (Nota n : cursos.values()) {
            suma += n.getValor(); 
        }
        return suma / cursos.size();
    }

    public Nota obtenerNotaCurso(Curso c) {
        return this.cursos.get(c);
    }

    public void listarCursos() {
        System.out.println("Cursos matriculados por " + nombre + ":");
        for (Curso c : cursos.keySet()) {
            System.out.println(" - " + c.getNombre() + " (Nota: " + cursos.get(c).getValor() + ")");
        }
    }

    public void mostrarInformacion() {
        System.out.println("ALUMNO");
        System.out.println("Nombre: " + nombre);
        System.out.println("CUI: " + cui);
        System.out.println("Email: " + email);
        if (carrera != null) {
            System.out.println("Carrera: " + carrera.getNombre());
        }
    }

    // Getters y Setters
    public int getCUI() { 
        return cui; }
    public String getNombre() { 
        return nombre; 
    }
    public String getEmail() { 
        return email; 
    }
    public Map<Curso, Nota> getCursos() { 
        return cursos; 
    }
    public Carrera getCarrera() { 
        return carrera; 
    }
    public void setCarrera(Carrera carrera) { 
        this.carrera = carrera; 
    }
}
