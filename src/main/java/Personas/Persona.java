package Personas;

public class Persona {
    // ATRIBUTOS
    private String nombre;
    private String apellido;
    private String rut;
    private String mail;

    // CONSTRUCTORES
    public Persona(String nombre, String apellido, String rut, String mail) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.mail = mail;
    }
    
    public Persona() {
        
    }

    // GETTERS
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getRut() {
        return rut;
    }

    public String getMail() {
        return mail;
    }

    // SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    // METODOS
}
