
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            String orignal = scanner.next();
            System.out.println(orignal.equals(reverse(orignal)) ? "yes" : "no");
        }
    }
    
    static String reverse(String str){
        int len = str.length();
        char[] ret = new char[len];
        
        for(int i=0;i<len;i++){
            ret[i] = str.charAt(len-i-1);
        }
        
        return new String(ret);
    }
    
}

/*
    迴文的定義為正向，反向讀到的字串均相同

    如：abba , abcba ... 等就是迴文

     請判斷一個字串是否是一個迴文？
--------------------------------------------------------------------------------
輸入說明
    一個字串(長度 < 1000)
範例輸入
    abba
    abcd
--------------------------------------------------------------------------------
輸出說明
    yes or no
範例輸出
    yes
    no
*/