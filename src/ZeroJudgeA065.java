
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
