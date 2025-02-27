package subset_0218;

import java.util.Arrays;
/**
 * subset의 개수는 2의 n승 개이므로 
 * 0 : 원소를 선택 안함    1:원소를 선택함      
 * 
 * 0      0000:  원소 하나도 선택안한 서브셋
 * 1      0001:  맨 끝의 원소 하나를 선택한 서브셋
 * 2      0010:  맨 끝에서 두번째 원소 하나를 선택한 서브셋   
 * 3      0011:  맨 끝의 두개의 원소를 선택한 서브셋 
 * ...
 * 
 * => 0 ~ 3 숫자 자체가 부분집합, -> 부분집합에 비트마스크 응용 가능
 * 
 * size-1 1111 : 모든 원소를 선택한 서브셋    
 * 
 * 시간 복잡도 2^n
 */
public class SubsetTest1 {
	static String[] input= "abcd".split("");
	public static void main(String[] args) {
		int[] subset = new int[input.length];
		
		for (int i = 0; i <2; i++) {
			subset[0] = i;
		
			for (int j = 0; j <2; j++) {
				subset[1] = j;
			
				for (int k = 0; k < 2; k++) {
					subset[2] = k;
				
					for (int l = 0; l < 2; l++) {
						subset[3] = l;
						print(subset);
//						System.out.println(Arrays.toString(subset));
					}
				}
			}
		}
	}
	private static void print(int[] subset) {
		
		System.out.println("subset = " + Arrays.toString(subset));
		
		int k =0;
		System.out.print("[");
		for (int s : subset) {
			
			// 0 이 아니면 -> 선택된 상태
			if(s!=0) {
				System.out.print(input[k]+" ");
			}
			
			k++;
			
		}
		System.out.println("]");
	}
}












