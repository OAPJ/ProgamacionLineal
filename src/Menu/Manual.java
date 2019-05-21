/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author PUMPKIN
 */
public class Manual extends javax.swing.JFrame {
    private int cont = 0;
    private String[] instrucciones =  new String[13];
    private Icon[] imagenes = new Icon[13];
    /**
     * Creates new form Manual
     */
    @Override
    public void dispose(){
        Menu m = new Menu();
        m.setVisible(true);
        super.dispose();
    }
    public void llenar(){    
        this.instrucciones[0] = "\n¡Hola! Bienvenid@ al manual de usuario :D \n" +
                                "Aquí te enseñaremos a usar la presente aplicación, por si tienes complicaciones y no te apures \n"+
                                "siempre estará disponible en tu pantalla principal para que lo puedas consultar cuando quieras c;";
        this.instrucciones[1] = "\n \n Para empezar, debes seleccionar el método por el cual deseas maximizar o minizar tu función objetivo.";
        this.instrucciones[2] = "NOTA: Recuerda que el método gráfico únicamente es posible aplicarlo para problemáticas que contengan\n"+
                                "             dos variables. Si tienes problemas primarios con 3 variables de decisión lo puedes reducir y"+
                                " resolver\n             de mejor manera con el método dual.";
        this.instrucciones[3] = "\n  == MÉTODO GRÁFICO == \n \n¿Qué deseas maximizar o minimizar tu función objetivo?";
        this.instrucciones[4] = "\nEs necesario llenar todos los campos; en pantalla se muestra un ejemplo de cómo introducir \n" +
                                "tanto tu función objetivo como las restricciones.\n"+
                                "Pero no te preocupes, de igual manera en la pantalla se encontrará el botón de ejemplo con el\n" +
                                "que al presionarlo únicamente tendrás que sustiur los valores de tu función objetivo y  de tus\n"+
                                "restricciones en la funciones del ejemplo, así como añadir o eliminar las restrcciones que necesites.";
        this.instrucciones[5] = "NOTA: Recuerda acompañar tus restricciones con el signo '=>' para Minimización y '<=' para Maximización.";
        this.instrucciones[6] = "\n \n == VENTANA DE RESULTADOS DEL MÉTODO GRÁFICO. ==";
        this.instrucciones[7] = "== MÉTODO SIMPLEX == \n"+
                                "Es necesario llenar todos los campos; en pantalla se muestra un ejemplo de cómo introducir\n" +
                                "tanto tu función objetivo como las restricciones.\n" +
                                "Pero no te preocupes, de igual manera en la pantalla se encontrará el botón de ejemplo con el\n"+
                                "que al presionarlo únicamente tendrás que sustiur los valores de tu función objetivo y  de tus\n" +
                                "restricciones en la funciones del ejemplo, así como añadir o eliminar las restrcciones que necesites.\n";
        this.instrucciones[8] = "NOTA: La presente aplicación únicamente soluciona problemas de máximización por método Simplex.\n"+
                                "            Tampoco olvides que es necesario acompañar tus restricciones con el signo de '<='.";
        this.instrucciones[9] = "== MÉTODO DUAL == \n \n¿Qué deseas maximizar o minimizar tu función objetivo? \n"+
                                "Recuerda que el método dual te permite resolver problemas de minimización por medio de maximización o"+
                                "maximización por medio de minización siempre y cuando exista una solución óptima factible.";
        this.instrucciones[10] = "\nEs necesario llenar todos los campos; en pantalla se muestra un ejemplo de cómo introducir \n" +
                                "tanto tu función objetivo como las restricciones.\n"+
                                "Pero no te preocupes, de igual manera en la pantalla se encontrará el botón de ejemplo con el\n" +
                                "que al presionarlo únicamente tendrás que sustiur los valores de tu función objetivo y  de tus\n"+
                                "restricciones en la funciones del ejemplo, así como añadir o eliminar las restrcciones que necesites.";
        this.instrucciones[11] = "NOTA: Recuerda acompañar tus restricciones con el signo '=>' para Minimización y '<=' para Maximización.";
        this.instrucciones[12] = "\n \n == VENTANA DUAL DE RESULTADOS. ==";

        ImageIcon IMG1 = new ImageIcon("src/imágenes/IMG_1.png");
        ImageIcon IMG2 =  new ImageIcon("src/imágenes/IMG_1.1.png");
        ImageIcon IMG3 =  new ImageIcon("src/imágenes/IMG_2.png");
        ImageIcon IMG4 =  new ImageIcon("src/imágenes/IMG_MG.png");
        ImageIcon IMG5 =  new ImageIcon("src/imágenes/IMG_R.png");
        ImageIcon IMG6 =  new ImageIcon("src/imágenes/IMG_MS.png");
        ImageIcon IMG7 =  new ImageIcon("src/imágenes/IMG_MD.png");
        ImageIcon IMG8 =  new ImageIcon("src/imágenes/IMG_MDD.png");
        ImageIcon IMG9 =  new ImageIcon("src/imágenes/IMG_MD_R.png");
        this.imagenes[0] =  new ImageIcon(IMG1.getImage().getScaledInstance(IMG.getWidth(), IMG.getHeight(), BufferedImage.TYPE_INT_RGB));
        this.imagenes[1] =  new ImageIcon(IMG2.getImage().getScaledInstance(IMG.getWidth(), IMG.getHeight(), BufferedImage.TYPE_INT_RGB));
        this.imagenes[2] =  new ImageIcon(IMG2.getImage().getScaledInstance(IMG.getWidth(), IMG.getHeight(), BufferedImage.TYPE_INT_RGB));
        this.imagenes[3] =  new ImageIcon(IMG3.getImage().getScaledInstance(IMG.getWidth(), IMG.getHeight(), BufferedImage.TYPE_INT_RGB));
        this.imagenes[4] =  new ImageIcon(IMG4.getImage().getScaledInstance(IMG.getWidth(), IMG.getHeight(), BufferedImage.TYPE_INT_RGB));
        this.imagenes[5] =  new ImageIcon(IMG4.getImage().getScaledInstance(IMG.getWidth(), IMG.getHeight(), BufferedImage.TYPE_INT_RGB));
        this.imagenes[6] =  new ImageIcon(IMG5.getImage().getScaledInstance(IMG.getWidth(), IMG.getHeight(), BufferedImage.TYPE_INT_RGB));
        this.imagenes[7] =  new ImageIcon(IMG6.getImage().getScaledInstance(IMG.getWidth(), IMG.getHeight(), BufferedImage.TYPE_INT_RGB));
        this.imagenes[8] =  new ImageIcon(IMG6.getImage().getScaledInstance(IMG.getWidth(), IMG.getHeight(), BufferedImage.TYPE_INT_RGB));
        this.imagenes[9] =  new ImageIcon(IMG7.getImage().getScaledInstance(IMG.getWidth(), IMG.getHeight(), BufferedImage.TYPE_INT_RGB));
        this.imagenes[10] =  new ImageIcon(IMG8.getImage().getScaledInstance(IMG.getWidth(), IMG.getHeight(), BufferedImage.TYPE_INT_RGB));
        this.imagenes[11] =  new ImageIcon(IMG8.getImage().getScaledInstance(IMG.getWidth(), IMG.getHeight(), BufferedImage.TYPE_INT_RGB));
        this.imagenes[12] =  new ImageIcon(IMG9.getImage().getScaledInstance(IMG.getWidth(), IMG.getHeight(), BufferedImage.TYPE_INT_RGB));
    }
    public Manual() {
        //VENTANA
        setUndecorated(true);
        initComponents();
        this.setSize(925, 700);
        this.setOpacity(0.92f);
        setLocationRelativeTo(null);
        
        //BOTONES
        ImageIcon N =  new ImageIcon("src/imágenes/next.png");
        ImageIcon B =  new ImageIcon("src/imágenes/back.png");
        ImageIcon C =  new ImageIcon("src/imágenes/close.png");
        Icon iconC = new ImageIcon(C.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        Icon iconN = new ImageIcon(N.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        Icon iconB = new ImageIcon(B.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        close.setIcon(iconC);
        Next.setIcon(iconN);
        Back.setIcon(iconB);
        
        //TEXTO E IMÁGENES
        llenar();
        TOP.setText(instrucciones[cont]);
        IMG.setIcon(imagenes[cont]);
        StyledDocument doc = TOP.getStyledDocument(); 
        SimpleAttributeSet center = new SimpleAttributeSet(); 
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER); 
        doc.setParagraphAttributes(0, doc.getLength(), center, false); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        Back = new javax.swing.JButton();
        Next = new javax.swing.JButton();
        IMG = new javax.swing.JLabel();
        close = new javax.swing.JButton();
        BOTTOM = new javax.swing.JEditorPane();
        TOP = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        getContentPane().setLayout(null);

        Back.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Back.setBorderPainted(false);
        Back.setContentAreaFilled(false);
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back);
        Back.setBounds(10, 630, 60, 60);

        Next.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Next.setBorderPainted(false);
        Next.setContentAreaFilled(false);
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });
        getContentPane().add(Next);
        Next.setBounds(850, 630, 60, 60);

