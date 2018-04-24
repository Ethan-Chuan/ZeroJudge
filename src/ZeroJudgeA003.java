
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA003 {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            int m = scanner.nextInt();
            int d = scanner.nextInt();
            int s = (m*2+d)%3;
            String ans = "";
            switch(s){
                case 0:
                    ans = "普通";
                    break;
                case 1:
                    ans = "吉";
                    break;
                case 2:
                    ans = "大吉";
                    break;
            }
            System.out.println(ans);
        }
    }
}
