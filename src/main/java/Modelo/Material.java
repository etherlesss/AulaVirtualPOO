package Modelo;

import Controlador.Operaciones;
import java.util.Date;
import javax.swing.JOptionPane;

public class Material {
    // ATRIBUTOS
    private String nombre; // Ejemplo: Set de lapices de colores
    private Date fechaEntrega; // Ejemplo: 22/09/2022
    
    private Operaciones operaciones = new Operaciones();
    
    // CONSTRUCTORES
    public Material(String nombre, Date fechaEntrega) {
        this.nombre = nombre;
        this.fechaEntrega = fechaEntrega;
    }
    
    public Material() {
        
    }
    
    // GETTERS
    public String getNombre() {
        return nombre;
    }

    public Date getFechaEntrega() {
        return this.fechaEntrega;
    }

    public Operaciones getOperaciones() {
        return this.operaciones;
    }
    
    // SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public void setOperaciones(Operaciones operaciones) {
        this.operaciones = operaciones;
    }
    
    // METODOS
    public void crearDatos() {
        String materiales = null;
        Date fecha = null;
        
        JOptionPane.showMessageDialog(null,"Ingrese material(es), " 
                +   "puede usar comillas para ingresar multiples materiales: ");
        while (materiales == null) {
            //System.out.print("Ingrese materiales: ");
            materiales = operaciones.validarMaterialesIngresados();
        }
        this.nombre = materiales;
        
        //JOptionPane.showMessageDialog(null,"Ingrese fecha de entrega (DD/MM/YYYY): ");
        while (fecha == null) {
            //System.out.print("Ingrese fecha de entrega: ");
            fecha = operaciones.validarFechaIngresada();
        }
        this.fechaEntrega = fecha;
    }
    
    public void mostrarDatos(int i) {
        System.out.println((i + 1) + ". "
                + this.nombre + " " + this.fechaEntrega.toString());
    }
}
