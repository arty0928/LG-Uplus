package tree;

import java.io.*;
import java.util.*;

/*
 *  우선 순위 : x / > + -
 * 
 * 1. 알파벳은 그냥 출력
 * 2. if ) 면 stack에서 ( 뽑을 때까지 계속 pop 해서 출력
 * 		( , ) 은 출력은 안 하고 뽑기만
 * 
 * 3. 현재 넣을 cur의 우선순위 < top 
 * 		pop 한번 해서 출력
 * 
 * 4. for문으로 문자열을 다 돌고 stack이 isEmpty 까지 pop 출력
 */

public class 후위표기식_1918 {
	
	static Deque<Character> stack;

	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		stack = new ArrayDeque<>();
		int N = line.length();
		
		for (int i = 0; i < N; i++) {
			char cur = line.charAt(i);
			
			// 1. 알파벳은 그냥 출력
			if (cur >= 'A' && cur <= 'Z') {
				sb.append(cur);
				continue;
			}
			
			// ) 를 만나면 ( 만날 때까지 pop 출력
			if (cur == ')') {
				while(!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.poll());
				}
				stack.poll(); // ( 제거
				continue;
			}
			
			// cur 의 우선순위 < peek : pop해서 출력
			if (!stack.isEmpty() 
					&& haveToPop(cur, stack.peek()) == true){
				while(!stack.isEmpty()) {
					sb.append(stack.poll());
				}
				stack.offer(cur);
				continue;
			}
			
			// 그게 아니면 그냥 stack 에 넣기
			stack.offer(cur);
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.poll());
		}
		
	}
	
	static boolean haveToPop(char cur, char top) {
		
		System.out.println("cur = " + cur + " top = " + top);
		if(cur == '*' && top == '+' || cur == '*' && top == '-') return true;
		if(cur == '/' && top == '+' || cur == '/' && top == '-') return true;
		return false;
	}

}
