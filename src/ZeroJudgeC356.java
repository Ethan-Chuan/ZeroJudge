
import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeC356 {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int n = reader.nextInt();
        System.out.print(reader.skip(0));
        for(int i=1;i<n;i++)
            System.out.print(reader.skip(n));
        reader.close();
    }

    static class Reader {
        // If setting 10MB, the memory consume 25.6MB
        // If setting 1KB, the memory consume 1.5MB
        private final int BUFFER_SIZE = 1024; //1KB
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = 0;
            bytesRead = 0;
        }

        public int getBufferPointer() {
            return bufferPointer;
        }

        public int getBytesRead() {
            return bytesRead;
        }
        
        private void fillBuffer() throws IOException{
            bufferPointer = 0;
            bytesRead = din.read(buffer, bufferPointer, BUFFER_SIZE);
            if(bytesRead==-1){
                buffer[0] = -1;
            }
        }
        
        private byte read() throws IOException{
            if(bufferPointer == bytesRead){
                fillBuffer();
            }
            byte c = buffer[bufferPointer];
            bufferPointer++;
            return c;
        }
        
        public int nextInt() throws IOException{
            // Return -1 if there is no more data
            // because the end of the stream
            // has been reached.
            if(getBytesRead()==-1){
                return -1;
            }
            
            // Find first number

            byte c = read();
            while(c<'0' || '9'<c){
                c = read();
                if(getBytesRead()==-1){
                    return -1;
                }
            }
            
            // Find other number
            int ret=0;
            do{
                ret = ret*10 + (c - '0');
                c = read();
            }while('0'<=c && c<='9');
            
            return ret;
        }
        
        // Return the character after reading step times.
        public char skip(int step) throws IOException{
            byte c = 0;
            int count = 0;
            while(count<=step){
                c = read();
                if(getBytesRead()==-1){
                    return 0;
                }
                if(('a'<=c && c<='z') || ('A'<=c && c<='Z')){
                    count++;
                }
            }
            return (char)c;
        }
        
        public void close() throws IOException{
            if(din == null){
                return;
            }
            din.close();
        }
    }
}

/*
      2018 年  4 月 1 日成功高中大門突然多了一顆石頭，但這次並不是學校出錢所買，而是從遙遠的
    火星飛來的神秘石頭。神秘的石頭上也寫了一串文字：

    『 HDNOWEEIOWWELWDDWWLOPODWO 』，NASA 也不知道其中的含義。Justin 精通各種加密技巧，
    看一眼就知道其中真正的含義，也就是 『HELLO』。

    只要經過  T ( 5 ) 的排列，再將對角線的字即為原文～

    『

        HDNOW

        EEIOW

        WELWD

        DWWLO

        PODWO

                    』

    就成了 ->『 HELLO 』。

    所以 N 也能代表秘文長度，現在給你一串原本字串及 N ，請你輸出其中真正想表達的字串。

    記憶體只有 16 MB ！
--------------------------------------------------------------------------------
輸入說明
    單筆輸入
    第一行有一個整數 N 代表秘文長度 (1 <= N <= 5000)
    第二行一個字串，代表石頭上出現的文字 ，長度為 N * N 。
範例輸入
    5
    HDNOWEEIOWWELWDDWWLOPODWO
--------------------------------------------------------------------------------
輸出說明
    輸出只有一行。
    請輸出真正想表達的字串。
    ( 必為英文字母 A ~ Z )
範例輸出
    HELLO
*/