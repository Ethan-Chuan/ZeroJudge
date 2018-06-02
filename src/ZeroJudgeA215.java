
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA215 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            String n = scanner.next();
            String m = scanner.next();
            System.out.println(counter(new BigInteger(n), new BigInteger(m)));
        }
    }
    
    /*
    * Area of a Trapezoid = (b1 + b2) * h / 2 =  (b1 + b2) * (b2 - b1 + 1) / 2 
    * m < (n + x) * (x - n + 1) / 2
    * 2*m < x*x + x + (n - n*n)
    * x*x + x + (n - n*n - 2*m) > 0
    * Using quadratic formula, we only check
    * The smallest integer value that is greater than or equal to
    * ( -1 + Math.sqrt( 8*m + 4*n*n - 4*n + 1) ) / 2.0
    */
    static BigInteger counter(BigInteger n, BigInteger m){
        if(n.compareTo(m)==1)
            // n > m
            return new BigInteger("1");
        else{
            BigInteger ac4 = m.multiply(new BigInteger("8"))
                    .add( n.multiply(n).multiply(new BigInteger("4")) )
                    .add(new BigInteger("1"))
                    .subtract( n.multiply(new BigInteger("4")) ) ;
            BigInteger qf = sqrt(ac4).subtract(new BigInteger("1"))
                    .divide(new BigInteger("2"))
                    .add(new BigInteger("1"));
            return qf.subtract(n).add(new BigInteger("1"));
        }
    }
    
    /*
    * Square root of biginteger.
    */
    static BigInteger sqrt(BigInteger x) {
        BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
        BigInteger div2 = div;
        // Loop until we hit the same value twice in a row, or wind
        // up alternating.
        for(;;) {
            BigInteger y = div.add(x.divide(div)).shiftRight(1);
            if (y.equals(div) || y.equals(div2))
                return y;
            div2 = div;
            div = y;
        }
    }
}

/*
    明明是一個愛數（ㄕㄨˇ）數（ㄕㄨˋ）的好學生，這天媽媽叫他從 n 開始數，下一個數字是 n+1，
    再下一個數字是 n+2，以此類推。媽媽想知道，明明數了幾個數字之後，他數過的這些數字的總和會
    超過 m。請幫助明明的媽媽吧。
--------------------------------------------------------------------------------
輸入說明
    輸入以 EOF 結束。每一筆測試資料有兩個數字，分別為 n 和 m，其中 m-n 不會超過 10^5。
範例輸入
    1 5
    5 10
    100 1000
--------------------------------------------------------------------------------
輸出說明
    輸出如題目敘述。
範例輸出
    3
    2
    10
*/