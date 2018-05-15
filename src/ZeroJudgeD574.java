
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeD574 {
    public static void main(String[] args) {
        int n;
        String str;
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            // The use of try-catch is due to errors in the topic data.
            try{
                n = scanner.nextInt();
                str = scanner.next();
            }catch(Exception e){
                str = scanner.next();
                n = 0;
                int i = 0;
                for(char chr:str.toCharArray()){
                    if(chr>='0'&&chr<='9'){
                        n = n*10 + (chr-'0');
                        i++;
                    }else{
                        break;
                    }
                }
                str = str.substring(i);
            }
            System.out.println(Magic(str)+"\n");
        }
    }
    
    
    static String Magic(String str){
        char[] arrChr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        char base = arrChr[0];
        int count = 0;
        
        for(int i=0;i<arrChr.length;i++){
            if(base==arrChr[i]){
                count++;
            }else{
                // Append number and character.
                sb.append(count);
                sb.append(base);
                // Reset
                base = arrChr[i];
                count = 1;
            }
        }
        // Last term
        sb.append(count);
        sb.append(base);
        
        // Return shortest string
        if(arrChr.length > sb.length())
            return sb.toString();
        else
            return str;
    }
}
