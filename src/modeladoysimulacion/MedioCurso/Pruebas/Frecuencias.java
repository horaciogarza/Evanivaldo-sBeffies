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
        
        System.out.println("Numeros rectangulares: \n");
        for(int i=0;i<N;i++){
            int j = 1;
            if(recs[i]<((float)((float)j/(float)n))){
                foi[j]++;
                System.out.println(recs[i]+" A");
            }else{
                while(!((j-1)==n)){
                    if(recs[i]<((float)((float)j/(float)n))){
                        foi[j]++;
                        System.out.print(recs[i]+" ");
                        switch(j){
                            case 2:
                                System.out.println("B");
                                break;
                            case 3:
                                System.out.println("C");
                                break;
                            case 4:
                                System.out.println("D");
                                break;
                            case 5:
                                System.out.println("E");
                                break;
                            case 6:
                                System.out.println("F");
                                break;
                            case 7:
                                System.out.println("G");
                                break;
                            case 8:
                                System.out.println("H");
                                break;
                            case 9:
                                System.out.println("I");
                                break;
                            case 10:
                                System.out.println("J");
                                break;
                            case 11:
                                System.out.println("K");
                                break;
                            case 12:
                                System.out.println("L");
                                break;
                        }
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
        System.out.println("");
        for(int i=1; i<foi.length; i++){
            System.out.print("\t");
            switch(i){
                case 1:
                    System.out.print("A");
                    break;
                case 2:
                    System.out.print("B");
                    break;
                case 3:
                    System.out.print("C");            
                    break;
                case 4:
                    System.out.print("D");
                    break;
                case 5:
                    System.out.print("E");
                    break;
                case 6:
                    System.out.print("F");
                    break;
                case 7:
                    System.out.print("G");
                    break;
                case 8:
                    System.out.print("H");
                    break;
                case 9:
                    System.out.print("I");
                    break;
                case 10:
                    System.out.print("J");
                    break;
                case 11:
                    System.out.print("K");
                    break;
                case 12:
                    System.out.print("L");
                    break;
            }
            System.out.print("\t");
        }
        System.out.print("\nFEi");
        for(int i=1; i<foi.length; i++){
            System.out.print("\t");
            System.out.printf("%.2f", fei);
            System.out.print("\t");
        }
        System.out.print("\t= "+N);
        System.out.print("\nFOi");
        for(int i=1; i<foi.length; i++){
            System.out.print("\t"+foi[i]);
            System.out.print("\t");
        }
        System.out.print("\t="+N);
        xo2 = (1/fei)*xo2;
        
    }
    
    public boolean compareX(double x2){
        System.out.println("\nX\u00B2o = " + xo2);
        System.out.println("\nComparar X\u00B2o < X\u00B2\u03B1, n-1");
        System.out.println("\n"+xo2+" < "+x2);
        if(xo2<x2){
            System.out.println("\n\tVerdadero," + xo2 + " < " + x2 + "; por lo tanto,\n\t"
                    + "los numeros son aceptados");
            return true;
        }else{
            System.out.println("\n\tFalso," + xo2 + " > " + x2 + "; por lo tanto,\n\t"
                    + "los numeros no son aceptados");
            return false;
        }
    }
    
}
