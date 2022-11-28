package Modelo;

public class Archivo {
    // ATRIBUTOS
    private String nombre; // Ejemplo: Suma_y_Resta
    private String tipoArchivo; // Ejemplo: PDF
    
    // CONSTRUCTORES
    public Archivo(String nombre, String tipoArchivo) {
        this.nombre = nombre;
        this.tipoArchivo = tipoArchivo;
    }
    
    public Archivo() {
        
    }
    
    // GETTERS
    public String getNombre() {
        return nombre;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }
    
    // SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }
    
    // METODOS
    
}
