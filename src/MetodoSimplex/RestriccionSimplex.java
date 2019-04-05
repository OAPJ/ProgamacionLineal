/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetodoSimplex;

/**
 *
 * @author <Mikel>
 */
public class RestriccionSimplex {
    private double[] valores;
    private char[] variable;

    public RestriccionSimplex() {
        
    }
    public boolean validarRestriccion(String restriccion){
        if(restriccion.contains("-")) return false;
        restriccion=restriccion.replace(" ", "");
        String[] valores= restriccion.split("\\+");
        this.valores= new double[valores.length];
        this.variable=new char[valores.length];
        try{
            for(int i=0;i<this.variable.length;i++){
                try{
                    Double.parseDouble(valores[i]);
                    return false;
                }catch(NumberFormatException e){
                     int aux= valores[i].length();
                    variable[i]=valores[i].charAt(aux-1);
                    if(aux==1){
                        this.valores[i]=1;
                    }else{
                        this.valores[i]= Double.parseDouble(valores[i].substring(0, aux-1));
                    }
                    if(restriccion.lastIndexOf(variable[i])!=restriccion.indexOf(variable[i]))
                        return false;
                }
                
            }
            return true;
        }catch(NumberFormatException x){
            return false;
        }
    }

    public double[] getValores() {
        return valores;
    }

    public char[] getVariable() {
        return variable;
    }
    public static void main(String[] args) {
        RestriccionSimplex r = new RestriccionSimplex();
        System.out.println(r.validarRestriccion("2.5x + k+ 1 "));
        System.out.println("");
    }
    
}
