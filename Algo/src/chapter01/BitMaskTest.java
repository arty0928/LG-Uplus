package chapter01;

public class BitMaskTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Bit Mask 
		 * 	- 기존의 bit를 & | ^ << >> 를 이용해서 다른 값으로 변경 (masking)
		 * 
		 * int a = 0b1000;
		 * int b = 0b0010;
		 * 
		 * a &= b; // 0000  1이었던 비트가 0으로 masking 됨.
		 * a |= b; // 1010  0이었던 비트가 1로 masking 됨.
		 * 
		 * - 정수의 이진수 표현을 자료 구조로 쓰는 기법 => boolean 배열을 대체하는 효과
		 * - 보통 어떤 비트가 1이면 '켜져 있다, true,  해당 위치에 원소가 있다.'
		 * 				  0이면 '꺼져 있다, false, 해당 위치에 원소가 없다.
		 * 
		 * - 장점
		 * 1. 수행 시간이 빠르다.
		 * 2. 비트 마스크 연산은 bit 연산 (& | ^ ~ ) 이므로 O(1)로 구현되는 것이 많다.
		 * 	  ==> 다른 자료 구조(boolean 배열)를 이용하는 것보다 빠르게 동작.
 		 * 
 		 * 
 		 * 예시 ) 10만개의 word에 a k g 가 있는지 check
 		 * 		 10만 * work 의 크기 => bitmask 이용하면 10만 O(N) 으로 성능 개선.
		 *		 O(N * word 크기)   => O(N)으로 개선
		 *		
		 *		
		 *		//10만 * work 의 크기
		 *
		 *		int result = 0 ;
		 *		for(int i = 0; i < 10만; i++){
		 *			int count = 0;
		 *			for(int j = 0; size = word.length(); j < size; j++){
		 *				if(word.charAt(j) =='a' || word.charAt(j) == 'k' || word.charAt(j) == 'g'){
		 *					count++;
		 *				}
	 *				}
	 *				
	 *				if(count == 3){
	 *					result++;
	 *				}
		 *		}
		 *
		 *		
		 *		// bitmask 이용하면 10만으로 성능을 높일 수 있다. => O(N)
		 *		int result = 0;
		 *
		 *		for(int i = 0 ; i < 10만; i++){
		 *
		 *			if(word & key == key){    //key위치에 1로 and 연산을 하면 나머지는 0으로 채우는 뜻, word == key 면 키가 있다는 소리.
		 *				result++;
		 *			}
		 *		}
		 *
		 *
		 * 3. 코드가 짧다.
		 * 		boolean 배열을 모두 순회해서 체크하는 코드가 bit 연산 하나로 대체 될 수 있으므로 코드가 간결해진다.
		 * 
		 * 4. 메모리 사용량이 적다.
		 * 		ex ) 문이 잠긴 행, 열로 구성된 map에서 key(a b c d e f) 를 이용해서 문을 열어야 도착점으로 탈출 할 수 있는 경우 방문 체크 배열
		 * 			 [행][열][a][b][c][d][e][f] 배열 선언			// 8차원 필요? ==> 이거 못 품.
		 * 
		 * 			
		 * 			bitmask 사용 시
		 * 			[행][열][key] 		// 3차원 배열 
		 * 
	     */
		
		
		// 1. 공집합과 꽉 찬 집합 구하기
		/*
		 * A = 0 ; 				// 32개의 원소 (int)가 모두 0이므로 공집합
		 * n = 10; 				// 원소가 10개인 
		 * A = (1<<n)-1;		// 꽉찬 집합
		 */
		
		int n = 10;			// 0000000001 << 10 
		int A = (1<<n) -1;  //10000000000  -  1 = 1111111111

		System.out.println(Integer.toBinaryString(A));
		
		
		// 2. 특정 위치에 1이 있는지 check로 & 사용
		/*
		 * & and : 연산하려는 두 비트가 모두 1일때 1이고 나머지는 0
		 * 		 : 특정 위치에 1이 잇는지 체크 용도, data & 0 => 0으로 초기화
		 */
		int a1 = 0b1000; 
		int b1 = 0b0010;
		int c1 = 0b1110;
		
		System.out.println(a1 & b1);
		System.out.println(Integer.toBinaryString(a1 & c1));	//1000
		System.out.println(Integer.toBinaryString(b1 & c1));	//10
		System.out.println(b1 & c1);							//2
		
		
		// 3. 원소 추가 : k번째 위치에 원소를 추가(1로 마스킹)
		/*
		 * A |= (1<<k)
		 * 
		 * k 번째는 뒤에서부터 세기 (0반째 부터~)
		 */
		
		A = 0;
		int k = 5;
		A |= (1<<k);
		System.out.println(Integer.toBinaryString(A)); //100000
		
		/*
		 * 파란색은 자동 형변환, 빨간색은 명시적 형변환 필요.
		 * boolean은 어떤 타입도 형 변환이 안된다.
		 * 
		 */
		
		
		/*
		 * 4. 원소 삭제
		 * 		k번째의 위치에 있는 원소를 삭제(0으로 만들어준다.)
		 * 		A &= ~(1<<k)
		 */
		A &= ~(1<<k);
		System.out.println(Integer.toBinaryString(A));
		
		/*
		 * 5. 마지막 1의 위치 찾기
		 * 		A&-A  : A의 인지수에서 1의 마지막 위치를 찾기  ==> 펜위 트리 구현 시 사용
		 * 		  -A  : A를 음수로 (값을 반전시키고 1을 더한 값)
		 */		
		 System.out.println("---------- 마지막 1의 위치 찾기 -----------");
		A = 0b1100111000;
		System.out.println(Integer.toBinaryString(A));
		System.out.println(Integer.toBinaryString(A&-A));
		
		int m = 0b11010;
		System.out.println(Integer.toBinaryString(m));
		System.out.println(Integer.toBinaryString(m&-m));
		
		
		/*
		 * 6. 최소 원소 지우기 ==> 모든 부분 집합 순회에 응용
		 * 		A & (A-1)
		 */
		System.out.println(" ---------- 6. 최소 원소 지우기 -----------  ");
		System.out.println("A : "+Integer.toBinaryString(A));
		System.out.println("A : " +Integer.toBinaryString(A & (A-1)));
		
		
		String[] str = {"a", "b", "c", "d"};
		
		
		/*
		 * 7. 모든 부분 집합 순회하기
		 * 		1101 : 총 3개의 원소를 가짐
		 * 		1100 : 총 3개의 원소 중 2개만 1,,
		 */
		System.out.println("--------- 7. 모든 부분 집합 출력 ----------");
		int s = 0b1101;
		System.out.println("원래 s : " + Integer.toBinaryString(s));
		for (int subset = s; subset != 0; subset=(subset-1) & s) {
			System.out.println(Integer.toBinaryString(subset));
		}
		
		
		
	}

}
