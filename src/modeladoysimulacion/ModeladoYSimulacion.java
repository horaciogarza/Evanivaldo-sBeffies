package modeladoysimulacion;

import java.util.Scanner;
import modeladoysimulacion.MedioCurso.GCMult;
import modeladoysimulacion.MedioCurso.GRandom;
import modeladoysimulacion.MedioCurso.GeneradorCongruencialMixto;

public class ModeladoYSimulacion {

    public static void main(String[] args) {
        int sel = 0, bi = 0;
        int cont;
        Scanner scan = new Scanner(System.in);
        do{
            do{
            System.out.println("Que tipo de generador deseas:\n(Presione el num que desea y de enter)\n"
                + "1.Generador Congruencial Mixto\n" + "2.Generador Congruencial Multiplicativo\n"
                + "3.Generador Alternativo(propio)\n");
            if(scan.hasNextInt()){
                sel = scan.nextInt();
                bi = 1;
            }
            else
                System.out.println("Formato no valido");
            }while(bi == 0);
        switch(sel){
            case 1:
                GCMix();
                break;
            case 2:
                GCMult();
                break;
            case 3:
                GRndm();
                break;
            default:
                System.out.println("Opcion no valda.");
        }
            System.out.println("Deseas generar de nuevo?\n1.Si\n2.No");
            cont = scan.nextInt();
        }while(cont == 0);
        
    }

    private static void GCMix() {
        Scanner scan = new Scanner(System.in);
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
    }

    private static void GCMult() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa A:\n");
        int a = scan.nextInt();
        System.out.println("Ingresa X0:\n");
        int x = scan.nextInt();
        System.out.println("Ingresa M:\n");
        int m = scan.nextInt();
        new GCMult(a, x, m).init();
    }

    private static void GRndm() {
        Scanner scan = new Scanner(System.in);
        int size;
        System.out.println("Cuantos numeros quieres generar?(indique el num y de enter)");
        size = scan.nextInt();
        GRandom rA = new GRandom();
        double[] rndL = rA.getRndL(size);
        for(int i = 1; i < size + 1; i++){
            System.out.println("Dato " + i + " : " + rndL[i - 1]);
        }
    }
}
