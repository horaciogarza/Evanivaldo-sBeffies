package modeladoysimulacion.MedioCurso.Pruebas;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
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
    private double alpha;
    private double results;
    private double result;
    private int size;

    private int[][] quadrCoords;

    public Series() {

    }

    //Constructor
    public Series(int size, int n, double alpha) {
        this.numRect = GRandom.getRndL(size);
        this.numRectSize = size;
        this.n = n;
        this.quadrCoords = new int[n][n];
        this.alpha = alpha;
    }

    public void calculateResults() {
        this.result = ((Math.pow((double) n, 2)) / (numRect.length));
        double result2 = 0.0;

        for (int[] a : quadrCoords) {
            for (int b : a) {
                result2 += Math.pow(((double) b) - Fe, 2);
            }
        }
        result *= result2;
    }

    public void calculateFe() {
        Fe = (((double) numRectSize) - 1.0) / ((double) Math.pow(n, 2));
    }

    public void setCoords() {
        coords = new double[numRectSize - 1][2];

        for (int i = 0; i < numRect.length - 1; i++) {
            coords[i][0] = numRect[i];
        }
        for (int i = 0; i < numRect.length - 1; i++) {
            coords[i][1] = numRect[i + 1];
        }
    }

    public void checkCoordsInCart() {

        int quadrCoordsNumber = 0;
        double valuePerSquare = 1 / ((double) this.n);
        double valueInside = 0;
        boolean accepted = false;
        double[] y = new double[n + 1];
        double[] x = new double[n + 1];

        for (int i = 0; i < n + 1; i++) {
            x[i] = valueInside;
            y[i] = valueInside;
            valueInside += valuePerSquare;
        }

        /*  
         G   H   I
         D   E   F
         A   B   C
         */
        for (double[] a : coords) {
            int valueInX = 0;
            int valueInY = 0;
            for (int i = 0; i < x.length - 1; i++) {
                if (a[0] >= x[i] && a[0] <= x[i + 1]) {
                    valueInX = i;
                    break;
                }
            }
            for (int i = 0; i < y.length - 1; i++) {
                if (a[1] >= y[i] && a[1] <= y[i + 1]) {
                    valueInY = i;
                    break;
                }
            }

            this.quadrCoords[valueInY][valueInX] = this.quadrCoords[valueInY][valueInX] + 1;

        }

    }

    public void printArray() {
        System.out.println("\n\nCoordenadas:\n");
        for (double[] d : coords) {

            System.out.print("\t");

            for (double dInside : d) {
                System.out.print(dInside + " ");
            }
            System.out.print("\n");
        }
    }

    public void checkIfAccepted() {
        if (result < this.alpha) {
            System.out.println("\n\t" + this.result + " < " + this.alpha + "\n\tPor lo tanto, los Numeros son Aceptados");
        } else {
            System.out.println("\n\t" + this.result + " > " + this.alpha + "\n\tLos Numeros no son aceptados");
        }
    }

    public void printRectNumbers() {
        System.out.println("\n\nNumeros rectangulares generados:\n");
        for (double a : numRect) {
            System.out.println("\t" + a);
        }
    }

    public void printQuadrs() {
        System.out.println("Cuadrantes: \n");

        int characterToPrint = 65;
        String[] quadrsToPrintFinal = new String[n];
        int[][] reversedArray = reverseArray(quadrCoords);
        for (int[] a : quadrCoords) {
            for (int j = 0; j < a.length; j++) {
                char prints = (char) characterToPrint;
                System.out.print("\t" + prints + ": " + a[j] + "\t");
                characterToPrint++;
            }
            System.out.println("\n");
        }
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

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private int[][] reverseArray(int[][] quadrCoords) {
        int[][] reversed = new int[n][n];
        
        for (int i = n; i > n; i--) {
            for (int[] a : quadrCoords) {
                for (int j = 0; j < a.length; j++) {
                    reversed[i][j] = a[j];
                }
            }
        }
        
        return reversed;
    }

}
