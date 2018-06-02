
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

/*
    對任意正整數n，平面上的n 個圓最多可將平面切成幾個區域？
    三個圓，區域數為8
    四個圓，區域數為14
--------------------------------------------------------------------------------
範例輸入
    3
    4
--------------------------------------------------------------------------------
範例輸出
    8
    14
*/