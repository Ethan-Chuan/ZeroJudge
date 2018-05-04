
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA216 {
    static final int MAX_INT = 30000+1;
    static long[] fn = new long[MAX_INT];
    static long[] gn = new long[MAX_INT];
    
    public static void main(String[] args) {
        allLove();
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            System.out.println(fn[n] + " " + gn[n]);
        }
    }
    
    /**
     * Dynamic programming
     */
    static void allLove(){
        fn[1] = 1;
        gn[1] = 1;
        for(int i=2;i<MAX_INT;i++){
            fn[i] = i + fn[i-1];
            gn[i] = fn[i] + gn[i-1];
        }
    }
}
