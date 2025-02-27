package graph_0219;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * stack 
 * 	1. while 현재 인덱스 위치 값 > stack.꼭대기 인덱스 위치의 값:
 * 		pop() 위치 <- cur
 * 
 * 	2. push
 * 
 * 
 *  3. 맨 마지막에 stack에 남은 인덱스는 모두 -1
 */

//152056 kb	788 ms
public class Main_17298_오큰수_prc {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		Deque<Integer> stack = new ArrayDeque<>();
		int[] input = new int[N];
		int[] result = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.fill(result, -1);
		for (int i = 0; i < N; i++) {
			
			while(!stack.isEmpty() && input[stack.peek()] < input[i]) {
				result[stack.pop()] = input[i];
			}
			stack.push(i);
		}

		
		for (int i : result) {
			
//			sb.append(i + " ");		//이렇게 하면 string을 추가하므로 시간 더 길어짐
			sb.append(i).append(" "); 
		}
		
		System.out.println(sb);
		br.close();
	}

}
