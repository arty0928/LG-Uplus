package chapter01;

public class Test {

	//main 함수 : 프로그램의 시작점
	public static void main(String[] args) {

		// 줄바꿈
		//window : \n\r 
		//linux, unix : /r
		
		/*
		 * printf(format, data)
		 * 
		 *  %d : 정수
		 *  %f : 실수  %.2f (소수점 2자리까지)
		 *  %s : 문자열
		 *  %c : 문자
		 *  %b : 논리
		 *  %n : new line (엔터효과) 
		 */
		
		System.out.printf("안녕하세요 저는 %s이고 나이는 %d입니다.\n", "uplus", 26);
		
		double pi = 3.14159265;
		System.out.printf("PI :  %.3f%n", pi);
		
		// 문자열 + anyType, anyType + 문자열 => 문자열이 된다.
		String name = "pes";
		int age = 26;
		System.out.println("제 이름은 " + name + age +"입니다");
		
		
		/*
		 * 문자열은 변경할 수 없다.
		 * 그래서 + 연산을 하면 기존의 객체를 버리고 새로 생성 <= 성능 저하
		 * 
		 * StringBuilder를 이용한다.
		 * 
		 */
		
		StringBuilder sb = new StringBuilder(100); // 배열의 크기가 100인 StringBuilder 생성
		//append() : 저장된 내용의 맨 끝에 추가
		
		sb.append("hello ");
		sb.append("world ");
		sb.append("java");
		System.out.println(sb);
		
		
		
		
		
	}

}
