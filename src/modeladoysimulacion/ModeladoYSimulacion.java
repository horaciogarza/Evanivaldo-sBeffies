package modeladoysimulacion;

import java.util.Scanner;
import modeladoysimulacion.MedioCurso.GCMult;
import modeladoysimulacion.MedioCurso.GRandom;
import modeladoysimulacion.MedioCurso.GeneradorCongruencialMixto;

public class ModeladoYSimulacion {

    public static void main(String[] args) {
        
        /*Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa A:\n");
        int a = scan.nextInt();
        System.out.println("Ingresa X0:\n");
        int x = scan.nextInt();
        System.out.println("Ingresa C:\n");
        int c = scan.nextInt();
        System.out.println("Ingresa M:\n");
        int m = scan.nextInt();
        
                                    
        GeneradorCongruencialMixto mix1 = new GeneradorCongruencialMixto(a, x, c, m);
        mix1.makeThisHappen();*/
        
        //new GCMult(4,9,16).init();
        /*new GCMult(7,12,32).init();
        new GCMult(5,8,64).init();
        new GCMult(15,3,16).init();
        
        new GCMult(5,5,32).init();*/
        
        GRandom rA = new GRandom();
        double[] rndL = rA.getRndL(13);
        for(int i = 1; i < 14; i++){
            System.out.println("Dato " + i + " : " + rndL[i - 1]);
        }
        
    }
}
