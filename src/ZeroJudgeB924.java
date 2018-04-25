
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Ethan
 */
// A graph is connected when there is a path between every pair of vertices.
// This topic is guaranteed to be connected graph.
public class ZeroJudgeB924 {

    static BufferedReader br = new BufferedReader(
                                new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        // An undirected graph has an Eulerian trail if and only if
        // exactly zero or two vertices have odd degree, 
        // and all of its vertices with nonzero degree 
        // belong to a single connected component.
        String strLine;
        while ( (strLine = br.readLine()) != null ) {
            
            st = new StringTokenizer(strLine);
            int n = nextInt() + 1;
            int m = nextInt();
            //System.out.println("n : " + n + ",  m : " + m);
            
            int[] vertices = new int[n];
            int countOddDegree = 0;
            int i;

            for (i = 0; i < m; i++) {
                vertices[nextInt()]++;
                vertices[nextInt()]++;
            }

            for (i = 1; i < n; i++) {
                if ((vertices[i] & 1) == 1) 
                    countOddDegree++;
                if (countOddDegree > 2)
                    break;
            }

            System.out.println(countOddDegree == 0 || countOddDegree == 2 ? "YES" : "NO");
        }

    }
    
    static String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
