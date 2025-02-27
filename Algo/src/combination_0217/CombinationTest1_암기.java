package combination_0217;

import java.util.Arrays;
import java.util.Scanner;



/**
 * [순열 - 암기]
 * 
 * 25C12,13		=> 35ms		안전 조합수 : 5,200,300
 * 
 * 26C10		=> 35ms		안전 조합수 : 5,311,735
 * 
 * 26C13		=> 80ms   	위험	조합수 : 10,400,600  ==> 백트레킹을 시도
 * 27C14		=> 200ms	위험	==> 백트레킹을 시도	
 * 30C15  		=> 1.2초 컷  안됨 1억 5천   
 */
public class CombinationTest1_암기 {
	static int testcase;
	static int n;
	static int r;
	static int[] numbers;	//뽑은 r개 수의 조합을 저장할 배열
	static int[] input;		//입력된 N개의 데이타
	static int count;
	public static void main(String[] args) {
		
		// input : 4 2 1 2 3 4
//		Scanner scan = new Scanner(System.in);
//		n = scan.nextInt();
//		r = scan.nextInt();		
//		input 	= new int [n];
//		numbers	= new int [r];
//		
//		for (int i = 0; i < n; i++) {
//			input[i] = scan.nextInt();
//		}
//		
		n = 27;
		r = 13; //r이 n의 절반이면 가지치기 해야 함. r이 n의 절반일 때 가장 많은 경우
		input 	= new int [n];
		numbers	= new int [r];
		for (int i = 0; i < n; i++) {
			input[i]= i+1;
		}
		
		long start = System.currentTimeMillis();
		combi(0, 0);
		long end = System.currentTimeMillis();
		System.out.printf("%dC%d 조합의 수:%d  time:%d  count:%d <= %d%n",n,r,testcase, end-start,count, testcase*r);
	}
	/**
	 * 
	 * @param depth   뽑은 수를 저장할 index 위치
	 * @param start 뽑을 수의 index 위치
	 */
	private static void combi(int depth, int start) {
	
		//모두 뽑은 상황
		if(depth == r) {
//			testcase++;
			return;
		}
		
		for (int i = start; i < n; i++) {
			numbers[depth] = input[i];
			
			combi(depth + 1, i + 1);
		}
		
	}
}
