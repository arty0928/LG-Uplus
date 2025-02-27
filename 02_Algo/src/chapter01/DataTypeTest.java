package chapter01;

/*
 * Primitive Type
 * - 자바에서 제공하는 기본 데이터 타입
 * - 변수를 위해서 할당한 공간에 실제 값이 저장된다.
 * - 정수형 : byte(1), short(2), int(4), long(8)
 * - 문자 :        char(2)
 * - 실수형 :       float(4), double(8)
 * - 논리 :  boolean
 * 
 * 
 * ReferenceType(참조 타입, 사용자 정의 테이터 타입, 객체)
 * - class, interface, enum, 배열
 * - 변수를 위해 할당된 공간에 객체를 참조할 수 있는 참조값(hashcode)가 저장.
 */
public class DataTypeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 100;
		String str = "hello"; //여기서 str는 변수, hello는 객체
		
		/*
		 * 정수의 기본 타입은 int 이다.
		 * 123 <- int 
		 * 
		 * byte, short의 변수를 연산시 int로 자동 형변환
		 * 
		 */
		byte b1 = 1;
		byte b2 = 2;
		
//		byte b3 = b1 + b2;			// 타입 에러
		int i1 = b1 + b2;			// int로 사용하거나
		byte b3 = (byte) (b1+b2);	// byte로 형변환해서 사용.
		
		long l1 = 222_222_222_222l; // int 범위를 벗어난 정수를 사용할 때는 l, L로 long임을 표시해야 한다.
		
		// 정수 / 정수 = 정수 => 5 / 2 => 2.5지만 2로 됨 (int로) => 몫을 구함
		System.out.println(5/2);
		System.out.println(5.0/2);
		System.out.println(5/2.0);
		
		int num1 = 5;
		int num2 = 2;
		
		System.out.println((double) num1/num2);
		System.out.println(num1/(double)num2);
		
		float f1 = 3.14f; // 부동소수점의 기본형은 double이라서 에러남 -> f F 붙여서 float라 명시해야
		double d2 = 3.14;
		
		// 0 ~ 1 사이의 무한의 실수가 있기 때문에 double은 8byte로 float는 4byte로 근사치를 표현
		float f2 = 65536.123456789f;
		double d3 = 65536.123456789f;
		double d4 = 0.1234567780123456789;
		
		System.out.println("f2: " + f2);		
		System.out.println("d3: " + d3);
		System.out.println("d4: " + d4);
		
		// 문자 ''
		char c1 = 'a'; // 아스키코드 : a == 0, z == 26
		char c2 = 'b';
		
		/*
		 * 숫자, 영문자, 특수기호는 ASCII 코드이므로
		 * 
		 * */
		System.out.println(c1);
		System.out.println(c2-c1); //a가 나옴 -> 아스키코드로 되어 있어서 내부적으로는 모두 숫자로 되어 있으므로
									// 문자지만 내부적으로 숫자 (0,1 이진수)로 되어 있으므로 연산이 가능.
		
		System.out.println((int)'A');
		System.out.println((int)'a');
		
		// a일 때 1칸 점프 
		// b일 때는 2칸 점프 
		// c일 때는 3칸 점프
		
		char state = 'C';
		int jump = state - 'A' + 1;
		
		System.out.println("jump = " + jump);
		
		
	}

}
