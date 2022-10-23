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
    // ATRIBUTS
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
                mostrarMensaje("Ingresa tu Rut y conraseña");
            }
            else if(Usuario.isEmpty()){
                mostrarMensaje("Ingrese su Rut");
            }
            else if(Contrasenya.isEmpty()){
                mostrarMensaje("Ingrese una contraseña");
            }
            else if(buscarPermisoProfesor(Principal.AulaVirtualEP3.profesores, Usuario) == true && Contrasenya.equals("contraseña")){
                mostrarMensaje("Bienvenido "
                        + obtenerUsuarioProfesor(Principal.AulaVirtualEP3.profesores, Usuario).getNombre() + " "
                        + obtenerUsuarioProfesor(Principal.AulaVirtualEP3.profesores, Usuario).getApellido());
                
                /* LLAMAR MENU CON MAYORES PERMISOS: PARA AGREGAR NOTAS, MODIFICAR, ETC... */
                
                ventana.setVisible(false);
            }
            else if(buscarPermisoAlumno(Principal.AulaVirtualEP3.alumnos, Usuario) == true && Contrasenya.equals("contraseña")){
                mostrarMensaje("Bienvenido "
                        + obtenerUsuarioAlumno(Principal.AulaVirtualEP3.alumnos, Usuario).getNombre() + " "
                        + obtenerUsuarioAlumno(Principal.AulaVirtualEP3.alumnos, Usuario).getApellido());
                
                /* LLAMAR MENU CON BAJOS PERMISOS: MOSTRAR, EXPORTAR, ETC... */
                
                ventana.setVisible(false);
            }
            else{
                mostrarMensaje("Datos ingresasdos son incorrectos");
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
    // Vemos si los datos ingresados corresponden a un alumno
    private boolean buscarPermisoAlumno(ArrayList<Alumno> alumnos, String Usuario){
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getRut().equals(Usuario)) {
                return true;
            }
        }
        return false;
    }
    // Vemos si los datos ingresados corresponden a un profesor
    private boolean buscarPermisoProfesor(ArrayList<Profesor> profesores, String Usuario){
        for (int i = 0; i < profesores.size(); i++) {
            if (profesores.get(i).getRut().equals(Usuario)) {
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
