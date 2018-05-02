
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA054 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            int x = scanner.nextInt();
            int num = numberPreCheck(x/10);
            for(int i=0; i<26;i++){
                char chr = indexMapping(i);
                int preNum = num + letterPreCheck(letterMapping(chr));
                if(isRealIdCard(preNum, x%10)) System.out.print(chr);
            }
            System.out.println();
        }
    }
    
    static char indexMapping(int index){
        return (char)(index + 'A');
    }
    
    static int letterMapping(char chr){
        int[] mapping = new int[]{
            10,11,12,13,14,
            15,16,17,34,18,
            19,20,21,22,35,
            23,24,25,26,27,
            28,29,32,30,31,
            33
        };
        int index = chr - 'A';
        return mapping[index];
    }
    
    static int letterPreCheck(int x){
        return x/10 + (x%10)*9;
    }
    
    static int numberPreCheck(int x){
        int len = 1;
        int ret = 0;
        int q = x;
        while(q>0){
            int r = q%10;
            q /= 10;
            ret += len*r;
            len++;
        }
        return ret;
    }
    
    static boolean isRealIdCard(int preNum, int checkNum){
        // The checking formula of topic is wrong.
        // Changing it reference to A020.
        int preCheckNum = preNum + checkNum;
        return preCheckNum%10==0;
    }
    
}
