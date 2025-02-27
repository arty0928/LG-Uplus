package recursive;

/*
 * 재귀함수
 * 		: 함수 내에서 해당 함수를 또 호출
 * 
 * 모든 for문은 재귀로 바꿀 수 있지만, 모든 재귀는 for문으로 바꿀 수는 없다.
 * 
 * for문은 다시 호출하려면 for문을 열고 수정해야 한다. ( 호출 횟수가 정해질 때)
 * 재귀는 depth를 랜덤으로 정할 수 있다. -> 반복의 depth를 알 수 없을 때 사용한다.
 * 		(반복의 depth는 인자 or 배열오 depth를 컨트롤)
 * 		
 * 		- 기저조건
 * 			: 재귀 함수를 중단하는 조건
 * 
 * 		- 유도파트
 * 			: 재귀 함수를 진행하는 파트
 * 
 */

public class RecursiveCallTest2 {
	
	static int N = 10;
	
	// bottom-up 
	public static int sum1(int n) {
		if(n == N) return n;
		
		return n + sum1(n+1);
	}
	
	// top - down
	public static int sum2(int n) {
//		System.out.println("n = " + n);
		if(n == 1) return n;
		
		return n + sum2(n-1);
	}

	
	//factorial recursive
	// bottom - up
	public static int fact1(int n) {
		
		if(n == N) return n;
		
		return n * fact1(n+1);
	}
	
	// top - down
	public static int fact2(int n) {
		if(n == 1) return 1; //마지막이 1이면 n이 아니라 1이 빠름.
							// 변수에 접근하는 것보다 빠름	
		
		return n * fact2(n-1);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum = 0;
		
		for (int i = 1; i <= N; i++) {
			sum += i;
		}
		System.out.println(sum);
		System.out.println(sum1(1));
		System.out.println(sum2(10));
		
		System.out.println(" --------- 팩토리얼 for문 ---------- ");
		
		int sum1 = 1;
		for (int i = 1; i <= N; i++) {
			sum1 *= i;
		}
		System.out.println(sum1);
		
		System.out.println(" --------- 팩토리얼 bottom-up ---------- ");
		System.out.println(fact1(1));

		System.out.println(" --------- 팩토리얼 top-down ---------- ");
		System.out.println(fact2(N));
		
	}

}
