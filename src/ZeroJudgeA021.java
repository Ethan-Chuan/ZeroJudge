
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            String x = scanner.next();
            String symbol = scanner.next();
            String y = scanner.next();
            BigInteger X = new BigInteger(x);
            BigInteger Y = new BigInteger(y);
            if(symbol.equals("+")){
                System.out.println(X.add(Y));
            }
            if(symbol.equals("-")){
                System.out.println(X.subtract(Y));
            }
            if(symbol.equals("*")){
                System.out.println(X.multiply(Y));
            }
            if(symbol.equals("/")){
                System.out.println(X.divide(Y));
            }
        }
    }
    
}
