package divideconquer_0220;

/**
 * Divide Conquer (분할 정복)
 * 분할 : 해결할 문제를 여러 개의 작은 부분으로 나눈다. 
 * 정복 : 나눈 작은 문제를 각각 해결한다. 
 * 통합 : (필요하다면) 해결된 해답을 모은다.
 * 
 * ex) 머지정렬, 퀵정렬, 이진검색
 */
public class PowerTest {
	public static long powerRec(int x, int n) {
		if(n == 1 ) return x;
		return x * powerRec(x, n-1);
	}
	
	
	static int cnt;
	public static long dcPower(int x, int n ) {
		cnt ++;
		if(n == 1) return x;
		if(n == 0) return 1; 
		
		long let = dcPower(x, n >> 1); //2로 나눔
		
		// 짝수
		if(n%2 == 0) {
			return let * let;
		}
		
		// 홀수
		else {
			return let * let * x;
		}
	}
	
	public static void main(String[] args) {
//		6268685802422096249
//		System.out.println(powerRec(9, 2111111111));
		
		long result = 1;
		int n = 9;
		
		// 21억
		//	시퀀스하게 연산을 하기 때문에 21억번 반복 O(N)의 시간 복잡도
		for (int i = 0; i < 2_111_111_111; i++) {
			result *= n;
		}
		System.out.println(result);

		// 위의 계산은 21억번, 너무 오래 걸림
		// 분할 정복으로 해보자
		//		logN의 시간 복잡도 (절반으로 계속 줄이기)
		System.out.println(dcPower(9, 2111111111));
		System.out.println(cnt); // 31번만 호출
		
		
		
		
		
//		System.out.println(dcPower(9, 2111111111));
//		System.out.println(powerRec(4, 4));
//		System.out.println(dcPower(4, 4));
//		System.out.println(16*16);
	}
}













