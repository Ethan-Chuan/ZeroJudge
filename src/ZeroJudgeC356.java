
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
