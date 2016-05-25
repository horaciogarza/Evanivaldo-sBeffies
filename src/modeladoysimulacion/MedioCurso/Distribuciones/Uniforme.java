/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeladoysimulacion.MedioCurso.Distribuciones;

import java.util.Arrays;
import modeladoysimulacion.MedioCurso.GRandom;

/**
 *
 * @author diego
 */
public class Uniforme {
    private final int numR;
    private final int a;
    private final int b;
    private final double[] r;
    private double[] x;
    private double xSum;
    private double xProm;
    
    public Uniforme(int a, int b, int numR){
        this.numR = numR;
        this.a = a;
        this.b = b;
        
        r = GRandom.getRndL(numR);
        x = new double[numR+1];
        xSum = 0;
        
        System.out.println("\nNumeros Aleatorios obtenidos:\n");
        for (double d : r) {
            System.out.println("\t" + d);
        }
        System.out.println("\n");
        for(int i=0;i<numR;i++){
            x[i] = a+(b-a)*r[i];
            xSum = x[i]+xSum;
            System.out.println("X["+(i+1)+"] = "+a+" + ( "+b+" - "+a+" )( "+r[i]+" ) "+" = "+x[i]);
        }
        xProm = xSum/numR;
        
        System.out.println("\n\tX Total = "+xSum);
        System.out.println("\tX Prom = " + xSum + " / " + numR +" = " + xProm);
    }
}
