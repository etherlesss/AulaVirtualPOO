package Principal;

import au.com.bytecode.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


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
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;
import javax.swing.JOptionPane;

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
    /*
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
            //llamar ventana profe
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
    */
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
        
        String rutBuscado = JOptionPane.showInputDialog("Ingrese el rut del alumno (con puntos y guion):");
        
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
    
    public static void subMenuCase1(int clave){
        int opcion, idRamo, flag = 1;
        int[] indicesAlumno = new int[2];
        opcion = clave;//operaciones.decisionMenuAgregado();
        
        while (opcion != 0) {
            switch (opcion) {
                case 1:
                    int cantidad;
                        indicesAlumno = getIndiceAlumnoAdmin();
                        while(flag == 1){
                            if(indicesAlumno != null){
                                //operaciones.ramosDisponibles();
                                JOptionPane.showMessageDialog(null, "id de ramos:\n"
                                        + "\"1- Historia\" \n" 
                                        + "\"2- Matematicas\" \n" 
                                        + "\"3- Lenguaje\" \n" 
                                        + "\"4- Ciencias\" \n" 
                                        + "\"5- Ingles\" \n" 
                                        + "\"6- Educacion_Fisica\" \n" 
                                        + "\"7- Tecnologia\" \n"
                                        + "\"8- Religion\");");
                                //System.out.print("Ingrese el id del ramo: ");
                                String Dato;// = JOptionPane.showInputDialog("Ingrese el id del ramo:");
                                //idRamo = Integer.valueOf(Dato);
                                idRamo = operaciones.validarIdIngresado();
                                while (idRamo == 0){
                                    //System.out.print("Vuelva a ingresar el id del ramo: ");
                                    //Dato = JOptionPane.showInputDialog("Vuelva a ingresar el id del ramo:");
                                    //idRamo = Integer.valueOf(Dato);
                                    idRamo = operaciones.validarIdIngresado();
                                }
                                        
                                //System.out.print("Ingrese cantidad de notas a agregar: ");
                                //Dato = JOptionPane.showInputDialog("Ingrese cantidad de notas a agregar");
                                //cantidad = Integer.valueOf(Dato);
                                cantidad = operaciones.validarNumeroIngresado();
                                while(cantidad == 0){
                                    cantidad = operaciones.validarNumeroIngresado();
                                }
                                for (int k = 0; k < cantidad; k++) {
                                    Nota notaNueva = new Nota();
                                    notaNueva.crearDatos(idRamo,indicesAlumno[1],indicesAlumno[0]);
                                    ramos.get(idRamo-1).getNotas().add(notaNueva);
                                }
                                JOptionPane.showMessageDialog(null, "Nota(s) añadidas con éxito");
                                //System.out.println("Nota(s) añadidas con éxito.");
                                flag = 0;
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Rut invalido");
                                //System.out.print("Rut inválido\n");
                                indicesAlumno = getIndiceAlumnoAdmin();
                            }
                        }
                    break;
                case 2:
                    operaciones.ramosDisponibles();
                    //System.out.print("Ingrese el id del ramo: ");
                    idRamo = operaciones.validarIdIngresado();
                    while (idRamo == 0){
                        //System.out.print("Vuelva a ingresar el id del ramo: ");
                        idRamo = operaciones.validarIdIngresado();
                    }

                    Material materialNuevo = new Material();
                    materialNuevo.crearDatos();
                    
                    for (int i = 0; i < ramos.size(); i++) {
                        if (idRamo == ramos.get(i).getId()) {
                            ramos.get(i).getMateriales().add(materialNuevo);
                        }
                    }
                    //System.out.println("Material agregado con exito.\n");
                    break;
                    
                default:
                    System.out.println("El numero ingresado no corresponde a ninguna opcion.");
                    System.out.println("Intente otra vez.");
                    break;
            }
            opcion = 0;//operaciones.decisionMenuAgregado();
        }
    }

    // MENU DE IMPRESION DE DATOS (MOSTRAR)
    public static void subMenuCase2(int[] indicesAlumno, int Admin, int clave, int claveDatos) {
        int opcion;
        opcion = clave; //operaciones.decisionMenuMuestra(Admin);
        
        while (opcion != 0) {
            if(Admin == 1){
                switch (opcion) {
                    case 1:
                        opcion = claveDatos;//operaciones.decisionMenuSesion(Admin);
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
                            //System.out.println("Ingrese rut: ");
                            String rutBuscado = JOptionPane.showInputDialog("Ingrese el rut del alumno a buscar");//Entrada.next();
                            
                            int[] indicesAlumnoBuscado = new int[2];
                            
                            indicesAlumnoBuscado = getIndiceAlumno(rutBuscado);
                            for (int i = 0; i < cursos.size(); i++) {
                                for (int j = 0; j < cursos.get(i).getListaAlumnos().size(); j++) {
                                    if (cursos.get(i).getListaAlumnos().get(j).getRut().equals(rutBuscado)) {
                                        cursos.get(i).printDatosAlumno(rutBuscado);
                                        double promedio = 0, contador = 0;
                                        System.out.println("Lista de notas ordenadas por ramo: ");
                                        for (int l = 0; l < ramos.size(); l++) {
                                            System.out.println("Notas de " + ramos.get(l).getNombre() + ": ");
                                                for (int n = 0; n < ramos.get(l).getNotas().size(); n++) {
                                                    if(validarIDS(l,n,indicesAlumnoBuscado[0],indicesAlumnoBuscado[1],ramos.get(l).getId())){
                                                        promedio += ramos.get(l).getNotas().get(n).getNota();
                                                        System.out.print(ramos.get(l).getNotas().get(n).getNota()+" ");
                                                        contador++;
                                                    }
                                                }
                                            System.out.println("");
                                            if (contador != 0) {
                                            System.out.println("El promedio de " + ramos.get(l).getNombre()
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
                        }
                        break;    
                    case 2:
                        double promedioRamo = 0, promedioTotal =0, menor = 0, mayor = 0;
                        ArrayList<Alumno> alumnosMenores = new ArrayList();
                        ArrayList<Double> notasMenores = new ArrayList(); 
                        
                        ArrayList<Alumno> alumnosMayores = new ArrayList();
                        ArrayList<Double> notasMayores = new ArrayList();
                        
                        //por todos los cursos
                        for (int i = 0; i < cursos.size(); i++) {
                            Alumno alumnMen = new Alumno();
                            Alumno alumnMay = new Alumno();
                            for (int j = 0; j < cursos.get(i).getListaAlumnos().size(); j++) {
                                for (int k = 0; k < ramos.size(); k++) {
                                    for (int l = 0; l < ramos.get(k).getNotas().size(); l++) {
                                        if(validarIDS(k,l,i,j,ramos.get(k).getId())){
                                            promedioRamo += ramos.get(k).getNotas().get(l).getNota();
                                        }
                                    }
                                    promedioTotal += promedioRamo/8;
                                    promedioRamo = 0;
                                }
                                if(j == 0){
                                    menor = promedioTotal/8;
                                    mayor = promedioTotal/8;
                                    alumnMen = cursos.get(i).getListaAlumnos().get(j);
                                    alumnMay = cursos.get(i).getListaAlumnos().get(j);
                                }
                                if(promedioTotal < menor){
                                    menor = promedioTotal/8;
                                    alumnMen = cursos.get(i).getListaAlumnos().get(j);
                                }
                                if(promedioTotal > mayor){
                                    mayor = promedioTotal/8;
                                    alumnMay = cursos.get(i).getListaAlumnos().get(j);
                                }  
                                promedioTotal = 0;                             
                            }
                            alumnosMenores.add(alumnMen);
                            alumnosMayores.add(alumnMay);
                            notasMenores.add(menor);
                            notasMayores.add(mayor);
                            
                        }
                        
                        System.out.println("Alumnos con el menor promedio de todos los cursos: ");
                        for (int i = 0; i < alumnosMenores.size(); i++) {
                            System.out.println(alumnosMenores.get(i).getRut() +" "+notasMenores.get(i));
                        }
                        System.out.println("Alumnos con el mayor promedio de todos los cursos: ");
                        for (int i = 0; i < alumnosMayores.size(); i++) {
                            System.out.println(alumnosMayores.get(i).getRut()+" "+notasMayores.get(i));
                        }
                        /*
                        for (int i = 0; i < cursos.size(); i++) {
                            Alumno alumnoMenor = new Alumno();
                            Alumno alumnoMayor = new Alumno();
                            for (int j = 0; j < cursos.get(i).getListaAlumnos().size(); j++) {
                                for (int k = 0; k < ramos.size(); k++) {
                                    for (int l = 0; l < ramos.get(k).getNotas().size(); l++) {
                                        if(validarIDS(k,l,i,j,ramos.get(i).getId())){
                                            promedioRamo += ramos.get(k).getNotas().get(l).getNota();
                                        }
                                    }
                                    promedioTotal += promedioRamo/8;
                                    promedioRamo = 0;
                                }
                                promedioTotal = promedioTotal/8;
                                if(j == 0){
                                    
                                    menor = promedioTotal;
                                    mayor = promedioTotal;
                                    alumnoMenor =cursos.get(i).getListaAlumnos().get(j);
                                    alumnoMayor = cursos.get(i).getListaAlumnos().get(i);
                                }
                                
                                if(promedioTotal < menor){
                                    menor = promedioTotal;
                                    alumnoMenor = cursos.get(i).getListaAlumnos().get(j);
                                }
                                if(promedioTotal > mayor){
                                    mayor = promedioTotal;
                                    alumnoMayor = cursos.get(i).getListaAlumnos().get(i);
                                }
                            }
                            alumnosMenores.add(alumnoMenor);
                            notasMenores.add(menor);
                            alumnosMayores.add(alumnoMayor);
                            notasMayores.add(mayor);
                            promedioTotal = 0;
                        }
                        System.out.println("Alumnos con el menor promedio de todos los cursos: ");
                        for (int i = 0; i < alumnosMenores.size(); i++) {
                            System.out.println(alumnosMenores.get(i).getRut() + " " + notasMenores.get(i));
                        }
                        System.out.println("");
                        System.out.println("Alumnos con el mayor promedio de todos los cursos: ");
                        for (int i = 0; i < alumnosMayores.size(); i++) {
                            System.out.println(alumnosMayores.get(i).getRut() + " " + notasMayores.get(i));
                        }*/
                        break;    
                    //ver alumnos con notas entre 4.0 y 7.0
                    case 3:
                        promedioRamo = 0;
                        promedioTotal = 0;
                        ArrayList<Alumno> alumnosAceptables = new ArrayList();
                        ArrayList<Double> notasAceptables = new ArrayList();
                        ArrayList<Alumno> alumnosInaceptables = new ArrayList();
                        ArrayList<Double> notasInaceptables = new ArrayList();
                        ArrayList<Alumno> alumnosBuenos = new ArrayList();
                        ArrayList<Double> notasBuenas = new ArrayList();
                        for (int i = 0; i < cursos.size(); i++) {
                            for (int j = 0; j < cursos.get(i).getListaAlumnos().size(); j++) {
                                for (int k = 0; k < ramos.size(); k++) {
                                    for (int l = 0; l < ramos.get(k).getNotas().size(); l++) {
                                        
                                        if(validarIDS(k,l,i,j,ramos.get(k).getId())){
                                            promedioRamo += ramos.get(k).getNotas().get(l).getNota();
                                        }
                                    }
                                    promedioTotal += promedioRamo/8;
                                    promedioRamo = 0;
                                }
                                
                                promedioTotal = promedioTotal/8;
                                
                                //compraraciones
                                if(promedioTotal > 4.0 && promedioTotal < 5.0){
                                    notasAceptables.add(promedioTotal);
                                    alumnosAceptables.add(cursos.get(i).getListaAlumnos().get(j));
                                }
                                if(promedioTotal < 4.0){
                                    notasInaceptables.add(promedioTotal);
                                    alumnosInaceptables.add(cursos.get(i).getListaAlumnos().get(j));
                                }
                                if(promedioTotal > 5.0){
                                    notasBuenas.add(promedioTotal);
                                    alumnosBuenos.add(cursos.get(i).getListaAlumnos().get(j));
                                }
                            }
                        }
                        
                        System.out.println("Alumnos con promedio general mayor a 5.0: ");
                        for (int i = 0; i < notasBuenas.size(); i++) {
                            System.out.println(alumnosBuenos.get(i).getRut() + " " + notasBuenas.get(i));
                        }
                        System.out.println("");
                        System.out.println("Alumnos con promedio general mayor a 4.0 y menor a 5.0: ");
                        for (int i = 0; i < notasAceptables.size(); i++) {
                            System.out.println(alumnosAceptables.get(i).getRut() + " " + notasAceptables.get(i));
                        }
                        System.out.println("");
                        System.out.println("Alumnos con promedio general menor a 4.0: ");
                        for (int i = 0; i < notasInaceptables.size(); i++) {
                            System.out.println(alumnosInaceptables.get(i).getRut() + " " + notasInaceptables.get(i));
                        }
                        
                        break;
                    default:
                        break;
                }
                opcion = 0;//operaciones.decisionMenuMuestra(Admin);
            }
            else{
                switch (opcion) {
                    case 1:
                        double promedio = 0, contador = 0;
                        System.out.println("Lista de notas ordenadas por ramo: ");
                        for (int j = 0; j < ramos.size(); j++) {
                            System.out.println("Notas de " + ramos.get(j).getNombre() + ": ");
                                for (int i = 0; i < ramos.get(j).getNotas().size(); i++) {
                                    if(validarIDS(j,i,indicesAlumno[0],indicesAlumno[1],ramos.get(j).getId())){
                                        promedio += ramos.get(j).getNotas().get(i).getNota();
                                        System.out.print(ramos.get(j).getNotas().get(i).getNota() + " ");
                                        contador++;
                                    }
                            }
                            System.out.println("");
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
                opcion = 0;//operaciones.decisionMenuMuestra(Admin);
            }
        }
    }
    
    public static boolean validarIDS (int posRamo, int posNota,int idCurso,int idAlumno, int idRamo){
        if(ramos.get(posRamo).getNotas().get(posNota).getIdAlumno() == idAlumno){
            if(ramos.get(posRamo).getNotas().get(posNota).getIdCurso() == idCurso){
                if(ramos.get(posRamo).getNotas().get(posNota).getIdRamo() == idRamo){
                    return true;
                }
            }
        }
        return false;
    }
    //MENU DE ELIMINAR
    public static void subMenuCase3(int[] indicesAlumno,int clave){
        int opcion, idRamo;
        
        opcion = clave;
        while(opcion != 0){
            switch(opcion){
                case 1:
                    //Elimminar nota             
                    double opcionNota;
                    //System.out.println("Ingrese rut: ");
                    String rutBuscado = JOptionPane.showInputDialog("Ingrese rut:");
                    // = Entrada.next();
                    if(rutBuscado == null){
                        System.out.println("El usuario no ingreso un rut");
                    }
                    int[] indicesAlumnoBuscado = new int[2];
                    indicesAlumnoBuscado = getIndiceAlumno(rutBuscado);
                    
                    operaciones.ramosDisponibles();

                    //System.out.print("Ingrese el ramo: ");
                    idRamo = operaciones.validarIdIngresado();
                    while(idRamo == 0){
                        JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");//System.out.print("Ingrese un valor válido: ");
                        idRamo = operaciones.validarIdIngresado();
                    }
                    for (int j = 0; j < ramos.size(); j++){
                        if(ramos.get(j).getId() == idRamo){
                            System.out.println("Notas de " + ramos.get(j).getNombre() + ": ");
                            for (int i = 0; i < ramos.get(j).getNotas().size(); i++) {
                               if(validarIDS(j,i,indicesAlumnoBuscado[0],indicesAlumnoBuscado[1],ramos.get(j).getId())){
                                    System.out.println("[ "+ i +" ] " + ramos.get(j).getNotas().get(i).getNota());
                                }
                            }
                        }
                    }
                    String EntradaNota = JOptionPane.showInputDialog("Ingrese nota a eliminar:");
                    opcionNota = Double.valueOf(EntradaNota);
                    try{
                    for (int j = 0; j < ramos.size(); j++){
                        if(ramos.get(j).getId() == idRamo){
                            System.out.println("Notas de " + ramos.get(j).getNombre() + ": ");
                            for (int i = 0; i < ramos.get(j).getNotas().size(); i++) {
                               if(validarIDS(j,i,indicesAlumnoBuscado[0],indicesAlumnoBuscado[1],ramos.get(j).getId())){
                                    if(opcionNota == i){
                                        ramos.get(j).getNotas().remove(i);
                                    }
                                }
                            }
                        }
                    }
                    }
                    catch(Exception e){
                        //JOptionPane.showMessageDialog(null, "Hubo un error en la operacion", "Error", JOptionPane.ERROR_MESSAGE);
                        //System.out.println("Hubo un error en la operación.");
                    }
                    
                    break;
                case 2:
                    //Eliminar material
                    int i, opcionMaterial;
                    operaciones.ramosDisponibles();
                    
                    //System.out.print("Ingrese el ramo: ");
                    String EntradaMaterial = JOptionPane.showInputDialog(null, "Ingrese el ramo:");
                    i = Integer.valueOf(EntradaMaterial);
                    JOptionPane.showMessageDialog(null, "Lista de materiales en terminal");
                    for (int j = 0; j < ramos.get(i-1).getMateriales().size(); j++) {
                        ramos.get(i-1).getMateriales().get(j).mostrarDatos(j);
                    }

                    //System.out.print("Ingrese material a eliminar: ");
                    EntradaMaterial = JOptionPane.showInputDialog(null, "Ingrese el material a eliminar");
                    opcionMaterial = Integer.valueOf(EntradaMaterial);
                    //hacer un try catch (crei que ese era el problema)
                    for(int j = 0; j < ramos.get(i-1).getMateriales().size();j++){
                        if(j == opcionMaterial-1){
                            ramos.get(i-1).getMateriales().remove(j);
                            JOptionPane.showMessageDialog(null, "Material eliminado correctamente");
                            //System.out.println("Material eliminado correctamente.");
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("El numero ingresado no corresponde a ninguna opcion.");
                    System.out.println("Intente otra vez.");
                    break;
            }
            opcion = 0;//operaciones.decisionMenuEliminar();
        }
    }
    // MENU DE REEMPLAZAR
    public static void subMenuCase4(int clave){
        int opcion, idRamo, flag = 1;
        int[] indicesAlumno = new int[2];
        opcion = clave;
        while(opcion != 0){
            switch(opcion){
                case 1:
                    double nuevaNota;
                    double opcionNota;
                    //System.out.println("Ingrese rut: ");
                    String rutBuscado = JOptionPane.showInputDialog("Ingrese rut:");
                    // = Entrada.next();
                    if(rutBuscado == null){
                        System.out.println("El usuario no ingreso un rut");
                    }
                    int[] indicesAlumnoBuscado = new int[2];
                    indicesAlumnoBuscado = getIndiceAlumno(rutBuscado);
                    
                    operaciones.ramosDisponibles();

                    //System.out.print("Ingrese el ramo: ");
                    idRamo = operaciones.validarIdIngresado();
                    while(idRamo == 0){
                        JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");//System.out.print("Ingrese un valor válido: ");
                        idRamo = operaciones.validarIdIngresado();
                    }
                    for (int j = 0; j < ramos.size(); j++){
                        if(ramos.get(j).getId() == idRamo){
                            System.out.println("Notas de " + ramos.get(j).getNombre() + ": ");
                            for (int i = 0; i < ramos.get(j).getNotas().size(); i++) {
                               if(validarIDS(j,i,indicesAlumnoBuscado[0],indicesAlumnoBuscado[1],ramos.get(j).getId())){
                                    System.out.println("[ "+ i +" ] " + ramos.get(j).getNotas().get(i).getNota());
                                }
                            }
                        }
                    }
                    String EntradaNota = JOptionPane.showInputDialog("Ingrese nota a reemplazar:");
                    opcionNota = Double.valueOf(EntradaNota);
                    try{
                    for (int j = 0; j < ramos.size(); j++){
                        if(ramos.get(j).getId() == idRamo){
                            System.out.println("Notas de " + ramos.get(j).getNombre() + ": ");
                            for (int i = 0; i < ramos.get(j).getNotas().size(); i++) {
                                if(opcionNota == i){
                                    if(validarIDS(j,i,indicesAlumnoBuscado[0],indicesAlumnoBuscado[1],ramos.get(j).getId())){
                                        System.out.println("Ingrese nueva nota: ");
                                        Nota nueva = new Nota();
                                        nueva = ramos.get(j).getNotas().get(i);
                                        
                                        nuevaNota = operaciones.validarNotaIngresada();
                                        nueva.setNota(nuevaNota);
                                        ramos.get(j).getNotas().set(i, nueva);
                                        System.out.println(ramos.get(i).getNotas().get(i).getNota());
                                        j = ramos.size();
                                        //break;
                                    }
                                }
                            }
                        }
                    }
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Hubo un error en la operacion", "Error", JOptionPane.ERROR_MESSAGE);
                        //System.out.println("Hubo un error en la operación.");
                    }
                    break;
                default:
                    System.out.println(""
                        + "El numero ingresado no corresponde a ninguna opcion.\n"
                        + "Intente otra vez.");
                    break;
            }
            opcion = 0;
            //opcion = operaciones.decisionMenuUpdate();
        }
    }
    /*
        EXPORTACION DE DATOS
    */
    /*
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
    */
    public static void exportarNotas(int[] indicesAlumno) {
        double promedio = 0;
        int contador = 0;
        File file = new File("src/test/java/out/InformeNotas1.csv");
        
        try {
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            String [] header = {"Notas alumno: "};
            writer.writeNext(header);
            ArrayList<String> notas = new ArrayList();
            
            System.out.println("Lista de notas ordenadas por ramo: ");  
            
            for (int j = 0; j < ramos.size(); j++) {
                writer.writeNext("Notas de " + ramos.get(j).getNombre() + ": ");
                for (int k = 0; k < cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().size(); k++) {
                    for (int i = 0; i < cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getNotas().size(); i++) {
                        if (cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getNotas().get(i).getIdRamo() == ramos.get(j).getId()) {
                            if(cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getNotas().get(i).getIdAlumno()== indicesAlumno[1]){
                                if(cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getNotas().get(i).getIdCurso() == cursos.get(indicesAlumno[0]).getNivel()-1){
                                    promedio += cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getNotas().get(i).getNota();
                                    notas.add(Double.toString(cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getNotas().get(i).getNota()));
                                    writer.writeNext((cursos.get(indicesAlumno[0]).getListaAlumnos().get(indicesAlumno[1]).getAsignaturas().get(k).getNotas().get(i).getNota())+"");
                                    contador++;
                                }     
                            }   
                        }
                    }
                }   
                if (contador != 0) {
                    writer.writeNext("El promedio de " + ramos.get(j).getNombre()
                            + " es " + promedio / contador);
                } else {
                    writer.writeNext("Este ramo no tiene notas.");
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
