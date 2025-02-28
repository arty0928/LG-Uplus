package chapter03;

import java.util.Arrays;

/*
 * 다차원 배열
 * 		선언시, 접근, 생성 : [] 차원
 * 
 * 
 * 선언 & 생성 & 할당		: {} 차원
 * 
 * 
 */


public class ArrayTest2 {

	public static void main(String[] args) {
//							 	 행 열
		int[][] array1 = new int[2][3];
		
		int[][] array2 = {  {1,2,3}, 
							{3,4,6}};
		
		
		int[][] asign = array2; //array2 전체를 asign에 대입
		
		for (int i = 0, size = asign.length; i < size; i++) {
			System.out.println(Arrays.toString(asign[i]));
		}
		
		int[] asign2 = array2[0];
		System.out.println(Arrays.toString(asign2));
		
		// 자바는 행마다 다른 열의 개수를 유지할 수 있다.
		int[][] arrays3 = new int[3][]; //행 갯수는 반드시 주어져야 함
		arrays3[0] = new int[2];
		arrays3[1] = new int[5];
		arrays3[2] = new int[1];
		
		for (int i = 0; i < arrays3.length; i++) { //행 반복
			for (int j = 0; j < arrays3[i].length; j++) { //열 반복
				System.out.printf("arrays[%d][%d] : %d \n ", i, j, arrays3[i][j]);
			}
			System.out.println();
		}
		
		int[][] a1 = {{1,2,3},
					{1},
					{3,4,5}};
		
	}

}
