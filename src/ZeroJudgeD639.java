
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

/*
    企鵝村村長裡諾有三個兒子
    大哥小米企鵝，企鵝村首席巫師，擅長黑暗魔法、冰魔法
    二哥小波企鵝，祭司，擅長神聖魔法
    三弟小皮企鵝，魔弓手，擅長製作附有魔法的箭
    由於在練功狂大哥小米企鵝的督促之下，
    小波企鵝和小皮企鵝無奈的只好一起練功。
    三隻企鵝每天的經驗值，如果排成一條數列的話，
    剛好會像是這樣：
    1 1 1 , 3 5 9 , 17...
    前三個數字是第一天小皮、小波、小米的經驗值
    中間三個數字是第二天三企鵝的經驗值
    以此類推
    這條數列的規則就是，從第四項開始的值，都是前三項的和…
--------------------------------------------------------------------------------
輸入說明
    每個測資點僅一個整數n，1<=n<=2147483647
範例輸入
    8
--------------------------------------------------------------------------------
輸出說明
    請輸出第n項的值。(請視第一項、第二項、第三項為1，無第0項)
    由於數字可能很大，請將結果mod10007後輸出
範例輸出
    31
*/