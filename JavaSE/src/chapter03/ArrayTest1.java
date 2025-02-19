package chapter03;

import java.util.Arrays;

public class ArrayTest1 {

	/*
	 * 배열
	 * 
	 * - 하나의 변수에 여러개의 공간을 할당하고 
	 * 	 동일한 타입의 데이터를 저장 관리
	 * 
	 * - 어떤 타입도 배열로 선언할 수 있고,
	 *   배열로 선언하면 Reference 타입이 된다.
	 * 
	 * - 배열 객체를 생성하면 length라는 속성을 가지게 되고
	 *   length 는 배열의 크기
	 * 
	 * - index를 통해서 접근하고 index는 0부터 시작.
	 * 	 => 접근할 수 있는 index는 0부터 length - 1까지
	 *   ==> 접근 범위를 벗어나면 ArrayIndexOutOfBoundsException 오류
	 *   
	 * - 배열을 생성하면 size를 변경 X
	 * 	 => 변경하려면 다시 생성해서 copy
	 * - 객체를 생성하면 기본 값으로 초기화
	 *   정수 : 0
	 *   실수 : 0.0
	 *   논리 : false
	 *   문자 : \u0000
	 *   객체 : null
	 * 
	 * - 선언 방법
	 * 	 DataType [ ] 변수명;			DataType 변수명 [ ] ;
	 * 
	 * 
	 * - 생성
	 *   변수명 = new DataType[size];
	 *   
	 *   
	 * - 선언 & 생성 동시에
	 *	 DataType[ ] 변수명 = new DataType[size];
	 *
	 *
	 * - 접근
	 *   변수명 [index]
	 *  
	 * - 선언 & 생성 & 할당
	 *   DataType[] 변수명 = {값1, 값2, ...} //값의 개수 만큼의 크기로 배열 생성.
	 *   
	 */
	
	public static void main(String[] args) {
		int[] a1, a2; 	//a1, a2는 1차원 int 배열
		int b1,b2[];  	//b1는 int, b2 1차원 int 배열
		int[] c1,c2[];	//c1은 1차원 int 배열, c2 2차원 int 배열
		
		int[] array = new int[3];
		for (int i = 0, size = array.length; i < size; i++) {
			System.out.printf("array[%d] : %d \n", i, array[i]);
		}
		
	}
}
