
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeD561 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal num;
        String str;
        double tmp;
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        
        while(scanner.hasNext()){
            num = new BigDecimal(scanner.next());
            str = df.format(num);
            tmp = Double.parseDouble(str)+0.0;
            if(tmp==0) System.out.println("0.00");
            else System.out.println(str);
        }
    }
    
}
/*
拿氣溫來說，攝氏15度和攝氏15.05度的差距對人來說差異實在不大，有了數學概數的觀念，我們可以透過四捨五入法來得到一個數字的估計值，進而方便統計。
現在請你將一些小數利用程式來四捨五入。
--------------------------------------------------------------------------------
輸入說明
    共計三個測資點，每個測資檔中有多行小數n(-1<=n<=1)，至多小數點以下有100位數
範例輸入
    1.00000
    0.5
    0.715
    0.1234567890
    -0.995
--------------------------------------------------------------------------------
輸出說明
    請輸出四捨五入至小數點以下第二位的結果
範例輸出
    1.00
    0.50
    0.72
    0.12
    -1.00
*/