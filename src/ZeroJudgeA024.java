
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA024 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(gcd(x, y));
        }
    }
    
    static int gcd(int x, int y){
        int ret = 0;
        int q,r;
        if(x<y){
            int tmp = x;
            x = y;
            y = tmp;
        }
        do{
            q = x / y;
            r = x % y;
            ret = y;
            x = y;
            y = r;
        }while(r>0);
        
        return ret;
    }
    
}
