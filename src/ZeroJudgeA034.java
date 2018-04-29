
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA034 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            int a = scanner.nextInt();
            System.out.println(Integer.toBinaryString(a));
        }
    }
    
}
