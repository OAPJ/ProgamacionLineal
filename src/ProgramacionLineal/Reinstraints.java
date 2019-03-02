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
public class Reinstraints {
    private String z;
    private ArrayList<String> restrinciones; 
    
    public Reinstraints(){
        this.z = "";
        restrinciones = new ArrayList<>();
        /*this.reinstraint = ""; //Todas las restriciones
        separateReintraints(); //Las separa por '\n'
        x = new ArrayList<>();
        y = new ArrayList<>();
        c = new ArrayList<>();
        xy = new ArrayList<>();
        coordenas = new ArrayList<>();
        graficar = new Graficar();*/
    }
    
    public boolean validarZ(String z){
        z = z.replace(" ", ""); //Remove to spaces
        //Verificamos que no sea negativo
        if(z.contains("-"))
            return false;
        //Verificamos que al final no este un signo raro
        //if()
        //Separamos por +
        String[] r = z.split("\\+");
        //Verificamos que el tamaño de z sea 2
        if(r.length != 2)
            return false;
        //Verificamos que x y y esten bien escritos;
        
        return true;
    }
    
    public boolean evaluarVaribales(String r){
        //reinstraint = reinstraint.replace(" ", ""); //Remove to spaces
        //Separamos por saltos de linea
        String[] res = r.split("\\\n");
        //Separamos por + y verificamos que sean solo dos variables
        
        //Las agregamos al array
        for(int i=0; i<res.length; i++)
            restrinciones.add(res[i]);
        return true;
    }
    public boolean evaluateNegatives(){
        //Verifica que no sean Negatives
        /*for(int i=0; i<getReinstraintsArray().length; i++)
            if(getReinstraintsArray()[i].contains("-"))
                return false;*/
        return true;
    }
    
    public void separateReintraints(){
//        reinstraint = reinstraint.replace(" ", ""); //Remove to spaces
//        reinstraintsArray = getReinstraint().split("\\\n"); //Separe the reintraint for '\n'
    }
    
    public void obtenerValores(String r){
        //Optenemos el valor de X de  Y y el valor de la ecucación
//        String[] ecuacion = r.split("\\<=");
//        c.add(Double.parseDouble(ecuacion[1]));
//        String[] ecuacion2 = ecuacion[0].split("\\+");
//        x.add(valorX(ecuacion2[0]));
//        y.add(valorY(ecuacion2[1]));
    }
    
    public double valorX(String x){
//        String aux="";
//        if(x.length() == 1)
//            return 1;
//        else
//            for(int i=0; i<x.length()-1; i++)
//                aux += x.charAt(i);
//        return Double.parseDouble(aux);
        return 0;
    }
    
    public double valorY(String y){
//        String aux="";
//        if(y.length() == 1)
//            return 1;
//        else
//            for(int i=0; i<y.length()-1; i++)
//                aux += y.charAt(i);
//        return Double.parseDouble(aux);
        return 0;
    }
    
    public void obtenerValoresGrafica(){
//        for(int i=0; i<c.size(); i++){
//            int[] aux = new int[2];
//            aux[0] = (int)(c.get(i)/x.get(i));
//            aux[1] = (int)(c.get(i)/y.get(i));
//            xy.add(aux);
//        }
    }
    
    public void sacarCordenas(){
//        double[] a = new double[]{x.get(0),x.get(1)};
//        double[] b = new double[]{y.get(0),y.get(1)};
//        double[] r = new double[]{c.get(0),c.get(1)};
//        Gauss2X2 g = new Gauss2X2(a, b, r);
    }
//
//    /**
//     * @return the reinstraintsArray
//     */
//    public String[] getReinstraintsArray() {
//        return reinstraintsArray;
//    }
//
//    /**
//     * @return the reinstraint
//     */
//    public String getReinstraint() {
//        return reinstraint;
//    }
//
//    /**
//     * @return the x
//     */
//    public ArrayList<Double> getX() {
//        return x;
//    }
//
//    /**
//     * @return the y
//     */
//    public ArrayList<Double> getY() {
//        return y;
//    }
//
//    /**
//     * @return the c
//     */
//    public ArrayList<Double> getC() {
//        return c;
//    }
//
//    /**
//     * @return the xy
//     */
//    public ArrayList<int[]> getXy() {
//        return xy;
//    }
    
}