        IMG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(IMG);
        IMG.setBounds(60, 140, 790, 480);

        close.setBorderPainted(false);
        close.setContentAreaFilled(false);
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        getContentPane().add(close);
        close.setBounds(890, 0, 35, 35);

        BOTTOM.setEditable(false);
        BOTTOM.setBackground(new java.awt.Color(214, 217, 223));
        BOTTOM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BOTTOM.setAutoscrolls(false);
        BOTTOM.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        BOTTOM.setEnabled(false);
        BOTTOM.setFocusCycleRoot(false);
        BOTTOM.setFocusable(false);
        BOTTOM.setOpaque(false);
        BOTTOM.setRequestFocusEnabled(false);
        BOTTOM.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(BOTTOM);
        BOTTOM.setBounds(90, 630, 747, 55);

        TOP.setEditable(false);
        TOP.setBackground(new java.awt.Color(214, 217, 223));
        TOP.setBorder(null);
        TOP.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        TOP.setAutoscrolls(false);
        TOP.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TOP.setEnabled(false);
        TOP.setFocusCycleRoot(false);
        TOP.setFocusable(false);
        TOP.setOpaque(false);
        TOP.setRequestFocusEnabled(false);
        TOP.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(TOP);
        TOP.setBounds(120, 10, 700, 120);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        //BTN SIGUIENTE
        if(cont >= 0 && cont < instrucciones.length-1){
            cont++;
            if(cont == 1 || cont == 4 || cont == 7 || cont == 10){
                cont++;
                BOTTOM.setText(instrucciones[cont]);
                TOP.setText(instrucciones[cont-1]);
                IMG.setIcon(imagenes[cont-1]);
            }else{
                TOP.setText(instrucciones[cont]);
                IMG.setIcon(imagenes[cont]);
                BOTTOM.setText("");
            }
        }
    }//GEN-LAST:event_NextActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        //BTN ATRÁS
        if(cont >= 0 && cont <= instrucciones.length){
            if(cont == 0){
                
            }else{
                cont--;
                if(cont == 2 || cont == 5 || cont == 8 || cont == 11){
                    cont--;
                    TOP.setText(instrucciones[cont]);
                    IMG.setIcon(imagenes[cont]);
                    BOTTOM.setText(instrucciones[cont+1]);
                }else{
                    TOP.setText(instrucciones[cont]);
                    IMG.setIcon(imagenes[cont]);
                    BOTTOM.setText("");
                }
            }
        }
    }//GEN-LAST:event_BackActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        //EXIT
        Menu m = new Menu();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_closeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Manual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane BOTTOM;
    private javax.swing.JButton Back;
    private javax.swing.JLabel IMG;
    private javax.swing.JButton Next;
    private javax.swing.JTextPane TOP;
    private javax.swing.JButton close;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
