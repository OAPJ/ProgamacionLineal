/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.DUAL;

import GUI.PL.Resultados;
import ProgramacionLineal.Reinstraints;

/**
 *
 * @author Miguel
 */
public class ResultadosD extends Resultados {
    public ResultadosD(Reinstraints r, String tipo){
        super(r,tipo);
//        super.getRegresar().removeAll();
//        super.getRegresar().addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                actionNew(evt);
//            }
//        });
    }
    @Override
    public void regresarActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        this.dispose();
    } 
}
