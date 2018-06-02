
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

/*
    鄭學長的手機裡有不可告人的秘密，為了不被發現那些照片和簡訊，他小心翼翼地把手機上鎖了。
    幸好，你是個會寫程式的天才，你能夠產生所有的密碼去嘗試，現在趕快動手吧！
    噢！還有一件事，基於某些理由，你知道鄭學長的密碼沒有重覆的字。
--------------------------------------------------------------------------------
輸入說明
    輸入為一個 n (n<=8)，代表鄭學長的密碼位數。
範例輸入
    3
    2
--------------------------------------------------------------------------------
輸出說明
    輸出所有可能的密碼，依字典順序反向排列（因為你覺得他的密碼應該在後半段）。
範例輸出
    321
    312
    231
    213
    132
    123
    21
    12
*/