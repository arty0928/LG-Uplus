package subset_0218;

import java.util.Arrays;


/*
 * 이중 for 문 BitMask
 */

public class SubsetTest2 {
	static String[] input= "abcd".split("");;
	static int N= input.length;
	static int[] subset;
	
	public static void main(String[] args) {
//		N=20;
//		input = new String[N];
		subset =  new int[N];
//		for (int i = 0; i < N; i++) {
//			input[i] = (char)('a'+i)+"";
//		}
		long stime = System.currentTimeMillis();
		
		/*
		 * subset의 개수는 2의 n승 개이므로 
		 * 0 : 원소를 선택 안함    1:원소를 선택함      
		 * 
		 * 0      0000:  원소 하나도 선택안한 서브셋
		 * 1      0001:  맨 끝의 원소 하나를 선택한 서브셋
		 * 2      0010:  맨 끝에서 두번째 원소 하나를 선택한 서브셋   
		 * 3      0011:  맨 끝의 두개의 원소를 선택한 서브셋 
		 * ...
		 * size-1 1111 : 모든 원소를 선택한 서브셋    
		 * 
		 * 결국 0 ~ 2^n-1까지 수의 bit를   1은 선택 0은 비선택으로  하면   수 자체가 부분 집합이 된다. 
		 * 수에서 bit값이 1인지를 확인해서 부분집합으로 표현하자
		 * 
		 * 시간 복잡도  2^n*n
		 *
		 */
		
		
	// 시간 복잡도 : ( 2 ^ N ) * N	(이중 for문)
		// 1 << N == 2 ^ N
		for (int i = 0, size = 1 << N ; i < size; i++) {
//			 i라는 숫자 자체가 부분 집합 (subset)  
//				=> i를 이진수로 표현해서 bit 하나가 0이면 해당 원소 선택 X, 1이면 선택
			
//			bit 하나가 원소에 대한 선택 여부를 의미하므로 모든 bit를 다 확인 할 필요 없이
//			원소 개수만 확인하면 된다. (N개의 비트)
//			O(N)
			for (int j = 0; j < N; j++) {
				
//				if((i  & 1 << j) != 0 ) {
//					subset[j] = 1;
//				}
				
				subset[j] = (i >> j) & 1;
				System.out.println("j = "  + j + " i = " + i);
			}
			print();
			
		}
		
		long etime = System.currentTimeMillis();
		System.out.printf("%dms\n", etime-stime);
	}
	
	public static void print() {
		System.out.print("[");
		for (int i = 0; i <N; i++) {
//			System.out.print(subset[i]+" ");
			if(subset[i]==1)
				System.out.print(input[i]+" ");
		}
		System.out.println("]");
	}
}






//package subset_0218;
//
//import java.util.Arrays;
//
//
///*
// * 이중 for 문 BitMask
// */
//
//public class SubsetTest2 {
//	static String[] input= "abcd".split("");;
//	static int N= input.length;
//	static int[] subset;
//	
//	public static void main(String[] args) {
//		N=20;
//		input = new String[N];
//		subset =  new int[N];
//		for (int i = 0; i < N; i++) {
//			input[i] = (char)('a'+i)+"";
//		}
//		long stime = System.currentTimeMillis();
//		
//		/*
//		 * subset의 개수는 2의 n승 개이므로 
//		 * 0 : 원소를 선택 안함    1:원소를 선택함      
//		 * 
//		 * 0      0000:  원소 하나도 선택안한 서브셋
//		 * 1      0001:  맨 끝의 원소 하나를 선택한 서브셋
//		 * 2      0010:  맨 끝에서 두번째 원소 하나를 선택한 서브셋   
//		 * 3      0011:  맨 끝의 두개의 원소를 선택한 서브셋 
//		 * ...
//		 * size-1 1111 : 모든 원소를 선택한 서브셋    
//		 * 
//		 * 결국 0 ~ 2^n-1까지 수의 bit를   1은 선택 0은 비선택으로  하면   수 자체가 부분 집합이 된다. 
//		 * 수에서 bit값이 1인지를 확인해서 부분집합으로 표현하자
//		 * 
//		 * 시간 복잡도  2^n*n
//		 *
//		 */
//		
//		// 1 << N == 2 ^ N
//		for (int i = 0, size = 1 << N ; i < size; i++) {
////			 i라는 숫자 자체가 부분 집합 (subset)  
////				=> i를 이진수로 표현해서 bit 하나가 0이면 해당 원소 선택 X, 1이면 선택
//			
////			bit 하나가 원소에 대한 선택 여부를 의미하므로 모든 bit를 다 확인 할 필요 없이
////			원소 개수만 확인하면 된다. (N개의 비트)
//			for (int j = 0; j < N; j++) {
//				
//				if((i  & 1 << j) != 0 ) {
//					subset[j] = 1;
//				}
//				
//			}
////			print();
//			
//			// 출력하고 난 후, 다음 부분 집합을 구하기 위해서 subset을 0으로 초기화.
//			Arrays.fill(subset, 0);
//		}
//		
//		long etime = System.currentTimeMillis();
//		System.out.printf("%dms\n", etime-stime);
//	}
//	
//	public static void print() {
//		System.out.print("[");
//		for (int i = 0; i <N; i++) {
////			System.out.print(subset[i]+" ");
//			if(subset[i]==1)
//				System.out.print(input[i]+" ");
//		}
//		System.out.println("]");
//	}
//}
//
//
//
//
