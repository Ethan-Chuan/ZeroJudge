
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA015 {
    public static void main(String[] args) {
        int m,n;
        int[][] matrix = new int[99][99];
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            m = scanner.nextInt();
            n = scanner.nextInt();
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            printMatrix(transpose(matrix, m, n), n, m);
            
        }
    }
    
    static int[][] transpose(int[][] arr, int m, int n){
        int[][] trMatrix = new int[n][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                trMatrix[j][i] = arr[i][j];
            }
        }
        return trMatrix;
    }
    
    static void printMatrix(int[][] matrix, int m, int n){
        String str = "";
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                str += matrix[i][j] + " ";
            }
            str = str.substring(0, str.length()-1).concat("\n");
        }
        System.out.print(str);
    }
}

/*
    已知一(m x n)矩陣A，我們常常需要用到另一個將A中之行與列調換的矩陣。這個動作叫做矩陣的翻轉。舉例來說，若

    A =     3	1	2	
            8	5	4
    則
    AT =	3	8	
            1	5
            2	4

    現在 請您針對所讀取到的矩陣進行翻轉。
--------------------------------------------------------------------------------
輸入說明
    第一行會有兩個數字，分別為 列(row)<100 和 行(column)<100，緊接著就是這個矩陣的內容
範例輸入
    2 3
    3 1 2
    8 5 4
--------------------------------------------------------------------------------
輸出說明
    直接輸出翻轉後的矩陣
範例輸出
    3 8
    1 5
    2 4
*/