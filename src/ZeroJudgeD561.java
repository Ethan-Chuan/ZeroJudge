
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
