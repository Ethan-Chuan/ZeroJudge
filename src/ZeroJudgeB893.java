
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