import java.util.ArrayList;
import java.util.List;

public class Facultad {
    private String nombre;
    private String decano;
    private Sucursal sucursal; 
    private List<Carrera> carreras;

    public Facultad(String nombre, String decano, Sucursal sucursal) {
        this.nombre = nombre;
        this.decano = decano;
        this.sucursal = sucursal;
        this.carreras = new ArrayList<>();
    }
    public boolean agregarCarrera(Carrera carrera) {
        if (!carreras.contains(carrera)) {
            carreras.add(carrera);
            carrera.setFacultad(this);
            return true;
        }
        return false;
    }
    public boolean eliminarCarrera(String nombre) {
        for (Carrera c : carreras) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                carreras.remove(c);
                return true;
            }
        }
        return false;
    }
    public Carrera buscarCarrera(String nombre) {
        for (Carrera c : carreras) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }
    public void listarCarreras() {
        System.out.println("Carreras en la facultad " + nombre + ":");
        for (Carrera c : carreras) {
            System.out.println(" - " + c.getNombre());
        }
    }
    public void mostrarInformacion() {
        System.out.println("Facultad: " + nombre);
        System.out.println("Decano: " + decano);
        System.out.println("Sucursal: " + (sucursal != null ? sucursal.getNombre() : "No asignada"));
        System.out.println("Número de carreras: " + carreras.size());
    }

    //Métodos getters y setters
    public String getNombre() {
        return nombre;
    }
    public String getDecano() {
        return decano;
    }
    public Sucursal getSucursal() {
        return sucursal;
    }
    public List<Carrera> getCarreras() {
        return carreras;
    }
    public void setDecano(String decano) {
        this.decano = decano;
    }
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}
