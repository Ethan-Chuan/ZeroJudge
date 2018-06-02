
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA224 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            char[] arrChr = scanner.next().toUpperCase().toCharArray();
            int[] countLetter = new int[26];
            int len = counter(arrChr, countLetter);
            System.out.println(isPalindrome(countLetter, (len&1)==1)?"yes !":"no...");
        }
    }
    
    static int counter(char[] arrChr, int[] countLetter){
        int ret = 0;
        int base = (int)'A';
        for(int i=0; i<arrChr.length; i++){
            if(arrChr[i] >= base && arrChr[i] <= base+25){
                countLetter[arrChr[i]-base]++;
                ret++;
            }
        }
        return ret;
    }
    
    static boolean isPalindrome(int[] countLetter, boolean isOdd){
        int count = 0;
        for(int i=0; i<countLetter.length; i++){
            if((countLetter[i]&1)==1)
                count++;
            if(count>1)
                return false;
        }
        return (isOdd && count==1) || (!isOdd && count==0);
    }
}

/*
    一看題名，你就該知道，這次跟迴文脫不了關係！
    若你不確定什麼是「迴文」，請看 Google 字典的解釋：

    迴文 huíwén

    一種修辭方式。
    通過詞語反復迴環使用，表達二者互相依存或彼此制約的關係，
    如“人人為我，我為人人”、“饒人不癡漢，癡漢不饒人”。
--------------------------------------------------------------------------------
輸入說明
    一筆測試資料一行，包含許許多多但總數不超過 1000 個的大小寫英文字母和標點符號。
    不可思議的是，裡面不會有任何空白字元。
範例輸入
    ababa
    bbaaa
    Level
    aaabbbcc
    abcdefg
    HowAreYouToday
    A_man,_a_plan,_a_canal:_Panama.
--------------------------------------------------------------------------------
輸出說明
    如果重新安排順序後，有辦法讓這一堆英文字母變成迴文的話，輸出「yes !」，否則輸出「no...」。
    注意，大寫和小寫字母視為相同，即 A 和 a 是一樣的，並且，請忽視所有非英文字母的字元。
範例輸出
    yes !
    yes !
    yes !
    no...
    no...
    no...
    yes !
*/