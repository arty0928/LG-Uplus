package chapter01;

public class BitOperater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int d = 10; 			//10진수
		int b = 0b1000;			//2진수로 표현한 8
		int o = 010;			//8진수로 표현한 8
		int h = 0x10;			//16진수
		System.out.println(b);
		System.out.println(o);
		System.out.println(h);
		
		
		// & and 		: 연산하려는 두 비트가 모두 1일때 1이고 나머지는 0
		//	     		: 특정 위치에 1이 있는지 체크 용도로 사용
		// data & 0   	: data를 0으로 초기화
		int a1 = 0b1000; 
		int b1 = 0b0010;
		int c1 = 0b1110;
		
		System.out.println(a1 & b1);
		System.out.println(Integer.toBinaryString(a1 & c1));	//1000
		System.out.println(Integer.toBinaryString(b1 & c1));	//10
		System.out.println(b1 & c1);							//2
		
		System.out.println("-------------------");
		
		// a b c d e f g
		int key   = 0b1010010; // a c f 가 있는지 확인하고 싶을 때, a c f 위치에 1 표시
		int word1 = 0b1110010;
		int word2 = 0b1110010;
		
		System.out.println(Integer.toBinaryString(key & word1));
		System.out.println((key & word1) == key);	// key와 연산해서 key와 똑같애? 그럼 key가 있는 것
		System.out.println((key & word2) == key);
		
		// | or 두 비트가 모두 0일 때만 0, 나머지는 1
		//		특정 위치에 1을 채우는 효과
		System.out.println("---------------OR 연산-------------");
		System.out.println(Integer.toBinaryString(a1 | c1));	//1110
		System.out.println(Integer.toBinaryString(b1 | c1));	//1110
		
		
		/*
		 * shift : 비트를 이동시키는 연산자
		 * data << 이동시킬 비트 수 		: 지정한 수만큼 왼쪽으로 이동
		 * 								  2^이동수 만큼 곱한 효과
		 * data >> 이동시킬 비트 수 		: 지정한 수만큼 오른쪽으로 이동
		 * 								  2^이동수 만큼 나눈 효과
		 * */
		
		System.out.println("------------ shift 연산 -------------");
		System.out.println(b << 2); // 32
		System.out.println(b >> 2); // 2
		
		//				 abcdefgh
		int checkbit = 0b00000000;
		
		
		/*
		 * XOR
		 * 		^(xor) 		: 두 비트가 같으면 0 다르면 1 ==> 토글 효과
		 * */
		int pw 			= 0b11001101;
		int salt 		= 0b10110011;
		int encoding 	= pw & salt;
		System.out.println(Integer.toBinaryString(encoding));
		
		System.out.println("------------- 비트 반전 --------------");
		// ~ 비트 반전
		int p = 0b1100;
		System.out.println(~p);
		System.out.println(Integer.toBinaryString(~p));
		System.out.println(Integer.toBinaryString(p));
		
		int p2 = -12;
		// 보수 만드는 법 : 비트 반전 후 + 1 = 2의 보수
		System.out.println(Integer.toBinaryString(p2));
		System.out.println(Integer.toBinaryString(~p2));
	}

}
