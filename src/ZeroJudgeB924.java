
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Ethan
 */

/*
* A graph is connected when there is a path between every pair of vertices.
* This topic is guaranteed to be connected graph.
*/
public class ZeroJudgeB924 {

    static Reader din;

    public static void main(String[] args) {
        int numVertices = 10000;
        int n, m, countOddDegree, i;
        int[] vertices = new int[numVertices];

        //makeSample(new int[]{4, 4, 6, 10}, new int[]{5, 6, 9, 22});
        //System.out.println(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        
        /* 
        * An undirected graph has an Eulerian trail if and only if
        * exactly zero or two vertices have odd degree, 
        * and all of its vertices with nonzero degree 
        * belong to a single connected component.
        */
        try {
            //din = new Reader("EulerPath.txt");
            din = new Reader();
            while ((n = din.nextInt()) != -1) {
                //System.out.println("bytesRead : " + din.bytesRead);
                //System.out.println("n : " + n);
                if (din.bytesRead == -1) {
                    break;
                }
                m = din.nextInt();
                //System.out.println("m : " + m);
                if (m == -1) {
                    break;
                }

                countOddDegree = 0;
                for (i = 0; i < numVertices; i++) {
                    vertices[i] = 0;
                }

                for (i = 0; i < m; i++) {
                    int a = din.nextInt();
                    int b = din.nextInt();
                    //System.out.println("a:" + a + ", b:" + b);
                    vertices[a]++;
                    vertices[b]++;
                }

                for (i = 1; i < numVertices; i++) {
                    if ((vertices[i] & 1) == 1) {
                        countOddDegree++;
                    }
                    if (countOddDegree > 2) {
                        break;
                    }
                }

                System.out.println(((countOddDegree == 0 || countOddDegree == 2) ? "YES" : "NO"));
            }
        } catch (IOException ex) {
            System.out.println("YES");
        } finally {
            try {
                din.close();
            } catch (IOException ex) {
            }
        }

    }
    
    /*
    * Fastest way to read data.
    * The max number of edges is 9999999, so it needs
    * first line and 999999999 line, and every lines 4 bytes.
    * So it at least needs 40 millions bytes buffer.
    */
    static class Reader {

        private final int BUFFER_SIZE = (1 << 25) + (1 << 24);
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException {
            if (this.bytesRead == -1) {
                return -1;
            }

            int ret = 0;
            byte c = read();
            while (c < '0' || '9' < c) {
                c = read();
            }

            do {
                ret = ret * 10 + (c - '0');
            } while ((c = read()) >= '0' && c <= '9');

            return ret;
        }

        private void fillBuffer() throws IOException {
            // If the end of stream has been reached, it return -1.
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            byte c = buffer[bufferPointer++];
            return c;
        }

        public void close() throws IOException {
            if (din == null) {
                return;
            }
            din.close();
        }
    }
    
    /*
    * Making connected graph for testing.
    */
    static void makeSample(int[] maxN, int[] maxEdge) {
        int minLength = Math.min(maxN.length, maxEdge.length);
        for (int i = 0; i < minLength; i++) {
            if (maxN[i] < 2 || 9999 < maxN[i]) {
                maxN[i] = 2;
            }
            if (maxEdge[i] < 1 || 9999999 < maxEdge[i]) {
                maxEdge[i] = 3;
            }
        }

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("EulerPath.txt"), "utf-8"))) {

            for (int i = 0; i < minLength; i++) {
                writer.write(maxN[i] + " " + maxEdge[i] + "\n");

                List<Integer> arrList = new ArrayList<>();
                List<Integer> arrListUsed = new ArrayList<>();
                for (int j = 0; j < maxN[i]; j++) {
                    arrList.add(j + 1);
                }
                Collections.shuffle(arrList);
                arrListUsed.add(arrList.remove(0));
                while (!arrList.isEmpty()) {
                    Collections.shuffle(arrList);
                    int ver1 = arrList.get(0);

                    Collections.shuffle(arrListUsed);
                    int ver2 = arrListUsed.get(0);
                    arrListUsed.add(arrList.remove(0));

                    writer.write(ver1 + " " + ver2 + "\n");
                }

                Random rand = new Random();
                for (int j = maxN[i]; j <= maxEdge[i]; j++) {
                    int ver1 = rand.nextInt(maxN[i]) + 1;
                    int ver2;
                    while ((ver2 = rand.nextInt(maxN[i]) + 1) == ver1);
                    writer.write(ver1 + " " + ver2 + "\n");
                }

                writer.write("\n");
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        System.out.println("Write done!");
    }
}

/*
    kevin 很喜歡畫畫 但是kevin畫圖有個原則 就是他只用一筆畫把圖畫完

    幾天前kevin喜歡的女生送了kevin一張圖

    這張圖上有一些點 點之間還有一些邊

    他很想幫這張圖上色

    但又必須堅守一筆畫的原則

    請你告訴kevin

    他能不能用一筆畫畫完這張圖 (( 經過所有的邊

    而且每條邊只能經過一次
--------------------------------------------------------------------------------
輸入說明
    第一行有兩個數字 n , m
    代表圖上有 n 個點  m 條邊
    接下來有 m 行
    每行有兩個數字 a b
    代表a b 兩點互相連接
    (( n < 10000 , m < 10^7 , 1 <= a , b <= n
    ((a b 間可能存在不只一條邊
    ((保證圖為連通圖
範例輸入
    4 5
    1 2
    2 4
    3 4
    3 1
    1 4

    4 6
    1 2
    2 4
    3 4
    3 1
    1 4
    2 3
--------------------------------------------------------------------------------
輸出說明
    如果可以一筆畫完成 輸出"YES"
    否則輸出"NO"
範例輸出
    YES

    NO
*/