/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dual;


import GUI.DUAL.DatosD;
import MetodoSimplex.ValidarSimplex;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel
 */
public class Dual {
    private final ValidarSimplex original;
    private DatosD dual;
    private final ValidarSimplex dualSimplex;
    private String zDual, restricciones;
    private String restriccionesDual[];
    private String [] variables;
    public Dual() {
        this.original=new ValidarSimplex();        
        this.dualSimplex=new ValidarSimplex();
    }
    public boolean crearDual(String tipo, String z, String restricciones){
        this.zDual="";
        this.restricciones="";
        if(tipo.equals("Minimización")){
            if(!recibirParametrosMin(z, restricciones)){
                JOptionPane.showMessageDialog(null, "Introduzca parametros válidos");
                return false;
            }
            char v='x';
            String v1=v+++"";
            this.zDual+=this.original.getConstantes()[0]+v1;
            for(int i=1;i<this.original.getRestricciones().length;i++){
                String aux= v+++"";
                this.zDual+="+"+this.original.getConstantes()[i]+aux;
            }
            this.restriccionesDual=new String[this.original.getzValores().length];
            
            for(int i=0;i<this.restriccionesDual.length;i++){
                v='x';
                v1=v+++"";
                this.restriccionesDual[i]="";
                this.restriccionesDual[i]+=this.original.getRestricciones()[0].getValores()[i]+v1;
                for (int j = 1; j < this.original.getRestricciones().length; j++) {
                    v1=v+++"";
                    this.restriccionesDual[i]+="+"+this.original.getRestricciones()[j].getValores()[i]+v1;
                }
                this.restriccionesDual[i]+="<="+this.original.getzValores()[i];
            }
            this.restricciones+=this.restriccionesDual[0];
            for (int i = 1; i < this.restriccionesDual.length; i++) {
                this.restricciones+="\n"+this.restriccionesDual[i];
            }
            this.variables= new String[original.getzValores().length];
            for(int i=0;i<this.variables.length;i++){
                this.variables[i]="x"+(i+1);
            }
            if(this.dualSimplex.validarZ(this.zDual) && this.dualSimplex.validarRestriccionesMax(this.restricciones)){
                this.dual= new DatosD("Maximización");
                this.dual.getZ().setText(this.zDual);
                this.dual.getReinstraintsTA().setText(this.restricciones);
                this.dual.getjButton2().doClick();
                return true;
            }else JOptionPane.showMessageDialog(null, "No se pudo transformar al dual");
        }else if(tipo.equals("Maximización")){
            if(!recibirParametrosMax(z, restricciones)){
                JOptionPane.showMessageDialog(null, "Introduzca parametros válidos");
                return false;
            }
            char v='x';
            String v1=v+++"";
            this.zDual+=this.original.getConstantes()[0]+v1;
            for(int i=1;i<this.original.getRestricciones().length;i++){
                String aux= v+++"";
                this.zDual+="+"+this.original.getConstantes()[i]+aux;
            }
            this.restriccionesDual=new String[this.original.getzValores().length];
            
            for(int i=0;i<this.restriccionesDual.length;i++){
                v='x';
                v1=v+++"";
                this.restriccionesDual[i]="";
                this.restriccionesDual[i]+=this.original.getRestricciones()[0].getValores()[i]+v1;
                for (int j = 1; j < this.original.getRestricciones().length; j++) {
                    v1=v+++"";
                    this.restriccionesDual[i]+="+"+this.original.getRestricciones()[j].getValores()[i]+v1;
                }
                this.restriccionesDual[i]+="=>"+this.original.getzValores()[i];
            }
            this.restricciones+=this.restriccionesDual[0];
            for (int i = 1; i < this.restriccionesDual.length; i++) {
                this.restricciones+="\n"+this.restriccionesDual[i];
            }
            this.variables= new String[original.getzValores().length];
            for(int i=0;i<this.variables.length;i++){
                this.variables[i]="x"+(i+1);
            }
            if(this.dualSimplex.validarZ(this.zDual) && this.dualSimplex.validarRestriccionesMin(this.restricciones)){
                this.dual= new DatosD("Minimización");
                this.dual.getZ().setText(this.zDual);
                this.dual.getReinstraintsTA().setText(this.restricciones);
                this.dual.getjButton2().doClick();
                return true;
            }else JOptionPane.showMessageDialog(null, "No se pudo transformar al dual");
        }
        JOptionPane.showMessageDialog(null, "Introduzca parametros válidos");
        return false;
    }

    public String getzDual() {
        return zDual;
    }

    public String getRestricciones() {
        return restricciones;
    }
    public boolean recibirParametrosMin(String z, String restricciones){
        return this.original.validarZ(z) && this.original.validarRestriccionesMin(restricciones);
    }
    public boolean recibirParametrosMax(String z, String restricciones){
        return this.original.validarZ(z) && this.original.validarRestriccionesMax(restricciones);
    }
    public static void main(String[] args) {
        Dual l= new Dual();
        l.crearDual("Minimización", "40x+20y+60w", "2x+4y+10w=> 24\n 5x+y+5w=> 8");
        l.crearDual("Maximización", "40x+20y+60w", "2x+4y+10w<= 24\n 5x+y+5w<= 8");
        System.out.println("");
    }
}