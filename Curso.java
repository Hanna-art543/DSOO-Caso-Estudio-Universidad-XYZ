public class Curso {
    // ATRIBUTOS
    private String codigo;
    private String nombre;
    private int creditos;
<<<<<<< Updated upstream
    private String requisitos;

    //CONSTRUCTORES
    //Constructor predeterminado
    Curso () {
        this.codigo = "00000000";
        this.nombre = "sin nombre";
        this.creditos = 0;
        this.requisitos = "no definidos";
=======
    private int semestre;
    private Carrera carrera;
    private List<PreRequisito> preRequisitos;
    private List<Nota> notas;

    //CONSTRUCTOR SOBRECARGADO
    public Curso(String nombre, String codigo, int creditos, int semestre, Carrera carrera) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.semestre = semestre;
        this.carrera = carrera;
        this.preRequisitos = new ArrayList<>();
        this.notas = new ArrayList<>();
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
    public String getRequisitos () {
        return requisitos;
=======
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


    //MÉTODOS (agregar, eliminar y cumplir los prerequisitos)
    public boolean agregarPreRequisito(PreRequisito p) {
        if (!preRequisitos.contains(p)) {
            preRequisitos.add(p);
            return true;
        }
        return false;
    }
    public boolean eliminarPreRequisito(String id) {
        //Función lambda
        return this.preRequisitos.removeIf(p -> p.getID().equalsIgnoreCase(id));
>>>>>>> Stashed changes
    }

    //MÉTODOS MUTADORES (setters)
    public void setCodigo (String codigo) {
        this.codigo = codigo;
    }
<<<<<<< Updated upstream
    public void setNombre (String nombre) {
        this.nombre = nombre;
    }
    public void setCreditos (int creditos) {
        this.creditos = creditos;
    }
    public void setRequisitos (String requisitos) {
        this.requisitos = requisitos;
=======

    //Método para calcular el promedio
    public double calcularPromedioNotas() {
        if (notas.isEmpty()) return 0.0;
        double suma = 0;
        for (Nota n : notas) {
            suma += n.getValor();
        }
        return suma / notas.size();
    }

    //Método para agregar una nueva nota
    public void agregarNota(Nota n) {
        this.notas.add(n);
    }

    public void mostrarInformacion() {
        System.out.println("Curso: " + nombre);
        System.out.println("Código: " + codigo);
        System.out.println("Créditos: " + creditos);
        System.out.println("Semestre: " + semestre);
        System.out.println("Promedio notas: " + calcularPromedioNotas());
        System.out.println("Carrera: "+carrera);
        System.out.println("PreRequisitos:");
        for (PreRequisito p : preRequisitos) {
            p.mostrarInformacion();
        }
>>>>>>> Stashed changes
    }
}
