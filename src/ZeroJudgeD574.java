
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeD574 {
    public static void main(String[] args) {
        int n;
        String str;
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            // The use of try-catch is due to errors in the topic data.
            try{
                n = scanner.nextInt();
                str = scanner.next();
            }catch(Exception e){
                str = scanner.next();
                n = 0;
                int i = 0;
                for(char chr:str.toCharArray()){
                    if(chr>='0'&&chr<='9'){
                        n = n*10 + (chr-'0');
                        i++;
                    }else{
                        break;
                    }
                }
                str = str.substring(i);
            }
            System.out.println(Magic(str)+"\n");
        }
    }
    
    
    static String Magic(String str){
        char[] arrChr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        char base = arrChr[0];
        int count = 0;
        
        for(int i=0;i<arrChr.length;i++){
            if(base==arrChr[i]){
                count++;
            }else{
                // Append number and character.
                sb.append(count);
                sb.append(base);
                // Reset
                base = arrChr[i];
                count = 1;
            }
        }
        // Last term
        sb.append(count);
        sb.append(base);
        
        // Return shortest string
        if(arrChr.length > sb.length())
            return sb.toString();
        else
            return str;
    }
}

/*
    梅蘭城的法師們研究出了一種魔法道具：符咒。
    即便是未曾學習魔法的人，
    只要念出符咒上獨特的咒語就能施展特定魔法，
    並且該咒語的魔力就會消失。

    現在為了訓練新進的法師，需要使用大量的符咒。
    但是梅蘭城(不事生產的)法師們並不會造紙這種技術，必須從首都艾克隆購買。

    在紙張有限的情況下，
    必須按照特定的規則來記述這些為數龐大的咒語才行。
    假設有一張地震術符咒的內容是：aaabb
    咒語是由三個a和兩個b所組成，所以在符咒上的記述內容必須改成：3a2b
    並且咒語的每個字都是有順序的，假如符咒治癒術是xxxyywwyy的話，必須記作3x2y2w2y，"y"的部分不能記作4y
    如果採取這個格式後沒有得到咒文的節約，那麼就選擇直接使用原本的咒語就可以了。

    然而…

    越強的法術寫出來的咒文就會越臭長！快寫個程式幫助魔法師節約咒文吧！
    (他們總是基於好奇喜歡對電腦這東西施展破壞性的閃電魔法，所以沒人知道怎麼寫程式。)
--------------------------------------------------------------------------------
輸入說明
    共計10個測資點。

    每個測資點只有一組測試資料。
    第一行有正整數n(1<=n<=10000000)，表示原本咒文的長度(以字元為單位)
    第二行則是咒文的內容連續的n個字元。
    其中咒文的字元是由小寫字母所組成。
範例輸入
    20
    aaaaabbbbbcccccaabba

    3
    abc
--------------------------------------------------------------------------------
輸出說明
    如果簡化過的咒文長度小於原咒文，則輸出簡化版本
    如果簡化後和原咒文字數相同甚至更多，則輸出原咒文
範例輸出
    5a5b5c2a2b1a

    abc
*/