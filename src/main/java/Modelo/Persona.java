package Modelo;

public class Persona {
    // ATRIBUTOS
    private String nombre;
    private String apellido;
    private String rut;
    private String mail;
    private String contrasenya;

    // CONSTRUCTORES
    public Persona(String nombre, String apellido, String rut, String mail, String contrasenya) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.mail = mail;
        this.contrasenya = contrasenya;
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

    public String getContrasenya() {
        return contrasenya;
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
    
    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }
    
    // METODOS
    // SOBREESCRITURA DE METODOS
    public void mostrarDatos(int i) {
        System.out.println("Persona " + (i + 1) + ": \n"
                + this.getNombre() + " "
                + this.getApellido() + " \n"
                + this.getRut() + " \n"
                + this.getMail() + " \n");
    }
}
