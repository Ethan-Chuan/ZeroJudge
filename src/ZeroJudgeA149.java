
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA149 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        for(int i=0;i<t;i++){
            System.out.println(multiplyAllDigit(scanner.nextInt()));
        }
    }
    
    static int multiplyAllDigit(int x){
        int ret = 1;
        int q = x;
        while(q>0){
            int r = q % 10;
            q /= 10;
            ret *= r;
        }
        return x==0 ? 0 : ret;
    }
}
