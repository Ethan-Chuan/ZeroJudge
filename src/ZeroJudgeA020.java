
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA020 {
    public static void main(String[] args) {
        String str;
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
            str = scanner.next();
            System.out.println(isIdCard(str)?"real":"fake");
        }
    }
    
    static boolean isIdCard(String str){
        int ret = letterMapping(str.charAt(0));
        ret = (ret/10) + (ret%10)*9;
        int end = str.length()-1;
        for(int i=1;i<end;i++){
            ret += Integer.parseInt(str.substring(i, i+1))*(end-i);
        }
        ret += Integer.parseInt(str.substring(end, end+1));
        return ret%10==0;
    }
    
    static int letterMapping(char chr){
        int[] mapping = new int[]{
            10,11,12,13,14,
            15,16,17,34,18,
            19,20,21,22,35,
            23,24,25,26,27,
            28,29,32,30,31,
            33
        };
        int index = chr - 'A';
        return mapping[index];
    }
}
/*
    我國的身分證字號有底下這樣的規則，因此對於任意輸入的身分證字號可以有一些基本的判斷原則，請您來判斷一個身分證字號是否是正常的號碼(不代表確有此號、此人)。

    (1) 英文代號以下表轉換成數字

          A=10 台北市     J=18 新竹縣     S=26 高雄縣
          B=11 台中市     K=19 苗栗縣     T=27 屏東縣
          C=12 基隆市     L=20 台中縣     U=28 花蓮縣
          D=13 台南市     M=21 南投縣     V=29 台東縣
          E=14 高雄市     N=22 彰化縣     W=32 金門縣
          F=15 台北縣     O=35 新竹市     X=30 澎湖縣
          G=16 宜蘭縣     P=23 雲林縣     Y=31 陽明山
          H=17 桃園縣     Q=24 嘉義縣     Z=33 連江縣
          I=34 嘉義市     R=25 台南縣

      (2) 英文轉成的數字, 個位數乘９再加上十位數的數字

      (3) 各數字從右到左依次乘１、２、３、４．．．．８

      (4) 求出(2),(3) 及最後一碼的和

      (5) (4)除10 若整除，則為 real，否則為 fake

     例： T112663836

    2 + 7*9 + 1*8 + 1*7 + 2*6 + 6*5 + 6*4 + 3*3 + 8*2 + 3*1 + 6 = 180

    除以 10 整除，因此為 real 
--------------------------------------------------------------------------------
輸入說明
    一組身分證號碼
範例輸入
    T112663836
    S154287863
--------------------------------------------------------------------------------
輸出說明
    輸出 real or fake
範例輸出
    real
    fake
*/