/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeladoysimulacion.MedioCurso.Distribuciones;

import java.util.ArrayList;
import modeladoysimulacion.MedioCurso.GRandom;

/**
 *
 * @author diego
 */
public class Poisson {
    private int lambda;
    private final ArrayList<Double> fxi;
    private double fxiSum;
    private double[] r;
    private int[] rx;
    public Poisson(int lambda){
        this.lambda = lambda;
        int i=0;
        fxi = new ArrayList();
        fxiSum = 0;
        System.out.println("x\tf(Xi)\t\t\tF(Xi)");
        do{
            fxi.add(i,(Math.exp(-lambda)*Math.pow(lambda, i))/(factorial(i)));
            fxiSum += fxi.get(i);
            if(fxiSum<1){
                System.out.println(i+"\t"+fxi.get(i)+"\t"+fxiSum);
            }
            i++;
        }while(fxiSum<.99997);
        
        //Numreos Rectangulares
        r = GRandom.getRndL(lambda);
        for(i = 0 ;i < lambda ;i++){
            int min = i;
            
            for (int j = i + 1; j < lambda ; j++) {
                if(r[j] < r[min])
                    min = j;
            }
            
            if (i != min) {
                double aux = r[i];
                r[i] = r[min];
                r[min] = aux;
            }
        }
        
        
        double ra=0;
        double rb=fxi.get(0);
        rx = new int[lambda];
        int x=0;
        for(int j=0;j<fxi.size();j++){
            if(x>=lambda){
                return;
            }
            if(ra<r[x] && rb>=r[x]){
                rx[x] = j;
                x++;
                j--;
            }else{
                ra = rb;
                rb = ra + fxi.get(j);
            }
        }
    }
    
    public void print(){
        System.out.println("\nR \t Num \t Rango");
        int sum =0;
        for(int i=0;i<lambda;i++){
            System.out.println("R"+i+"\t"+r[i]+"\t "+rx[i]);
            sum += rx[i];
        }
        System.out.println("\t  Total: "+sum);
    }
    
    
    private double factorial(int n){
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
