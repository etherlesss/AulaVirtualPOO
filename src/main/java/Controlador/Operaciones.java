package Controlador;

import java.util.Scanner;
import java.util.Date;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import javax.swing.JOptionPane;

public class Operaciones {
    public Scanner entrada = new Scanner(System.in);
    
    public Operaciones(){
        
    }
    
    // Metodos 
    public int decisionMenuPrincipal(int flag){
        if(flag == 1){
        System.out.println(""
            + "(1) - Agregar elemento(s)\n"
            + "(2) - Mostrar por pantalla elementos de una lista \n"
            + "(3) - Eliminar elemento(s) \n"
            + "(4) - Modificar elemento(s) \n"
            + "(0) - Salir");
        }
        else{
            System.out.println(""
            + "(1) - Mostrar por pantalla elementos de una lista \n"
            + "(0) - Salir");
        }
        System.out.print("Ingrese opcion: ");
        int opcion = entrada.nextInt();
        
        System.out.println("");
        
        return opcion;
    }
    
    public int decisionMenuAgregado(){
        System.out.println(""
            + "(1) - Agregar notas a alumno x\n"
            + "(2) - Agregar material a ramo x\n"
            + "(0) - Volver");
        
        System.out.print("Ingrese opcion: ");
        int opcion = entrada.nextInt();
        
        System.out.println("");
        
        return opcion;
    }
    
    public int decisionMenuMuestra(int flag){
        if(flag == 1){
        System.out.println(""
            + "(1) - Imprimir datos\n"
            + "(2) - Mostrar alumnos con promedios mas bajos y altos por curso\n"
            + "(3) - Mostrar las notas de los alumnos por aceptables e inaceptables\n"
            + "(0) - Volver");
        }
        else{
            System.out.println(""
            + "(1) - Imprimir avance de notas del alumno\n"
            + "(2) - Imprimir materiales pedidos por ramo\n"
            + "(3) - Exportar avance de notas del alumno\n"
            + "(0) - Volver");
        }
        System.out.print("Ingrese opcion: ");
        int opcion = entrada.nextInt();
        
        System.out.println("");
        
        return opcion;
    }
    
    public int decisionMenuEliminar(){
        System.out.println(""
                + "(1) - Eliminar nota(s) de un alumno\n"
                + "(2) - Eliminar material(es) de un ramo\n "
                + "(0) - Volver");
        System.out.print("Ingrese opcion: ");
        int opcion = entrada.nextInt();
        
        System.out.println("");
        
        return opcion;
    }
    
    public int decisionMenuUpdate(){
        System.out.println(""
                + "(1) - Cambiar nota de un ramo \n"
                + "(0) - Volver");
        System.out.print("Ingrese opcion: ");
        int opcion = entrada.nextInt();
        
        System.out.println("");
        
        return opcion;
    }
    
    public int decisionMenuSesion(int Admin){
        if(Admin == 0){
        System.out.println(""
            + "(1) - Mostrar datos alumno sesión\n"
            + "(2) - Buscar alumno por rut");
        }
        else{
            System.out.println(""
            + "(1) - Mostrar datos sesión\n"
            + "(2) - Buscar alumno por rut");
        }
        
        System.out.print("Ingrese opción: ");
        int opcion = entrada.nextInt();
        
        System.out.println("");
        
        return opcion;
    }
    
    public void ramosDisponibles(){
        JOptionPane.showMessageDialog(null,"" 
            + "1- Historia\n" 
            + "2- Matematicas\n" 
            + "3- Lenguaje\n" 
            + "4- Ciencias\n" 
            + "5- Ingles\n" 
            + "6- Educacion_Fisica\n" 
            + "7- Tecnologia\n" 
            + "8- Religion\n");
    }
    
    public double validarNotaIngresada(){
        String cadena = JOptionPane.showInputDialog("Ingrese una nota");
        double nota;
        if (cadena.matches("[0-9.]*")) {
            System.out.println(cadena);
            nota = Double.valueOf(cadena);
            System.out.print(nota);
            return nota;
        } else {
            JOptionPane.showMessageDialog(null, "Dato invalido");
            //System.out.println("Dato invalido.\n");
        }
        return 0;
    }
    public int validarNumeroIngresado(){
        String cadena = JOptionPane.showInputDialog("Ingrese cantidad de notas a agregar");
        if(cadena.matches("[1-9]*")){
            return Integer.valueOf(cadena);
        }
        else{
            JOptionPane.showMessageDialog(null, "Dato invalido");
            //System.out.println("Dato inválido.\n");
        }
        return 0;
    }
    public int validarIdIngresado(){
        String cadena = JOptionPane.showInputDialog("Ingrese un id de ramo");
        if (cadena.matches("[1-8]*")) {
            return Integer.valueOf(cadena);
        } else {
            JOptionPane.showMessageDialog(null, "Dato invalido");
            //System.out.println("Dato invalido.\n");
        }
        return 0;
    }
    
    public int validarUnidadIngresada(){
        String cadena = entrada.next();
        if (cadena.matches("[1-4]*")) {
            return Integer.valueOf(cadena);
        } else {
            JOptionPane.showMessageDialog(null, "Dato invalido");
            //System.out.println("Dato invalido.\n");
        }
        return 0;
    }
    
    public Date validarFechaIngresada(){
        String cadena;
        cadena = JOptionPane.showInputDialog(null,"Ingrese fecha de entrega (DD/MM/YYYY): ");
        DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        Date salida;
        fecha.setLenient(false);
        try {
            salida = fecha.parse(cadena);
        } catch (ParseException e){
            JOptionPane.showMessageDialog(null, "Dato invalido");
            //System.out.println("Dato invalido.\n");
            return null;
        }
        return salida;
    }
    
    public String validarMaterialesIngresados(){
        String cadena;// = entrada.useDelimiter("\n").next();
        cadena = JOptionPane.showInputDialog(null, "Ingrese materiales:");
        if (cadena.matches("[A-Za-z, ]*")) {
            return cadena;
        } else {
            JOptionPane.showMessageDialog(null, "Dato invalido");
            //System.out.println("Dato invalido.\n");
        }
        return null;
    }
    
    public String validarContenidosIngresados(){
        String cadena = entrada.useDelimiter("\n").next();
        if (cadena.matches("[A-Za-z, ]*")) {
            return cadena;
        } else {
            JOptionPane.showMessageDialog(null, "Dato invalido");
            //System.out.println("Dato invalido.\n");
        }
        return null;
    }
}
