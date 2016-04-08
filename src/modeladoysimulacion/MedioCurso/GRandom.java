package modeladoysimulacion.MedioCurso;

import java.util.Random;

public class GRandom {

    public double[] getRndL(int size) {
        double[] rndL = new double[size];
        Random rm = new Random();
        int[] iL = new int[size];
        for (int i = 0; i < size; i++) {
            iL[i] = rm.nextInt(100_000);
            rndL[i] = ((double)iL[i])/100000;
        }
        return rndL;
    }
    
    
}
