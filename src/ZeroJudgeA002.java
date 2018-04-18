
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA002{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int x,y;
        
        /*
        * continue to judge whether there is data.
        * read two values and print sum of x and y.
        */
        while(scanner.hasNext()){
            x = scanner.nextInt();
            y = scanner.nextInt();
            System.out.println(x+y);
        }
    }
    
}