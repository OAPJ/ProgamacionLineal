/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetodoSimplex;

import java.util.ArrayList;

/**
 *
 * @author <Mikel>
 */
public class Matriz {
    double matriz[][];
    char variable[];
    int numRestricciones;
    ValidarSimplex datos;
    public Matriz() {
    }
    public void crearMatriz(ValidarSimplex jsjs){
        this.datos=jsjs;
        this.numRestricciones= jsjs.getRestricciones().length;
        int tamannoVariables= numRestricciones+jsjs.getVariable().length;
        this.matriz= new double[numRestricciones+1][tamannoVariables+1];
        this.variable= new char[tamannoVariables];
        llenarMatriz();
    }

    private void llenarMatriz() {
        //Se ponen los datos de la funcion Objetivo
        for (int var = 0; var < datos.getVariable().length; var++) {
            variable[var]=datos.getVariable()[var];
            for(int i=0;i<datos.getzValores().length;i++){
                if(variable[var]==datos.getVariable()[i])matriz[datos.getRestricciones().length][i]=(datos.getzValores()[i])*-1;
            }
        }
        //Se ponen los datos de las restricciones
        for(int i=0;i<this.numRestricciones;i++){
            for(int j=0;j<this.datos.getRestricciones()[0].getValores().length;j++){
                for (int z = 0; z < this.datos.getRestricciones()[0].getValores().length; z++) {
                    if(variable[j]==datos.getRestricciones()[i].getVariable()[z]){
                        matriz[i][j]=datos.getRestricciones()[i].getValores()[z];
                    }
                }
            }
        }
        //Se ponen las variables flojas
        char aux='1';
        for(int i=this.datos.getRestricciones()[0].getValores().length;i<variable.length;i++){
            variable[i]=aux;
            aux++;
        }
        for(int i=0;i<this.numRestricciones;i++){
            for(int j=this.datos.getRestricciones()[0].getValores().length;j<variable.length;j++){
                if(i==j-this.datos.getRestricciones()[0].getValores().length) matriz[i][j]=1;
            }
        }
        //se ponen las constantes
        for(int i=0;i<this.numRestricciones;i++){
            matriz[i][variable.length]=datos.getConstantes()[i];
        }
    }
    public String mostrarMatriz(){
        String aux="";
        for(double[] fila: this.matriz){
            for(int i=0;i<fila.length-1;i++){
               String num=String.format("%.2f", fila[i]);
               while(num.length()<5)
                   num+=" ";
                aux+=num+"| ";
            }
            aux+=fila[fila.length-1]+"\n";
        }
        return aux;
    }
    public boolean hayNegativos(){
        for(int i=0;i<matriz[0].length;i++){
            if(matriz[numRestricciones][i]<0) return true;
        }
        return false;
    }

    public double[][] getMatriz() {
        return matriz;
    }
    public int posAbsolutoMayor(){
        int aux=0;
        for(int i=1;i<matriz[0].length-numRestricciones-1;i++){
            if(Math.abs(matriz[numRestricciones][i])>Math.abs(matriz[numRestricciones][aux])){
                aux=i;
            }
        }
        return aux;
    }
    public int razonDesp(int col){
        int aux=0;
        double desp= matriz[aux][col]/matriz[aux][variable.length];
        for (int i = 1; i < this.numRestricciones; i++) {
            double res=matriz[i][col]/matriz[i][variable.length];
            if(desp<res){
                aux=i;
                desp=res;
            }
        }
        return aux;
    }
    public void resolverMaximizacion(){
        while(hayNegativos()){
            int pos=posAbsolutoMayor();
            int fila=razonDesp(pos);
            System.out.println(pos+" col : fila"+fila);
            double facDiv= 1/matriz[fila][pos];
            System.out.println(facDiv);
            for(int i=0;i<variable.length+1;i++){
                matriz[fila][i]*=facDiv;
            }
            System.out.println(mostrarMatriz());
            
            for(int i=0;i<numRestricciones+1;i++){
                if(i!=fila){
                    double objetivo=matriz[i][pos]*-1;
                    System.out.println(objetivo);
                    for(int x=0;x<variable.length+1;x++){
                        matriz[i][x]+= (objetivo*matriz[fila][x]);
                    }
                    System.out.println(mostrarMatriz());
                }
            }
        }
    }
    
    public String variables(){
        String a = "";
        for(int i=0; i<this.variable.length; i++)
            if(variable[i] > 47 && variable[i] < 58)
                a += "    S"+variable[i]+"  |";
            else
                a += "    "+variable[i]+"    |";
        return a+"   CTE";
    }
    
    public String intrepretacion(){
        int cont = 0;
        for(int i=0; i<this.variable.length; i++)
            if(variable[i] > 47 && variable[i] < 58) break;
            else cont++;
        String[] inter = new String[cont]; 
        for(int x=0; x<cont; x++)
            for(int i=0; i<this.matriz.length; i++){
                System.out.println(matriz[i][x]);
                if(matriz[i][x] == 1) {
                    inter[x] = ""+matriz[i][matriz[i].length-1];
                    //System.out.println("R "+variable[x]+" = "+matriz[i][matriz[i].length-1]);
                }
            }
        String res = "Para que la empresa logre Maximizar su función objetivo, requiere generar \n";
        for(int i=0; i<cont; i++){
            if(i == cont-2) res += inter[i] + " unidades de ´"+variable[i]+"´ y ";
            else if(i < cont-2) res += inter[i] + " unidades de ´"+variable[i]+"´, ";
            else if(i == cont-1) res += inter[i] + " unidades de ´"+variable[i]+"´ ";
        }
        res += "\npara optener "+matriz[matriz.length-1][matriz[0].length-1]+" de ganancia considerando las restricciones";
        System.out.println(res);
        return res;
    }
    public static void main(String[] args) {
        ValidarSimplex vs= new ValidarSimplex();
        vs.validarZ("3x+c");
        vs.validarRestriccionesMax("3c+2x<=2\n 3x+4c<=3\n 2x+2c<=5");
        Matriz m= new Matriz();
        m.crearMatriz(vs);
        System.out.println("");
    }
    
}
