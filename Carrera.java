import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private String nombre;
    private int duracion; // en años o ciclos, según tu sistema
    private List<Curso> cursos;
    private List<Alumno> alumnos;
    public Carrera(String nombre, int duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.cursos = new ArrayList<>();
        this.alumnos = new ArrayList<>();
    }
    public boolean agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
            return true;
        }
        return false;
    }
    public boolean eliminarCurso(String codigo) {
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
    public boolean agregarAlumno(Alumno alumno) {
        if (!alumnos.contains(alumno)) {
            alumnos.add(alumno);
            return true;
        }
        return false;
    }
    public boolean eliminarAlumno(String nombre) {
        for (Alumno a : alumnos) {
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                alumnos.remove(a);
                return true;
            }
        }
        return false;
    }
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
    public String getNombre() {
        return nombre;
    }
    public int getDuracion() {
        return duracion;
    }
    public List<Curso> getCursos() {
        return cursos;
    }
    public List<Alumno> getAlumnos() {
        return alumnos;
    }
}
