/**
 *
 * @author Ethan
 */
public class ZeroJudgeA147 {
    public static void main(String[] args) {
        
    }
    
    // skip number of multiply by 7.
    static void printExceptNumOfMultiplyBy7(int x){
        int last;
        int q = x / 7;
        int r = x % 7;
         
        // find last number divisible by 7.
        if(q==0)
            last = 0;
        else
            last = q*7;
        
    }
}
