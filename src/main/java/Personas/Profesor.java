package Personas;

import Principal.Ramo;

public class Profesor extends Persona {
    // ATRIBUTOS
    private Ramo ramo;
    
    // CONSTRUCTORES
    public Profesor(Ramo ramo, String nombre, String apellido, String rut, String mail, String contrasenya) {
        super(nombre, apellido, rut, mail, contrasenya);
        this.ramo = ramo;
    }

    public Profesor(Ramo ramo) {
        this.ramo = ramo;
    }
    
    public Profesor() {
        
    }
    
    // GETTERS
    public Ramo getRamo() {
        return ramo;
    }

    // SETTERS
    public void setRamo(Ramo ramo) {
        this.ramo = ramo;
    }
    
    // METODOS
    public void mostrarDatos(int i) {
        System.out.println("Profesor " + (i + 1) + ": \n"
                + this.getNombre() + " "
                + this.getApellido() + " \n"
                + this.getRut() + " \n"
                + this.getMail() + " \n"
                + "Ramo que imparte: " + this.ramo.getNombre());
    }
}
