
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA524 {
    static List<String> permutation;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            String a = scanner.next();
            char b = a.charAt(0);
            permutation = new ArrayList<>();
            char[] arrChr = new char[Integer.parseInt(a)];
            for(int i=b; i>'0'; i--){
                arrChr[b-i] = (char)i;
            }
            
            permute(arrChr, 0, arrChr.length-1);
            Collections.sort(permutation);
            for(int i=permutation.size()-1;i>=0;i--){
                System.out.println(permutation.get(i));
            }
        }
    }
    
    static void permute(char[] arrChr, int left, int right){
        if(left==right){
            permutation.add(new String(arrChr));
        }else{
            for(int i=left; i<=right; i++){
                arrChr = swap(arrChr, left, i);
                permute(arrChr, left+1, right);
                arrChr = swap(arrChr, left, i);
            }
        }
    }
    
    static char[] swap(char[] chrChr, int pos1, int pos2){
        char tmp = chrChr[pos1];
        chrChr[pos1] = chrChr[pos2];
        chrChr[pos2] = tmp;
        return chrChr;
    }
}
