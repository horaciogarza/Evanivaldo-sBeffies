/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeladoysimulacion.MedioCurso.Pruebas;

import modeladoysimulacion.MedioCurso.GRandom;

/**
 *
 * @author diego
 */
public class Frecuencias {
    private int n;
    private int N;
    private float fei;
    private int [] foi;
    private double xo2;
    private double [] recs;

    public Frecuencias(int n, int N) {
        this.n = n;
        this.N = N;
        
        fei = (float)N/(float)n;
        recs = GRandom.getRndL(N);
        foi = new int[n+1];
        for(int i=0;i<N;i++){
            int j = 1;
            if(recs[i]<((float)((float)j/(float)n))){
                foi[j]++;
            }else{
                while(!((j-1)==n)){
                    if(recs[i]<((float)((float)j/(float)n))){
                        foi[j]= foi[j]+1;
                        break;
                    }
                    j++;
                }
            }
        }
        xo2=0;
        for(int i=1;i<foi.length;i++){
            xo2 = Math.pow(foi[i]-fei, 2)+xo2;
        }
        xo2 = (1/fei)*xo2;
        
    }
    
    public boolean compareX(double x2){
        System.out.println("\n"+xo2+"<"+x2);
        if(xo2<x2){
            System.out.println("Los numeros son Aceptados");
            return true;
        }else{
            System.out.println("Los numeros No son Aceptados");
            return false;
        }
    }
    
}
