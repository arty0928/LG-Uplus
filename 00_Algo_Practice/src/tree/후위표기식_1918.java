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
			
			switch(cur) {
				case '+':
				case '-':
				case '*':
				case '/':
					while(!stack.isEmpty() && (haveToPop(cur)) <= haveToPop(stack.peek())) {
						sb.append(stack.pop());
					}
					stack.push(cur);
					break;
				
			
				// ( 를 만나면 push 만
				case '(':
					stack.push(cur);
					break;
				
				// ) 를 만나면 ( 만날 때까지 pop 출력
				case ')':
					while(!stack.isEmpty() && stack.peek() != '(') {
						sb.append(stack.pop());
					}
					stack.pop(); // ( 제거
					break;
				
				// 알파벳은 그냥 출력
				default:
					sb.append(cur);
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
		
	}
	
	static int haveToPop(char op) {
		if(op =='(' || op == ')') {
			return 0;
		}
		
		else if (op == '+' || op =='-') {
			return 1;
		}
		
		// * /
		else {
			return 2;
		}
	}

}
