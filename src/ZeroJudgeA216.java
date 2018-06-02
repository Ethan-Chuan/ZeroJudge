
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA216 {
    static final int MAX_INT = 30000+1;
    static long[] fn = new long[MAX_INT];
    static long[] gn = new long[MAX_INT];
    
    public static void main(String[] args) {
        allLove();
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            System.out.println(fn[n] + " " + gn[n]);
        }
    }
    
    /**
     * Dynamic programming
     */
    static void allLove(){
        fn[1] = 1;
        gn[1] = 1;
        for(int i=2;i<MAX_INT;i++){
            fn[i] = i + fn[i-1];
            gn[i] = fn[i] + gn[i-1];
        }
    }
}

/*
    數數是班上聰明又漂亮的女生，有一天……，她愛上了明明。
    她對明明說：「我們的愛，若是錯誤，願你我沒有白白受苦。呃，不是，我們的愛就像是函數！」
    明明說，「是啊，我對妳的愛是與日俱增呢！」
    數數開心地說，「你的意思是，你在第 n 天對我的愛若用函數 f(n) 來描述，那麼，
    f(n) = n + f(n-1)。也就是說，每一天都比前一天多了一單位的愛，並且與舊的愛累積起來嗎？」
    明明點了點頭，然後問，「那麼，妳呢？」
    數數說，「我在第 n 天對你的愛若是 g(n)，則會滿足 g(n) = f(n) + g(n-1) 關係！」
    於是，明明笑了笑，摟著數數說，我一定會更加愛妳的！
    註：在第一天的時候，f(1) = g(1) = 1。 
--------------------------------------------------------------------------------
輸入說明
    輸入以 EOF 結束。每一筆測試資料有一個數字 n，其中 n > 0。 
    此外，50% 的測資 n <= 500；80% 的測資，n <= 3000；全部的測資 n <= 30000。 
範例輸入
    1
    2
    3
    5
    8
    13
--------------------------------------------------------------------------------
輸出說明
    輸出 f(n) 與 g(n)。
範例輸出
    1 1
    3 4
    6 10
    15 35
    36 120
    91 455
*/