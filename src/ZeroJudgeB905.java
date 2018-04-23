import java.util.Scanner;
/**
 *
 * @author Ethan
 */
public class ZeroJudgeB905 {
    static Scanner scanner ;
    public static void main(String[] args){
        int n; //N datas
        
        scanner = new Scanner(System.in);
        n = scanner.nextInt();
        
        charAnswer(n);
    }
    
    
    static void charAnswer(int n){
        for(int i=0;i<n;i++){
            String silenced = scanner.next();
            char[] t = scanner.next().toCharArray();
            
            System.out.println(isOriginal(silenced,t)?"Yes":"No");
        }
    }
    
    static boolean isOriginal(String silenced, char[] t){
        boolean hasStarHead = silenced.startsWith("*");
        boolean hasStarTail = silenced.endsWith("*");

        if(hasStarHead){
            silenced = silenced.replaceFirst("\\*+", "");
        }
        String[] sp = silenced.split("\\*+");
        
        int arr[] = new int[]{0,0};
        
        // There is no a * at Head.
        int spFirstPos = 0;
        if(!hasStarHead){
            spFirstPos = 1;
            
            arr = judgeHead(sp[0].toCharArray(), t);
            //System.out.println("At Head,  arr[0] : " + arr[0] + ",  arr[1] : " + arr[1]);
            // Origianl sentence is not the same as silenced sentence.
            if(arr[0]==-1){
                //System.out.println("There is no a * at Head.");
                return false;
            }else{
                // At head, length of splitted sentence is equals to 1 and both string of two is the same.
                if(sp.length==1 && t.length==sp[0].length()){
                    //System.out.println("At head, length of Splitted sentence is equals to 1 and string is the same.");
                    return true;
                }
            }
        }
        
        // There is no a * at Tail
        int spLastPos=sp.length;
        int tFirstPos = arr[1];
        int tLastPos=t.length;
        if(!hasStarTail){ 
            //System.out.println("At tail.");
            if(!judgeTail(sp[sp.length-1].toCharArray(), t, tFirstPos)){
                //System.out.println("The last splitted sentence is not the same as the tail of original.");
                return false;
            }
            // At tail, length of splitted sentence is equals to 1 and both string of two is not the same.
            if(!hasStarHead && sp.length==1 && t.length!=sp[0].length()){
                //System.out.println("At tail, length  of Splitted sentence is equals to 1 and string is not the same.");
                return false;
            }
            spLastPos = spLastPos - 1;
            tLastPos = tLastPos - sp[sp.length-1].length();
        }
        
        // If length of splitted silenced sentence is equal to 1 and 
        // it is empty or null string, then the silenced sentence 
        // there is only * symbol, no other words.
        if( sp.length==1 && (sp[0].isEmpty() || sp[0].equals("")) ){
            return true;
        }
        
        // Calculating middle
        //System.out.println("spFirstPos : " + spFirstPos + ",  spLastPos : " + spLastPos + ",  t.length : " + t.length);
        //System.out.println("Before judgeMiddle,  arr[0] : " + arr[0] + ",  arr[1] : " + arr[1] + ",  tLastPos : " + tLastPos);
        for(int i=spFirstPos;i<spLastPos;i++){
            arr = judgeMiddle(sp[i].toCharArray(), t, tFirstPos, tLastPos-sp[i].length());
            //System.out.println("arr[0] : " + arr[0] + ",  arr[1] : " + arr[1] + ",  tLastPos : " + tLastPos);
            // Origianl sentence is not the same as silenced sentence.
            if(arr[0]==-1){
                return false;
            }else{
                tFirstPos = arr[1];
            }
        }

        return true;
    }
    
    static int[] judgeHead(char[] spChar, char[] original){
        int begin = 0;
        int end = spChar.length;
        
        // If length of original sentence is short than 'end',
        // it is not original.
        if(end-begin > original.length){
            return new int[]{-1,-1};
        }
        
        // If the head of silenced and original sentence is not the same,
        // it is not original.
        for(int i=begin;i<end;i++){
            if(spChar[i]!=original[i]){
                return new int[]{-1,-1};
            }
        }
        
        // Found silenced sentence the same as splitted s.
        // Return new start position.
        return new int[]{end, end};
    }
    
    
    static int[] judgeMiddle(char[] spChar, char[] original, int tFirstPos, int tLastPos){
        char first = spChar[0];
        int max = Math.min((original.length - spChar.length), tLastPos);
        
        for(int i=tFirstPos;i<=max;i++){
            // Look for first character.
            if(original[i] != first){
                while(++i <= max && original[i] != first);
            }
            
            // Found first character, now look at the rest of spChar.
            if(i <= max){
                int j = i + 1;
                int end = j + spChar.length - 1;
                for(int k=1;j<end && original[j] == spChar[k] ; j++, k++);
                
                if(j==end){
                    return new int[]{spChar.length, i+spChar.length};
                }
            }
        }
        
        return new int[]{-1, -1};
    }
    
