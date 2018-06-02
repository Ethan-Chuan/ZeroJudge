
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeD586 {
    static final char[] TO_LETTER = new char[]{'0',
        'm', 'j', 'q', 'h', 'o',
        'f', 'a', 'w', 'c', 'p',
        'n', 's', 'e', 'x', 'd',
        'k', 'v', 'g', 't', 'z',
        'b', 'l', 'r', 'y', 'u',
        'i'
    };
    static final int[] TO_NUMBER = new int[27];
    
    public static void main(String[] args) {
        genToNumber();
        /*
        for(int i:TO_NUMBER){
            System.out.print(i + "\t");
        }
        System.out.println();
        for(char chr='a';chr<='z';chr++){
            System.out.print(chr + "\t");
        }
        System.out.println();
        for(char chr='a';chr<='z';chr++){
            System.out.print(TO_NUMBER[chr-'a'] + "\t");
        }*/
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m;
        String firstStr;
        for(int i=0;i<n;i++){
            m = scanner.nextInt();
            firstStr = scanner.next();
            if(firstStr.length()==1 && firstStr.charAt(0)>='a' && firstStr.charAt(0)<='z'){
                int sum = TO_NUMBER[firstStr.charAt(0) - 'a' + 1] ;
                for(int j=1;j<m;j++){
                    sum += TO_NUMBER[scanner.next().charAt(0) - 'a' + 1] ;
                }
                System.out.println(sum);
            }else{
                System.out.print(TO_LETTER[Integer.parseInt(firstStr)]);
                for(int j=1;j<m;j++){
                    System.out.print(TO_LETTER[scanner.nextInt()]);
                }
                System.out.println();
            }
        }
    }
    
    static void genToNumber(){
        char[] toNumer = new char[]{'0',
            'u', 'z', 'r', 'm', 'a', 
            't', 'i', 'f', 'x', 'o',
            'p', 'n', 'h', 'w', 'v',
            'b', 's', 'l', 'e', 'k',
            'y', 'c', 'q', 'j', 'g', 
            'd'
        };
        TO_NUMBER[0] = '0';
        for(int i=1;i<=26;i++){
            TO_NUMBER[toNumer[i] - 'a' + 1] = i;
        }
    }
}

/*
    「什麼？指導老師哈密瓜…這哪招阿！」
    這不是重點，反正哈密瓜老師出來開幼兒美語補習班了。
    哈密瓜老師為了加強小朋友的數字和英文字母對應能力，
    他出了一道邪惡的謎題…

    一般英文字母的排列是abcdefghijklmnopqrstuvwxyz(a~z)
    有種密碼是這樣的，
    假如明文是16 5 14 7 21 9 14，
    那麼它的密文就是penguin。
    為什麼呢？因為p是第16個英文字母，e是第五個，n是第14個…以此類推

    現在邪惡的哈密瓜把英文字母的排列給洗亂了，
    並且出了雙向的謎題。
    如果題目是由數字組成，就要解出英文單字
    如果題目是由小寫字母組成，就要解出數字的總合
    假設現在的字母排列是：jvkixcpomtfgdyhesrlzbqnwua
    那麼整理出對應表如下：
    1 j
    2 v
    3 k
    4 i
    5 x
    6 c
    7 p
    8 o
    9 m
    10 t
    11 f
    12 g
    13 d
    14 y
    15 h
    16 e
    17 s
    18 r
    19 l
    20 z
    21 b
    22 q
    23 n
    24 w
    25 u
    26 a
    數字：7 16 23 12 25 4 23 答案是penguin
    英文：p e n g u i n 答案是7+16+23+12+25+4+23=110

    --

    好了，照慣例哈密瓜的智商有限，現在他自己也解不出他自己出的謎題了。
--------------------------------------------------------------------------------
輸入說明
    本題有兩個測資點。
    第一行有整數n(1<n<=100)，表示總共有幾條謎題
    接下來的n行，每行有整數m(1<=m<=10000)，
    表示接下來有m個數字/英文字母要解密。
    每個數字或是英文字母會以空格隔開，
    並且數字一定在1~26(包含)
    英文字母必定是小寫
    並且請注意…
    如果題目是數字，程式要轉換成英文字母時，
    必須使用的字母排列是：mjqhofawcpnsexdkvgtzblryui
    相反的，如果題目給你英文字母，要算出對應數字總和時，
    必須使用這套字母排列：uzrmatifxopnhwvbslekycqjgd
範例輸入
    2
    7 p e n g u i n
    7 10 13 11 18 25 26 11
--------------------------------------------------------------------------------
輸出說明
    對應連續的數字，請按照規則排列輸出英文單字(連續無空格)
    對應連續的字母，請按照規則排列輸出數字總合
    (對範例測資來說，第一筆輸入penguin對應的數列是
    11 19 12 25 1 7 12，總和是87)
範例輸出
    87
    penguin
*/