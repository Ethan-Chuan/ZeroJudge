
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA001{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s;
        
        /*
        * continue to judge whether there is data.
        * read one line and append "hello, " before those word.
        */
        while(scanner.hasNext()){
            s = scanner.nextLine();
            System.out.println("hello, " + s);
        }
    }
    
}