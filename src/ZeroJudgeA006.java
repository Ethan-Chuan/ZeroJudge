
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a, b, c;
        double discriminant;
        String ans = "";
        
        while(scanner.hasNext()){
            a = scanner.nextDouble();
            b = scanner.nextDouble();
            c = scanner.nextDouble();
            
            // A univariate (single-variable) quadratic function has Discriminant.
            discriminant = b*b - 4*a*c;
            
            // The quadratic formula for the roots of the quadratic polynomial:
            // (-b+discriminant)/(2*a) and (-b-discriminant)/(2*a)
            if(discriminant<0){
                ans += "No real root";
            }else if(discriminant==0){
                ans += "Two same roots x=" + (int)((-b)/(2*a));
            }else{
                discriminant = Math.sqrt(discriminant);
                ans += "Two different roots x1=" + (int)((-b+discriminant)/(2*a)) + 
                        " , x2=" + (int)((-b-discriminant)/(2*a));
            }
            
            System.out.println(ans);
            ans = "";
        }
    }
    
}
