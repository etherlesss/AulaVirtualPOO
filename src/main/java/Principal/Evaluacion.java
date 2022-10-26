package Principal;

import Funciones.Operaciones;
import java.util.Date;

public class Evaluacion {
    // ATRIVUTOS
    private int unidad;
    private String contenidoEvaluar;
    private Date fechaPrueba;
    
    private Operaciones operaciones = new Operaciones();
    
    // CONSTRUCTORES
    public Evaluacion(int unidad, String contenidoEvaluar, Date fechaPrueba) {
        this.unidad = unidad;
        this.contenidoEvaluar = contenidoEvaluar;
        this.fechaPrueba = fechaPrueba;
    }
    
    public Evaluacion() {
        
    }
    
    // GETTERS
    public int getUnidad() {
        return this.unidad;
    }

    public String getContenidoEvaluar() {
        return this.contenidoEvaluar;
    }

    public Date getFechaPrueba() {
        return this.fechaPrueba;
    }

    public Operaciones getOperaciones() {
        return this.operaciones;
    }
    
    // SETTERS
    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }

    public void setContenidoEvaluar(String contenidoEvaluar) {
        this.contenidoEvaluar = contenidoEvaluar;
    }

    public void setFechaPrueba(Date fechaPrueba) {
        this.fechaPrueba = fechaPrueba;
    }

    public void setOperaciones(Operaciones operaciones) {
        this.operaciones = operaciones;
    }
    
    // METODOS
    public void crearDatos() {
        int numero = 0;
        String contenido = null;
        Date fecha = null;
        
        System.out.println("Ingrese sobre que unidad sera la evaluacion (1-4): ");
        while (numero == 0) {
            System.out.print("Ingrese sobre que unidad sera la evaluacion: ");
            numero = operaciones.validarUnidadIngresada();
        }
        this.unidad = numero;
        
        System.out.println("Ingrese el contenido a evaluar (puede separar temas con comas): ");
        while (contenido == null) {
            System.out.print("Ingrese el contenido a evaluar: ");
            contenido = operaciones.validarContenidosIngresados();
        }
        this.contenidoEvaluar = contenido;
        
        System.out.println("Ingrese fecha de evaluacion (DD/MM/YYYY): ");
        while (fecha == null) {
            System.out.print("Ingrese fecha de evaluacion (DD/MM/YYYY): ");
            fecha = operaciones.validarFechaIngresada();
        }
        this.fechaPrueba = fecha;
    }
    
    public void mostrarDatos(int i) {
        System.out.println("Evaluacion " + (i + 1) + ": "
                + "Unidad " + this.unidad + ", "
                + "Contenido " + this.contenidoEvaluar + ", "
                + "Fecha de la evaluacion: " + this.fechaPrueba.toString());
    }
}
