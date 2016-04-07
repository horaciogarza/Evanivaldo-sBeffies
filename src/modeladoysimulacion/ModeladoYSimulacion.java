/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeladoysimulacion;

import java.util.Scanner;
import modeladoysimulacion.MedioCurso.GeneradorCongruencialMixto;

/**
 *
 * @author hgx95
 */
public class ModeladoYSimulacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        /*Scanner checkOption = new Scanner(System.in);
        System.out.println("What do you want to do?\n\n" +
                            "1. Generador Congruencial ");*/
                                    
        GeneradorCongruencialMixto mix1 = new GeneradorCongruencialMixto(5, 4, 7, 8); //Funciona
        mix1.makeThisHappen();
        
    }
    
}
