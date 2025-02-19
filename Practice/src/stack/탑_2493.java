package stack;

import java.util.*;
import java.io.*;


/*
 * 132172 KB   2348 ms
 * 2차 - 스택 : 배열 앞에서부터 접근
 * 	
 * 	- 해당 인덱스 탑에 접근했을 때,
 * 	  스택의 peek 값 : 해당 인덱스의 탑이 보낸 신호를 받는 탑의 인덱스
 * 
 * 
 */
public class 탑_2493 {

	public static void main(String[] args) throws Exception {
		
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//선언
		Deque<Integer> stack = new ArrayDeque<>();
		int[] result = new int[N];
		
		//스택 풀이
		for (int i = 0; i < N; i++) {
			
			int cur = arr[i];
			
			while( !stack.isEmpty() && cur > arr[stack.peek()] ) {
				stack.pop();
			}
			
			
			//int 배열의 초기값이 0 이므로 보낼 수 있는 경우만 update
			if(!stack.isEmpty()) {
				result[i] = stack.peek() + 1;
			}
			
			stack.push(i);
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(result[i]+" ");
		}

	}

}


/*
 * 132224KB	2508ms
 *
 * 	1차 - 스택 : 
 * 		- 해당 인덱스 위치에서 받아지는 탑들
 * 		  해당 인덱스의 위치에서 스택에 저장되어 있는 모든 탑들은 해당 인덱스의 탑에 신호를 보냄.
 * 
 * 		- 배열 뒤에서부터 접근	
 *
public class 2493_G5_탑_박은서 {

	public static void main(String[] args) throws Exception {
		
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//선언
		Deque<Integer> stack = new ArrayDeque<>();
		long[] result = new long[N];
		
		//스택 풀이
		for (int i = N-1; i > -1; i--) {
			
			int cur = arr[i];
			
			while( !stack.isEmpty() && cur > arr[stack.peek()] ) {
				result[stack.pop()] = i + 1;
			}
			
			stack.push(i);
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(result[i]+" ");
		}

	}

}

*/