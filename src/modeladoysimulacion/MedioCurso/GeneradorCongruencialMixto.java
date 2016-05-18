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
        
        resultsToPrint = new String[this.m][5];

    }

    /**
     * Initial
     */
    public void makeThisHappen() {

        initialX0 = x0;

        for (int i = n; i <= m; i++, n++) {

            System.out.println(x0);
            currentFraction = new Fraction((a * x0 + c) % m, m);
            xn1 = currentFraction.getNumerator();
            rectNumb = currentFraction.evaluate();
            String fractionAdded = ((Integer) ((a * x0 + c)/ m)).toString();
            
            System.out.println("sad " + x0);

            
            setValuesOnArray(i, m, ((Integer) n).toString(), ((Integer) x0).toString(), fractionAdded + " " + currentFraction.toString(), ((Integer) xn1).toString(), ((Double) rectNumb).toString());
            x0 = xn1;
            

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
        returningTheArray = "n\tx0\t(ax0+c)modm\txn+1\t#Rect";
        boolean breakOrWhat = false;
        for (String[] s : resultsToPrint) {
            returningTheArray += "\n";
            int ajax = 0;
            for(String s2 : s){
                if (s2 == null) {
                   breakOrWhat = true;
                   break;
                   
                }
                returningTheArray += s2 + "\t";
                if (ajax == 2) {
                    returningTheArray += "\t";
                    
                }
                
                ajax++;
            }
            if (breakOrWhat) {
                break;
            }

        }
        returningTheArray += "\n\n" + (isTrustable? "Generador Congruencial Mixto Confiable" : "Generador Congruencial Mixto No Confiable");
        return returningTheArray;
    }

    private void setValuesOnArray(int i, int m, String n, String x0, String currentFraction, String xn1, String rectNumb) {
        if (resultsToPrint != null) {
            int aux = --i;
            for (int j = 0; j < 5; j++) {

                switch (j) {
                    case 0:
                        resultsToPrint[aux][j] = n;
                        break;
                    case 1:
                        resultsToPrint[aux][j] = x0;
                        break;
                    case 2:
                        resultsToPrint[aux][j] = currentFraction;
                        break;
                    case 3:
                        resultsToPrint[aux][j] = xn1;
                        break;
                    case 4:
                        resultsToPrint[aux][j] = rectNumb;
                        break;
                }

            }
        } else {
            resultsToPrint = new String[5][m];
            for (int j = 0; j < 5; j++) {
                int aux = --i;
                switch (j) {
                    case 0:
                        resultsToPrint[aux][j] = n;
                        break;
                    case 1:
                        resultsToPrint[aux][j] = x0;
                        break;
                    case 2:
                        resultsToPrint[aux][j] = currentFraction;
                        break;
                    case 3:
                        resultsToPrint[aux][j] = xn1;
                        break;
                    case 4:
                        resultsToPrint[aux][j] = rectNumb;
                        break;
                }

            }
        }

    }

}
