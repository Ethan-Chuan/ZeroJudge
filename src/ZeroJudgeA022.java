
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
