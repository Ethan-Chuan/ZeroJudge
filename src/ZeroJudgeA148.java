
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA148 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int sum = 0;
            for(int i=0;i<n;i++)
                sum += scanner.nextInt();
            System.out.println((sum > 59*n) ? "no" : "yes");
        }
    }
    
}
