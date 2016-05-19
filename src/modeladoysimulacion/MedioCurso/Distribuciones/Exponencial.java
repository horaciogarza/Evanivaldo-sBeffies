/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeladoysimulacion.MedioCurso.Distribuciones;

import modeladoysimulacion.MedioCurso.GRandom;

/**
 *
 * @author diego
 */
public class Exponencial {
    private final int lambda;
    private final int numR;
    private final double[] r;
    private double[] x;
    private double xSum;
    private double xProm;
    
    public Exponencial (int lambda, int numR){
        this.lambda = lambda;
        this.numR = numR;
        
        r = GRandom.getRndL(numR);
        x = new double[numR+1];
        xSum = 0;
        for(int i=0;i<numR;i++){
            x[i] = -((double)1/(double)lambda)*Math.log(r[i]);
            xSum = x[i]+xSum;
            System.out.println("X["+(i+1)+"]="+x[i]);
        }
        xProm = xSum/numR;
        
        System.out.println("X Total: "+xSum);
        System.out.println("X Prom: "+xProm);
    }
}
