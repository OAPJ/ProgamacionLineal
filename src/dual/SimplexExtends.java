/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dual;

import GUI.MS.Simplex;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

/**
 *
 * @author Miguel
 */
public class SimplexExtends extends Simplex {

    public SimplexExtends() {
        super();
        super.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        ImageIcon flecha =  new ImageIcon("src/imágenes/flecha3.png");
        Icon flechaIcon = new ImageIcon(flecha.getImage().getScaledInstance(70, 60, Image.SCALE_DEFAULT));
        super.getRegresar().setIcon(flechaIcon);
        System.out.println(super.getDefaultCloseOperation());
    }
    @Override
    public void regresarActionPerformed(java.awt.event.ActionEvent evt){
        this.dispose();
    }
    
}
