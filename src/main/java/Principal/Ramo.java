package Principal;

import java.util.ArrayList;

public class Ramo {
    // ATRIBUTOS
    private int id;
    private String nombre;
    
    private ArrayList<Archivo> archivos = new ArrayList<>();
    private ArrayList<Material> materiales = new ArrayList<>();
    private ArrayList<Evaluacion> evaluaciones = new ArrayList<>();
    private ArrayList<Nota> notas = new ArrayList<>();
    
    // CONSTRUCTORES
    public Ramo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public Ramo() {
        
    }
    
    // GETTERS
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Archivo> getArchivos() {
        return archivos;
    }

    public ArrayList<Material> getMateriales() {
        return materiales;
    }

    public ArrayList<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    // SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setArchivos(ArrayList<Archivo> archivos) {
        this.archivos = archivos;
    }

    public void setMateriales(ArrayList<Material> materiales) {
        this.materiales = materiales;
    }

    public void setEvaluaciones(ArrayList<Evaluacion> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }
    
    // METODOS
    public void mostrarDatos(int i) {
        System.out.println("Ramo " + (i + 1) + ": " + this.nombre);
    }
    
    public void mostrarMateriales(){
        for (int i = 0; i < this.materiales.size(); i++) {
            this.materiales.get(i).mostrarDatos(i);
        }
    }
}
