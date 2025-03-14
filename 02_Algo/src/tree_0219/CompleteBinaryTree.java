package tree_0219;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 완전 이진 트리(Complete Binary Tree)
 * 각 노드가 최대 2개의 자식 노드를 갖는 이진 트리로
 * 마지막 레벨을 제외한 모든 노드는 완전히 채워져 있어야 한다. 
 * 또한, 최하단 레벨의 노드는 좌측만 채워져 있거나, 좌측 우측이 모두 채워진 상태
 * 
 *     2					2							2
 *  8    12   			8		12					8		12
 *23 40				  23	   40  					  23  40
 *  (O)						(O)							(X)		
 *  
 *  
 * - heap, 세그먼트 트리는 완전 이진 트리를 이용해서 구현  
 * 		세그먼트 트리 : LinkedList에서 N번에 접근을 반복하면 시간 복잡도를 줄이기 위해 logN번으로 탐색 시 사용
 * 		heap	:  
 */
public class CompleteBinaryTree<E> {

	// 데이터를 저장할 배열
	private Object[] nodes;
	private int lastIndex;		// 현재 노드를 저장할 위치
	private final int SIZE;		// tree의 크기

	public CompleteBinaryTree(int size) {
		SIZE = size;
		
		//자식 노드를 탐색할 때, 왼쪽 자식 : *2, 오른쪽 자식 : *2 + 1 
		// = >  0인덱스 사용 안함 
		nodes = new Object[size + 1]; 
	}

	public boolean isEmpty() {
		return lastIndex == 0;
	}
	
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	public void add(E e) {
		if(isFull()) {
			System.err.println("포화 상태입니다.");
			return;
		}
		
		// 0번 인덱스는 안씀
		nodes[++lastIndex] = e;
		
	}
	
	public void inOrder(int current) {
		if (current <= lastIndex) {
			// 왼쪽 자식노드 방문처리
			inOrder(current * 2); 
			// 현재 노드 방문처리
			System.out.print(nodes[current] + " ");
			// 오른쪽 자식노드 방문처리
			inOrder(current * 2 + 1); 
		}
	}
	
	public void preOrder(int current) {
		if(current <= lastIndex) {
			// 현재 노드 방문 처리
			System.out.print(nodes[current] + " ");
			
			// 왼쪽 자식 노드 방문 처리
			preOrder(current*2);
			// 오른쪽 자식 노드 방문 처리
			preOrder(current * 2 + 1);
		}
	}
	
	
	public void postOrder(int current) {
		if(current <= lastIndex) {
			// 왼쪽 자식 노드 방문 처리
			postOrder(current*2);
			// 오른쪽 자식 노드 방문 처리
			postOrder(current * 2 + 1);
			
			// 현재 노드 방문 처리
			System.out.print(nodes[current] + " ");
		}
	}
	
	

}



