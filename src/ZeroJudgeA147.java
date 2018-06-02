
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

/*
    大於 0、整數、不可以被 7 整除、小於 n，請輸出所有可能的數字。
--------------------------------------------------------------------------------
輸入說明
    輸入為一個整數 n，其中 n 不大於 10000。
    若 n = 0 表示資料結束。
範例輸入
    5
    10
    20
    0
--------------------------------------------------------------------------------
輸出說明
    輸出如前述，各個數字之間以一個空白隔開。
範例輸出
    1 2 3 4
    1 2 3 4 5 6 8 9
    1 2 3 4 5 6 8 9 10 11 12 13 15 16 17 18 19
*/