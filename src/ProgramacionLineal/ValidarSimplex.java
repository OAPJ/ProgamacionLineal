/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramacionLineal;

/**
 *
 * @author <Mikel>
 */
public class ValidarSimplex {
    private double[] zValores;
    private char[] variable;
    private RestriccionSimplex[] restricciones;
    private double[] limites;
    public double[] getzValores() {
        return zValores;
    }

    public RestriccionSimplex[] getRestricciones() {
        return restricciones;
    }

    public double[] getLimites() {
        return limites;
    }

    public char[] getVariable() {
        return variable;
    }
    public ValidarSimplex() {
        
    }
    public boolean validarZ(String z){
        if(z.contains("-")) return false;
        z=z.replace(" ", "");
        String[] valores= z.split("\\+");
        zValores= new double[valores.length];
        this.variable=new char[valores.length];
        try{
            for(int i=0;i<this.variable.length;i++){
                int aux= valores[i].length();
                variable[i]=valores[i].charAt(aux-1);
                if(aux==1){
                    zValores[i]=1;
                }else{
                    zValores[i]= Double.parseDouble(valores[i].substring(0, aux-1));
                }
                if(z.lastIndexOf(variable[i])!=z.indexOf(variable[i]))
                    return false;
            }
            return true;
        }catch(NumberFormatException x){
            return false;
        }
    }
    public boolean validarRestricciones(String res){
        String[] restriccionesAux= res.split("\n");
        this.restricciones=new RestriccionSimplex[restriccionesAux.length];
        this.limites= new double[restriccionesAux.length];
        for(int i=0;i<this.restricciones.length;i++){
            String[] aux= restriccionesAux[i].split("\\<=");
            this.restricciones[i]= new RestriccionSimplex();
            if(this.restricciones[i].validarRestriccion(aux[0])){
                try{
                    this.limites[i]= Double.parseDouble(aux[1]);
                }catch(NumberFormatException e){
                    return false;
                }
            }else return false;
        }
        return true;
    }
    public static void main(String[] args) {
        ValidarSimplex v = new ValidarSimplex();
        boolean s=v.validarRestricciones("3x + 1a+ 4y+ 99z+ 88n<=2 \n 4q + 4p+ 5y+ 99z+ 88n <=2");
        System.out.println(s);
    }
}
