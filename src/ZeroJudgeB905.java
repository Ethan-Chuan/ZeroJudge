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
        
        tleError(n);
    }
    
    
    static void answer(int n){
        char[] t;
        String[] sp;
        for(int i=0;i<n;i++){
            String slienced = scanner.next();
            t = scanner.next().toCharArray();
            
            boolean hasStarHead = slienced.startsWith("*");
            boolean hasStarEnd = slienced.endsWith("*");
            
            if(hasStarHead){
                slienced = slienced.replaceFirst("\\*+", "");
            }
            sp = slienced.split("\\*+");
            
            boolean isOriginal = true;
            if(!sp[0].equals("") && !sp[0].isEmpty()){
                int[] arr = judgeHead(hasStarHead, sp[0].toCharArray(), t,  0);
                if(arr[0]==-1){
                    isOriginal = false;
                }else{
                    if(sp.length==1){
                        if(!hasStarEnd){
                            if(hasStarHead){
                                // Has at least one star at Head and Has no star at Tail.
                                 isOriginal = judgeEnd(hasStarEnd, sp[0].toCharArray(), t, 0);
                            }else{
                                 if(t.length!=arr[1]){
                                    // Has no star at Head and Tail.
                                    isOriginal = false;
                                }
                            }
                        }
                    }else{
                        if(!hasStarEnd){
                             isOriginal = judgeEnd(hasStarEnd, sp[sp.length-1].toCharArray(),  t,  t.length-sp[sp.length-1].length());
                        }
                        if(isOriginal){
                            for(int j=1;j<sp.length-1;j++){
                                arr = judgeMiddle(sp[j].toCharArray(), t,  arr[1]);
                                if(arr[0]==-1){
                                    isOriginal = false;
                                    break;
                                }
                            }
                            if(isOriginal){
                                if(hasStarEnd){
                                    isOriginal = judgeEnd(hasStarEnd, sp[sp.length-1].toCharArray(),  t,  arr[1]);
                                }else{
                                    if(arr[1]>t.length-sp[sp.length-1].length()){
                                        isOriginal = false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            
            System.out.println(isOriginal?"Yes":"No");
        }
    }
    
    static int[] judgeHead(boolean hasStar, char[] s, char[] t, int posT){
        int posS, nextPosT ;
        if(hasStar){
            return judgeMiddle(s, t, posT);
        }else{
            posS = s.length;
            nextPosT = s.length;
            for(int i=0;i<s.length;i++){
                if(s[i]!=t[i+posT]){
                    posS = -1;
                    nextPosT = -1;
                    break;
                }
            }
        }
        return new int[]{posS, nextPosT};
    }
    
    
    static int[] judgeMiddle(char[] s, char[] t, int posT){
        int posS=0, nextPosT=0 ;
        for(int i=posT;i<t.length;i++){
            if(s[posS]==t[i]){
                posS++;
                if(posS==s.length){
                    nextPosT = i+1;
                    break;
                }
            }else{
                posS = 0;
            }
        }
        if(posS != s.length){
            posS = -1;
            nextPosT = -1;
        }
        return new int[]{posS, nextPosT};
    }
    
    static boolean judgeEnd(boolean hasStar, char[] s, char[] t, int posT){
        boolean isOriginal = true;
        
        if(hasStar){
            int arr[] = judgeMiddle(s, t, posT);
            if(arr[0]==-1){
                isOriginal = false;
            }
        }else{
             int currentPosT = t.length - s.length;
             for(int i=0;i<s.length;i++){
                if(s[i]!=t[currentPosT+i]){
                    isOriginal = false;
                    break;
                }
            }
        }
        
        return isOriginal;
    }
    

    
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
    
    static boolean isOriginal(String s, StringBuilder o){
        String[] sp = s.split("\\*");
        
        /*
        * If there is no a * at head, 
        * then check that the head of s and o is the same.
        */
        if(!s.startsWith("*")){
            int begin = 0;
            int end = sp[0].length();
            if(end-begin > o.length()){
                return false;
            }
            if(!sp[0].equals(o.subSequence(0, sp[0].length()))){
                return false;
            }else{
                o.delete(0, sp[0].length());
                if(o.length()==0 && s.equals(sp[0])){
                    return true;
                }
            }
        }
        /*
        * If there is no a * at tail, 
        * then check that the tail of s and o is the same.
        */
        if(!s.endsWith("*")){
            int lastLength = sp[sp.length-1].length();
            int begin = o.length()-lastLength;
            int end =  o.length();
            if(end-begin > o.length()){
                System.out.println(end-begin + ",  " +  o.length());
                return false;
            }
            if(!sp[sp.length-1].equals(o.subSequence(begin ,end))){
                return false;
            }else{
                o.delete(begin, end);
            }
        }
        /*
        * Check that middle string of t whether contains substrings of splitted s.
        */
        for(int i=1;i<=sp.length-2;i++){
            if(sp[i].isEmpty() || sp[i].equals("")){
                continue;
            }
            
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
ajbdsfjipajkdiweafjkciuaaajdifwopgnduiaaa


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