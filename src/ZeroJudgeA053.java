
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA053 {
    public static void main(String[] args) {
        int[] stepScore = new int[]{0, 1, 2, 6, 0};
        int[] baseScore = new int[]{100, 80, 60, 0, 0};
        int[] stepNumQ = new int[]{40, 20, 10, 0, 0};
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int ret, i;
            for(i=0; i<4  && n<=stepNumQ[i]; i++);
            ret = baseScore[i] + stepScore[i]*(n-stepNumQ[i]);
            System.out.println(ret);
        }
    }
    
}
