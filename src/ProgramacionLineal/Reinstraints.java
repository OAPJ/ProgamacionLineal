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
    private ArrayList<double[]> xyz;//Valores que estan en las restriciones
    private ArrayList<double[]> coordenadas; //Cordenas de la eccuacion
    private Gauss2X2 gauss;
    
    public Reinstraints(){
        this.z = "";
        restrinciones = new ArrayList<>();
        xyz = new ArrayList<>();
        coordenadas = new ArrayList<>();
    }
    
    public boolean validarZ(String z){
        z = z.replace(" ", ""); //Remove to spaces
        //Verificamos que no sea negativo
        if(z.contains("-")) return false;
        //Verificamos que al inicio tenga numero
        if(!((z.charAt(0)>47 && z.charAt(0)<58) || z.charAt(0)=='x')) return false;
        //Verificamos que al final no este un signo raro
        if(z.charAt(z.length()-1) != 'y') return false;
        //Validamos que contenga x y y
        if(!z.contains("x") || !z.contains("y")) return false;
        //Validamos que no tenga un caracter extraño
        int contx=0, conty=0;
        for(int i=0; i<z.length(); i++){
            int aux = z.charAt(i);
            if(aux == 'x') contx++;
            if(aux == 'y') conty++;
            if((aux == 'x' && contx>1) || (aux == 'y' && conty>1)) return false; //Verifica si hay más de dos x o y
            if(aux == '.' && !(z.charAt(i+1)>47 && z.charAt(i+1)<58)) return false; //Verifica que despues del punto tenga un numero
            if(aux == '+' && !((z.charAt(i+1)>47 && z.charAt(i+1)<58) || z.charAt(i+1)=='y')) return false;//Verifica que despues del + tenga un numero
            if(!((aux>47 && aux<58) || aux==120 || aux==121 || aux==46 || aux=='+')) return false;//Si no es un nuemor, x, y y el .
        }
        //Verificar que no tenga más de +
        String[] a = z.split("\\+");
        if(a.length != 2) return false;
        return true;
    }
    
    public boolean validarRestrinciones(String r){
        //Quitamos los espacios en blanco
        r = r.replace(" ", "");
        //Verificamos que las restriciones no sean negativas
        if(r.contains("-")) return false;
        //Separamos las restriciones por \n
        String[] res = r.split("\\\n");
        for(int i=0; i<res.length; i++){
            //Verificamos que al inicio tenga numero
            if(!((res[i].charAt(0)>47 && res[i].charAt(0)<58) || res[i].charAt(0)=='x')) return false;
            //Verificamos que al final no este un signo raro
            if(!(res[i].charAt(res[i].length()-1)>47 && res[i].charAt(res[i].length()-1)<58)) return false;
            //Validamos que todas las restriciones contegan x e y;
            if(!res[i].contains("x") || !res[i].contains("y")) return false;
            //Validamos que las restriciones no contegan un caracter extraño
            int contx=0, conty=0;
            for(int j=0; j<res[i].length(); j++){
                int aux = res[i].charAt(j);
                if(aux == 'x') contx++;
                if(aux == 'y') conty++;
                if((aux == 'x' && contx>1) || (aux == 'y' && conty>1)) return false; //Verifica si hay más de dos x o y
                if(aux == '.' && !(res[i].charAt(j+1)>47 && res[i].charAt(j+1)<58)) return false; //Verifica que despues del punto tenga un numero
                if(aux == '+' && !((res[i].charAt(j+1)>47 && res[i].charAt(j+1)<58) || res[i].charAt(j+1)=='y')) return false;//Verifica que despues del + tenga un numero
                if(!((aux>47 && aux<58) || aux==120 || aux==121 || aux=='.' || aux=='+' || aux=='<' || aux=='=')) return false;//Si no es un nuemor, x, y y el .
            }
            //Verificar que no tenga más de +
            String[] a = res[i].split("\\+");
            if(a.length != 2) return false;
            a = res[i].split("\\<");
            if(a.length != 2) return false;
            a = res[i].split("\\=");
            if(a.length != 2) return false;
        }
        //Guarda las restriciones una vez que son todas validas
        for(int i=0; i<res.length; i++)
            getRestrinciones().add(res[i]);
        return true;
    }
    
    public void obtenerValores(){
        //Optenemos el valor de X de  Y y el valor de la ecucación
        for(int i=0; i<getRestrinciones().size(); i++){
            //Separamos las restrinciones por <=
            String[] ec  = getRestrinciones().get(i).split("\\<=");
            //Separamos por el +
            String[] ec2 = ec[0].split("\\+");
            //Guardamos los valores
            double[] aux = new double[3];
            for(int j=0; j<ec2.length; j++){
                String aux2 = "";
                for(int k=0; k<ec2[j].length()-1; k++)
                    aux2 += ec2[j].charAt(k);
                if(aux2 == "")
                    aux2 = "1";
                aux[j] = Double.parseDouble(aux2);
            }
            aux[2] = Double.parseDouble(ec[1]);
            this.getXyz().add(aux);
            coordenadas.add(new double[]{aux[2]/aux[0],0});
            coordenadas.add(new double[]{0,aux[2]/aux[1]});
        }
        gauss = new Gauss2X2(xyz);
        for(int i=0; i<gauss.getCoordenasdas().size(); i++)
            coordenadas.add(gauss.getCoordenasdas().get(i));
        for(int i=0; i<coordenadas.size(); i++)
            System.out.println(coordenadas.get(i)[0]+" "+coordenadas.get(i)[1]);
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

    /**
     * @return the z
     */
    public String getZ() {
        return z;
    }

    /**
     * @return the restrinciones
     */
    public ArrayList<String> getRestrinciones() {
        return restrinciones;
    }

    /**
     * @return the xyz
     */
    public ArrayList<double[]> getXyz() {
        return xyz;
    }
}
