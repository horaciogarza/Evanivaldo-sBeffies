package modeladoysimulacion.MedioCurso;

import static java.lang.Math.pow;
import ownUtils.Fraction;

public class GCMult {
    int a, x, m, pe;

    public GCMult(int a, int x, int m) {
        this.a = a;
        this.x = x;
        this.m = m;
    }
    
    public void init(){
        pe = getPE(m);
        if(cal()){
            System.out.println("(Por lo tanto)Generador Confiable");
        }else{
            System.out.println("(Por lo tanto)Generador No Confiable");
        }
    }
    
    public boolean bord(int m){
        Integer m1 = m;
        String ms = m1.toString();
        char n1 = ' ';
        char n2 = ' ';
        char n3 = ' ';
        try{
            n1 = ms.charAt(0);
            n2 = ms.charAt(1);
            n3 = ms.charAt(2);
        }catch(StringIndexOutOfBoundsException e){
            //System.out.println(e);
        }
        if(n1 == '1'){
            if(n2 == '0' || n2 == ' '){
                if(n3 == '0' || n3 == ' '){
                    return true;
                }
        }
        }
        return false;
    }
    
    public int getExp(int m){
        int exp=0;
        if(m != 1){
            while(m != 1){
                m = m/10;
                exp++;
            }
        }
        return exp;
    }
    
    private int getPE(int m){
        int pe;
        if(bord(m) == false){
            pe = m/4;
        }else{
            int exp = getExp(m);
            switch(exp){
                case 1: 
                    pe = 4;
                    break;
                case 2:
                    pe = 20;
                    break;
                case 3: 
                    pe = 100;
                    break;
                case 4: 
                    pe = 500;
                    break;
                default:
                    exp -= 2;
                    pe = (int)(5*pow(10,exp));
            }
        }
        return pe;
    }
    
    private boolean cal(){
        boolean res;
        int i = 0;
        int newX = x;
        System.out.println("n \t Xo \t aXomodm \t Xn+1 \tNum. Rectangulares");
        do{
            i++;
            newX = new line(i, newX).lineCal(a);
        }while(x != newX && !(pe == i));
        if(x == newX && pe == i){
            res = true;
        }else{
            res = false;
        }
        return res;
    }
    
    
    public class line{
        int n, x0, x, funint;
        double recD;
        String fun;
        Fraction recF;

        public line(int n, int x0) {
            this.n = n;
            this.x0 = x0;
        }
        
        private int lineCal(int a){
            this.x =(a*x0)%m;
            this.funint = (a * x0) / m;
            this.fun = funint +"+"+x+"/"+m;
            this.recD = (double)x/m;
            print();
            return x;
        }
        
        public void print(){
            System.out.println(n+"\t "+x0+"\t "+fun+"\t "+x+"\t "+recD);
        }
        
    }
}
