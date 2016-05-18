
import java.util.Map;

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
    private Map<double, double> coords;
    
    //Constructor
    public Series(double[] numRect, int numRectSize, int a, int n){
        
        this.numRect = numRect;
        this.numRectSize = numRectSize;
        this.a = a;
        this.n = n;
        
        
    }

    public void letsStartThis(){
        
        
        for (int i = 0; i < numRect.length; i++) {
            
            coords[i][0] = numRect[i]; 
        }
        
        for (int i = 0; i < numRect.length-1; i++) {
            
        }
    }
    // Getters and Setters
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
    
     
    
}
