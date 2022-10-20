package Personas;

import Principal.Ramo;

public class Profesor extends Persona {
    // ATRIBUTOS
    private Ramo ramo;
    
    // CONSTRUCTORES
    public Profesor(Ramo ramo, String nombre, String apellido, String rut, String mail) {
        super(nombre, apellido, rut, mail);
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
        System.out.println("Profesor " + (i + 1) + ": "
                + this.getNombre() + " "
                + this.getApellido() + " "
                + this.getRut() + " "
                + this.getMail() + " "
                + "Ramo que imparte: " + this.ramo.getNombre());
    }
}
