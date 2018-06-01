
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            String x = scanner.next();
            String symbol = scanner.next();
            String y = scanner.next();
            BigInteger X = new BigInteger(x);
            BigInteger Y = new BigInteger(y);
            if(symbol.equals("+")){
                System.out.println(X.add(Y));
            }
            if(symbol.equals("-")){
                System.out.println(X.subtract(Y));
            }
            if(symbol.equals("*")){
                System.out.println(X.multiply(Y));
            }
            if(symbol.equals("/")){
                System.out.println(X.divide(Y));
            }
        }
    }
    
}
/*
    我們都知道電腦擅長於各種數字的計算，可是，我們又知道各種程式語言的變數又都有上限，
    比如整數只有216 或 232 個。如果要計算更大的數字時又該如何計算呢? 就交給聰明的您來解決囉。

    以 + 代表加法 
    以 - 代表減法
    以 * 代表乘法 
    以 / 代表除法 (取商數)
--------------------------------------------------------------------------------
輸入說明
    兩個正整數的運算式，運算元及運算子之間以空格隔開
範例輸入
    2222222222222222222222222 + 1111111111111111111111111
    2222222222222222222222222 - 1111111111111111111111111
    2222222222222222222222222 * 1111111111111111111111111
    2222222222222222222222222 / 1111111111111111111111111
--------------------------------------------------------------------------------
輸出說明
    兩個正整數的運算結果，總長度不超過 500 個位數
範例輸出
    3333333333333333333333333
    1111111111111111111111111
    2469135802469135802469135308641975308641975308642
    2
*/