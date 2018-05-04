
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA147 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x;
        
        while( (x = scanner.nextInt()) !=0 ){
            printExceptNumOfMultiplyBy7(x);
            System.out.println();
        }
    }
    
    // skip number of multiply by 7.
    static void printExceptNumOfMultiplyBy7(int x){
        for(int i=1; i<x; i++){
            if(i%7==0)
                continue;
            System.out.print(i + " ");
        }
    }
    
    // Java 8
    static void printExceptNumOfMultiplyBy7(int x, int y){
        IntStream.range(1, x).filter(i -> (i % 7) != 0).forEach(i -> System.out.print(i + " "));
    }
}
