
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

/*
    求一元二次方程式 ax^2+bx+c=0 的根
--------------------------------------------------------------------------------
輸入說明
    輸入三個整數 a, b, c
範例輸入
    1 3 -10
    1 0 0
    1 1 1
--------------------------------------------------------------------------------
輸出說明
    Two different roots x1=?? , x2=??
    Two same roots x=??
    No real root
    PS: 答案均為整數，若有兩個根則大者在前
範例輸出
    Two different roots x1=2 , x2=-5
    Two same roots x=0
    No real root
*/