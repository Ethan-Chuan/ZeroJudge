
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
