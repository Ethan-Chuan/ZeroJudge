
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
