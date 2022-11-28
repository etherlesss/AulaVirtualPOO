package Controlador;

import static Principal.AulaVirtualEP3.alumnos;
import static Principal.AulaVirtualEP3.cursos;
import static Principal.AulaVirtualEP3.profesores;
import static Principal.AulaVirtualEP3.ramos;

public class Asignacion {
    public static void asignarDatos() {
        asignarProfesoresJefes();
        asignarAlumnosCursos();
        asignarProfesoresRamo();
        asignarRamosAlumnos();
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
}
