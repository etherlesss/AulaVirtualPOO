package Modelo;

import java.util.ArrayList;

public class Alumno extends Persona {
    // ATRIBUTOS
    int idCurso;
    
    private ArrayList<Ramo> asignaturas = new ArrayList<>();

    // CONSTRUCTORES
    public Alumno(int idCurso, String nombre, String apellido, String rut, String mail, String contrasenya) {
        super(nombre, apellido, rut, mail, contrasenya);
        this.idCurso = idCurso;
    }

    public Alumno(int idCurso) {
        this.idCurso = idCurso;
    }
    
    public Alumno() {
        
    }
    
    // GETTERS
    public int getIdCurso() {
        return idCurso;
    }

    public ArrayList<Ramo> getAsignaturas() {
        return asignaturas;
    }

    // SETTERS
    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public void setAsignaturas(ArrayList<Ramo> asignaturas) {
        this.asignaturas = asignaturas;
    }
    
    // METODOS
    public void mostrarDatos(int i) {
        System.out.println("Alumno " + (i + 1) + ": "
                + this.getNombre() + " "
                + this.getApellido() + " "
                + this.getRut() + " "
                + this.getMail());
        
        /*
        System.out.println("Asignaturas que tiene el alumno: ");
        for (int j = 0; j < asignaturas.size(); j++) {
            System.out.println((j + 1)+ "- "
                    + this.asignaturas.get(j).getNombre());
        }
        */
    }
}
