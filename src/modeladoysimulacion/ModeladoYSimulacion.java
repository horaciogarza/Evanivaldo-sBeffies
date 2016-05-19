package modeladoysimulacion;

import java.util.Scanner;
import modeladoysimulacion.MedioCurso.Distribuciones.Exponencial;
import modeladoysimulacion.MedioCurso.Distribuciones.Poisson;
import modeladoysimulacion.MedioCurso.Distribuciones.Uniforme;
import modeladoysimulacion.MedioCurso.GCMult;
import modeladoysimulacion.MedioCurso.GRandom;
import modeladoysimulacion.MedioCurso.GeneradorCongruencialMixto;
import modeladoysimulacion.MedioCurso.Pruebas.Estadisticas;
import modeladoysimulacion.MedioCurso.Pruebas.Frecuencias;
import modeladoysimulacion.MedioCurso.Pruebas.KolmogorovSmirnov;

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
                + "3.Generador Alternativo(propio)\n" + "4.Prueba Estadisitcas\n"+"5.Prueba de Kolmogorov-Smirnov\n"
                + "6.Prueba de Frecuencias\n" + "7.\n" + "8.Distribucion Exponencial\n"
                + "9.Distribucion Uniforme\n" + "0.Distribucion de Poisson");
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
            case '4':
                PEstadistica();
                break;
            case '5':
                PKolomogorov();
                break;
            case '6':
                PFrecuencias();
                break;
            case '7':
                break;
            case '8':
                DExponencial();
                break;
            case '9':
                DUniforme();
                break;
            case '0':
                DPoisson();
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
        System.out.print("Ingresa A: ");
        int a = scan.nextInt();
        System.out.print("Ingresa X0: ");
        int x = scan.nextInt();
        System.out.print("Ingresa C: ");
        int c = scan.nextInt();
        System.out.print("Ingresa M: ");
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
        System.out.print("Ingresa A: ");
        int a = scan.nextInt();
        System.out.print("Ingresa X0: ");
        int x = scan.nextInt();
        System.out.print("Ingresa M: ");
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
    
    private static void PEstadistica(){
        Scanner scan = new Scanner(System.in);
        int n;
        float z;
        try{
            System.out.println("Ingrese cantidad de numeros Rectangulares(N)?");
            n = scan.nextInt();
            System.out.println("Ingrese El valor de Z a comparar?");
            z = scan.nextFloat();
        }catch(Exception e){
            System.out.println("Error");
            return;
        }
        new Estadisticas(n).compareZ(z);
    }
    
    private static void PKolomogorov(){
        Scanner scan = new Scanner(System.in);
        int n;
        float d;
        try{
            System.out.println("Ingrese cantidad de numeros Rectangulares(N)?");
            n = scan.nextInt();
            System.out.println("Ingrese El valor de D a comparar?");
            d = scan.nextFloat();
        }catch(Exception e){
            System.out.println("Error");
            return;
        }
        new KolmogorovSmirnov(n).print().compareD(d);
    }
    
    private static void PFrecuencias(){
        Scanner scan = new Scanner(System.in);
        int nr;
        int n;
        float x;
        try{
            System.out.println("Ingrese el valor de n.");
            n = scan.nextInt();
            System.out.println("Ingrese cantidad de numeros Rectangulares(N)?");
            nr = scan.nextInt();
            System.out.println("Ingrese El valor de x^2 a comparar?");
            x = scan.nextFloat();
        }catch(Exception e){
            System.out.println("Error");
            return;
        }
        new Frecuencias(n,nr).compareX(x);
    }
    
    private static void DExponencial(){
        Scanner scan = new Scanner(System.in);
        int n;
        int lambda;
        try{
            System.out.println("Ingrese El valor de λ");
            lambda = scan.nextInt();
            System.out.println("Ingrese cantidad de numeros Rectangulares(N)?");
            n = scan.nextInt();
        }catch(Exception e){
            System.out.println("Error");
            return;
        }
        new Exponencial(lambda,n);
    }
    
    private static void DUniforme(){
        Scanner scan = new Scanner(System.in);
        int n;
        int a;
        int b;
        try{
            System.out.println("Ingrese El valor de a");
            a = scan.nextInt();
            System.out.println("Ingrese El valor de b");
            b = scan.nextInt();
            System.out.println("Ingrese cantidad de numeros Rectangulares(N)?");
            n = scan.nextInt();
        }catch(Exception e){
            System.out.println("Error");
            return;
        }
        new Uniforme(a,b,n);
    }
    
    private static void DPoisson(){
        Scanner scan = new Scanner(System.in);
        int lambda;
        try{
            System.out.println("Ingrese El valor de λ");
            lambda = scan.nextInt();
        }catch(Exception e){
            System.out.println("Error");
            return;
        }
        new Poisson(lambda).print();
    }
}
