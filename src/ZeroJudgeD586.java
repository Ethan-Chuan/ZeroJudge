
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeD586 {
    static final char[] TO_LETTER = new char[]{'0',
        'm', 'j', 'q', 'h', 'o',
        'f', 'a', 'w', 'c', 'p',
        'n', 's', 'e', 'x', 'd',
        'k', 'v', 'g', 't', 'z',
        'b', 'l', 'r', 'y', 'u',
        'i'
    };
    static final int[] TO_NUMBER = new int[27];
    
    public static void main(String[] args) {
        genToNumber();
        /*
        for(int i:TO_NUMBER){
            System.out.print(i + "\t");
        }
        System.out.println();
        for(char chr='a';chr<='z';chr++){
            System.out.print(chr + "\t");
        }
        System.out.println();
        for(char chr='a';chr<='z';chr++){
            System.out.print(TO_NUMBER[chr-'a'] + "\t");
        }*/
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m;
        String firstStr;
        for(int i=0;i<n;i++){
            m = scanner.nextInt();
            firstStr = scanner.next();
            if(firstStr.length()==1 && firstStr.charAt(0)>='a' && firstStr.charAt(0)<='z'){
                int sum = TO_NUMBER[firstStr.charAt(0) - 'a' + 1] ;
                for(int j=1;j<m;j++){
                    sum += TO_NUMBER[scanner.next().charAt(0) - 'a' + 1] ;
                }
                System.out.println(sum);
            }else{
                System.out.print(TO_LETTER[Integer.parseInt(firstStr)]);
                for(int j=1;j<m;j++){
                    System.out.print(TO_LETTER[scanner.nextInt()]);
                }
                System.out.println();
            }
        }
    }
    
    static void genToNumber(){
        char[] toNumer = new char[]{'0',
            'u', 'z', 'r', 'm', 'a', 
            't', 'i', 'f', 'x', 'o',
            'p', 'n', 'h', 'w', 'v',
            'b', 's', 'l', 'e', 'k',
            'y', 'c', 'q', 'j', 'g', 
            'd'
        };
        TO_NUMBER[0] = '0';
        for(int i=1;i<=26;i++){
            TO_NUMBER[toNumer[i] - 'a' + 1] = i;
        }
    }
}
