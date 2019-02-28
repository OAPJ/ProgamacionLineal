/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramacionLineal;

/**
 *
 * @author ovall
 */
public class Gauss2X2 {
    private double[] a;
    private double[] b;
    private double[] r;
    private double x;
    private double y;
    
    public Gauss2X2(double[] a, double[] b, double[] r){
        this.a = a;
        this.b = b;
        this.r = r;
    }
    
    public void metodo(){
        //Primera parte hacerlo de la forma: 1)
        //1 ? = ?;
        //? ? = ?;
        double auxA = a[0];
        a[0] = a[0] / auxA;
        b[0] = b[0] / auxA;
        r[0] = r[0] / auxA;
        System.out.println(a[0]+" "+b[0]+" "+r[0]);
        System.out.println(a[1]+" "+b[1]+" "+r[1]);
        //2) Convertir en:
        //1 ? = ?
        //0 ? = ?
        double auxA2 = a[1]*a[0];
        a[1] = a[1] - (a[0] * auxA2);
        b[1] = b[1] - (b[0] * auxA2);
        r[1] = r[1] - (r[0] * auxA2);
        System.out.println("");
        System.out.println(a[0]+" "+b[0]+" "+r[0]);
        System.out.println(a[1]+" "+b[1]+" "+r[1]);
        //3) Convertir en:
        //1 ? = ?
        //0 1 = ?
        double auxB = b[1];
        b[1] = b[1] / auxB;
        r[1] = r[1] / auxB;
        System.out.println("");
        System.out.println(a[0]+" "+b[0]+" "+r[0]);
        System.out.println(a[1]+" "+b[1]+" "+r[1]);
        //4) Convertir en:
        //1 0 = ?
        //0 1 = ?
        double auxB2 = b[0];
        b[0] = b[0] - (b[1] * auxB2);
        r[0] = r[0] - (r[1] * auxB2);
        System.out.println("");
        System.out.println(a[0]+" "+b[0]+" "+r[0]);
        System.out.println(a[1]+" "+b[1]+" "+r[1]);
        //Guardamos el valor de X y Y
        x = r[0];
        y = r[1];
        System.out.println("");
        System.out.println("("+x+","+y+")");
    }
    
    public static void main(String[] args) {
        double[] a = new  double[]{2.5, 3};
        double[] b = new  double[]{1,3};
        double[] r = new  double[]{20,30};
        Gauss2X2 g = new Gauss2X2(a, b, r);
        g.metodo();
    }
}
