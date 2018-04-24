
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA005 {
    public static void main(String[] args){
        int t, num = 4;
        int[] terms = new int[num];
        Scanner scanner = new Scanner(System.in);
        int ans;
        
        /*
        * 等差數列 (A.P.) arithmetic progression
        * 等差級數 (A.S.) arithmetic series
        * 等比數列 (G.P.) geometric progression
        * 等比級數 (G.S.) geometric series
        */
        t = scanner.nextInt();
        for(int i=0;i<t;i++){
            int j;
            for(j=0;j<num;j++){
                terms[j] = scanner.nextInt();
                System.out.print(terms[j] + " ");
            }
            
            // If its difference  is the same, 
            // then it is a arithmetic progression.
            // Otherwise, it is a geometric progression.
            ans = terms[1] - terms[0];
            for(j=2;j<num && terms[j]==terms[j-1]+ans;j++);
            if(j==num){
                // A.P.
                ans = terms[num-1] + ans;
            }else{
                // G.P.
                ans = terms[num-1] * (terms[num-1] / terms[num-2]);
            }
            
            System.out.println(ans);
        }
        
    }
    
}
