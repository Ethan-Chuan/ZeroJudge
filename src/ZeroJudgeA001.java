
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

/*
學習所有程式語言的第一個練習題 
請寫一個程式，可以讀入指定的字串，並且輸出指定的字串。
-------------------------------------------------------------------------------
輸入說明
    輸入指定的文字
範例輸入
    world
    C++
    mary
-------------------------------------------------------------------------------
輸出說明
    輸出指定的文字
範例輸出
    hello, world
    hello, C++
    hello, mary
*/