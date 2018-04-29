
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
