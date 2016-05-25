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
            System.out.println(recs[i-1]);
            sum+=recs[i-1];
        }
        System.out.println("\nResultados: ");
        System.out.println("\tSuma: Σx = "+sum);
        double prom = sum/n;
        System.out.println("\tPromedio: x̅ = "+prom);
        z0 = ((prom-.5)*(Math.sqrt(n)))/(Math.sqrt(1.0/12.0));
        if(z0<0){
            z0=z0*-1;
        }
        System.out.println("\tZo = |("+prom+" - "+.5+") * ("+Math.sqrt(n)+")/("+Math.sqrt(1.0/12.0)+")| = "+z0);
    }
    
    public double getZ0(){
        return z0;
    }
    
    public boolean compareZ(double z){
        System.out.println("");
        if(z0<z){
            System.out.println("\tZo < z");
            System.out.println("\tSustituyendo...");
            System.out.println("\t" +z0+" < "+z);
            System.out.println("\tPor lo tanto, los numeros son aceptados");
            return true;
        }else{
            System.out.println("\tZo < Z");
            System.out.println("\tSustituyendo...");
            System.out.println("\t" + z0 + " > "+z);
            System.out.println("Por lo tanto, los numeros no son aceptados");
            return false;
        }
    }
}
