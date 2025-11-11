import java.util.ArrayList;
import java.util.List;
class Universidad {
    //Atributos 
    private String nombre;
    private List<Sucursal> sucursales;

    //Constructor sobrecargado
    public Universidad (String nombre) {
        this.nombre = nombre;
        this.sucursales = new ArrayList<>();
    }


    //Métodos getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre (String nombre) {
        this.nombre = nombre;
    }
    public List<Sucursal> getSucursales () {
        return sucursales;
    }

    //Métodos para agregar, eliminar, buscar y listar sucursales
    public boolean agregarSucursal(Sucursal sucursal) {
        if (!sucursales.contains(sucursal)) {
            sucursales.add(sucursal);
            return true;
        }
        return false;
    }

    public boolean eliminarSucursal (String nombre) {
        //Función lambda
        return this.sucursales.removeIf(s -> s.getNombre().equalsIgnoreCase(nombre));
    }

    public Sucursal buscarSucursal(String nombre) {
        for (Sucursal s : sucursales) {
            if (s.getNombre().equalsIgnoreCase(nombre)) {
                return s;
            }
        }
        return null;
    }

    public void listarSucursales() {
        System.out.println("Sucursales de la universidad " + nombre + ":");
        for (Sucursal s : sucursales) {
            System.out.println(" - " + s.getNombre());
        }
    }

    //Método para buscar un alumno
    public Alumno buscarAlumnoPorCUI (int cui) {
        for(Sucursal s : sucursales) {
            for(Facultad f : s.getFacultades()) {
                for(Carrera c : f.getCarreras()) {
                    Alumno a = c.buscarAlumno(cui);
                    if(a != null) {
                        return a;
                    }
                }
            }
        }
        return null;
    }

    public void mostrarInformacion () {
        System.out.println("UNIVERSIDAD");
        System.out.println("Nombre: "+nombre);
        System.out.println("Sucursales: "+ sucursales.size());
    }
    
}
