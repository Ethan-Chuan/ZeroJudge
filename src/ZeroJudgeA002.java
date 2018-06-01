
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

/*
請寫一個程式，讀入兩個數字，並求出它們的和。
--------------------------------------------------------------------------------
輸入說明
    每一組輸入有兩個整數，絕對值皆小於 106。
範例輸入
    5 10
    1 2
--------------------------------------------------------------------------------
輸出說明
    對於每組輸入，輸出該兩整數的和。
範例輸出
    15
    3
*/