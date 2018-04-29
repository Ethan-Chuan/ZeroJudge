
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
