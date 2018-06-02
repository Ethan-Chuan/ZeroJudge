
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA095 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            
            if(a!=b){
                System.out.println(b+1);
            }else{
                System.out.println(b);
            }
        }
    }
    
}

/*
* For each prisoner, the number of Red Hats is only two possible. 
* One is assuming that they are white hats. 
* For that prisoner, the number of Red Hats is what the prisoners now see. 
* One is to assume that they are Red Hats. 
* The number of Red Hats is the number of Red Hats seen by prisoners +1
*
* Each prisoner will only go to the warden if he knows he will not die.
*
* Type 1 : 10 people have 1 Red Riding Hood.
* The Red Hat person knows that there is at least one Red Riding Hood.
* He sees that everyone else is white, so only he is Red Hat.
*
* Type 2 : 10 individuals have 2 Red Riding Hoods.
* The first person wearing a red hat saw a red hat, 
* and the second person wearing a red hat also saw a red hat,
* and all persons wearing white hats see 2 Red Hats.
* For first and second person wearing red hats, there are up to 2 red riding hoods.
* For other people wearing white hats, there are up to 3 red riding hoods.
* The next day, first and second person wearing red hats saw no one left. 
* First person wearing red hats was not sure if he was a Red Hat. 
* Second person wearing red hats was not sure if he was a Red Hat.
* At this time, other people wearing white hats were not sure if they were red hat,
* but First person wearing red hats knows that 
* Second person wearing red hats still sees at least one Red Hat.
* It must be him, because other people are a white hat.
* Second person wearing red hats thinks so too.
* On the third day, the people wearing white hats saw wearing Red Hat persons gone,
* so they knew they were wearing white hat and they gone.
*
* Type 3 : 10 people have 3 Red Riding Hoods.
* First, second, third persons wearing red hat saw two Red Riding Hoods.
* No one left the next day.
* At this time, First person assumed that he wear white hats, and 
* it should be tomorrow that both of wearing red hat persons would have left. 
* However, on the third day, second and thrid person wearing red hat did not go.
* The representative said there was at least one Red Riding Hood. 
* It must be me because first person saw other people are white hats. 
* So on the third day, All of wearing red hat persons are gone.
* On the fourth day, people wearing white hats knew that they are white hats,
* and they gone.
*
* Finally, when the number of all persons and number of persons wearing red hat 
* is the same, the number of days required will be the same as 
* the number of days of one less number of persons wearing red hat.
*
* Ex 10 people 9 Red hats, same as 10 people 10 Red hats, 
* because on the ninth day, everyone did not go, 
* there are nine Red Riding Hoods, a white hat on the tenth day, 
* or no tenth day, everyone is Red Hat, everyone walks together
*/

/*
    在禁忌的貝殼城裡存在著一座監獄
    有N個犯人被關在裡頭
    我們只知道 .....
    "他們都帶著帽子" 
    這是一頂神奇的帽子
    稱作 "廬山帽"
    是貝殼城裡的特產
    分為紅色及白色兩種 
    凡是帶上 "廬山帽" 的人 ......
    就會 "不識廬山真面目" !!!!
    而監獄內的所有犯人都被配帶了這一頂可怕的帽子 0.0
    而邪惡的所長麥哲倫想到了一個邪惡又沒有良心的鬼計畫：
    " 猜帽子 "

    只要能猜出自己的帽子顏色即可立即出獄
    但猜錯者須以死謝罪 

    而你可以假設監獄裡的犯人都跟羅賓一樣絕頂聰明
    不會有想要以死謝罪的白癡行為
    因此

    在N個犯人的監獄中，麥哲倫所長將M頂紅帽配給其中的犯人
    請問最少需要幾天，監獄內的所有犯人均可以確定自己的帽子顏色後出獄

    PS. 犯人並不知道共有幾頂紅帽，只知道紅帽至少有一頂，而且不可互相討論 = =
--------------------------------------------------------------------------------
輸入說明
    輸入兩數N，M （1 < M <= N < 2^31）
    代表N個犯人，M頂紅帽 
範例輸入
    10 1
    10 2
--------------------------------------------------------------------------------
輸出說明
    輸出最少幾天所有犯人均可以確定自己的帽子顏色後出獄
範例輸出
    2
    3
*/