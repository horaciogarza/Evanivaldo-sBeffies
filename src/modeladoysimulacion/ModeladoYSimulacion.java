package modeladoysimulacion;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;
import modeladoysimulacion.MedioCurso.Distribuciones.Exponencial;
import modeladoysimulacion.MedioCurso.Distribuciones.Poisson;
import modeladoysimulacion.MedioCurso.Distribuciones.Uniforme;
import modeladoysimulacion.MedioCurso.GCMult;
import modeladoysimulacion.MedioCurso.GRandom;
import modeladoysimulacion.MedioCurso.GeneradorCongruencialMixto;

import modeladoysimulacion.MedioCurso.Pruebas.*;


public class ModeladoYSimulacion {

    public static void main(String[] args) {
        char sel = '0', bi = 0;
        char cont;

        Scanner scan = new Scanner(System.in);
        do{
            do{
            bi = 0;
            System.out.println("Que tipo de generador deseas:\n(Presione el num que desea y de enter)\n"
                + "A.Generador Congruencial Mixto\n" + "B.Generador Congruencial Multiplicativo\n"
                + "C.Generador Alternativo(propio)\n" + "D.Prueba Estadisitcas\n"+"E.Prueba de Kolmogorov-Smirnov\n"
                + "F.Prueba de Frecuencias\n" + "G.Series\n" + "H.Distribucion Exponencial\n"
                + "I.Distribucion Uniforme\n" + "J.Distribucion de Poisson" + "\nK. Moneda");
            sel = scan.next().charAt(0);
        
            
            switch(sel){
            case 'A':
                GCMix();
                break;
            case 'B':
                GCMult();
                break;
            case 'C':
                GRndm();
                break;
            case 'D':
                PEstadistica();
                break;
            case 'E':
                PKolomogorov();
                break;
            case 'F':
                PFrecuencias();
                break;
            case 'G':
                Series();
                break;
            case 'H':
                DExponencial();
                break;
            case 'I':
                DUniforme();
                break;
            case 'J':
                DPoisson();
                break;
            case 'K':
                Moneda();
                break;
            case 'a':
                GCMix();
                break;
            case 'b':
                GCMult();
                break;
            case 'c':
                GRndm();
                break;
            case 'd':
                PEstadistica();
                break;
            case 'e':
                PKolomogorov();
                break;
            case 'f':
                PFrecuencias();
                break;
            case 'g':
                Series();
                break;
            case 'h':
                DExponencial();
                break;
            case 'i':
                DUniforme();
                break;
            case 'j':
                DPoisson();
                break;
            case 'k':
                Moneda();
                break;
            default:
                System.out.println("Opcion no valda.");
                bi = 1;
        }}while(bi == 1);
        
            System.out.println("Deseas generar de nuevo?\n1.Si\n2.No");

            cont = scan.next().charAt(0);

        } while (cont == '1');

    }

    private static void GCMix() {
        Scanner scan = new Scanner(System.in);
        try {
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
            System.out.println(mix1.letsPrintThisShit());
        } catch (Exception e) {
            System.out.println("Error" + e);
            return;
        }

    }

    private static void GCMult() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.print("Ingresa A: ");
            int a = scan.nextInt();
            System.out.print("Ingresa X0: ");
            int x = scan.nextInt();
            System.out.print("Ingresa M: ");
            int m = scan.nextInt();
            new GCMult(a, x, m).init();
        } catch (Exception e) {
            System.out.println("Error");
            return;
        }

    }

    private static void GRndm() {
        Scanner scan = new Scanner(System.in);
        int size;
        System.out.println("¿Cuántos numeros desea generar?(Tecleé el numero y presione enter)");
        try {
            size = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Error");
            return;
        }
        GRandom rA = new GRandom();
        double[] rndL = rA.getRndL(size);
        for (int i = 1; i < size + 1; i++) {
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

    private static void Series() {
        Series serie = new Series();
        Scanner lec = new Scanner(System.in);
        try {
            System.out.println("a: ");
            serie.setA(lec.nextInt());
            
            System.out.println("n: ");
            serie.setN(lec.nextInt());
            
            serie = new Series(10, serie.getA(), serie.getN());
            serie.letsStartThis();
        } catch (Exception e) {
            System.out.println("Error");
            
        }
    }
    
    private static void Moneda(){
        System.out.println("Abriendo Problema de la Moneda en su Navegador Predeterminado");
        try{
            URL url = (new java.io.File("src/modeladoysimulacion/Moneda/moneda.html")).toURI().toURL();
            URI uri = url.toURI();
            if(Desktop.isDesktopSupported()){
                Desktop.getDesktop().browse(uri);
            }
        }catch(URISyntaxException | IOException e){
            System.out.println(e);
            System.out.println("Error");
        }
    }
    
}
