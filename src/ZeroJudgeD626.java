
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
