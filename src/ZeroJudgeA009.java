
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeA009 {
	
	public static void main(String[] args){
		//checkOffset();
		
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNext()){
			char[] chr = scanner.nextLine().toCharArray();
			for(int i=0; i<chr.length; i++){
				// Using checkOffset() method, we know offset is -7.
				// Converting to character after calculating.
				System.out.print( (char)(chr[i]+(-7)) );
			}
			System.out.println();
		}
	}
	
	static void checkOffset(){
		char[] cA = "1JKJ'pz'{ol'{yhklthyr'vm'{ol'Jvu{yvs'Kh{h'Jvywvyh{pvu5".toCharArray();
		char[] cB = "*CDC is the trademark of the Control Data Corporation.".toCharArray();
		for(int i=0;i<cA.length;i++){
			System.out.print(cB[i]-cA[i] + " ");
			if((i+1)%10==0){
				System.out.println();
			}
		}
		System.out.println("\n\n------------next------------\n");
		cA = "1PIT'pz'h'{yhklthyr'vm'{ol'Pu{lyuh{pvuhs'I|zpulzz'Thjopul'Jvywvyh{pvu5".toCharArray();
		cB = "*IBM is a trademark of the International Business Machine Corporation.".toCharArray();
		for(int i=0;i<cA.length;i++){
			System.out.print(cB[i]-cA[i] + " ");
			if((i+1)%10==0){
				System.out.println();
			}
		}
	}
}

/*
　　在密碼學裡面有一種很簡單的加密方式，就是把明碼的每個字元加上某一個整數K而得到密碼的字元
（明碼及密碼字元一定都在ASCII碼中可列印的範圍內）。例如若K=2，那麼apple經過加密後就變成crrng了。
解密則是反過來做。這個問題是給你一個密碼字串，請你依照上述的解密方式輸出明碼。

    至於在本任務中K到底是多少，請自行參照Sample Input及Sample Output推出來吧！相當簡單的。
--------------------------------------------------------------------------------
輸入說明
    每筆測試資料一列。每列有1個字串，就是需要解密的明碼。
範例輸入
    1JKJ'pz'{ol'{yhklthyr'vm'{ol'Jvu{yvs'Kh{h'Jvywvyh{pvu5
    1PIT'pz'h'{yhklthyr'vm'{ol'Pu{lyuh{pvuhs'I|zpulzz'Thjopul'Jvywvyh{pvu5
--------------------------------------------------------------------------------
輸出說明
    對每一測試資料，請輸出解密後的密碼。
範例輸出
    *CDC is the trademark of the Control Data Corporation.
    *IBM is a trademark of the International Business Machine Corporation.
*/