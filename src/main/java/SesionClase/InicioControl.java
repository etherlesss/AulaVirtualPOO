package SesionClase;

import SesionFrame.VerInicio;
import Principal.AulaVirtualEP3;
import Personas.Alumno;
import Personas.Profesor;
import java.util.ArrayList;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class InicioControl implements ActionListener{
    // ATRIBUTOS
    private VerInicio ventana;
    //CONSTRUCTOR
    public InicioControl(VerInicio vision){
        this.ventana = vision;
        agregarOyente();
    }
    // METODOS
    @Override //USO DE SOBREESCRITURA EN ESTE METODO
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ventana.getBtnAceptar()){
            // Variables donde se almacenan los datos del inicio de sesion
            String Usuario = ventana.getRut().getText();
            String Contrasenya = ventana.getContrasenya().getText();
            // Verificaciones de inicio de sesion
            if(Usuario.isEmpty() && Contrasenya.isEmpty()){
                mostrarMensajeError("Debe ingresar su RUT y contraseña");
            }
            else if(Usuario.isEmpty()){
                mostrarMensajeError("Debe ingresar su RUT (con puntos y guion)");
            }
            else if(Contrasenya.isEmpty()){
                mostrarMensajeError("Debe ingresar una contraseña");
            }
            else if(buscarPermisoProfesor(AulaVirtualEP3.profesores, Usuario, Contrasenya) == true){
                mostrarMensaje("Bienvenid@, "
                        + obtenerUsuarioProfesor(AulaVirtualEP3.profesores, Usuario).getNombre() + " "
                        + obtenerUsuarioProfesor(AulaVirtualEP3.profesores, Usuario).getApellido());
                
                /* LLAMAR MENU CON MAYORES PERMISOS: PARA AGREGAR NOTAS, MODIFICAR, ETC... */
                
                ventana.setVisible(false);
                AulaVirtualEP3.menu(1, Usuario);
                System.exit(0);
            }
            else if(buscarPermisoAlumno(AulaVirtualEP3.alumnos, Usuario, Contrasenya) == true){
                mostrarMensaje("Bienvenido@, "
                        + obtenerUsuarioAlumno(AulaVirtualEP3.alumnos, Usuario).getNombre() + " "
                        + obtenerUsuarioAlumno(AulaVirtualEP3.alumnos, Usuario).getApellido());
                
                /* LLAMAR MENU CON BAJOS PERMISOS: MOSTRAR, EXPORTAR, ETC... 
                   CABE DESTACAR QUE NO ES NECESARIO VOLVER A PREGUNTAR POR EL RUT
                   DEL ALUMNO, YA QUE LOS DATOS LOS OBTIENE DE ESTE INICIO DE SESION. */
                
                ventana.setVisible(false);
                AulaVirtualEP3.menu(0, Usuario);
                System.exit(0);
            }
            else{
                mostrarMensajeError("Datos ingresasdos son incorrectos!");
            }
        }
        if(e.getSource() == ventana.getBtnSalir()){
            System.exit(0);
        }
    }
    
    private void agregarOyente(){
        ventana.getBtnAceptar().addActionListener(this);
        ventana.getBtnSalir().addActionListener(this);
    }
    private void mostrarMensaje(String msg){
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(ventana, msg);
    }
    private void mostrarMensajeError(String msg){
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(ventana, msg, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    // Vemos si los datos ingresados corresponden a un alumno
    private boolean buscarPermisoAlumno(ArrayList<Alumno> alumnos, String Usuario, String Contrasenya){
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getRut().equals(Usuario) && alumnos.get(i).getContrasenya().equals(Contrasenya)) {
                return true;
            }
        }
        return false;
    }
    // Vemos si los datos ingresados corresponden a un profesor
    private boolean buscarPermisoProfesor(ArrayList<Profesor> profesores, String Usuario, String Contrasenya){
        for (int i = 0; i < profesores.size(); i++) {
            if (profesores.get(i).getRut().equals(Usuario) && profesores.get(i).getContrasenya().equals(Contrasenya)) {
                return true;
            }
        }
        return false;
    }
    // Obtenemos los datos del usuario de la sesion
    private Alumno obtenerUsuarioAlumno(ArrayList<Alumno> alumnos, String Usuario){
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getRut().equals(Usuario)){
                return alumnos.get(i);
            }
        }
        return null;
    }
    // Obtenemos los datos del usuario de la sesion
    private Profesor obtenerUsuarioProfesor(ArrayList<Profesor> profesores, String Usuario){
        for (int i = 0; i < profesores.size(); i++) {
            if (profesores.get(i).getRut().equals(Usuario)){
                return profesores.get(i);
            }
        }
        return null;
    }
}
