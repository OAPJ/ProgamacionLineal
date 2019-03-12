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
    private ArrayList<double[]> coordenadasValidas; //Coordenas que estan en el rango
    private ArrayList<Double> evaCoordenadas; //Valor de las coordenadas en z
    private Gauss2X2 gauss;
    private double[] resultado; //Saber cual es el valor mayor y cuales son las coordenadas
    
    public Reinstraints(){
        this.z = "";
        xyz = new ArrayList<>();
        coordenadas = new ArrayList<>();
        restrinciones = new ArrayList<>();
        evaCoordenadas = new ArrayList<>();
        coordenadasValidas = new ArrayList<>();
        resultado = new double[3];
    }
    
    public boolean validarZ(String z){
        this.z = z;
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
    
    public boolean validarRestrincionesMin(String r){
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
                if(!((aux>47 && aux<58) || aux==120 || aux==121 || aux=='.' || aux=='+' || aux=='>' || aux=='=')) return false;//Si no es un nuemor, x, y y el .
            }
            //Verificar que no tenga más de +
            String[] a = res[i].split("\\+");
            if(a.length != 2) return false;
            a = res[i].split("\\>");
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
        //Guardamos las cooredenas generadas por el metodo gauss
        for(int i=0; i<gauss.getCoordenasdas().size(); i++)
            coordenadas.add(gauss.getCoordenasdas().get(i));
    }
    
    public void obtenerValoresMin(){
        //Optenemos el valor de X de  Y y el valor de la ecucación
        for(int i=0; i<getRestrinciones().size(); i++){
            //Separamos las restrinciones por <=
            String[] ec  = getRestrinciones().get(i).split("\\=>");
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
        //Guardamos las cooredenas generadas por el metodo gauss
        for(int i=0; i<gauss.getCoordenasdas().size(); i++)
            coordenadas.add(gauss.getCoordenasdas().get(i));
    }
    
    public void evaluarCoordenadas(){
        //Otenemos los datos de z;
        z = z.replace(" ", ""); //Remove to spaces
        String[] ec = z.split("\\+");
        String X="", Y="";
        double x, y;
        for(int i=0; i<ec[0].length()-1; i++)
           X += ec[0].charAt(i);//Optenemos el valor de x
        x = Double.parseDouble(X);
        for(int i=0; i<ec[1].length()-1; i++)
           Y += ec[1].charAt(i);//Optenemos el valor de y
        y = Double.parseDouble(Y);
        coordenadasValidas.add(new double[]{0,0});
        for(int i=0; i<coordenadas.size(); i++)
            if(validarCumplanRestrincion(coordenadas.get(i)[0],coordenadas.get(i)[1])){
                coordenadasValidas.add(coordenadas.get(i));//Guardamos las que si son validas
            }
        //Sacamos los valores respecto a z
        for(int i=0; i< coordenadasValidas.size(); i++){
            double r = x * coordenadasValidas.get(i)[0] + y * coordenadasValidas.get(i)[1];
            if(r > getResultado()[2]){
                resultado[0] = coordenadasValidas.get(i)[0];
                resultado[1] = coordenadasValidas.get(i)[1];
                resultado[2] = r;
            }
            evaCoordenadas.add(r);
        }
    }
    
    public void evaluarCoordenadasMin(){
        //Otenemos los datos de z;
        z = z.replace(" ", ""); //Remove to spaces
        String[] ec = z.split("\\+");
        String X="", Y="";
        double x, y;
        for(int i=0; i<ec[0].length()-1; i++)
           X += ec[0].charAt(i);//Optenemos el valor de x
        x = Double.parseDouble(X);
        for(int i=0; i<ec[1].length()-1; i++)
           Y += ec[1].charAt(i);//Optenemos el valor de y
        y = Double.parseDouble(Y);
        for(int i=0; i<coordenadas.size(); i++)
            if(validarCumplanRestrincionMin(coordenadas.get(i)[0],coordenadas.get(i)[1])){
                coordenadasValidas.add(coordenadas.get(i));//Guardamos las que si son validas
            }
        //Sacamos los valores respecto a z
        getResultado()[2] = 1000000;
        for(int i=0; i< coordenadasValidas.size(); i++){
            double r = x * coordenadasValidas.get(i)[0] + y * coordenadasValidas.get(i)[1];
            if(r < getResultado()[2]){
                resultado[0] = coordenadasValidas.get(i)[0];
                resultado[1] = coordenadasValidas.get(i)[1];
                resultado[2] = r;
            }
            evaCoordenadas.add(r);
        }
    }
    
    public boolean validarCumplanRestrincion(double x, double y){
        //Esta funcion va a recorrero todas las restrinciones y va a verificar que se cumplan
        //Para que sea valida
        for(int i=0; i<xyz.size(); i++)
            if((xyz.get(i)[0]*x + xyz.get(i)[1]*y) > xyz.get(i)[2])
                return false;
        return true;
    }
    
    public boolean validarCumplanRestrincionMin(double x, double y){
        //Esta funcion va a recorrero todas las restrinciones y va a verificar que se cumplan
        //Para que sea valida
        for(int i=0; i<xyz.size(); i++)
            if((xyz.get(i)[0]*x + xyz.get(i)[1]*y) < xyz.get(i)[2])
                return false;
        return true;
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

    /**
     * @return the coordenadasValidas
     */
    public ArrayList<double[]> getCoordenadasValidas() {
        return coordenadasValidas;
    }

    /**
     * @return the evaCoordenadas
     */
    public ArrayList<Double> getEvaCoordenadas() {
        return evaCoordenadas;
    }

    /**
     * @return the resultado
     */
    public double[] getResultado() {
        return resultado;
    }
}
