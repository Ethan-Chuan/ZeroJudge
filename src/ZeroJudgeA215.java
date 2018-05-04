
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
