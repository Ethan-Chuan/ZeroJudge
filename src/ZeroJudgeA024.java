
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA024 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(gcd(x, y));
        }
    }
    
    static int gcd(int x, int y){
        int ret = 0;
        int q,r;
        if(x<y){
            int tmp = x;
            x = y;
            y = tmp;
        }
        do{
            q = x / y;
            r = x % y;
            ret = y;
            x = y;
            y = r;
        }while(r>0);
        
        return ret;
    }
    
}
/*
    給定兩個數字，請得出它們的最大公因數
--------------------------------------------------------------------------------
輸入說明
    兩個整數 大於 0, 小於 2^31
範例輸入
    12 15
--------------------------------------------------------------------------------
輸出說明
    最大公因數為一整數
範例輸出
    3
*/