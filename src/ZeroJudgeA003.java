
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

/*
兩光法師時常替人占卜，由於他算得又快有便宜，因此生意源源不絕，時常大排長龍，他想算 得更快一點，因此找了你這位電腦高手幫他用電腦來加快算命的速度。

　　他的占卜規則很簡單，規則是這樣的，輸入一個日期，然後依照下面的公式：

M=月
D=日 
S=(M*2+D)%3

得到 S 的值，再依照 S 的值從 0 到 2 分別給與 普通、吉、大吉 等三種不同的運勢
--------------------------------------------------------------------------------
輸入說明
    月份及日期
範例輸入
    1 1
    1 2
--------------------------------------------------------------------------------
輸出說明
    運勢
範例輸出
    普通
    吉
*/