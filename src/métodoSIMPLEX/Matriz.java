/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package métodoSIMPLEX;

/**
 *
 * @author <Mikel>
 */
public class Matriz {
    double matriz[][];
    char variable[];
    public Matriz() {
    }
    public void crearMatriz(ValidarSimplex jsjs){
        int numRestricciones= jsjs.getRestricciones().length;
        int tamannoVariables= numRestricciones+jsjs.getVariable().length;
        this.matriz= new double[numRestricciones+1][tamannoVariables+1];
        this.variable= new char[numRestricciones+1];
        llenarMatriz();
    }

    private void llenarMatriz() {
        
    }
    public static void main(String[] args) {
        ValidarSimplex vs= new ValidarSimplex();
        vs.validarZ("3x+c");
        vs.validarRestricciones("3x+2c<=2\n 3x+4c<=3\n 2x+2c<=5");
        Matriz m= new Matriz();
        m.crearMatriz(vs);
        System.out.println("");
    }
}
