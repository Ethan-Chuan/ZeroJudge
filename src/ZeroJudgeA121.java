
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA121 {
    static final int MAX_INT = 100000000;
    static int lenPrime;
    static int[] prime;
    
    public static void main(String[] args) {
        genPrime();
        //printPrime();
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext())
            System.out.println(countPrime(scanner.nextInt(), scanner.nextInt()));
    }
    
    static int countPrime(int a, int b){
        int ret = 0;
        
        if(b<=prime[lenPrime-1]){
            int begin, end;
            for(begin=0; begin<lenPrime && prime[begin]<a; begin++);
            for(end=0; end<lenPrime && prime[end]<=b; end++);
            ret = end - begin;
        }else if(a<=prime[lenPrime-1]){
            int begin;
            for(begin=lenPrime-1; begin>0 && prime[begin]>=a; begin--);
            ret = lenPrime - begin - 1;
            ret += isPrime(prime[lenPrime-1]+2, b);
        }else{
            ret = isPrime(a, b);
        }
        
        return ret;
    }
    
    static int isPrime(int a, int b){
        int ret = 0;
        
        for(int i=a;i<=b;i++){
            int sqrtNum = 1 + (int)Math.sqrt(i);
            int j;
            for(j=0; j<lenPrime && prime[j]<=sqrtNum && i%prime[j]!=0; j++);
            if(j==lenPrime || prime[j]>sqrtNum)
                ret++;
        }
        
        return ret;
    }
    
    static void genPrime(){
        int sqrtNum = 1 + (int)Math.sqrt(MAX_INT);
        lenPrime = 1 + (int) ( ( sqrtNum / Math.log1p(sqrtNum ) ) *  ( 1 + 1.2762 / Math.log1p(sqrtNum) ));
        prime = new int[lenPrime];
        prime[0] = 2;
        prime[1] = 3;
        int count = 2;
        for(int i=5; i<sqrtNum; i=i+6){
            int pos;
            // 6k-1
            for(pos=0; pos<count && i%prime[pos]!=0; pos++);
            if(pos==count){
                prime[count] = i;
                count++;
            }
            // 6k+2
            for(pos=0; pos<count && (i+2)%prime[pos]!=0; pos++);
            if(pos==count){
                prime[count] = i+2;
                count++;
            }
        }
        lenPrime = count;
    }
    
    static void printPrime(){
        System.out.println("lenPrime : " + lenPrime);
        for(int i=0; i<lenPrime; i++){
            System.out.print(prime[i] + ",  ");
            if((i+1)%10==0)
                System.out.println();
        }
        System.out.println();
    }
}
