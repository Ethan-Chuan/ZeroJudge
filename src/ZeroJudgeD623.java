
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeD623 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            try{
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                double c = scanner.nextDouble();
                double d = scanner.nextDouble();
                if(a+b+c+d==0)
                    break;

                // Formula for checking whether exist inverse matrix.
                // [a b
                //  c d]
                double det = a*d - b*c;
                String str;
                if(det==0){
                    str = "cheat!";
                }else{
                    // Formula of inverse matrix.
                    str = String.format("%.5f %.5f\n%.5f %.5f",
                            d/det, -b/det, -c/det, a/det);
                }
                System.out.println(str);
            }catch(NoSuchElementException e){
                // The information of topic is wrong!
                // Throw a java.util.NoSuchElementException
                break;
            }
        }
    }
}
