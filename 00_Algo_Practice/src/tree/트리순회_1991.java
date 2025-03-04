package tree;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 트리순회_1991 {

	static int N;
	static Node[] nodes;
	
	static class Node{
		char word;
		Node left;
		Node right;
		
		public Node(char word) {
			super();
			this.word = word;
			this.left = null;
			this.right = null;
		}

		@Override
		public String toString() {
			return "  word=" + word + ", left=" + left + ", right=" + right;
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nodes = new Node[N + 1];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			char mid = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			if(nodes[mid - 'A'] == null) {
				nodes[mid - 'A'] = new Node(mid);
			}
			
			// 왼쪽 노드가 존재하는 경우
			if(left != '.') {
				nodes[left - 'A'] = new Node(left); 		// 생성
				nodes[mid - 'A'].left = nodes[left - 'A'];  // 연결
			}
			
			// 오른쪽 노드가 존재하는 경우
			if(right != '.') {
				nodes[right - 'A'] = new Node(right);
				nodes[mid - 'A'].right = nodes[right - 'A']; 
			}
			
			
		}
		
		preOrder(nodes[0]);
		System.out.println();
		inOrder(nodes[0]);
		System.out.println();
		postOrder(nodes[0]);
	}
	
	static void inOrder(Node node) {
		
		if(node == null) return;
			
		inOrder(node.left);
		System.out.print(node.word);
		inOrder(node.right);
		
	}
	
	static void preOrder(Node node) {
		if(node == null) return;
		
		System.out.print(node.word);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	static void postOrder(Node node) {
		if(node == null) return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.word);
	}

}
