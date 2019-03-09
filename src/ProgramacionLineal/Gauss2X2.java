/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramacionLineal;

import java.util.ArrayList;

/**
 *
 * @author ovall
 */
public class Gauss2X2 {
    ArrayList<double[]> xyz;
    private ArrayList<double[]> coordenasdas;
    
    public Gauss2X2(ArrayList<double[]> xyz){
        this.xyz = xyz;
        coordenasdas = new ArrayList<>();
        metodo();
    }
    
    public void metodo(){
        for(int i=0; i<xyz.size()-1; i++)
            for(int j=i+1; j<xyz.size(); j++){
                //Para no perder los valores de las ecuacuiones
                double a0 = xyz.get(i)[0]; //X
                double a1 = xyz.get(i)[1]; //Y
                double a2 = xyz.get(i)[2]; //Z
                double b0 = xyz.get(j)[0];//X
                double b1 = xyz.get(j)[1];//Y
                double b2 = xyz.get(j)[2];//Z
                //Primera parte hacerlo de la forma: 1)
                //1 ? = ?;
                //? ? = ?;
                double auxA = a0;
                a0 = a0 / auxA;
                a1 = a1 / auxA;
                a2 = a2 / auxA;
//                System.out.println(a0+" "+a1+" "+a2);
//                System.out.println(b0+" "+b1+" "+b2);
                //2) Convertir en:
                //1 ? = ?
                //0 ? = ?
                double auxA2 = b0*a0;
                b0 = b0 - (a0 * auxA2);
                b1 = b1 - (a1 * auxA2);
                b2 = b2 - (a2 * auxA2);
//                System.out.println("2");
//                System.out.println(a0+" "+a1+" "+a2);
//                System.out.println(b0+" "+b1+" "+b2);
                //3) Convertir en:
                //1 ? = ?
                //0 1 = ?
                double auxB = b1;
                b1 = b1 / auxB;
                b2 = b2 / auxB;
//                System.out.println("3");
//                System.out.println(a0+" "+a1+" "+a2);
//                System.out.println(b0+" "+b1+" "+b2);
                //4) Convertir en:
                //1 0 = ?
                //0 1 = ?
                double auxB2 = a1;
                a1 = a1 - (b1 * auxB2);
                a2 = a2 - (b2 * auxB2);
//                System.out.println("4");
//                System.out.println(a0+" "+a1+" "+a2);
//                System.out.println(b0+" "+b1+" "+b2);
//                System.out.println("");
//                System.out.println("("+a2+","+b2+")");
//                System.out.println("");
                coordenasdas.add(new double[]{a2,b2});
            }
    }
    
    /**
     * @return the coordenasdas
     */
    public ArrayList<double[]> getCoordenasdas() {
        return coordenasdas;
    }
    public static void main(String[] args) {
        double[] a = new  double[]{3, 3, 30};
        double[] b = new  double[]{1,2,16};
        double[] r = new  double[]{20,30};
        ArrayList<double[]> x =new ArrayList<>();
        x.add(a);
        x.add(b);
        Gauss2X2 g = new Gauss2X2(x);
        g.metodo();
    }
}
