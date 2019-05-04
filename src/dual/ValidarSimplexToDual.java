/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dual;

import GUI.PL.Datos;
import MetodoSimplex.RestriccionSimplex;
import MetodoSimplex.ValidarSimplex;

/**
 *
 * @author Miguel
 */
public class ValidarSimplexToDual extends ValidarSimplex {
    private double nuevosZValores[];
    private String[] nuevoVariable;
    public RestriccionSimplex[] nuevoRestricciones;
    public double[] nuevoConstantes;
    private String restriccionesNuevas;
    private String fObjetivo;
    @Override
    public boolean validarRestriccionesMax(String res){
        String[] restriccionesAux= res.split("\n");
        super.setRestricciones(new RestriccionSimplex[restriccionesAux.length]);
        super.setConstantes(new double[restriccionesAux.length]);
        for(int i=0;i<this.getRestricciones().length;i++){
            String[] aux= restriccionesAux[i].split("\\=>");
            super.getRestricciones()[i]= new RestriccionSimplex();
            if(super.getRestricciones()[i].validarRestriccion(aux[0])){
                try{
                    super.getConstantes()[i]= Double.parseDouble(aux[1]);
                }catch(NumberFormatException e){
                    return false;
                }
            }else return false;
        }
        return true;
    }
    
    public void generarDual(){
        char n='x';
        String obj="";
        this.nuevosZValores= new double[super.getConstantes().length];
        this.nuevoVariable= new String[super.getConstantes().length];
        char [] nuevoVariableAux= new char[super.getConstantes().length];
        for(int i=0;i<nuevosZValores.length;i++){
            this.nuevosZValores[i]=super.getConstantes()[i];
            this.nuevoVariable[i]="x"+(i+1);
            nuevoVariableAux[i]=n++;
        }
        this.nuevoConstantes = new double[super.getzValores().length];
        this.nuevoRestricciones= new RestriccionSimplex[super.getzValores().length];
        System.arraycopy(this.getzValores(), 0, this.nuevoConstantes, 0, this.nuevoConstantes.length);
        String aux="";
        for(int i=0;i<this.getRestricciones().length;i++){
            aux+=this.getRestricciones()[i].getValores()[0]+"x";
            for(int j=1;j<this.getRestricciones().length;j++){
                double num= this.getRestricciones()[j].getValores()[i];
                aux+="+"+num+nuevoVariableAux[j];
            }
            aux+="=>"+nuevoConstantes[i]+"\n";
        }
        obj+=this.nuevosZValores[0]+"x";
        for(int i=1;i<this.nuevosZValores.length;i++){
            obj+="+"+this.nuevosZValores[i]+nuevoVariableAux[i];
        }
        aux= aux.substring(0,aux.length()-2);
        System.out.println(obj+"\n"+aux);
        this.restriccionesNuevas=aux;
        this.fObjetivo=obj;
        if(validarRestriccionesMax(aux))//lo que hay que considerar son nuevo constantes, restricciones,nuevo variable
        {
            Datos d= new Datos("Minimización");
            d.getZ().setText(this.fObjetivo);
            d.getReinstraintsTA().setText(this.restriccionesNuevas);
            d.getjButton2().doClick();
        }
    }
    
    public static void main(String[] args) {
        ValidarSimplexToDual SD = new ValidarSimplexToDual();
        SD.validarZ("40x+20y+60w");
        System.out.println(SD.validarRestriccionesMax(
                "2x+4y+10w=> 24\n" +"5x+y+5w=> 8"));
        
        SD.generarDual();
        System.out.println("");
    }
    
}
