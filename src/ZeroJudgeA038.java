
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA038{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            String str = scanner.next();
            String revStr = reverse(str);
            int beginIndex = firstNonZero(revStr);
            if(beginIndex==revStr.length())
                System.out.println("0");
            else
                System.out.println(revStr.substring(beginIndex));
        }
    }
    
    static String reverse(String str){
        int len = str.length();
        char[] ret = new char[len];
        
        for(int i=0;i<len;i++){
            ret[i] = str.charAt(len - 1 - i);
        }
        
        return new String(ret);
    }
    
    static int firstNonZero(String str){
        char[] arrChr = str.toCharArray();
        int ret;
        for(ret=0; ret<str.length() && arrChr[ret]=='0'; ret++);
        return ret;
    }
}

/*
    輸入任意數字，並將其數字全部倒轉
--------------------------------------------------------------------------------
輸入說明
    輸入包含一個整數，不超過 2^31
範例輸入
    12345
--------------------------------------------------------------------------------
輸出說明
    輸出翻轉過後的數字
範例輸出
    54321
*/
