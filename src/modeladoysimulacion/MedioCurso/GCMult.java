package modeladoysimulacion.MedioCurso;

import static java.lang.Math.pow;
import ownUtils.Fraction;

public class GCMult {
    int a, x, m, pe;

    public GCMult(int a, int x, int m) {
        this.a = a;
        this.x = x;
        this.m = m;
        init();
    }
    
    public void init(){
        pe = getPE(m);
        cal();
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
        }catch(Exception e){
            System.out.println(e);
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
                    pe = 0;
                    break;
                case 2:
                    pe = 0;
                    break;
                case 3: 
                    pe = 0;
                    break;
                case 4: 
                    pe = 0;
                    break;
                default:
                    exp -= 2;
                    pe = (int)(5*pow(10,exp));
            }
        }
        return pe;
    }
    
    private void cal(){
        int i = 1;
        int newX = x;
        do{
            newX = new line(i, newX).lineCal(a);
            i++;
        }while(x != newX || i == pe);
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
            System.out.println(n+" "+x0+" "+fun+" "+x+" "+recD);
        }
        
    }
}
