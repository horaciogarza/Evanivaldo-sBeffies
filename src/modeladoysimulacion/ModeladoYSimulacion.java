package modeladoysimulacion;

import java.util.Scanner;
import modeladoysimulacion.MedioCurso.GCMult;
import modeladoysimulacion.MedioCurso.GRandom;
import modeladoysimulacion.MedioCurso.GeneradorCongruencialMixto;

public class ModeladoYSimulacion {

    public static void main(String[] args) {
        char sel = '0', bi = 0;
        char cont;
        Scanner scan = new Scanner(System.in);
        do{
            do{
            bi = 0;
            System.out.println("Que tipo de generador deseas:\n(Presione el num que desea y de enter)\n"
                + "1.Generador Congruencial Mixto\n" + "2.Generador Congruencial Multiplicativo\n"
                + "3.Generador Alternativo(propio)\n");
            sel = scan.next().charAt(0);
        switch(sel){
            case '1':
                GCMix();
                break;
            case '2':
                GCMult();
                break;
            case '3':
                GRndm();
                break;
            default:
                System.out.println("Opcion no valda.");
                bi = 1;
        }}while(bi == 1);
        
            System.out.println("Deseas generar de nuevo?\n1.Si\n2.No");
            cont = scan.next().charAt(0);
            
        }while(cont == '1');
        
    }

    private static void GCMix() {
        Scanner scan = new Scanner(System.in);
        try{
        System.out.println("Ingresa A:\n");
        int a = scan.nextInt();
        System.out.println("Ingresa X0:\n");
        int x = scan.nextInt();
        System.out.println("Ingresa C:\n");
        int c = scan.nextInt();
        System.out.println("Ingresa M:\n");
        int m = scan.nextInt();
        GeneradorCongruencialMixto mix1 = new GeneradorCongruencialMixto(a, x, c, m);
        mix1.makeThisHappen();
        }catch(Exception e){
            System.out.println("Error");
            return;
        }
        
                                    
        
    }

    private static void GCMult() {
        Scanner scan = new Scanner(System.in);
        try{
        System.out.println("Ingresa A:\n");
        int a = scan.nextInt();
        System.out.println("Ingresa X0:\n");
        int x = scan.nextInt();
        System.out.println("Ingresa M:\n");
        int m = scan.nextInt();
        new GCMult(a, x, m).init();
        }catch(Exception e){
            System.out.println("Error");
            return;
        }
        
    }

    private static void GRndm() {
        Scanner scan = new Scanner(System.in);
        int size;
        System.out.println("Cuantos numeros quieres generar?(indique el num y de enter)");
        try{
            size = scan.nextInt();
        }catch(Exception e){
            System.out.println("Error");
            return;
        }
        GRandom rA = new GRandom();
        double[] rndL = rA.getRndL(size);
        for(int i = 1; i < size + 1; i++){
            System.out.println("Dato " + i + " : " + rndL[i - 1]);
        }
    }
}
