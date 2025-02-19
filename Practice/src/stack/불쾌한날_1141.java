package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 불쾌한날_1141 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> stack = new ArrayDeque<>();
//		int[] count = new int[N];
		long result = 0;
		
		for(int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			
			// tmp 보다 더 작은 애가 있으면 안됨
			while(!stack.isEmpty() && stack.peek() <= tmp) {
				stack.pop();
			}
			
//			count[i] = stack.size();
			result += stack.size();
			stack.push(tmp);
		}
		
//		System.out.println(Arrays.toString(count));
		System.out.println(result);
		

	}

}
