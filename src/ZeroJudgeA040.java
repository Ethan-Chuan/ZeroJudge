
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA040 {
    static int[] armNum = new int[]{
        1, 	2, 	3, 	4, 	5,
        6, 	7, 	8, 	9, 	153,
        370, 	371, 	407, 	1634, 	8208,
        9474, 	54748, 	92727, 	93084, 	548834
    };
    
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       
       //printArmNum();
       
       while(scanner.hasNext()){
           int n = scanner.nextInt();
           int m = scanner.nextInt();
           
           int beginIndex, endIndex;
           for(beginIndex = 0; armNum[beginIndex] < n; beginIndex++);
           for(endIndex = 0; armNum[endIndex] <= m; endIndex++);
           
           if(beginIndex==endIndex){
               // Because n < m.
               System.out.println("none");
           }else{
               for(int i=beginIndex; i<endIndex; i++){
                   System.out.print(armNum[i] + " ");
               }
               System.out.println();
           }
       }
    }
    
    /* ------------------------------------------------------------ */
    /*
    * Calculating Armstrong Number below 1000000.
    */
    static List<Integer> armstrongNumber = new ArrayList<>();
    
    static void initArmstrongNum(){
        int maxInt = 1000000;
        
        for(int i=1; i<=maxInt; i++)
            if(isArmstrongNum(i)) armstrongNumber.add(i);
        
    }
    
    static boolean isArmstrongNum(int x){
        int n = stringSize(x);
        int q = x;
        int check = 0;
        
        while(q>0){
            int r = q % 10;
            q = q / 10;
            check += Math.pow(r, n);
        }
        
        return x==check;
    }
    
    static int stringSize(int x){
        final int[] sizeTable = new int[]{
            9, 99, 999, 9999, 99999,
            999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE
        };
        
        for(int i=0;;i++)
            if(x<=sizeTable[i]) return i+1;        
    }
    
    static void printArmNum(){
        initArmstrongNum();
        System.out.println("static int[] armNum = new int[]{");
        for(int i=0; i<armstrongNumber.size()-1; i++){
           System.out.print(armstrongNumber.get(i));
           if((i+1)%5==0)
               System.out.print(",\n");
           else
               System.out.print(", \t");
        }
        System.out.println(armstrongNumber.get(armstrongNumber.size()-1) + "\n};");
    }
}

/*
    所謂 Armstrong number 指的是一個 n 位數的整數，它的所有位數的 n 次方和恰好等於自己。

    如；1634 = 14 + 64 + 34+ 44 

    請依題目需求在一定範圍內找出該範圍內的所有 armstrong numbers.
--------------------------------------------------------------------------------
輸入說明
    輸入包含兩個數字n, m(n<m, n>0, m<=1000000)，代表所有尋找 armstrong number 的範圍
範例輸入
    100 999
    10 99
--------------------------------------------------------------------------------
輸出說明
    將所有範圍內的 armstrong number 依序由小到大輸出，如果沒有找到請輸出 none.
範例輸出
    153 370 371 407
    none
*/