    static boolean judgeTail(char[] spChar, char[] original, int tFistPos){  
        int lastLength = spChar.length;
        int begin = original.length-lastLength;
        int end =  original.length;
        
        // The remaining length is insufficient.
        if(begin < tFistPos){
            return false;
        }
        
        // If the tail of silenced and original sentence is not the same,
        // it is not original.
        for(int i=0;i<lastLength;i++){
            if(spChar[i]!=original[begin+i]){
                return false;
            }
        }
        
        // Found silenced sentence the same as splitted s.
        // Return true.
        return true;
    }
    

    
    /* ---------------------------------------------------------------------- */
    /* 
    * Time Limit Exceed Algorithm.
    */
    static void tleError(int n){
        String s; //Silenced sentence.
        StringBuilder t = new StringBuilder(); //Original sentence.
        for(int i=0;i<n;i++){
            s = scanner.next();
            t.append(scanner.next());
            
            System.out.println(isOriginal(s,t)?"Yes":"No");
            
            t.delete(0, t.length());
        }
    }
    
    static boolean isOriginal(String silenced, StringBuilder o){
        
        boolean hasStarHead = silenced.startsWith("*");
        boolean hasStarTail = silenced.endsWith("*");

        if(hasStarHead){
            silenced = silenced.replaceFirst("\\*+", "");
        }
        String[] sp = silenced.split("\\*+");
        
        
        /*
        * If there is no a * at head, 
        * then check that the head of s and o is the same.
        */
        int spFirstPos = 0;
        if(!hasStarHead){
            spFirstPos = 1;
            int begin = 0;
            int end = sp[0].length();
            if(end-begin > o.length()){
                return false;
            }
            if(!sp[0].equals(o.subSequence(0, sp[0].length()))){
                return false;
            }else{
                o.delete(0, sp[0].length());
                if(o.length()==0 && silenced.equals(sp[0])){
                    return true;
                }
            }
        }
        /*
        * If there is no a * at tail, 
        * then check that the tail of s and o is the same.
        */
        int spLastPos = sp.length;
        if(!hasStarTail){
            spLastPos = spLastPos-1;
            int lastLength = sp[sp.length-1].length();
            int begin = o.length()-lastLength;
            int end =  o.length();
            if(end-begin > o.length()){
                return false;
            }
            if(!sp[sp.length-1].equals(o.subSequence(begin ,end))){
                return false;
            }else{
                o.delete(begin, end);
            }
        }
        
        // If length of splitted silenced sentence is equal to 1 and 
        // it is empty or null string, then the silenced sentence 
        // there is only * symbol, no other words.
        if( sp.length==1 && (sp[0].isEmpty() || sp[0].equals("")) ){
            return true;
        }
        
        
        /*
        * Check that middle string of t whether contains substrings of splitted s.
        */
        for(int i=spFirstPos;i<spLastPos;i++){
            int begin = o.indexOf(sp[i]);
            if(begin==-1){
                return false;
            }else{
                o.delete(0, begin + sp[i].length());
            }
        }

        return true;
    }
}

/*
3
*armstrong*armstrong*
neoarmstrongcyclonejetarmstrongcannon
a
ba
qq
qaq



3
*
aa
**
a
a*b*
accbccs

1
a*bv*nm
a12313bv1546nm


1
******a*b****v******n*****m****
a12313bv1546nm

1
*armstrong*armstrong
neoarmstrongcyclonejetarmstrong

1
12*ab*ab*ab*123
12sfgfhghshgabsgfggf123


1
*a*aaa*aaaaaa*a
jsdkjaajfaakdjksaaaaafjkjdkaaaaaajieup313a

1
*a*aaa*aaaaaa*a
jsdkjaajfaakdjksaaaaafjkjdkaaaaaa

1
a*a**aaaa*
ajbdsfjipaafjkciuaaajdifwopgnduiaaa


1
a*a**aaaa*b
ajbdsfjipajkdiweafjkciuaaajdifwopgnduiaaaab


1
*a
aba

1
*a
abb

1
*b
aba

1
a*
aba

1
b*
aba

1
a
aba

1
ba
aba

1
ba*
aba

1
*ba
aba

1
abc
abc







1
a*a
ahja

1
a*a
aagjajaaajfkda

1
*a*a
aa

1
*a*a
agjwua

1
*a*a
rupdafjkdaafjkdjaafurupdjfa

1
a*a*
aa

1
a*a*
ajjjuieaeaaa

1
*a*a*
aa

1
*a*a*
rujdafjdkuoea

1
*a*a*
aaaaarupefjkd
*/