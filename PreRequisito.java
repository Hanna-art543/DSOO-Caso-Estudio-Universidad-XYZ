class PreRequisito {
    //ATRIBUTOS
    private String id;
    private double notaMinima;
    private Curso cursoRequerido;


    //CONSTRUCTOR SOBRECARGADO
    public PreRequisito (String id, double notaMinima, Curso cursoRequerido) {
        this.id = id;
        this.notaMinima = notaMinima;
        this.cursoRequerido = cursoRequerido;
    }

    //GETTERS Y SETTERS
    public String getID() {
        return id;
    }
    public double getNotaMinima () {
        return notaMinima;
    }
    public Curso getCursoRequerido () {
        return cursoRequerido;
    }
    
    public boolean verificarCumplimiento (Alumno a) {
        double nota = a.obtenerNota(cursoRequerido);
        return nota >= notaMinima;
    }

    public void mostrarInformacion () {
        System.out.println("\nInformación" +
        "\nID: " + this.id + 
        "\nNota mínima: " + this.notaMinima +
        "\\nCurso Requerido: " + this.cursoRequerido);
    }
}
