import java.util.ArrayList;
import java.util.List;

public class Sucursal {
    //Atributos 
    private String nombre;
    private String tipoSede;
    private String ciudad;
    private String direccion;
    private List<Facultad> facultades;

    public Sucursal(String nombre, String tipoSede, String ciudad, String direccion) {
        this.nombre = nombre;
        this.tipoSede = tipoSede;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.facultades = new ArrayList<>();
    }

    //Métodos getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre (String nombre) {
        this.nombre = nombre;
    }
    public String getTipoSede() {
        return tipoSede;
    }
    public String getCiudad () {
        return ciudad;
    }
    public String getDireccion() {
        return direccion;
    }
    public List<Facultad> getFacultades() {
        return facultades;
    }

    public boolean agregarFacultad(Facultad facultad) {
        if (!facultades.contains(facultad)) {
            facultades.add(facultad);
            facultad.setSucursal(this);
            return true;
        }
        return false;
    }
    public boolean eliminarFacultad(String nombre) {
        //Función lambda (devuleve true si se eliminó)
        return this.facultades.removeIf(f -> f.getNombre().equalsIgnoreCase(nombre));
    }
    public Facultad buscarFacultad(String nombre) {
        for (Facultad f : facultades) {
            if (f.getNombre().equalsIgnoreCase(nombre)) {
                return f;
            }
        }
        return null;
    }
    public void listarFacultades() {
        System.out.println("Facultades en la sucursal " + nombre + ":");
        for (Facultad f : facultades) {
            System.out.println(" - " + f.getNombre());
        }
    }

    public void mostrarInformacion() {
        System.out.println("Sucursal: " + nombre);
        System.out.println("Tipo de sede: " + tipoSede);
        System.out.println("Dirección: " + direccion);
        System.out.println("Número de facultades: " + facultades.size());
    }

}
