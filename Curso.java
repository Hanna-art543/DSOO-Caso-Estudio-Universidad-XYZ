import java.util.ArrayList;
import java.util.List;

public class Curso {
    // ATRIBUTOS
    private String codigo;
    private String nombre;
    private int creditos;
    private int semestre;
    private List<PreRequisito> preRequisitos;
    private List<Nota> notas;

    //CONSTRUCTOR SOBRECARGADO
    public Curso(String nombre, String codigo, int creditos, int semestre) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.semestre = semestre;
        this.preRequisitos = new ArrayList<>();
        this.notas = new ArrayList<>();
    }


    //MÉTODOS ACCESORES (getters)
    public String getCodigo () {
        return codigo;
    }
    public String getNombre () {
        return nombre;
    }
    public int getCreditos () {
        return creditos;
    }

    //MÉTODOS
    public void agregarPrerequisito (PreRequisito p) {
        preRequisitos.add(p);
    }

    public boolean cumpleRequisitos (Alumno a) {
        for(PreRequisito p : preRequisitos) {
            if(!p.verificarCumplimiento(a)) {
                return false;
            }
        }
        return true;
    }

    public double calcularPromedioNotas () {
        if (notas.isEmpty()) {
            return 0.0;
            double suma = 0;
            for (Nota n : notas) {
                suma += n.getValor ();
            }
            return suma / notas.size();
        }
    }


    public void mostrarInformacion() {
        System.out.println("Curso: " + nombre);
        System.out.println("Código: " + codigo);
        System.out.println("Créditos: " + creditos);
        System.out.println("Semestre: " + semestre);
        System.out.println("Promedio notas: " + calcularPromedioNotas());
        System.out.println("PreRequisitos:");
        for (PreRequisito p : preRequisitos) {
            p.mostrarInformacion();
        }
    }
    
}
