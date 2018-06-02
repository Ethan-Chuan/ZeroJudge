
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeB893 {
    public static void main(String[] args) {
        double ans1 = 0, ans2 = 0; //solution in range ans1 to ans2.
        int count=0; //numbers of solutions.
        int[][] solution = new int[6][2]; //storing solutions.
        Scanner input=new Scanner(System.in);
       
        int [] A = new int[6];
        for(int i=0;i<6;i++){
            A[i] = input.nextInt();
        }
        
        /*
        * calculating boundary of real number 
        * for Bolzano's Theorem
        */
        int boundary = 1;
        while(Math.pow(++boundary,6)<Integer.MAX_VALUE);
        boundary--;

        /*
        * calculating values for specified function and
        * if f(x)*f(y) < 0, then at least one solution (there is only one).
        * if f(x) == 0, then the solution is 0 0.
        * if count > 5, then the function there are infinite solutions.
        */
        for(int x=-boundary;x<=boundary;x++){
            int y = x+1;
            for(int i=0;i<6;i++){
                ans1 += A[i]*Math.pow(x,5-i);
                ans2 += A[i]*Math.pow(y,5-i);
            }
            
            if( (ans1>0&&ans2<0) || (ans2>0&&ans1<0)){
                solution[count][0] = x;
                solution[count][1] = y;
                count++;
            }else if(ans1==0){
                solution[count][0] = x;
                solution[count][1] = x;
                count++;
            }

            if(count > 5){
                break;
            }
            ans1 = ans2 = 0;
        }
        
        /*
        * print answers.
        */
        if(count == 0){
            System.out.println("N0THING! >\\\\\\<");
        }else if(count > 5){
            System.out.println("Too many... = =\"");
        }else{
            for(int i=0;i<count;i++){
                System.out.println(solution[i][0]+" "+solution[i][1]);
            }
        }
    }
}

/*
    高中數學的等級明顯比國中高出了許多，這點在小紫進入了板橋高中之後她就清楚地體會到了──以往國中
    輕鬆考都可以90分以上甚至滿分的數學，居然會不及格！
    但儘管小紫受到了莫大的打擊，她依然想努力地把數學顧好，再加上他們的數學老師誇下海口，讓這次數學
    段考排名是三位數的同學兩個兩個分組，可以在第二次段考的時候針對各組進步最多分的那一位同學來做
    整組相對應的學期總成績加分，這種種契機讓小紫燃起了鬥志，於是她找了班上一位數學很好的同學波路
    特石與她同組，想讓第二次段考能夠有90分。

    這天，小紫正好與波路特石在討論數學。
    「欸欸，這個『甚根定理』是什麼東西啊？」
    小紫對波路特石提出了疑問。
    「ㄜ……那個是『勘』根定理。」
    波路特石無奈地回應。
    「沒差啦，我問你這個是什麼意思！」
    「……」波路特石儘管感到很頭痛，但還是繼續解釋了下去：「勘根定理的概念其實很簡單，就是在講
    『當一個連續的函數f(x)滿足f(a)×f(b)<0的時候，必可以在a和b之間找到至少一個根滿足f(x)=0』，
    順帶一提，a、b是實數。」
    「為什麼？」
    針對小紫再次的提問，波路特石在紙上畫出了一個直角座標，並在x軸的上方和下方各點出了一個點。
    「因為我已經給出了『函數是連續的』這個條件，也就是說這個函數必不會間斷……你應該知道當y是x的
    函數，一個x最多只能對應到一個y吧？」
    「知道。」
    「好，那你模擬看看，假設你今天要從下面這個點，走到上面這個點，並且你的路徑一定要是連續的，又
    不能繞出去這兩點之間，請問你有辦法不經過x軸就到達上面的點嗎？」
    「當然不能啊！」小紫在反駁波路特石的剎那間忽然靈光一閃、恍然大悟：「我懂了！所以在上面這個點
    和下面這個點之間一定會經過x軸，也就是f(x)=0的解嘛！」
    「沒錯，這樣你應該就懂了。」
    「謝謝！」

    小紫非常的興奮，她又理解了一個新的定理，但有關於勘根定理的題目實在是太少了，於是她想自己出給
    自己題目，不過她卻沒辦法確認答案的正確性，又不想再打擾最近忙著程式競賽還願意花時間教自己數學
    的波路特石。

    請你撰寫一個程式，幫小紫判斷她出的「多項式函數」所有根的範圍分別介於哪兩個連續整數之間，好讓
    小紫可以驗證正確答案。
--------------------------------------------------------------------------------
輸入說明
    每筆輸入有以空格隔開的6個整數，分別為a、b、c、d、e、f，代表
    ax^5+bx^4+cx^3+dx^2+ex+f，來表示小紫出給自己的函數題目。
範例輸入
    0 0 6 -25 -29 20
--------------------------------------------------------------------------------
輸出說明
    請輸出這個函數所有的根分別介於哪兩個「連續」整數之間，並由小排到大，每一個根的範圍占一行，
    每一行裡的兩個數字以空格隔開，小的在左。
    若有無限多組根請輸出「Too many... = ="」(不含引號)；
    若函數無實根請輸出「N0THING! >\\\<」(不含引號)。
    若根恰為整數，請重複輸出兩次此根，並以空格隔開。
範例輸出
    -2 -1
    0 1
    5 5
*/