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
    private final ArrayList<Double> fxiSumArray;
    private double fxiSum;
    private double[] r;
    private int[] rx;

    public Poisson(int lambda) {
        this.lambda = lambda;
        int i = 0;
        fxi = new ArrayList();
        fxiSumArray = new ArrayList();
        
        fxiSum = 0;
        System.out.println("\tx\tf(Xi)\t F(Xi)");
        while (fxiSum < .99997) {
            fxi.add(i, (Math.exp(-lambda) * Math.pow(lambda, i)) / (factorial(i)));
            /*if (i == 0) {
                fxiSumArray.add(i, fxi.get(i));
            }else{
                fxiSumArray.add(i, fxi.get(i) + fxiSumArray.get(i-1));
            }*/
            
            fxiSum += fxi.get(i);
            fxiSumArray.add(i, fxiSum);
            if (fxiSum < 1) {
                //System.out.println(i + "\t" + fxi.get(i) + "\t" + fxiSum);
                System.out.printf("\t%d\t%.5f\t %.5f\n", i ,fxi.get(i), fxiSum);
            }
            if(fxiSum > 1){
                do{
                    fxiSum -= .00001;
                }while(fxiSum >=1);
                //System.out.println(i+"\t"+fxi.get(i)+"\t"+fxiSum);
                System.out.printf("\t%d\t%.5f\t %.5f\n", i ,fxi.get(i), fxiSum-.00001);
                fxiSumArray.add(i, fxiSum);
            }
            i++;
        } 

        //Numreos Rectangulares
        r = GRandom.getRndL(lambda);
        for (i = 0; i < lambda; i++) {
            int min = i;

            for (int j = i + 1; j < lambda; j++) {
                if (r[j] < r[min]) {
                    min = j;
                }
            }

            if (i != min) {
                double aux = r[i];
                r[i] = r[min];
                r[min] = aux;
            }
        }

        double ra = 0;
        double rb = fxi.get(0);
        rx = new int[lambda];
        int x = 0;
        for (int j = 0; j < fxi.size(); j++) {
            if (x >= lambda) {
                return;
            }
            if (ra < r[x] && rb >= r[x]) {
                rx[x] = j;
                x++;
                j--;
            } else {
                ra = rb;
                rb = ra + fxi.get(j);
            }
        }
    }

    public void print() {
        int sum = 0;

        //System.out.print("\n\tSi R > 0.00000 y R \u2264 " + fxiSumArray.get(0) + "\t entonces x = 0");
        System.out.printf("\n\tSi R > 0.00000 y R \u2264 %.5f \t entonces x = 0",fxiSumArray.get(0));
        
        if (r.length >= 1) {
            for (int i = 1; i < fxiSumArray.size()-1; i++) {
                System.out.printf("\n\tSi R > %.5f y R \u2264 %.5f \t entonces x =  %d",fxiSumArray.get(i-1), (fxiSumArray.get(i)-.00001), i);
            }
        }
        System.out.println("\n");
        System.out.println("\n\t#Rectangulares \t Numumero \t Rango");  
        for(int i=0;i<lambda;i++){  
            System.out.println("\tR"+i+" \t\t "+r[i]+"\t "+rx[i]);  
            sum += rx[i];  
        }


        System.out.println("\t\t\t\t  Total: " + sum);
    }

    private double factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
