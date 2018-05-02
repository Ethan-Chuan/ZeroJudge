
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeD562 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            String[] magnet = new String[n];
            for(int j=0;j<n;j++){
                magnet[j] = scanner.next();
            }
            printMagnet(magnet, 0, n);
            System.out.println();
        }
    }
    
    static void printMagnet(String[] str, int beginIndex, int endIndex){
        boolean flag = true;
        while(beginIndex != endIndex){
            String ret = "";
            if(flag){
                for(int i=beginIndex; i<endIndex; i++)
                    ret += (" " + str[i]);
                endIndex--;
                flag = false;
            }else{
                for(int i=endIndex; i>beginIndex; i--)
                    ret += (" " + str[i]);
                beginIndex++;
                flag = true;
            }
            System.out.println(ret.substring(1));
        }
    }
    
}
