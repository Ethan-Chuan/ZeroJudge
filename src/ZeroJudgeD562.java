
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeD562 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            String[] magnet = new String[n];
            for(int j=0;j<n;j++){
                magnet[j] = scanner.next();
            }
            printMagnet(magnet, 0, n);
            System.out.println();
        }
    }
    
    static void printMagnet(String[] str, int beginIndex, int endIndex){
        boolean flag = true;
        while(beginIndex != endIndex){
            String ret = "";
            if(flag){
                for(int i=beginIndex; i<endIndex; i++)
                    ret += (" " + str[i]);
                endIndex--;
                flag = false;
            }else{
                for(int i=endIndex; i>beginIndex; i--)
                    ret += (" " + str[i]);
                beginIndex++;
                flag = true;
            }
            System.out.println(ret.substring(1));
        }
    }
    
}

/*
    遊戲洛克人有一個BOSS叫做磁力蜈蚣。
    現在山寨版磁力蜈蚣出現了，顯然設計得比本尊弱得很多：
    它身上所有的節是由一個個附有數字的磁鐵所組成，
    並且會暫時分解自己身上所有的節散落來攻擊玩家。
    但是有一天它發現它身上的節居然隨著絕招的使用越來越少！

    每次山寨版磁力蜈蚣將自己分解時，會讓所有磁鐵的排列順序倒轉。
    例如原本是：1 2 3 4 5，那麼倒轉後便成了5 4 3 2 1
    但是現在每次分解前便會先遺失第一節磁鐵，
    也就是原本：1 2 3 4 5，會遺失1，
    剩下的磁鐵倒轉後是5 4 3 2
    下次分解會遺失5，剩下的倒轉成了2 3 4
    ，再遺失2，成了4 3，最後剩下3便無法分解。

    請利用程式來模擬這個過程。
--------------------------------------------------------------------------------
輸入說明
    共計三個測資點。
    每組測資有兩行
    第一行有整數n(0<n<100)代表有幾個數,
    第二行有n個數A1...An(0<An<100)表示每個磁鐵上的數字
範例輸入
    5
    99 77 66 44 11
    7
    1 98 95 52 56 34 43
--------------------------------------------------------------------------------
輸出說明
    第一行請輸出最一開始的狀態
    第二行開始，輸出「刪去第一項後，全部倒轉的結果」
    直到數字只剩下一個為止
範例輸出
    99 77 66 44 11
    11 44 66 77
    77 66 44
    44 66
    66

    1 98 95 52 56 34 43
    43 34 56 52 95 98
    98 95 52 56 34
    34 56 52 95
    95 52 56
    56 52
    52
*/