/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeladoysimulacion.MedioCurso;

import ownUtils.*;

/**
 *
 * @author hgx95
 */
public class GeneradorCongruencialMixto {

    /**
     * Xn1 = Semilla generada a = Constante Multiplicativa X0 = Semilla Inicial
     * C = cte. Aditiva Mod = Función obtenida del residuo de una división m =
     * modulo (divisor constante)
     */
    int xn1, a, x0, c, m;
    int n; //iteraciones
    boolean isTrustable;
    double partDivided;
    Fraction currentFraction, lastFraction, auxFraction;
    double rectNumb;
    int initialX0;
    String[][] resultsToPrint;

    /**
     * Gives the first parameters
     *
     * @param a
     * @param x0
     * @param c
     * @param m
     */
    public GeneradorCongruencialMixto(int a, int x0, int c, int m) {
        this.a = a;
        this.x0 = x0;
        this.c = c;
        this.m = m;
        this.isTrustable = false;
        this.rectNumb = 0.0;
        this.n = 1;
        this.resultsToPrint = null;

    }

    /**
     * Initial
     */
    public void makeThisHappen() {

        initialX0 = x0;

        for (int i = n; i <= m; i++, n++) {

            currentFraction = new Fraction((a * x0 + c) % m, m);
            xn1 = currentFraction.getNumerator();
            rectNumb = currentFraction.evaluate();
            x0 = xn1;

            setValuesOnArray(i, m, ((Integer) n).toString(), ((Integer) x0).toString(), currentFraction.toString(), ((Integer) xn1).toString(), ((Double) rectNumb).toString());

            if (xn1 == initialX0 && i != m) {
                break;
            }

        }

        if (xn1 == initialX0 && n == (m + 1)) {
            isTrustable = true;
        }

        if (isTrustable) {

            System.out.println("Generador Congruencial Mixto confiable");

        } else {
            System.out.println("Generador Congruencial Mixto no confiable");
        }

    }

    public String letsPrintThisShit() {
        String returningTheArray = "";
        returningTheArray = "n\tx0\txn+1\t#Rect";

        for (String[] s : resultsToPrint) {
            returningTheArray += "\n";
            for(String s2 : s){
                returningTheArray += s2 + "\t";
            }

        }
        return returningTheArray;
    }

    private void setValuesOnArray(int i, int m, String n, String x0, String currentFraction, String xn1, String rectNumb) {
        if (resultsToPrint != null) {
            for (int j = 0; j < 5; j++) {

                switch (j) {
                    case 0:
                        resultsToPrint[i][j] = n;
                        break;
                    case 1:
                        resultsToPrint[i][j] = x0;
                        break;
                    case 2:
                        resultsToPrint[i][j] = currentFraction;
                        break;
                    case 3:
                        resultsToPrint[i][j] = xn1;
                        break;
                    case 4:
                        resultsToPrint[i][j] = rectNumb;
                        break;
                }

            }
        } else {
            resultsToPrint = new String[5][m];
            for (int j = 0; j < 5; j++) {

                switch (j) {
                    case 0:
                        resultsToPrint[i][j] = n;
                        break;
                    case 1:
                        resultsToPrint[i][j] = x0;
                        break;
                    case 2:
                        resultsToPrint[i][j] = currentFraction;
                        break;
                    case 3:
                        resultsToPrint[i][j] = xn1;
                        break;
                    case 4:
                        resultsToPrint[i][j] = rectNumb;
                        break;
                }

            }
        }

    }

}
