/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SesionClase;

import Principal.AulaVirtualEP3;
import static Principal.AulaVirtualEP3.cursos;
import static Principal.AulaVirtualEP3.ramos;
import SesionFrame.ventanaAlumno;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;


/**
 *
 * @author marti
 */
public class VentanaAlumnoControl implements ActionListener{
    private ventanaAlumno ventana;
    private String rut;
    private int[] indicesAlumno = new int[2];
    
    public VentanaAlumnoControl(ventanaAlumno vision,String rut){
        this.ventana = vision;
        this.rut = rut;
        agregarActions();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        indicesAlumno = AulaVirtualEP3.getIndiceAlumno(rut);
        if(e.getSource()== ventana.getBtnExportarNotas()){
            //mandar señal de exportar
            AulaVirtualEP3.subMenuCase2(indicesAlumno, 0, 3,0);
            mostrarMensaje("Exportacion se guardó en: src/test/java/out/InformeNotas1.csv");
        }else if(e.getSource()== ventana.getBtnMateriales()){
            //mandar señal de materiales
            mostrarMensaje("El resultado se mostrará en la terminal");
            AulaVirtualEP3.subMenuCase2(indicesAlumno, 0, 2,0);
        }else if (e.getSource()== ventana.getBtnMostrarNotas()){
            //mandar señal de mostrar notas
            mostrarMensaje("El resultado se mostrará en la terminal");
            AulaVirtualEP3.subMenuCase2(indicesAlumno, 0, 1,0);
        }else if(e.getSource()== ventana.getBtnSalir()){
            System.exit(0);
        }
    }
    private void agregarActions(){
        ventana.getBtnExportarNotas().addActionListener(this);
        ventana.getBtnMateriales().addActionListener(this);
        ventana.getBtnMostrarNotas().addActionListener(this);
        ventana.getBtnSalir().addActionListener(this);
        
    }
    private void mostrarMensaje(String msg){
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(ventana, msg);
    }
}
