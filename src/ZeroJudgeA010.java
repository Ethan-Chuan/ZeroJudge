
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA010 {
    static final int MAX_INT = 1000000;
    static int lenPrime;
    static int[] prime;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        generatePrime();
        /*System.out.println(lenPrime);
        for(int i=0; i<lenPrime; i++){
            System.out.print(prime[i] + ",  ");
            if((i+1)%10==0)
                System.out.println();
        }*/
        
        while(scanner.hasNext()){
            primeFactorization(scanner.nextInt());
        }
    }
    
    /*
    * lenPrime is an approximate number of all prime when sqrt is greater than 598.
    */
    static void generatePrime(){
        int sqrt = 1 + (int)Math.sqrt(MAX_INT);
        lenPrime =1 + (int) ( ( sqrt / Math.log1p(sqrt ) ) *  ( 1 + 1.2762 / Math.log1p(sqrt) ));
        prime = new int[lenPrime];
        //System.out.println(lenPrime);
        prime[0] = 2;
        prime[1] = 3;
        int count= 2;
        for(int i=5; i<sqrt; i = i + 6){
            int pos;
            // 6k-1
            for(pos=0; pos<count && i%prime[pos]!=0; pos++);
            if(pos==count){
                prime[count] = i;
                count++;
            }
            // 6k+1
            for(pos=0; pos<count && (i+2)%prime[pos]!=0; pos++);
            if(pos==count){
                prime[count] = i+2;
                count++;
            }
        }
        lenPrime = count;
    }
    
    static void primeFactorization(int x){
        String ret = "";
        for(int i=0;i<lenPrime;i++){
            int count = 0;
            while(x%prime[i]==0){
                x /= prime[i];
                count++;
            }
            if(count>0){
                ret += " * " + prime[i];
                if(count>1)
                    ret += "^" + count;
            }
        }
        if(x!=1){
            ret += " * " + x;
        }
        System.out.println(ret.substring(3));
    }
}
