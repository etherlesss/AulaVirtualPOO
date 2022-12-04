package Modelo;

import Controlador.Operaciones;
import javax.swing.JOptionPane;

public class Nota {
    // ATRIBUTOS
    private int idRamo;
    private double nota;
    private int idAlumno;
    private int idCurso;
    
    private Operaciones operaciones = new Operaciones();
    
    // CONSTRUCTORES
    public Nota(int idRamo, double nota,int idAlumno,int idCurso) {
        this.idRamo = idRamo;
        this.nota = nota;
        this.idAlumno = idAlumno;
        this.idCurso = idCurso;
    }
    
    public Nota() {
        
    }
    
    // GETTERS
    public int getIdRamo() {
        return this.idRamo;
    }

    public double getNota() {
        return this.nota;
    }
    
    public int getIdAlumno(){
        return this.idAlumno;
    }
    
    public int getIdCurso(){
        return this.idCurso;
    }
    
    public Operaciones getOperaciones() {
        return this.operaciones;
    }
    
    // SETTERS
    public void setIdRamo(int idRamo) {
        this.idRamo = idRamo;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void setIdAlumno(int id){
        this.idAlumno = id;
    }
    
    public void setIdCurso(int id){
        this.idCurso = id;
        
    }
    
    public void setOperaciones(Operaciones operaciones) {
        this.operaciones = operaciones;
    }
    
    // METODOS
    public void crearDatos(int idRamo, int idAlumno, int idCurso) {
        double notaIngresada = 0;
        
        //System.out.println("Ingrese las notas: ");
        this.idRamo = idRamo;
        this.idCurso = idCurso;
        this.idAlumno = idAlumno;
        while (notaIngresada == 0) {
            //System.out.print("Nota: ");
            notaIngresada = operaciones.validarNotaIngresada();
            System.out.println(notaIngresada);
        }
        this.nota = notaIngresada;
    }
}
