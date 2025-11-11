import java.time.LocalDate; 

public class Matricula {
    private String id;
    private LocalDate fecha; 
    private boolean estado;
    private Alumno alumno;
    private Carrera carrera;

    public Matricula(String id, LocalDate fecha, Alumno alumno, Carrera carrera) { // <-- MODIFICADO
        this.id = id;
        this.fecha = fecha; 
        this.alumno = alumno;
        this.carrera = carrera;
        this.estado = true; 
    }

    public void registrarMatricula(Alumno a, Carrera c) {
        this.alumno = a;
        this.carrera = c;
        this.estado = true; 
    }

    public void cancelarMatricula() {
        this.estado = false;
    }

    public boolean verificarEstado() {
        return this.estado;
    }

    public void mostrarInformacion() {
        System.out.println("====== MATRÍCULA ======");
        System.out.println("ID: " + id);
        System.out.println("Fecha: " + fecha); 
        String estadoTexto;
        if (estado) { 
            estadoTexto = "Activa";
        } 
        else { 
            estadoTexto = "Cancelada";
        }

        System.out.println("Estado: " + estadoTexto);
        System.out.println("Alumno: " + alumno.getNombre());
        System.out.println("Carrera: " + carrera.getNombre());
    }

    // Getters
    public String getID() { 
        return id; 
    }
    public LocalDate getFecha() { 
        return fecha; 
    } 
    public boolean isEstado() { 
        return estado; 
    }
    public Alumno getAlumno() { 
        return alumno; 
    }
    public Carrera getCarrera() { 
        return carrera; 
    }
}