import java.util.ArrayList;
import java.util.List;

public class Carrera {
    //ATRIBUTOS
    private String nombre;
    private String codigo;
    private int duracion;
    private Facultad facultad; // en años o ciclos, según tu sistema
    private List<Curso> cursos;
    private List<Alumno> alumnos;

    //CONSTRUCTOR DE INSTANCIA
    public Carrera(String nombre, String codigo, int duracion, Facultad facultad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.duracion = duracion;
        this.facultad = facultad;
        this.cursos = new ArrayList<>();
        this.alumnos = new ArrayList<>();
    }
    public boolean agregarCurso(Curso curso) {
        //Verifica que no esté el curso
        if (!cursos.contains(curso)) {
            cursos.add(curso);
            return true;
        }
        return false;
    }

    public boolean eliminarCurso(String codigo) {
        // Comparamos códigos ignorando mayúsculas.
        for (Curso c : cursos) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) {
                cursos.remove(c);
                return true;
            }
        }
        return false;
    }
    public Curso buscarCurso(String nombre) {
        for (Curso c : cursos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    public void listarCursos() {
        System.out.println("Cursos de la carrera " + nombre + ":");
        for (Curso c : cursos) {
            System.out.println(" - " + c.getNombre());
        }
    }

    //Métodos para agregar, eliminar y listar alumnos
    public boolean agregarAlumno(Alumno alumno) {
        //Verifica que no esté el alumno
        if (!alumnos.contains(alumno)) {
            alumnos.add(alumno);
            alumno.setCarrera(this); //Relacion
            return true;
        }
        return false;
    }
    public boolean eliminarAlumno(int cui) {
        //Función lambda
        return this.alumnos.removeIf(a -> a.getCUI() == cui);
    }

    public Alumno buscarAlumno(int CUI) {
        for (Alumno a : alumnos) {
            if (a.getCUI() == CUI) {
                return a;
            }
        }
        return null;
    }

    //Mostrar todos los alumnos
    public void listarAlumnos() {
        System.out.println("Alumnos en la carrera " + nombre + ":");
        for (Alumno a : alumnos) {
            System.out.println(" - " + a.getNombre());
        }
    }
    public int obtenerDuracion() {
        return duracion;
    }

    public void mostrarInformacion() {
        System.out.println("Carrera: " + nombre);
        System.out.println("Duración: " + duracion + " años");
        System.out.println("Número de cursos: " + cursos.size());
        System.out.println("Número de alumnos: " + alumnos.size());
    }

    //Métodos getters y setters
    public String getNombre() {
        return nombre;
    }
    public String getCodigo() {
        return codigo;
    }
    public int getDuracion() {
        return duracion;
    }
    public Facultad getFacultad () {
        return facultad;
    }
    public List<Curso> getCursos() {
        return cursos;
    }
    public List<Alumno> getAlumnos() {
        return alumnos;
    }
    public void setFacultad (Facultad facultad) {
        this.facultad = facultad;
    }
}
