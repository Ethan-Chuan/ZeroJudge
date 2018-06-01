
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA034 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            int a = scanner.nextInt();
            System.out.println(Integer.toBinaryString(a));
        }
    }
    
}

/*
    還記得計算機概論嗎？還記得二進位嗎？

    現在我們來計算一下將一個10進位的數字換成二進位數字
--------------------------------------------------------------------------------
輸入說明
    一個十進位的數值
範例輸入
    3
    6
--------------------------------------------------------------------------------
輸出說明
    輸出二進位制的結果
範例輸出
    11
    110
*/