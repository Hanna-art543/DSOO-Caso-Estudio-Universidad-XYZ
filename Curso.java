public class Curso {
    // ATRIBUTOS
    private String codigo;
    private String nombre;
    private int creditos;
    private String requisitos;

    //CONSTRUCTORES
    //Constructor predeterminado
    Curso () {
        this.codigo = "00000000";
        this.nombre = "sin nombre";
        this.creditos = 0;
        this.requisitos = "no definidos";
    }

    //Constructor sobrecargado
    Curso (String codigo, String nombre, int creditos, String requisitos){
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.requisitos = requisitos;
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
    public String getRequisitos () {
        return requisitos;
    }

    //MÉTODOS MUTADORES (setters)
    public void setCodigo (String codigo) {
        this.codigo = codigo;
    }
    public void setNombre (String nombre) {
        this.nombre = nombre;
    }
    public void setCreditos (int creditos) {
        this.creditos = creditos;
    }
    public void setRequisitos (String requisitos) {
        this.requisitos = requisitos;
    }
}
