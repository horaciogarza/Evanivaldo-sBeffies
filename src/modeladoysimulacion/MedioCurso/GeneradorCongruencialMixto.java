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
     * Xn1 = Semilla generada
     * a = Constante Multiplicativa
     * X0 = Semilla Inicial
     * C = cte. Aditiva
     * Mod = Función obtenida del residuo de una división
     * m = modulo (divisor constante)
     */
    
    int xn1, a, x0, c, m;
    int n; //iteraciones
    boolean isTrustable;
    double partDivided;
    Fraction currentFraction, lastFraction, auxFraction;
    double rectNumb;
    int initialX0;
    
    /**
     * Gives the first parameters
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
        
    }
    
    /**
     * Initial
     */
    public void makeThisHappen(){
        
        initialX0 = x0;
        
        for (int i = n; i <= m; i++, n++) {
            
          currentFraction = new Fraction((a*x0+c)%m , m);
          xn1 = currentFraction.getNumerator();
          rectNumb = currentFraction.evaluate();
          x0 = xn1;
          
          if (xn1 == initialX0 && i != m) { 
              break; 
          }
          
        }
        
        if (xn1 == initialX0 && n ==  (m+1)) {
            isTrustable = true;
        }
        
        if (isTrustable) {
            
            System.out.println("Generador Congruencial Mixto confiable");
            
        }
        else{
            System.out.println("Generador Congruencial Mixto no confiable");
        }
        
    }
    
    
    
    
    
    
}
