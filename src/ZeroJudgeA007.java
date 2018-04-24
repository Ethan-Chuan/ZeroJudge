
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA007 {

    // All primes less than the square root of Integer.MAX_VALUE
    static int lenP = 4792;
    static int[] prime = new int[lenP];
    
    public static void main(String[] args) {
        //writeFile();
        int num;
        Scanner scanner = new Scanner(System.in);
        
        generatePrime();
        while(scanner.hasNextInt()){
            num = scanner.nextInt();
            System.out.println(isPrime(num)?"質數":"非質數");
        }
    }
    


    // Time complexity of this solution is O(√n)
    //
    // Sieve of Eratosthenes.
    // All integers can be expressed as (6k + i) for some integer k and for i = -1, 0, 1, 2, 3, or 4; 
    // 2 divides (6k + 0), (6k + 2), (6k + 4); and 3 divides (6k + 3). 
    // So a more efficient method is to test if n is divisible by 2 or 3, 
    // then to check through all the numbers of form 6k ± 1
    //
    static void generatePrime() {
        int sqrtMaxInt = 1 + (int)Math.sqrt(Integer.MAX_VALUE);
        prime[0] = 2; prime[1] = 3;
        int end = 2;
        for(int i=5; i<=sqrtMaxInt; i=i+6){
            int pos;
            // Check that 6k-1 is prime.
            for(pos=0; pos<end && i%prime[pos]!=0; pos++);
            if(pos==end) prime[end++] = i;
            // Check that 6k+1 is prime.
            for(pos=0; pos<end && (i+2)%prime[pos]!=0; pos++);
            if(pos==end) prime[end++] = i+2;
        }
    }
    
    //
    // If num is less or equal to prime[lastIndex],
    // then check that it is inside array.
    // Otherwise, check that it is divisible by all elements in prime array.
    //
    static boolean isPrime(int num) {
        if(num<=prime[lenP-1]){
            return Arrays.binarySearch(prime, num)>=0;
        }else{
            int i;
            for(i=0; i<lenP && num%prime[i]!=0; i++);
            return i >= lenP;
        }
    }

    // Write results of prime to file.
    static void writeFile() {
        generatePrime();
        System.out.println("Prime Count : " + lenP);

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("prime.txt"), "utf-8"))) {

            writer.write("static int[] prime = new int[]{\n");
            String str = "";
            int end = lenP;
            if (end % 10 != 0) {
                end = 10 * (end / 10);
            }
            for (int i = 0; i < end; i++) {
                str += prime[i] + ", ";
                if ((i + 1) % 10 == 0) {
                    str += "\n";
                    writer.write(str);
                    str = "";
                }
            }
            for (int i = end; i < lenP; i++) {
                str += prime[i];
                if (i == lenP - 1) {
                    str += "\n};";
                } else {
                    str += ", ";
                }
            }
            writer.write(str);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        System.out.println("Write done!");
    }
}
