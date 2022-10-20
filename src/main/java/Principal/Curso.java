package Principal;

import Personas.Profesor;
import Personas.Alumno;
import java.util.ArrayList;

public class Curso {
    // ATRIBUTOS
    private int nivel; // Ejemplo: 4
    private char letra; // Ejemplo: A
    private Profesor profesorJefe;
    
    private ArrayList<Alumno> listaAlumnos = new ArrayList<>();

    // CONSTRUCTORES
    public Curso(int nivel, char letra, Profesor profesorJefe) {
        this.nivel = nivel;
        this.letra = letra;
        this.profesorJefe = profesorJefe;
    }
    
    public Curso() {
        
    }

    // GETTERS
    public int getNivel() {
        return nivel;
    }

    public char getLetra() {
        return letra;
    }

    public Profesor getProfesorJefe() {
        return profesorJefe;
    }

    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    // SETTERS
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public void setProfesorJefe(Profesor profesorJefe) {
        this.profesorJefe = profesorJefe;
    }

    public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }
    
    // METODOS
    public void mostrarDatos() {
        System.out.println(this.nivel + " Basico " + this.letra + ", "
                + "Profesor Jefe: " + this.profesorJefe.getNombre() + " "
                + this.profesorJefe.getApellido());
        
        System.out.println("Alumnos del curso: ");
        for (int i = 0; i < listaAlumnos.size(); i++) {
            listaAlumnos.get(i).mostrarDatos(i);
        }
    }
    // sobrecarga de metodos
    public void printDatosAlumno(String rut) {
        for (int i = 0; i < this.listaAlumnos.size(); i++) {
            if (this.listaAlumnos.get(i).getRut().equals(rut)) {
                System.out.println(""
                        + "Nombre: " + this.listaAlumnos.get(i).getNombre() + " " + this.listaAlumnos.get(i).getApellido() + "\n"
                        + "Rut: " + this.listaAlumnos.get(i).getRut()
                        + "Curso: " + this.nivel + this.letra + "\n"
                        + "Mail: " + this.listaAlumnos.get(i).getMail());
                return;
            }
        }
    }

    public void printDatosAlumno(int id) {
        System.out.println(""
                + "Nombre: " + this.listaAlumnos.get(id).getNombre() + " " + this.listaAlumnos.get(id).getApellido() + "\n"
                + "Rut: " + this.listaAlumnos.get(id).getRut()
                + "Curso: " + this.nivel + this.letra + "\n"
                + "Mail: " + this.listaAlumnos.get(id).getMail());

    }
}
