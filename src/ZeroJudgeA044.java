
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
/*
* Different n lines division plane, the max number of parts is C(n+1, 2) + 1
* Different n planes division space, the max number of parts is C(n+1, 3) + n + 1
*
* 1st plane split into 1 + 1 = 2 spaces. 
*
* Adding another plane intersect remaining planes to get 1 lines. 
* It added 2*(2-1)/2 + 1 = 2 sub-divided planes, so the sub-divided plane divides 
* the original space into two parts. The total is 1 + 1 + 2 = 4 spaces.
*
* Adding 3rd plane intersect remaining planes to get 2 lines.
* It added 3*(3-1)/2 + 1 = 4 sub-divided planes, so the sub-divided plane divides
* the original space into two parts. The total is 1 + 1 + 2 + 4 = 8 spaces.
*
* Adding 4rd plane intersect remaining planes to get 3 lines.
* It added 4*(4-1)/2 + 1 = 7 sub-divided planes, so the sub-divided plane divides
* the original space into two parts. The total is 1 + 1 + 2 + 4 + 7 = 15 spaces.
*
* n planes division space 1 + [ 1 + 2 + 4 + 7 + ... + ( n*(n-1)/2 + 1) ]
* = 1 + [ (1*(1-1)/2 + 1) + (2*(2-1)/2 + 1) + (3*(3-1)/2 + 1) + (4*(4-1)/2 + 1) + ... + ( n*(n-1)/2 + 1) ]
* = 1 + n + (1/2)*[ (1^2-1) + (2^2-2) +  (3^2-3) + (4^2-4) + ... + (n^2-n) ]
* = 1 + n + (1/2)*[ (1^2+2^2+3^2+4^2+...+n^2) - (1+2+3+4+...+n) ]
* = 1 + n + (1/2)*[ (n*(n+1)*(2n+1)/6) - (n*(n+1)/2) ]
* = 1 + n + (1/2)*[ n*(n+1)*(2n+1-3)/6 ]
* = 1 + n + (1/2)*[ 2*n*(n^2-1)/6 ]
* = 1 + n + (n^3 - n)/6
* = (n^3 + 5*n + 6)/6
*/
public class ZeroJudgeA044 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            System.out.println((n*n*n + 5*n + 6)/6);
        }
    }
    
}

/*
    對任意正整數n，空間中的n 個平面最多可將空間切成幾個區域？
--------------------------------------------------------------------------------
範例輸入
    1
    2
--------------------------------------------------------------------------------
範例輸出
    2
    4
*/