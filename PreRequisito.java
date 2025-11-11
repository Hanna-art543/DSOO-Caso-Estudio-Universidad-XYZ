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

    //GETTERS 
    public String getID() {
        return id;
    }
    public double getNotaMinima () {
        return notaMinima;
    }
    public Curso getCursoRequerido () {
        return cursoRequerido;
    }
    
    public boolean verificarCumplimiento(Alumno a) {
        Nota notaDelCurso = a.obtenerNotaCurso(this.cursoRequerido);
        if (notaDelCurso == null) {
            return false; // No ha llevado el curso
        }
        return notaDelCurso.getValor() >= this.notaMinima;
    }

    public void mostrarInformacion () {
        System.out.println("\nPre-Requisito" +
        "\nID: " + this.id + 
        "\nCurso Requerido: " + this.cursoRequerido +
        "\nNota mínima: " + this.notaMinima);
    }
}
