
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA149 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        for(int i=0;i<t;i++){
            System.out.println(multiplyAllDigit(scanner.nextInt()));
        }
    }
    
    static int multiplyAllDigit(int x){
        int ret = 1;
        int q = x;
        while(q>0){
            int r = q % 10;
            q /= 10;
            ret *= r;
        }
        return x==0 ? 0 : ret;
    }
}

/*
    你拿到一個整數，卻忍不住想把每個位數都乘在一起。例如看到 356 就會想要知道 3 * 5 * 6 的值
    為何。快寫個程式幫幫為了乘數字而快發瘋的自己吧！
--------------------------------------------------------------------------------
輸入說明
    一開始有一個數字 T，表示共有幾組測試資料。
    接下來有 T 個數字 n (0 <= n < 2147483648)。
範例輸入
    3
    356
    123
    9999
--------------------------------------------------------------------------------
輸出說明
    輸出可以拯救自己的結果。
範例輸出
    90
    6
    6561
*/