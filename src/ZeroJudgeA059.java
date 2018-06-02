
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA059 {
    static int[] sqrtNum = new int[32];
    
    public static void main(String[] args) {
        genSqrtNum();
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println("Case " + (i+1) + ": " + sumSqrtNum(a,b));
        }
    }
    
    static void genSqrtNum(){
        int maxInt = 1000;
        
        int end = 1 + (int)Math.sqrt(maxInt);
        for(int i=0; i<end; i++){
            sqrtNum[i] = i*i;
        }
    }
    
    static int sumSqrtNum(int a, int b){
        int ret = 0;
        int beginIndex, endIndex;
        
        for(beginIndex=0; beginIndex<sqrtNum.length && sqrtNum[beginIndex]<a; beginIndex++);
        for(endIndex=0; endIndex<sqrtNum.length && sqrtNum[endIndex]<=b; endIndex++);
        
        for(int i=beginIndex; i<endIndex; i++){
            ret += sqrtNum[i];
        }
        
        return ret;
    }
}

/*
    給你一個範圍 a 到 b ，請你找出 a 與 b 之間所有完全平方數的和。

    例如：範圍 [3, 25] 中所有完全平方數的和就是 4 + 9 + 16 + 25  = 54 。
--------------------------------------------------------------------------------
輸入說明
    輸入的第一列有一個整數 T （1≦T≦100），代表以下有多少組測試資料。
    每組測試資料為兩列，包含兩個數 a 與 b （0≦a≦b≦1000）。
範例輸入
    2
    1
    5
    5
    35
--------------------------------------------------------------------------------
輸出說明
    每組測試資料輸出一列，內容為 a 及 b 間所有完全平方數的和。
範例輸出
    Case 1: 5
    Case 2: 50
*/