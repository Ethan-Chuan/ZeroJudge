
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
