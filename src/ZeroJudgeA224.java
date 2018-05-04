
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
