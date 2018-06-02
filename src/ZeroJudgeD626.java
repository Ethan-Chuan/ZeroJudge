
import java.util.ArrayDeque;
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeD626 {
    static final char[] BASE_COLOR = new char[]{'+','-'};
    static char[][] arrChr;
    static int n;
    static char base;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p, q;
        n = scanner.nextInt();
        arrChr = new char[n][n];
        for(int i=0;i<n;i++){
            arrChr[i] = scanner.next().toCharArray();
        }
        p = scanner.nextInt();
        q = scanner.nextInt();
        
        // Calculating.
        result(p, q);
        
        // Display.
        for(int i=0;i<arrChr.length;i++){
            for(int j=0;j<arrChr[0].length;j++){
                System.out.print(arrChr[i][j]);
            }
            System.out.println();
        }
    }
    
    static void result(int p, int q){
        ArrayDeque<Integer[]> deque = new ArrayDeque<>();
        // Specific sign.
        base = arrChr[p][q];
        // The opposite sign.
        char drawColor = base==BASE_COLOR[0]?BASE_COLOR[1]:BASE_COLOR[0];
        
        // Drawing color.
        arrChr[p][q] = drawColor;
        
        // Initial four sides
        checkFourSides(deque, p, q);
        
        // Checking until there are no elements in deque.
        while(!deque.isEmpty()){
            Integer[] pos = deque.poll();
            // Drawing color.
            arrChr[pos[0]][pos[1]] = drawColor;
            // Checking four sides.
            checkFourSides(deque, pos[0], pos[1]);
        }
    }
    
    static void checkFourSides(ArrayDeque<Integer[]> deque, int i, int j){
        // Up
        if(isDrawing(i-1,j)) deque.offer(new Integer[]{i-1, j});
        // Wown
        if(isDrawing(i+1,j)) deque.offer(new Integer[]{i+1, j});
        // Left
        if(isDrawing(i,j-1)) deque.offer(new Integer[]{i, j-1});
        // Right
        if(isDrawing(i,j+1)) deque.offer(new Integer[]{i, j+1});
    }
    
    static boolean isDrawing(int i, int j){
        // Exceed boundary.
        if(i<0 || i>n-1 || j<0 || j>n-1)
            return false;
        // Checking it whether is the same sign.
        return arrChr[i][j]==base;
    }
}

/*
    Windows的小畫家真好用！
    (至少在處理PrintScreen方面蠻快的…)
    大家都知道
    小畫家裡面有一種繪圖工具
    叫做油漆桶工具
    只要選定你要的顏色、油漆的地點就可以進行填色
    油漆桶的填色範圍是取決於"同色塊相鄰"的原則
    現在請你模擬這項工具
--------------------------------------------------------------------------------
輸入說明
    每個測資點只有一筆測資。
    第一行有整數n(1<=n<=100)表示這張圖的大小是(n*n)個字元
    接下來的n行，每行n個字元表示這張圖的樣子。
    只有+、-兩種字元組成(兩種顏色的意思)
    在最後一行，有兩個整數i,j表示油漆桶點擊的地點是第(i+1)列第(j+1)個字元，
    [
    假設有圖如下3*3：
     012
    0---
    1-+-
    2-++
    那麼0,2就表示這格：
     012
    0--*
    1-+-
    2-++
    ]
    請視選取的顏色為+，選取的位置原本的顏色必為-
    並且墨水只會利用上下左右四個方位擴散
範例輸入
    7
    -------
    -+++---
    -+--+--
    -+---+-
    --+++--
    ---++--
    -------
    3 4
--------------------------------------------------------------------------------
輸出說明
    請直接輸出經過油漆桶塗色後的圖案
範例輸出
    -------
    -+++---
    -++++--
    -+++++-
    --+++--
    ---++--
    -------
*/