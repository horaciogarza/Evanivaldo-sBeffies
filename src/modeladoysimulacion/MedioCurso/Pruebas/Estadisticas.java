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
public class Estadisticas {
    private double z0;
    public Estadisticas(int n){
        double[] recs = GRandom.getRndL(n);
        double sum = 0;
        for(int i=1;i<n+1;i++){
            sum+=recs[i-1];
        }
        double prom = sum/n;
        z0 = ((prom-.5)*(Math.sqrt(n)))/(Math.sqrt(1.0/12.0));
        if(z0<0){
            z0=z0*-1;
        }
    }
    
    public double getZ0(){
        return z0;
    }
    
    public boolean compareZ(double z){
        if(z0<z){
            System.out.println("Z0<Z");
            System.out.println(z0+"<"+z);
            System.out.println("Los numeros son Aceptados");
            return true;
        }else{
            System.out.println("Z0<Z");
            System.out.println(z0+"<"+z);
            System.out.println("Los numeros No son Aceptados");
            return false;
        }
    }
}