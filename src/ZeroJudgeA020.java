
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA020 {
    public static void main(String[] args) {
        String str;
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            str = scanner.next();
            System.out.println(isIdCard(str)?"real":"fake");
        }
    }
    
    static boolean isIdCard(String str){
        int ret = letterMapping(str.charAt(0));
        ret = (ret/10) + (ret%10)*9;
        int end = str.length()-1;
        for(int i=1;i<end;i++){
            ret += Integer.parseInt(str.substring(i, i+1))*(end-i);
        }
        ret += Integer.parseInt(str.substring(end, end+1));
        return ret%10==0;
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
}
