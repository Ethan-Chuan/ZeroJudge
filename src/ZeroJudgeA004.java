
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
            String ans; //閏年(leap year) 或 平年(common year)  
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

/*
    文文為即將出國的珊珊送行，由於珊珊不喜歡別人給文文的那個綽號，意思就是嘲笑文文不夠
聰明，但珊珊沒把握那個綽號是不是事實，所以珊珊決定考驗文文，於是告訴文文說，如果你能在
我回國之前回答我生日那年是不是閏年，則等她回國後就答應他的求婚。文文抓抓腦袋想不出來， 
於是決定讓最擅長做運算的電腦來幫忙。
--------------------------------------------------------------------------------
輸入說明
    年份
範例輸入
    1977
--------------------------------------------------------------------------------
輸出說明
    閏年 或 平年
範例輸出
    平年
*/