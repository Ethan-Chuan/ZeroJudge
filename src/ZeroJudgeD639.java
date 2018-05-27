
/**
 *
 * @author Ethan
 */
public class ZeroJudgeD639 {
    static final int[] BASE_EXP = new int[]{1,1,1};
    static final int[][] TM = new int[][]{
                                    {1, 1, 1},
                                    {1, 0, 0},
                                    {0, 1, 0}};
    
    public static void main(String[] args) {
        
        int[][][] powTM = genTMPower();
        
        /*
        System.out.println("{");
        for(int i=0;i<31;i++){
            display(powTM[i], 0);
            System.out.println(",");
        }
        display(powTM[31], 0);
        System.out.println("\n}");
        System.out.println();*/
        
        int n = new java.util.Scanner(System.in).nextInt();
        System.out.println(answer(powTM, n-3));
    }
    /*
    public static int[] getSize(int[][] mat)
    {
        int n = mat.length;
        int m = mat[0].length;
        return new int[]{n,m};
    }*/
    /* function for displaying the matrix */
    /*
    public static void display(int[][] mat, int flag)
    {
        int[] size = getSize(mat);
        System.out.print("{");
        int i, j;
        for (i = 0; i < size[0]-1; i++){
            System.out.print("{");
            for (j = 0; j < size[1]-1; j++)
                System.out.print(mat[i][j] + ", ");
            
            System.out.print(mat[i][size[1]-1] + "},");
        }
        i = size[0]-1;
        System.out.print("{");
        for (j = 0; j < size[1]-1; j++)
            System.out.print(mat[i][j] + ", ");

        System.out.print(mat[i][size[1]-1] + "}}");
    }*/
    
    // return c = a * b
    static int[][] multiply(int[][] a, int[][] b){
        int m1 = a.length;
        int n1 = a[0].length;
        int m2 = b.length;
        int n2 = b[0].length;
        if(n1 != m2) throw new RuntimeException("Illegal matrix dimensions.");
        int[][] c = new int[m1][n2];
        for(int i=0;i<m1;i++)
            for(int j=0;j<n2;j++)
                for(int k=0;k<n1;k++)
                    c[i][j] += a[i][k] * b[k][j] % 10007;
        return c;
    }
    
    // matrix-vector multiplication (y = A * x)
    static int[] multiply(int[][] a, int[] x) {
        int m = a.length;
        int n = a[0].length;
        if (x.length != n) throw new RuntimeException("Illegal matrix dimensions.");
        int[] y = new int[m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                y[i] += a[i][j] * x[j] % 10007;
        return y;
    }
    
    // generate the TM power of 
    // 2^0, 2^1, 2^2, 2^3, 2^4, 2^5, 2^6, 2^7,
    // 2^8, 2^9, 2^10, 2^11, 2^12, 2^13, 2^14, 2^15,
    // 2^16, 2^17, 2^18, 2^19, 2^20, 2^21, 2^22, 2^23, 
    // 2^24, 2^25, 2^26, 2^27, 2^28, 2^29, 2^30, 2^31
    static int[][][] genTMPower(){
        int[][][] arrTM = new int[32][3][3];
        for(int i=0;i<TM.length;i++){
            for(int j=0;j<TM[0].length;j++){
                arrTM[0][i][j] = TM[i][j];
            }
        }
        for(int i=1;i<=31;i++){
            int[][] tmp = multiply(arrTM[i-1], arrTM[i-1]);
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    arrTM[i][j][k] = tmp[j][k];
                }
            }
        }
        return arrTM;
    }
    
    
    static int answer(int[][][] powTM, int n){
        int tmp = n;
        int index = 0;
        int[][] A = new int[][]{
                        {1, 0, 0},
                        {0, 1, 0},
                        {0, 0, 1}}; 
        do{
            if( (tmp&1)==1 ){
                A = multiply(A, powTM[index]);
            }
            index++;
        }while((tmp=tmp>>1)!=0);
        
        int[] ans = multiply(A, BASE_EXP);
        
        return ans[0]%10007;
    }
}
