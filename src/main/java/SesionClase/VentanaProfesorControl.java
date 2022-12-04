/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SesionClase;

import Principal.AulaVirtualEP3;
import SesionFrame.ventanaProfesor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author marti
 */
public class VentanaProfesorControl implements ActionListener{
    private ventanaProfesor ventana;
    private String rut;
    private int[] indiceAlumno = new int[2];
    
    public VentanaProfesorControl(ventanaProfesor ventana,String rut){
        this.ventana = ventana;
        this.rut = rut;
        indiceAlumno = buscarProfe(rut);
        agregarAcciones();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==ventana.getBtnSalir()){
            System.exit(0);
        }else if(e.getSource()==ventana.getBtnVerDatos()){
            AulaVirtualEP3.subMenuCase2(indiceAlumno, 1, 1, 1);
            mostrarMensaje("Resultado en terminal");
        }else if(e.getSource()==ventana.getBtnVerAlumno()){
            AulaVirtualEP3.subMenuCase2(indiceAlumno, 1, 1, 2);
            mostrarMensaje("Resultado en terminal");
        }else if(e.getSource()==ventana.getBtnAlumnoPromedios()){
            AulaVirtualEP3.subMenuCase2(indiceAlumno, 1, 2, 1);
            mostrarMensaje("Resultado en terminal");
        }else if(e.getSource()==ventana.getBtnNotaAceptableInaceptable()){
            AulaVirtualEP3.subMenuCase2(indiceAlumno, 1, 3, 1);
            mostrarMensaje("Resultado en terminal");
        }else if(e.getSource()==ventana.getBtnAgregarNota()){
            AulaVirtualEP3.subMenuCase1(1);
            mostrarMensaje("Resultado en terminal");
        }else if(e.getSource()==ventana.getBtnAgregarMaterial()){
            AulaVirtualEP3.subMenuCase1(2);
            mostrarMensaje("Material agregado con exito");
        }else if(e.getSource()==ventana.getBtnCambiarNota()){
            mostrarMensaje("deberia cambiar una nota ");
            AulaVirtualEP3.subMenuCase4(1);
        }else if(e.getSource()==ventana.getBtnEliminarMaterial()){
            //insertar codigo para eliminar material
            AulaVirtualEP3.subMenuCase3(indiceAlumno, 2);
        }else if(e.getSource()==ventana.getBtnEliminarNota()){
            //inserta codigo para eliminar nota
            AulaVirtualEP3.subMenuCase3(indiceAlumno, 1);
        }
    }
    public void agregarAcciones(){
        ventana.getBtnVerDatos().addActionListener(this);
        ventana.getBtnVerAlumno().addActionListener(this);
        ventana.getBtnAlumnoPromedios().addActionListener(this);
        ventana.getBtnNotaAceptableInaceptable().addActionListener(this);
        ventana.getBtnAgregarNota().addActionListener(this);
        ventana.getBtnAgregarMaterial().addActionListener(this);
        ventana.getBtnCambiarNota().addActionListener(this);
        ventana.getBtnSalir().addActionListener(this);
        ventana.getBtnEliminarMaterial().addActionListener(this);
        ventana.getBtnEliminarNota().addActionListener(this);
    }
    private void mostrarMensaje(String msg){
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(ventana, msg);
    }
    public int[] buscarProfe(String rut){
        int[] indicesAlumno = new int[2];
        for (int i = 0; i < AulaVirtualEP3.profesores.size(); i++) {
            if(AulaVirtualEP3.profesores.get(i).getRut().equals(rut)){
                indicesAlumno[0] = i;
            }
        }
        return indicesAlumno;
    }
}
