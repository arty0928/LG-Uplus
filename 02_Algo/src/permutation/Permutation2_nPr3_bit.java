package permutation;
import java.util.Arrays;

// bitmask는 boolean 을 대체
// 배열을 돌면서 다 체크할 필요 없이 비트마스크의 and or로 확인

// 중복 원소를 bitmask를 이용해서 체크하기
// 9P9   : 0.009	    (안전)
// 10P10 : 0.1초 컷		(약간 위험) 
public class Permutation2_nPr3_bit {
	static long tc;					//순열 개수
	static long count;				//반복 횟수 
	static int  R;					//뽑을 개수			
	static int  N;					//원소의 개수
	static int[] numbers;			//순열을 담은 배열
	static int[] input;				//입력된 데이타 
	/**
	 * @param depth 	뽑을 원소의 위치 
	 * @param flag 	뽑을 원소의 중복 체크를 위한 flas  (bitmask 활용) 
	 */
	public static void permutation(int depth, int flag) {
		//배열은 0부터 시작이므로 R-1개가 모두 뽑은 상황. idx가 R과 동일한 상황은 순열을 다 뽑은 상황 
		if(depth == R) {
			tc++;
			//순열을 뽑은 이후의 task를 작성 
//			System.out.println(Arrays.toString(numbers));
			return ;
		}
		
		for (int i = 0; i < N; i++) {
			// 중복 검사 : bitmask 이용해서 i번째가 사용되었는지 확인
			
			System.out.println("flag = " + Integer.toBinaryString(flag) + "  i = " + i);
			
			// 1 << i 번 이동 후 flag와 &연산을 한 결과가 0이면 
			// i번째 원소는 사용을 안 했고, 0이 아니면 사용.
			
			// 0 1 0 -> 2가 되므로 == 1 로 비교하면 안된다. !=0 으로 해야 함

			if((flag & 1 << i) != 0) continue;
			
			numbers[depth] = input[i];
			
//			flag |= 1<<i;   	// 다음 순열을 뽑을 때도 여전히 사용중임을 표시한 상태
			permutation(depth + 1, flag | 1 << i); // i번 위치에 1을 추가
		}
	}
	public static void main(String[] args) {
//		input = new int[] {1,2,3,4,5,6,7,8,9,10}; //9P9 까지는 되지만 10개가 되면 0.1초 걸려서 너무 오래 걸림.
//		input = new int[] {1,2,3,4};
		input = new int[] {1,2,3};
		N = input.length;
		R = input.length;
		numbers = new int[R];	
		long start = System.currentTimeMillis();
		permutation(0, 0);
		long end = System.currentTimeMillis();
		System.out.printf("tc: %d   count:%d   time:%dms%n", tc, count, end-start);
	}
}





