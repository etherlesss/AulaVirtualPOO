/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SesionClase;

import SesionFrame.VerInicio;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author marti
 */
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
            String Usuario = ventana.getRut().getText();
            String Contrasenya = ventana.getContrasenya().getText();
            if(Usuario.isEmpty() && Contrasenya.isEmpty()){
                mostrarMensaje("Ingresa tu Rut y conraseña");
            }
            else if(Usuario.isEmpty()){
                mostrarMensaje("Ingrese tu Rut");
            }
            else if(Contrasenya.isEmpty()){
                mostrarMensaje("Ingrese una contraseña");
            }
            else if(Usuario.equals("admin") && Contrasenya.equals("contraseña")){
                mostrarMensaje("Bienvenido");
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
}
