
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
/*
* 1st circle there is 2 parts.
* Adding another circle, the max number of intersection is 2.
* Every intersection extra adding one part.
* So, 2 circle there is 2+2=4 parts.
* 3 circle there is 2+2+4=8 parts.
* n circle there is 2 + 2 + 4 + ... + 2*(n-1) = n^2 - n + 2 parts.
*/
public class ZeroJudgeA042 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            int x = scanner.nextInt();
            System.out.println(x*x - x + 2);
        }
    }
    
}
