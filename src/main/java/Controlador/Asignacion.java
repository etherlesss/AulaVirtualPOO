package Controlador;

import Modelo.Nota;
import static Principal.AulaVirtualEP3.alumnos;
import static Principal.AulaVirtualEP3.cursos;
import static Principal.AulaVirtualEP3.profesores;
import static Principal.AulaVirtualEP3.ramos;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Asignacion {
    public static void asignarDatos() throws FileNotFoundException {
        asignarProfesoresJefes();
        asignarAlumnosCursos();
        asignarProfesoresRamo();
        asignarRamosAlumnos();
        asignarNotasArchivo();
    }
    
    public static void asignarProfesoresJefes() {
        for (int i = 0; i < cursos.size(); i++) {
            cursos.get(i).setProfesorJefe(profesores.get(i));
        }
    }
    
    public static void asignarAlumnosCursos(){
        for (int i = 0; i < cursos.size(); i++) {
            for (int j = 0; j < alumnos.size(); j++) {
                if (cursos.get(i).getNivel() == alumnos.get(j).getIdCurso()) {
                    cursos.get(i).getListaAlumnos().add(alumnos.get(j));
                }
            }
        }
    }
    
    public static void asignarProfesoresRamo() {
        for (int i = 0; i < ramos.size(); i++) {
            profesores.get(i).setRamo(ramos.get(i));
        }
    }
    
    public static void asignarRamosAlumnos() {
        for (int i = 0; i < alumnos.size(); i++) {
            alumnos.get(i).setAsignaturas(ramos);
        }
    }
    
    public static int getIndexAlumno(String rut){
        
        for (int i = 0; i < cursos.size(); i++) {
            for (int j = 0; j < cursos.get(i).getListaAlumnos().size(); j++) {
                
                if(rut.equals(cursos.get(i).getListaAlumnos().get(j).getRut()))
                    return j;
                
            }
        }
        return -1;
    }
    
    public static void asignarNotasArchivo() throws FileNotFoundException{
        String file  = "src/test/java/in/notasAlumnos.csv";
        int index, l = 0;
        try{
            File archivo = new File(file);
            System.out.println("Ruta: " +archivo.getAbsolutePath());
            
            Scanner entrada = new Scanner(archivo);
            
            //System.out.println(alumnos.size());
            
            
            while(entrada.hasNext()){
                String [] datos = entrada.next().split(";");
                for (int i = 3; i < datos.length; i++) {
                    Nota nueva = new Nota();
                    nueva.setIdRamo(Integer.valueOf(datos[0]));
                    nueva.setNota(Double.valueOf(datos[i]));
                    index = getIndexAlumno(datos[2]);
                    nueva.setIdAlumno(index);
                    nueva.setIdCurso(Integer.valueOf(datos[1])-1);

                    //System.out.print("Curso: "+Integer.valueOf(datos[1])+" ");
                    //System.out.println(index);
                    
                    cursos.get(Integer.valueOf(datos[1])-1).getListaAlumnos().get(index).getAsignaturas().get(Integer.valueOf(datos[0])-1).getNotas().add(nueva);
                    
                    //System.out.println("Nota agregada:"+cursos.get(Integer.valueOf(datos[1])-1).getListaAlumnos().get(index).getAsignaturas().get(Integer.valueOf(datos[0])-1).getNotas().get(l).getNota());
                    //System.out.println("");
                    l++;
                    if(l==6) l = 0;
                }
            }
            entrada.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        
    }
    
}
