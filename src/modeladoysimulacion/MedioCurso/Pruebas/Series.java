package modeladoysimulacion.MedioCurso.Pruebas;

import java.util.Scanner;
import modeladoysimulacion.MedioCurso.GRandom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author horaciogarza
 */
public class Series {
    
    //Variables
    private double[] numRect;
    private int numRectSize;
    private int a;
    private int n;
    private double Fe;
    private double Fo;
    private double[][] coords;
    private int quadrA;
    private int quadrB;
    private int quadrC;
    private int quadrD;
    private float alpha = 0;
    private double result;
    //private Map<double, double> coords;

    public Series() {
        
    }
    
    
    //Constructor
    public Series(int size, int a, int n){
        this.numRect = GRandom.getRndL(size);
        this.numRectSize = size;
        this.a = a;
        this.n = n;
    }
    
    
    public void letsStartThis(){
        
        calculateFe();
        setCoords();
        checkCoordsInCart();
        
        double results = ((Math.pow((double) n, 2))/(numRect.length));
        results *= (Math.pow(quadrA - Fe,2) + Math.pow(quadrB-Fe, 2) + Math.pow(quadrC - Fe,2) + Math.pow(quadrD-Fe, 2));
        
        result = results;
        
        
        do{
            try{
                Scanner lec = new Scanner(System.in);
                
                System.out.println("\nDame el valor a comparar: ");
                alpha = lec.nextFloat();
                
            }catch(Exception ex){
                
                System.out.println("Error, vuelve a insertar");
            }
        }
        while(alpha == 0);
        
        
        printArray();       
        System.out.println("\n");
        System.out.println(results);
        System.out.println("\n");
        checkIfAccepted();
    }
    // Getters and Settersty
    public double[] getNumRect() {
        return numRect;
    }

    public void setNumRect(double[] numRect) {
        this.numRect = numRect;
    }

    public int getNumRectSize() {
        return numRectSize;
    }

    public void setNumRectSize(int numRectSize) {
        this.numRectSize = numRectSize;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    private void calculateFe() {
        Fe = (((double)numRectSize)-1.0)/((double)Math.pow(n, 2));
    }

    private void setCoords() {
        coords = new double[numRectSize-1][2];
        
        for (int i = 0; i < numRect.length-1; i++) {
            coords[i][0] = numRect[i];
        }
        
        for (int i = 0; i < numRect.length-1; i++) {
            coords[i][1] = numRect[i+1];
        }
        
        
    }

    private void checkCoordsInCart() {

        for(double[] d : coords){
            boolean flag = true;
            boolean maybeA = false;
            for(double dInside : d){
                if (flag) {
                    maybeA = dInside < 0.5;
                    flag = false;
                }else{
                    if (maybeA) {
                        if (dInside < 0.5) {
                            quadrA++;
                        }else{
                            quadrC++;
                        }
                    }else{
                        if (dInside < 0.5) {
                            quadrB++;
                        }else{
                            quadrD++;
                        }
                    }
                    
                }
            }
        }
    }

    private void printArray() {
        for(double[] d : coords){
            for (double dInside : d) {
                System.out.print(dInside + " ");
            }
            System.out.print("\n");
        }
    }

    private void checkIfAccepted() {
        if (result < alpha) {
            System.out.println("Los Numeros son Aceptados");
        }else{
            System.out.println("Los Numeros no son aceptados");
        }
    }
    
     
    
}
