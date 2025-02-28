package subset_0218;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 
 * @author 
 * 재귀 
 * 	시간 복잡도 2^n
 *
 */
public class SubsetTest3_암기 {
	static int N, totalCnt;
	static int[] input;
	static int[] numbers;
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		numbers = new int[N];
//		input = new int[N];
//		for (int i = 0; i < N; i++) {
//			input[i] = sc.nextInt();
//		}
		
		
		N = 21;
		numbers = new int[N];
		input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = i + 1;
		}
		long start = System.currentTimeMillis();
		subset(0,0);
		long end = System.currentTimeMillis();
		System.out.printf("총 경우의 수 : %d  시간 : %dms ", totalCnt, end - start);
		
	}
	
	/*
	 *  [ subset에서는 이거 암기 ]
	 * depth : 
	 * len   : 부분 집합에서 실제 선택한 원소수 ( 부분집합의 원소 수 )
	 */
	private static void subset(int depth, int len) {
		
		// 모든 원소에 대해서 선택했냐 안 했냐를 확인하여 subset 생성
		// depth == N 일 때 1개의 subset 완성
		if(depth == N) {
			// subset이 완성됐으므로 필요한 코드 작성
			totalCnt++;
			
			// copyOfRange(배열, start, 길이) , start 부터 len 길이만큼 배열 복사
//			System.out.println(Arrays.toString(Arrays.copyOfRange(numbers, 0, len)));
			return;
		}
		
	// 오름차순
//		// 원소 비선택
//		subset(depth + 1, len);
//		
//		// 원소 선택
//		numbers[len] = input[depth];
//		subset(depth + 1, len + 1);

		
	// 내림차순
		// 원소 선택
		numbers[len] = input[depth];
		subset(depth + 1, len + 1);
		
		// 원소 비선택
		subset(depth + 1, len);
	}
}
