/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.DUAL;

import GUI.PL.Datos;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel
 */
public class DatosD extends Datos {

    public DatosD(String tipo) {
        super(); 
//        super.getjButton2().removeAll();
//        super.getjButton2().addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton2ActionPerformed(evt);
//            }
//        });
        super.iniciar(tipo);
    }
    @Override
    public void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {        
        //Botón de Solución 
        if(!super.getZ().getText().equals("") && !super.getReinstraintsTA().getText().equals(""))
            if(super.getTipo() == "Maximización")//Para el metodo de maximizacion
                //Validar Z
                if(super.getRestrincciones().validarZ(this.getZ().getText()))
                    //Validamos las restrinciones
                    if(super.getRestrincciones().validarRestrinciones(super.getReinstraintsTA().getText())){
                        super.getRestrincciones().obtenerValores();
                        super.getRestrincciones().evaluarCoordenadas();
                        ResultadosD r = new ResultadosD(super.getRestrincciones(), super.getTipo());
                        r.setVisible(true);
                        this.dispose();
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Escriba bien las restricciones","Programación Lineal",JOptionPane.ERROR_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null,"Función Z incorrecta","Programación Lineal",JOptionPane.ERROR_MESSAGE);   
            else{
                //Validar Z
                if(super.getRestrincciones().validarZ(super.getZ().getText()))
                    //Validamos las restrinciones
                    if(super.getRestrincciones().validarRestrincionesMin(super.getReinstraintsTA().getText())){
                        super.getRestrincciones().obtenerValoresMin();
                        super.getRestrincciones().evaluarCoordenadasMin();
                        ResultadosD r = new ResultadosD(super.getRestrincciones(), super.getTipo());
                        r.setVisible(true);
                        this.dispose();
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Escriba bien las restricciones","Programación Lineal",JOptionPane.ERROR_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null,"Función Z incorrecta","Programación Lineal",JOptionPane.ERROR_MESSAGE);
            }
        else
            JOptionPane.showMessageDialog(null,"Completa todos los campos","Programación Lineal",JOptionPane.ERROR_MESSAGE);
    }
}
