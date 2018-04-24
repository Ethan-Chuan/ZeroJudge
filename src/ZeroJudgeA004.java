
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA004 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNextInt()){
            int year = scanner.nextInt();
            
            // 1. Every 4 years is a leap year. But there are exception.
            // 2. Every 100 years except every 400 years is not a leap year.
            boolean isDivBy4 = (year%4==0);
            boolean isDivBy100 = (year%100==0);
            boolean isDivBy400 = (year%400==0);
            String ans = ""; //閏年(leap year) 或 平年(common year)  
            if(isDivBy100){
                if(isDivBy400){
                    ans = "閏年";
                }else{
                    ans = "平年";
                }
            }else if(isDivBy4){
                ans = "閏年";
            }else{
                ans = "平年";
            }
            
            System.out.println(ans);
        }
    }
}
