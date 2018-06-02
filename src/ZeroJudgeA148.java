
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

/*
    你考了 n 科筆試題目，每科的滿分都是 100 分。老師說，如果平均大於 59 你就過關了。
--------------------------------------------------------------------------------
輸入說明
    輸入第一行為一個數字 n，接著有 n 個正整數。
範例輸入
    1 60
    3 0 80 75
    5 61 61 61 61 55
--------------------------------------------------------------------------------
輸出說明
    若你被當了，請輸出「yes」，否則輸出「no」。
範例輸出
    no
    yes
    no
*/