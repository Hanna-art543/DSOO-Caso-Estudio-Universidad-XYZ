import java.util.ArrayList;
import java.util.List;

public class Curso {
    // Atributos
    private String nombre;
    private String codigo;
    private int creditos;
    private int semestre;
    private Carrera carrera; 
    // Listas para manejar relaciones "uno a muchos"
    private List<PreRequisito> preRequisitos;
    private List<Nota> notas;

    public Curso(String nombre, String codigo, int creditos, int semestre, Carrera carrera) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.semestre = semestre;
        this.carrera = carrera;
        //Inicializamos las listas vacías 
        this.preRequisitos = new ArrayList<>();
        this.notas = new ArrayList<>();
    }

    // Métodos 
    public boolean agregarPreRequisito(PreRequisito p) {
        // Evitamos duplicados antes de agregar
        if (!preRequisitos.contains(p)) {
            preRequisitos.add(p);
            return true;
        }
        return false;
    }

    public boolean eliminarPreRequisito(String id) {
        // Uso de Lambda, elimina directo si el ID coincide (ignorando mayúsculas)
        return this.preRequisitos.removeIf(p -> p.getID().equalsIgnoreCase(id));
    }

    public boolean cumpleRequisitos(Alumno a) {
        for (PreRequisito p : preRequisitos) {
            // Si falla en UNO solo, retorna falso inmediatamente
            if (!p.verificarCumplimiento(a)) {
                return false;
            }
        }
        return true; // Si terminó el bucle, es que cumplió todo
    }

    public double calcularPromedioNotas() {
        // Validación de seguridad
        if (notas.isEmpty()) return 0.0;
        
        double suma = 0;
        for (Nota n : notas) {
            suma += n.getValor();
        }
        return suma / notas.size();
    }

    public void agregarNota(Nota n) {
        this.notas.add(n);
    }

    public void mostrarInformacion() {
        System.out.println("CURSO ");
        System.out.println("Nombre: " + nombre);
        System.out.println("Código: " + codigo);
        System.out.println("Créditos: " + creditos);
        System.out.println("Semestre: " + semestre);
        // Operador ternario: Evita error si la carrera aún no fue asignada (null)
        System.out.println("Carrera: " + (carrera != null ? carrera.getNombre() : "No asignada"));
    }

    // Getters y Setters
    public String getNombre() { 
        return nombre; 
    }
    public String getCodigo() { 
        return codigo; 
    }
    public int getCreditos() { 
        return creditos; 
    }
    public int getSemestre() { 
        return semestre; 
    }
    public Carrera getCarrera() { 
        return carrera; 
    }
    public List<PreRequisito> getPreRequisitos() { 
        return preRequisitos; 
    }
    public List<Nota> getNotas() { 
        return notas; 
    }
    public void setCarrera(Carrera carrera) { 
        this.carrera = carrera; 
    }
}
