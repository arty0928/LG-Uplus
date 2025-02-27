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

public class RecursiveCallTest {
	
	static int N = 10;
	
	// bottom-up 
	public static void print(int num) {
		if(num > N) return;
		System.out.print(num+" ");
		print(num + 1);
	}
	
	// top - down
	public static void print2(int num) {
		if(num == -1) return;
		System.out.print(num +" ");
		print2(num - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < N; i++) {
			System.out.print(i+" ");
		}
		System.out.println();
		print(0);
		System.out.println();

		// top-down
		for (int i = N; i > -1; i--) {
			System.out.print(i + " ");
		}
		System.out.println();
		print2(N);
		
		
//		int sum = 0;
//		for (int i = 1; i < N + 1; i++) {
//			sum += i;
//		}
//		System.out.println("for : " + sum);
//		System.out.println("가우스 : " + (N+1)*N/2);
////		System.out.println(sum1(1));
		
	}

}
