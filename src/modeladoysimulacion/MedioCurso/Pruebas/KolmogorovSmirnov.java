package modeladoysimulacion.MedioCurso.Pruebas;

import modeladoysimulacion.MedioCurso.GRandom;

public class KolmogorovSmirnov {
    private double[] recs;
    private double[] fxi;
    private double[] dn;
    private double may;
    private int n;
    public KolmogorovSmirnov(int n){
        this.n = n;
        recs = GRandom.getRndL(n);
        fxi = new double[n];
        dn = new double[n];
        
        for(int i = 0 ;i < n ;i++){
            int min = i;
            
            for (int j = i + 1; j < n ; j++) {
                if(recs[j] < recs[min])
                    min = j;
            }
            
            if (i != min) {
                double aux = recs[i];
                recs[i] = recs[min];
                recs[min] = aux;
            }
        }
        
        for(int i = 0;i < n;i++){
            fxi[i]=(double)(i+1)/(double)n;
        }
        
        may = 0;
        for(int i = 0;i < n;i++){
            dn[i] = fxi[i]-recs[i];
            if(dn[i]<0){
                dn[i] = -dn[i];
            }
            if(dn[i]>may){  
               may=dn[i];  
           } 
        }
        /*
        for(int i = 1; i < n + 1; i++){
            System.out.println("Dato " + i + " : " + recs[i - 1]);
            System.out.println(fxi[i-1]);
        }*/
    }
    
    public KolmogorovSmirnov print(){
        System.out.println("i"+"\tXi"+"\t\tF(Xi)"+"\t\tDn");
        for(int i = 1; i < n + 1; i++){
            System.out.println(i+"\t"+recs[i-1]+"\t\t"+i+"/"+n+"="+fxi[i-1]+"\t"+fxi[i-1]+"-"+recs[i-1]+"="+dn[i-1]);
            //System.out.println("Dato " + i + " : " + recs[i - 1]);
            //System.out.println(fxi[i-1]);
        }
        return this;
    }
    
    public boolean compareD(double d){
        System.out.println("Dn = "+may);
        System.out.println("\n"+may+"<"+d);
        if(may<d){
            System.out.println("Los numeros son Aceptados");
            return true;
        }else{
            System.out.println("Los numeros No son Aceptados");
            return false;
        }
    }
}
