package tree;

import java.io.*;
import java.util.StringTokenizer;

public class 트리순회_1991 {

	static int lastIndex, level;
	static char[] nodes;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		level = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int i = 0; i < level; i++) {
			st = new StringTokenizer(br.readLine());
			
			char mid = st.nextToken().toCharArray()[0];
			char left = st.nextToken().toCharArray()[0];
			char right = st.nextToken().toCharArray()[0];			
			
		}

	}
	
	static void inOrder(int current) {
		
		if(current <= lastIndex) {
			
			inOrder(current * 2);
			
			System.out.print(nodes[current]);
			
			inOrder(current * 2 + 1);
		}
	}

}
