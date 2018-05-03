
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA059 {
    static int[] sqrtNum = new int[32];
    
    public static void main(String[] args) {
        genSqrtNum();
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println("Case " + (i+1) + ": " + sumSqrtNum(a,b));
        }
    }
    
    static void genSqrtNum(){
        int maxInt = 1000;
        
        int end = 1 + (int)Math.sqrt(maxInt);
        for(int i=0; i<end; i++){
            sqrtNum[i] = i*i;
        }
    }
    
    static int sumSqrtNum(int a, int b){
        int ret = 0;
        int beginIndex, endIndex;
        
        for(beginIndex=0; beginIndex<sqrtNum.length && sqrtNum[beginIndex]<a; beginIndex++);
        for(endIndex=0; endIndex<sqrtNum.length && sqrtNum[endIndex]<=b; endIndex++);
        
        for(int i=beginIndex; i<endIndex; i++){
            ret += sqrtNum[i];
        }
        
        return ret;
    }
}
