package Principal;

import Controlador.*;
import Modelo.*;
import Controlador.Operaciones;
import SesionClase.InicioControl;
import SesionFrame.VerInicio;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AulaVirtualEP3 {
    // AVANCE (datos) GENERAL(es) DEL COLEGIO
    public static ArrayList<Curso> cursos = new ArrayList<>();
    public static ArrayList<Ramo> ramos = new ArrayList<>();
    public static ArrayList<Alumno> alumnos = new ArrayList<>();
    public static ArrayList<Profesor> profesores = new ArrayList<>();
    // SCANNER
    public static Scanner Entrada = new Scanner(System.in);
    // OPERACIONES
    public static Operaciones operaciones = new Operaciones();
    
    public static void main(String[] args) throws FileNotFoundException {
        // LEER
        Lectura.leerDatos();
        
        // ASIGNAR
        Asignacion.asignarDatos();
        
        // MOSTRAR - PARA MANTENIMIENTO
        /*
        mostrarCursos();
        mostrarRamos();
        mostrarAlumnos();
        mostrarProfesores();
        */
        
        // CUADRO DE INICIO DE SESION
        VerInicio ventana = new VerInicio(null,true);
        new InicioControl(ventana);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
      
    /*
        MENU
    */
    public static void menu(int Admin, String rut){
        int opcion;
        int[] indicesAlumno = new int[2];
        if(Admin == 0){
            

            indicesAlumno = getIndiceAlumno(rut);

        }
        else{
            
            for (int i = 0; i < profesores.size(); i++) {
                if(profesores.get(i).getRut().equals(rut)){
                    indicesAlumno[0] = i;
                }
            }
        }
        
        if(Admin == 1){
            opcion = operaciones.decisionMenuPrincipal(Admin);
            while (opcion != 0) {
                switch (opcion) {
                    //Agregar Elemento(s)
                    case 1:
                        subMenuCase1();
                        break;
                    //Mostrar elementos lista
                    case 2:
                        subMenuCase2(indicesAlumno,Admin);
                        break;
                    case 3:
                        //Eliminar 
                        subMenuCase3(indicesAlumno);
                        break;
                    case 4:
                        subMenuCase4();
                        break;
                    default:
                        System.out.println(""
                                + "El numero ingresado no corresponde a ninguna opcion.\n"
                                + "Intente otra vez.");
                        break;
                }
                opcion = operaciones.decisionMenuPrincipal(Admin);
            }
        }
        else{
            opcion = operaciones.decisionMenuPrincipal(Admin);
            while (opcion != 0) {
                switch (opcion) {
                    //Mostrar Elemento(s)
                    case 1:
                        subMenuCase2(indicesAlumno, Admin);
                        break;
                    default:
                        System.out.println(""
                                + "El numero ingresado no corresponde a ninguna opcion.\n"
                                + "Intente otra vez.");
                        break;
                }
                opcion = operaciones.decisionMenuPrincipal(Admin);
            }
        }
    }
    
    public static int[] getIndiceAlumno(String rutBuscado) {
        int[] indicesAlumno = new int[2];
        int i, j;
        
        for (i = 0; i < cursos.size(); i++) {
            for (j = 0; j < cursos.get(i).getListaAlumnos().size(); j++) {
                if (rutBuscado.equals(cursos.get(i).getListaAlumnos().get(j).getRut())) {
                    indicesAlumno[0] = i;
                    indicesAlumno[1] = j;
                    return indicesAlumno;
                }
            }
        }
        return null;
    }
    public static int[] getIndiceAlumnoAdmin() {
        int[] indicesAlumno = new int[2];
        int i, j;
          
        System.out.print("Ingrese el rut del alumno (con puntos y guion): ");
        String rutBuscado = Entrada.next();
        
        for (i = 0; i < cursos.size(); i++) {
            for (j = 0; j < cursos.get(i).getListaAlumnos().size(); j++) {
                if (rutBuscado.equals(cursos.get(i).getListaAlumnos().get(j).getRut())) {
                    indicesAlumno[0] = i;
                    indicesAlumno[1] = j;
                    return indicesAlumno;
                }
            }
        }
        return null;
    }
    
    public static void subMenuCase1(){
        int opcion, idRamo, flag = 1;
        int[] indicesAlumno = new int[2];
        opcion = operaciones.decisionMenuAgregado();
        
        while (opcion != 0) {
            switch (opcion) {
                case 1:
                    int cantidad;
                        indicesAlumno = getIndiceAlumnoAdmin();
                        while(flag == 1){
                            if(indicesAlumno != null){
                                operaciones.ramosDisponibles();
                                System.out.print("Ingrese el id del ramo: ");
                                idRamo = operaciones.validarIdIngresado();
                                while (idRamo == 0){
                                    System.out.print("Vuelva a ingresar el id del ramo: ");
                                    idRamo = operaciones.validarIdIngresado();
                                }
                                        
                                System.out.print("Ingrese cantidad de notas a agregar: ");
                                cantidad = operaciones.validarNumeroIngresado();
                                while(cantidad == 0){
                                    cantidad = operaciones.validarNumeroIngresado();
                                }
                                for (int k = 0; k < cantidad; k++) {
                                    Nota notaNueva = new Nota();
                                    notaNueva.crearDatos(idRamo);
                                    for (int l = 0; l < cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().size(); l++) {
                                        if (cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(l).getId() == idRamo) {
                                            cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(l).getNotas().add(notaNueva);
                                        }
                                    }
                                }
                                System.out.println("Nota(s) añadidas con éxito.");
                                flag = 0;
                            }
                            else{
                                System.out.print("Rut inválido\n");
                                indicesAlumno = getIndiceAlumnoAdmin();
                            }
                        }
                    break;
                case 2:
                    operaciones.ramosDisponibles();
                    System.out.print("Ingrese el id del ramo: ");
                    idRamo = operaciones.validarIdIngresado();
                    while (idRamo == 0){
                        System.out.print("Vuelva a ingresar el id del ramo: ");
                        idRamo = operaciones.validarIdIngresado();
                    }

                    Material materialNuevo = new Material();
                    materialNuevo.crearDatos();
                    
                    for (int i = 0; i < ramos.size(); i++) {
                        if (idRamo == ramos.get(i).getId()) {
                            ramos.get(i).getMateriales().add(materialNuevo);
                        }
                    }
                    System.out.println("Material agregado con exito.\n");
                    break;
                    
                default:
                    System.out.println("El numero ingresado no corresponde a ninguna opcion.");
                    System.out.println("Intente otra vez.");
                    break;
            }
            opcion = operaciones.decisionMenuAgregado();
        }
    }

    // MENU DE IMPRESION DE DATOS (MOSTRAR)
    public static void subMenuCase2(int[] indicesAlumno, int Admin) {
        int opcion;
        
        opcion = operaciones.decisionMenuMuestra(Admin);
        
        while (opcion != 0) {
            if(Admin == 1){
                switch (opcion) {
                    case 1:
                        opcion = operaciones.decisionMenuSesion(Admin);
                        while (opcion == 0) {
                            System.out.println(""
                                + "Numero no corresponde a ninguna opcion\n"
                                + "Intente otra vez");
                            opcion = operaciones.decisionMenuSesion(Admin);
                        }
                        if (opcion == 1) {
                            profesores.get(indicesAlumno[0]).mostrarDatos(indicesAlumno[0]);
                        }
                        if (opcion == 2) {
                            System.out.println("Ingrese rut: ");
                            String rutBuscado = Entrada.next();
                            
                            for (int i = 0; i < cursos.size(); i++) {
                                for (int j = 0; j < cursos.get(i).getListaAlumnos().size(); j++) {
                                    if (cursos.get(i).getListaAlumnos().get(j).getRut().equals(rutBuscado)) {
                                        cursos.get(i).printDatosAlumno(rutBuscado);
                                        double promedio = 0, contador = 0;
                                        System.out.println("Lista de notas ordenadas por ramo: ");
                                        for (int l = 0; l < ramos.size(); l++) {
                                            System.out.println("Notas de " + ramos.get(l).getNombre() + ": ");
                                            for (int k = 0; k < cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().size(); k++) {
                                                for (int n = 0; n < cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getNotas().size(); n++) {
                                                    if (cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getNotas().get(n).getIdRamo() == ramos.get(l).getId()) {
                                                        promedio += cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getNotas().get(n).getNota();
                                                        System.out.print(cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getNotas().get(n).getNota() + " ");
                                                        contador++;
                                                    }
                                                }
                                            }
                                            System.out.println("");
                                        }
                                        if (contador != 0) {
                                        System.out.println("El promedio de " + ramos.get(j).getNombre()
                                                        + " es " + promedio / contador);
                                        }
                                        else {
                                            System.out.println("Este ramo no tiene notas.");
                                        }
                                        promedio = 0;
                                        contador = 0;
                                    }
                                }
                            }
                        }
                        break;     
                }
                opcion = operaciones.decisionMenuMuestra(Admin);
            }
            else{
                switch (opcion) {
                    case 1:
                        double promedio = 0, contador = 0;
                        
                        System.out.println("Lista de notas ordenadas por ramo: ");
                        for (int j = 0; j < ramos.size(); j++) {
                            System.out.println("Notas de " + ramos.get(j).getNombre() + ": ");
                            for (int k = 0; k < cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().size(); k++) {
                                for (int i = 0; i < cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getNotas().size(); i++) {
                                    if (cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getNotas().get(i).getIdRamo() == ramos.get(j).getId()) {
                                        promedio += cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getNotas().get(i).getNota();
                                        System.out.print(cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getNotas().get(i).getNota() + " ");
                                        contador++;
                                    }
                                }
                                System.out.println("");
                            }
                            
                            if (contador != 0) {
                                System.out.println("El promedio de " + ramos.get(j).getNombre()
                                        + " es " + promedio / contador);
                            } else {
                                System.out.println("Este ramo no tiene notas.");
                            }
                            
                            promedio = 0;
                            contador = 0;
                        }
                        break;
                        
                    case 2:
                        System.out.println("Materiales por ramo: ");
                        for (int i = 0; i < ramos.size(); i++) {
                            System.out.println(ramos.get(i).getNombre());
                            ramos.get(i).mostrarMateriales();
                        }
                        break;
                    case 3:
                        exportarNotas(indicesAlumno);
                        System.out.println("\nAVANCE DE NOTAS GUARDADOS EXITOSAMENTE EN: src/test/java/out/InformeNotas.txt\n");
                        break;
                        
                    default:
                        System.out.println("El numero ingresado no corresponde a ninguna opcion.");
                        System.out.println("Intente otra vez.");
                        break;
                }
                opcion = operaciones.decisionMenuMuestra(Admin);
            }
        }
    }
        
    //MENU DE ELIMINAR
    public static void subMenuCase3(int[] indicesAlumno){
        int opcion, idRamo;
        
        opcion = operaciones.decisionMenuEliminar();
        while(opcion != 0){
            switch(opcion){
                case 1:
                    //Elimminar nota             
                    int opcionNota;
                    operaciones.ramosDisponibles();
                    
                    
                    System.out.print("Ingrese el ramo: ");
                    idRamo = operaciones.validarIdIngresado();
                    while(idRamo == 0){
                        System.out.print("Ingrese un valor válido: ");
                        idRamo = operaciones.validarIdIngresado();
                    }
                    for (int j = 0; j < ramos.size(); j++){
                        if(ramos.get(j).getId() == idRamo){
                            System.out.println("Notas de " + ramos.get(j).getNombre() + ": ");
                            for (int k = 0; k < cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().size(); k++) {
                                for (int i = 0; i < cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getNotas().size(); i++) {
                                    if (cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getId() == ramos.get(j).getId()) {
                                        System.out.println("[ "+ i +" ] " + cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getNotas().get(i).getNota());
                                    }
                                }
                            }
                        }
                    }
                    opcionNota = Entrada.nextInt();
                    try{
                    for (int j = 0; j < ramos.size(); j++){
                        if(ramos.get(j).getId() == idRamo){
                            for (int k = 0; k < cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().size(); k++) {
                                if (cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getId() == ramos.get(j).getId()) {
                                    cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getNotas().remove(opcionNota);
                                    System.out.println("Operación realizada correctamente.");
                                    j = ramos.size();
                                    break;
                                }
                            }
                        }
                    }
                    }
                    catch(Exception e){
                        System.out.println("Hubo un error en la operación.");
                    }
                    
                    break;
                case 2:
                    //Eliminar material
                    int i, opcionMaterial;
                    operaciones.ramosDisponibles();
                    
                    System.out.print("Ingrese el ramo: ");
                    i = Entrada.nextInt();
                    
                    for (int j = 0; j < ramos.get(i-1).getMateriales().size(); j++) {
                        ramos.get(i-1).getMateriales().get(j).mostrarDatos(j);
                    }

                    System.out.print("Ingrese material a eliminar: ");
                    
                    opcionMaterial = Entrada.nextInt();
                    //hacer un try catch (crei que ese era el problema)
                    for(int j = 0; j < ramos.get(i-1).getMateriales().size();j++){
                        if(j == opcionMaterial-1){
                            ramos.get(i-1).getMateriales().remove(j);
                            System.out.println("Material eliminado correctamente.");
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("El numero ingresado no corresponde a ninguna opcion.");
                    System.out.println("Intente otra vez.");
                    break;
            }
            opcion = operaciones.decisionMenuEliminar();
        }
    }
    // MENU DE REEMPLAZAR
    public static void subMenuCase4(){
        int opcion, idRamo, flag = 1;
        int[] indicesAlumno = new int[2];
        
        opcion = operaciones.decisionMenuUpdate();
        while(opcion != 0){
            switch(opcion){
                case 1:
                    int opcionNota;
                    double nuevaNota;
                    indicesAlumno = getIndiceAlumnoAdmin();
                        while(flag == 1){
                            if(indicesAlumno != null){
                                operaciones.ramosDisponibles();
                                System.out.print("Ingrese el id del ramo: ");
                                idRamo = operaciones.validarIdIngresado();
                                while (idRamo == 0){
                                    System.out.print("Vuelva a ingresar el id del ramo: ");
                                    idRamo = operaciones.validarIdIngresado();
                                }
                                for (int j = 0; j < ramos.size(); j++){
                                    if(ramos.get(j).getId() == idRamo){
                                        System.out.println("Notas de " + ramos.get(j).getNombre() + ": ");
                                        for (int k = 0; k < cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().size(); k++) {
                                            for (int i = 0; i < cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getNotas().size(); i++) {
                                                if (cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getId() == ramos.get(j).getId()) {
                                                    System.out.println("[ "+ i +" ] " + cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getNotas().get(i).getNota());
                                                }
                                            }
                                        }
                                    }
                                }
                                opcionNota = Entrada.nextInt();
                                try{
                                    for (int j = 0; j < ramos.size(); j++){
                                        if(ramos.get(j).getId() == idRamo){
                                            for (int k = 0; k < cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().size(); k++) {
                                                if (cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getId() == ramos.get(j).getId()) {
                                                    System.out.println("Ingrese nueva nota: ");
                                                    nuevaNota = operaciones.validarNotaIngresada();
                                                    cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getNotas().get(opcionNota).setNota(nuevaNota);
                                                    System.out.println("Operación realizada correctamente.");
                                                    j = ramos.size();
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                                catch(Exception e){
                                    System.out.println("Hubo un error en la operación.");
                                }
                                flag = 0;
                            }
                            else{
                                System.out.print("Rut inválido\n");
                                indicesAlumno = getIndiceAlumnoAdmin();
                            }
                        }
                    break;
                default:
                    System.out.println(""
                        + "El numero ingresado no corresponde a ninguna opcion.\n"
                        + "Intente otra vez.");
                    break;
            }
            opcion = operaciones.decisionMenuUpdate();
        }
    }
    /*
        EXPORTACION DE DATOS
    */
    public static void exportarNotas(int[] indicesAlumno) {
        try {
            PrintWriter writer = new PrintWriter("src/test/java/out/InformeNotas1.txt", "UTF-8");
            double promedio = 0, contador = 0;
            
            writer.println("Lista de notas ordenadas por ramo: ");
            writer.println("-----------------------------------");
            
            for (int j = 0; j < ramos.size(); j++) {
                writer.println("Notas de " + ramos.get(j).getNombre() + ": ");
                for (int k = 0; k < cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().size(); k++) {
                    for (int i = 0; i < cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getNotas().size(); i++) {
                        if (cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getNotas().get(i).getIdRamo() == ramos.get(j).getId()) {
                            promedio += cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getNotas().get(i).getNota();
                            writer.print(cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getNotas().get(i).getNota() + " ");
                            contador++;
                        }
                    }
                }
                        
                if (contador != 0) {
                    writer.println("El promedio de " + ramos.get(j).getNombre()
                            + " es " + promedio / contador);
                } else {
                    writer.println("Este ramo no tiene notas.");
                }
                        
                promedio = 0;
                contador = 0;
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*
        VISUALIZACION DE DATOS - PARA MANTENIMIENTO
    */
    public static void mostrarCursos() {
        System.out.println("Lista de Cursos: ");
        for (int i = 0; i < cursos.size(); i++) {
            cursos.get(i).mostrarDatos();
        }
        System.out.println("---------------------------");
    }
    
    public static void mostrarRamos() {
        System.out.println("Lista de Ramos: ");
        for (int i = 0; i < ramos.size(); i++) {
            ramos.get(i).mostrarDatos(i);
        }
        System.out.println("---------------------------");
    }
    
    public static void mostrarAlumnos() {
        System.out.println("Lista de alumnos: ");
        for (int i = 0; i < alumnos.size(); i++) {
            alumnos.get(i).mostrarDatos(i);
        }
        System.out.println("---------------------------");
    }
    
    public static void mostrarProfesores() {
        System.out.println("Lista de profesores: ");
        for (int i = 0; i < profesores.size(); i++) {
            profesores.get(i).mostrarDatos(i);
        }
        System.out.println("---------------------------");
    }
}
