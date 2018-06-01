
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA016 {
    public static void main(String[] args) {
        int m=9, n=9;
        int[][] sudoku = new int[9][9];
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    sudoku[i][j] = 1 << (scanner.nextInt() - 1);
                }
            }
            //printSudoku(sudoku, m, n);
            System.out.println(isSudoku(sudoku, m, n)?"yes":"no");
        }
    }
    
    static boolean isSudoku(int[][] sudoku, int m, int n){
        int base = 0b111111111;
        int status;
        
        // row
        for(int i=0;i<m;i++){
            status = 0;
            for(int val : sudoku[i]){
                status |= val;
            }
            if((status^base)!=0){
                return false;
            }
        }
        // column
        for(int j=0;j<n;j++){
            status = 0;
            for(int i=0;i<m;i++){
                status |= sudoku[i][j];
            }
            if((status^base)!=0){
                return false;
            }
        }
        
        // block
        for(int i=2;i<m;i=i+3){
            for(int j=2;j<n;j=j+3){
                status = 0;
                int end1 = i-3;
                int end2 = j-3;
                for(int c1=i;c1>end1;c1--){
                    for(int c2=j;c2>end2;c2--){
                        status |= sudoku[c1][c2];
                    }
                }
                if((status^base)!=0){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    static void printSudoku(int[][] sudoku, int m, int n){
        String str = "";
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                str += sudoku[i][j] + "\t";
            }
            str = str.substring(0, str.length()-1).concat("\n");
        }
        System.out.print(str);
    }
}

/*
    數獨是一種源自18世紀末的瑞士數學家歐拉(Leonhard Euler)所創造的拉丁方塊游戲。
    在9格寬×9格高的大九宮格中有9個3格寬×3格高的小九宮格，已經有一些數字在裡面了
    (但並非一定採用數字，例如採用字母a,b,c...)，根據這些數字，運用你的邏輯和推理,
    在其他的空格上填入1到9的數字，但是要注意了，每個數字在每個小九宮格內不能重複，
    每個數字在每行、每列也不能出現一樣的數字。 這種遊戲只需要邏輯思維能力，與數字運算無關。
    雖然玩法簡單，但數字排列方式卻千變萬化，所以不少教育者認為數獨是鍛鍊腦筋的好方法。 (wikipedia)

    現在我們可以用程式來判斷一個九宮格數字是不是一個數獨的正解。
--------------------------------------------------------------------------------
輸入說明
    輸入的每一組測試資料均為 9 × 9 的矩陣，且全部為 1~9 的數字，每兩組九宮格之間以一空行作為分隔
範例輸入
    1 2 3 4 5 6 7 8 9
    2 3 4 5 6 7 8 9 1
    3 4 5 6 7 8 9 1 2
    4 5 6 7 8 9 1 2 3
    5 6 7 8 9 1 2 3 4
    6 7 8 9 1 2 3 4 5
    7 8 9 1 2 3 4 5 6
    8 9 1 2 3 4 5 6 7
    9 1 2 3 4 5 6 7 8

    1 9 3 2 6 5 4 7 8
    7 8 2 3 1 4 9 5 6
    4 5 6 9 7 8 1 3 2
    2 3 4 8 5 1 6 9 7
    9 6 5 4 3 7 2 8 1
    8 7 1 6 9 2 3 4 5
    3 1 9 5 8 6 7 2 4
    5 2 7 1 4 3 8 6 9
    6 4 8 7 2 9 5 1 3
--------------------------------------------------------------------------------
輸出說明
    yes or no
範例輸出
    no
    yes
*/