
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA053 {
    public static void main(String[] args) {
        int[] stepScore = new int[]{0, 1, 2, 6, 0};
        int[] baseScore = new int[]{100, 80, 60, 0, 0};
        int[] stepNumQ = new int[]{40, 20, 10, 0, 0};
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int ret, i;
            for(i=0; i<4  && n<=stepNumQ[i]; i++);
            ret = baseScore[i] + stepScore[i]*(n-stepNumQ[i]);
            System.out.println(ret);
        }
    }
    
}

/*
    sagit 是一位高中電腦老師，這學期正在教學生寫C++程式。他的評分標準是依照每一位學生在 
    ZeroJudge 系統上解出的題數，去計算出對應的得分。為了不讓分數落差太大，因此他並不是採取
    每一題固定得分的方式，而是隨著題數增加而調整每題的得分。規則如下：

    答對題數在 0~10 者，每題給6分。
    題數在 11~20 者，從第11題開始，每題給2分。(前10題還是每題給6分)
    題數在 21~40 者，從第21題開始，每題給1分。
    題數在 40 以上者，一律100分。
    如此一來，只要寫10題，就可以得到60分，寫20題，就可以得到80分，不過要得到滿分100分，
    則是要寫到40題，所以同學們分數的差距就大大地減少了。 

    不過問題來了，雖然學生們因為這樣的計分公式而大大地提升了及格率，但因為 sagit 有600多位學生，
    一個一個去計算真的是一件很吃重的工作，所以現在想請你幫他寫個程式解決這個問題。
--------------------------------------------------------------------------------
輸入說明
    每組測資只有一個整數 N (0<=N<=100)，代表學生在 ZeroJudge 系統上解出的題數。
範例輸入
    10
    40
--------------------------------------------------------------------------------
輸出說明
    印出該位同學的得分。
範例輸出
    60
    100
*/