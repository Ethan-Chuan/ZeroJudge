
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA065 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext())
            System.out.println(wenWenPassword(scanner.next()));
    }
    
    static String wenWenPassword(String str){
        char[] ret = new char[6];
        
        for(int i=0;i<6;i++){
            ret[i] = (char)(Math.abs(str.charAt(i+1) - str.charAt(i)) + '0');
        }
        
        return String.valueOf(ret);
    }
}

/*
    文文記性不太好，常常會忘東忘西。他也常忘記提款卡密碼，每次忘記密碼都得帶著身份證、存摺、印章
    親自到銀行去重設密碼，還得繳交 50 元的手續費，很是麻煩。後來他決定把密碼寫在提款卡上免得忘記，
    但是這樣一來，萬一提款卡掉了，存款就會被盜領。因此他決定以一個只有他看得懂的方式把密碼寫下來。

    他的密碼有 6 位數，所以他寫下了 7 個大寫字母，相鄰的每兩個字母間的「距離」就依序代表密碼中的
    一位數。所謂「距離」指的是從較「小」的字母要數幾個字母才能數到較「大」字母。字母的大小則是依其
    順序而定，越後面的字母越「大」。

    假設文文所寫的 7 個字母是 POKEMON，那麼密碼的第一位數就是字母 P 和 O 的「距離」，由於 P 
    就是 O 的下一個字母，因此，從 O 開始只要往下數一個字母就是 P 了，所以密碼的第一位數就是 1。
    密碼的第二位數則是字母 O 和 K 的「距離」，從 K 開始，往下數 4 個字母 (L, M, N, O) 
    就到了 O，所以第二位數是 4，以此類推。因此，POKEMON 所代表的密碼便是 146821。

    噓！你千萬別把這個密秘告訴別人哦，要不然文文的存款就不保了。
--------------------------------------------------------------------------------
輸入說明
    輸入有若干筆測試資料，每筆一行，每行有 7 個相連的大寫英文字母。
範例輸入
    POKEMON
    TYPHOON
--------------------------------------------------------------------------------
輸出說明
    對於每筆測試資料，輸出它所代表的密碼。
範例輸出
    146821
    598701
*/