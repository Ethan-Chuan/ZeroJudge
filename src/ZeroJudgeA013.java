
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA013 {
    public static void main(String[] args) {
        String a, b;
        RomanNumeral roman1, roman2;
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            a = scanner.next();
            if(a.equals("#")){
                break;
            }
            b = scanner.next();
            if(b.equals("#")){
                break;
            }
            if(isNumber(a)){
                roman1 = new RomanNumeral(Integer.parseInt(a));
            }else{
                roman1 = new RomanNumeral(a);
            }
            
            if(isNumber(b)){
                roman2 = new RomanNumeral(Integer.parseInt(b));
            }else{
                roman2 = new RomanNumeral(b);
            }
            System.out.println(roman1.subtract(roman2));
        }
    }
    
    static public boolean isNumber(String str){
        try{
            Integer.parseInt(str);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    
    static class RomanNumeral extends Number{
        private char[] roman;
        private int decimal;
        
        private final char[][][] basicDecimalPattern = new char[][][]{
            {
                {},
                {'I'},
                {'I', 'I'},
                {'I', 'I', 'I'},
                {'I', 'V'},
                {'V'},
                {'V', 'I'},
                {'V', 'I', 'I'},
                {'V', 'I', 'I', 'I'},
                {'I', 'X'},
            },
            {
                {},
                {'X'},
                {'X', 'X'},
                {'X', 'X', 'X'},
                {'X', 'L'},
                {'L'},
                {'L', 'X'},
                {'L', 'X', 'X'},
                {'L', 'X', 'X', 'X'},
                {'X', 'C'},
            },
            {
                {},
                {'C'},
                {'C', 'C'},
                {'C', 'C', 'C'},
                {'C','D'},
                {'D'},
                {'D', 'C'},
                {'D', 'C', 'C'},
                {'D', 'C', 'C', 'C'},
                {'C', 'M'}, 
            },
            {
                {},
                {'M'},
                {'M', 'M'},
                {'M', 'M', 'M'},
            }
        };
        
        RomanNumeral(String str){
            decimal = 0;
            roman = str.toUpperCase().toCharArray();
            romanConvertDecimal();
        }
        
        RomanNumeral(int value){
            decimal = value;
            decimalConvertRoman();
        }
        
        public String getRoman() {
            return Arrays.toString(roman);
        }

        public int getDecimal() {
            return decimal;
        }
        
        private int romanValue(char chr){
            switch(chr){
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
            }
            return -1;
        }
        
        private void romanConvertDecimal(){
            boolean isPlus = true;
            int preInt = Integer.MAX_VALUE;
            for(int i=0;i<roman.length;i++){
                int curInt = romanValue(roman[i]);
                if(preInt < curInt){
                    decimal += curInt - 2*preInt;
                }else{
                    decimal += curInt;
                }
                preInt = curInt;                
            }
        }
        
        private void decimalConvertRoman(){
            String ret = "";
            int basicDecimal = 1000;
            int val = this.decimal;
            if(val > 0){
                while(basicDecimal>0){
                    int p = (int)Math.log10(basicDecimal);
                    int q = val / basicDecimal;
                    val %= basicDecimal;
                    for(char chr : basicDecimalPattern[p][q]){
                        ret += chr;
                    }
                    basicDecimal /= 10;
                }
            }else{
                ret = "ZERO";
            }
            roman = ret.toCharArray();
        }
        
        public RomanNumeral subtract(RomanNumeral val){
            this.decimal -= val.decimal;
            if(this.decimal < 0){
                this.decimal *= -1;
            }

            if(this.decimal >= 4000){
                this.decimal = 0;
            }
            decimalConvertRoman();
            return this;
        }      

        @Override
        public int intValue() {
            return decimal;
        }

        @Override
        public long longValue() {
            return (long)decimal;
        }

        @Override
        public float floatValue() {
            return (float)decimal;
        }

        @Override
        public double doubleValue() {
            return (double)decimal;
        }

        @Override
        public String toString() {
            return new String(roman);
        }
    }
}

/*
如果生活在數世紀之前的古羅馬，你應該用過 V 來表示五。V 和 5 這兩個符號都可以用來表示數目五。用來表示數目的符號稱作數字。而羅馬人用來表示數目的符號就是羅馬數字。

以下是七個基本的羅馬數字︰
羅馬數字	數目
I	1
V	5
X	10
L	50
C	100
D	500
M	1,000
所有其他的數目都是由這些數字組合而成。數目都是由左寫到右，通常值是等於組成的羅馬數字加起來。

例如十七可以表示為
        X+V+I+I=XVII
        10+5+1+1=17
表示羅馬數字可以使用減法來取代加法的規則。例如四可以不用四個一相加來表示 IIII，而採用五減一來表示 IV。利用這類規則，羅馬人能夠減化許多數目的表示方式，例如 IX 取代 VIIII 表示 9，及 CD 取代 CCCC 表示 400。
今日我們並不確定羅馬符號的起源為何。例如符號 V 的起源主要有兩個理論。有些學者認為五最早是用握拳、拇指在外的手勢來表示。最後以象形文字書寫而簡化為 V。
另一個理論認為 X 源自在 10 條線加上交叉線。因此五可以表示為 X 的一半，或是 V。
羅馬數字可以很容易地用來相加或相減，但算起乘除法就相當不順手。這就是為什麼現在羅馬數字並不常用的原因了。

問題
然而，羅馬數字還是經常用於書本章節及頁碼的編號。在這一題工作是讀入兩個正整數，然後輸出兩個數字差的絕對值。所有的數字都必須以羅馬數字來表示。而連續四個相同符號出現時，必須用減法規則來化簡之。
--------------------------------------------------------------------------------
輸入說明
    每個輸入檔中會有一個或以上的測試資料。每一行由兩個數字組成一筆測試資料，且所有數字將會小於4,000。檔案最後會以符號 # 表示結束。
範例輸入
    I I
    MM II
    #
--------------------------------------------------------------------------------
輸出說明
    每筆測試資料的答案必須輸出到檔案中，並且換行。如果答案為零，則須輸出字串 ZERO。
範例輸出
    ZERO
    MCMXCVIII
*/