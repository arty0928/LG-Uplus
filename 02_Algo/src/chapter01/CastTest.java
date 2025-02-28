package chapter01;

/*
 *  형변환 (Cast)
 *  - 데이터 타입을 변환
 *  - 논리(boolean) 타입은 어떤 타입으로도 형변환이 안된다.
 *    어떤 타입도 논리 타입으로 형변환이 안된다.
 *   
 *  - 자동 형변환
 *  	JVM 에서 자동으로 형변환
 *  	byte => short => int => long => float => double
 *  			 char 
 *  
 *  - 명시적 형변환
 *  	자동으로 형변환 안되므로 명식적으로 형변환을 한다.
 *  	형식 ] (변환타입)값 ;
 *  
 *  
 */
public class CastTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b1 = 127;
		short s1 = b1;
		int i1 = s1;
		long l1 = i1;
		float f1 = l1;
		float f2 = 222_222_222_2l;
		double d1 = f2;
		System.out.println("f2 :" + f2);
		System.out.println("d1 :" + d1);
		
		char c1= 'a';
		int i2 = c1;
		
		System.out.println("i2 :" + i2);
		
		float f3 = (float) d1;
		long l3 = (long) f3; //long으로 바뀌면 소수부 버림 (반올림이 아니라 무조건 버림)
		System.out.println("l3 : " + l3);
		int i3 = (int)l3;
		
		System.out.println("i3 :" + i3); 
		//음수가 출력됨. 
		// : long으로 표시했을 때 8byte의 앞의 4byte는 제거된 후 남은 4byte의 첫 비트가 1인 경우 음수로 표현
		//   자바는 맨 앞 비트는 '부호'를 의미. 1이면 음수
		
		short s3 = (short)i3;
		System.out.println("s3 : " + s3);
		byte b3 = (byte) s3;
		System.out.println("s3 : " +Integer.toBinaryString(s3));
		System.out.println("b3 : " +b3);
		
		char c3 = (char)s3;
		System.out.println("c3 : " + c3);
		
		s3 = (short)c3;
		System.out.println("s3 : " + s3);
		
		s3 = (short)c3;
		System.out.println("s3 : " + s3);
		
		
		
	}

}
