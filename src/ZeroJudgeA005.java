
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

/*
　　Eva的家庭作業裏有很多數列填空練習。填空練習的要求是：已知數列的前四項，填出第五項。因
為已經知道這些數列只可能是等差或等比數列，她決定寫一個程式來完成這些練習。
--------------------------------------------------------------------------------
輸入說明
    第一行是數列的數目t（0 <= t <= 20）。 以下每行均包含四個整數，表示數列的前四項。 
約定數列的前五項均為不大於105的自然數，等比數列的比值也是自然數。

範例輸入
    2
    1 2 3 4
    1 2 4 8
--------------------------------------------------------------------------------
輸出說明
    對輸入的每個數列，輸出它的前五項。
範例輸出
    1 2 3 4 5
    1 2 4 8 16
*/