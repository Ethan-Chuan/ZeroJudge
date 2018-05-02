
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA053 {
    public static void main(String[] args) {
        int[] stepNumQ = new int[]{40, 20, 10, -1};
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int ret, i;
            for(i=0; i<4  && n<=stepNumQ[i]; i++);
            switch(i){
                case 0:
                    ret = 100;
                    break;
                case 1:
                    ret = 80;
                    ret += (n-stepNumQ[i])*1;
                    break;
                case 2:
                    ret = 60;
                    ret += (n-stepNumQ[i])*2;
                    break;
                case 3:
                    ret = n*6;
                    break;
                default:
                    ret = 0;
            }
            System.out.println(ret);
        }
    }
    
}
