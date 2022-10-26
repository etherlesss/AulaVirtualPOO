package Funciones;

import Personas.Alumno;
import Personas.Profesor;
import static Principal.AulaVirtualEP3.alumnos;
import static Principal.AulaVirtualEP3.cursos;
import static Principal.AulaVirtualEP3.profesores;
import static Principal.AulaVirtualEP3.ramos;
import Principal.Curso;
import Principal.Ramo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lectura {
    public static void leerDatos() throws FileNotFoundException {
        insertarCursosArchivo();
        insertarRamosArchivo();
        insertarAlumnosArchivo();
        insertarProfesoresArchivo();
    }
    
    
    public static void insertarCursosArchivo() throws FileNotFoundException {
        String file = "src/test/java/in/Cursos.txt";

        try {
            File archivo = new File(file);
            System.out.println("Ruta: " + archivo.getAbsolutePath());

            Scanner entrada = new Scanner(archivo);

            while (entrada.hasNext()) {
                String[] datos = entrada.next().split(";");
                Curso curso = new Curso();

                curso.setNivel(Integer.parseInt(datos[0]));
                curso.setLetra(datos[1].charAt(0));

                cursos.add(curso);
            }

            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static void insertarRamosArchivo() throws FileNotFoundException {
        String file = "src/test/java/in/Ramos.txt";

        try {
            File archivo = new File(file);
            System.out.println("Ruta: " + archivo.getAbsolutePath());

            Scanner entrada = new Scanner(archivo);

            while (entrada.hasNext()) {
                String[] datos = entrada.next().split(";");
                Ramo ramo = new Ramo();

                ramo.setId(Integer.parseInt(datos[0]));
                ramo.setNombre(datos[1].replace("_", " "));

                ramos.add(ramo);
            }

            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static void insertarAlumnosArchivo() throws FileNotFoundException {
        String file = "src/test/java/in/Alumnos.txt";

        try {
            File archivo = new File(file);
            System.out.println("Ruta: " + archivo.getAbsolutePath());

            Scanner entrada = new Scanner(archivo);

            while (entrada.hasNext()) {
                String[] datos = entrada.next().split(";");
                Alumno alumno = new Alumno();

                alumno.setIdCurso(Integer.parseInt(datos[0]));
                alumno.setNombre(datos[1]);
                alumno.setApellido(datos[2]);
                alumno.setRut(datos[3]);
                alumno.setMail(datos[4]);
                alumno.setContrasenya(datos[5]);

                alumnos.add(alumno);
            }

            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static void insertarProfesoresArchivo() throws FileNotFoundException {
        String file = "src/test/java/in/Profesores.txt";

        try {
            File archivo = new File(file);
            System.out.println("Ruta: " + archivo.getAbsolutePath());

            Scanner entrada = new Scanner(archivo);

            while (entrada.hasNext()) {
                String[] datos = entrada.next().split(";");
                Profesor profesor = new Profesor();

                profesor.setNombre(datos[0]);
                profesor.setApellido(datos[1]);
                profesor.setRut(datos[2]);
                profesor.setMail(datos[3]);
                profesor.setContrasenya(datos[4]);

                profesores.add(profesor);
            }

            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
