package datastructure_0214;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * Queue
 * - 저장한 순서대로 데이타를 꺼내오는 방식의 자료 구조(FIFO:First Input First Out)
 *  ex) 표 예매 시스템
 *	- offer(arg): 맨 끝에 저장 
 *  - foll()	: 맨 처음에 있는 데이타를 제거 후 리턴
 *  - peek()   	: 맨 끝에 있는 데이타를 제거 없이 리턴
 *  - isEmpty()	: 저장된 데이타가 있으면 false 없으면 true
 *  - size()	: 저장된 데이타의 개수를 리턴
 *  - contains(데이타) : 해당 데이타가 stack에 저장되어 있으면 true, 없으면 false
 */
public class QueueTest {
	public static void main(String[] args) {
		Queue<Character> queue = new LinkedList<>();
//		offer : queue에 데이타 추가 
		queue.offer('A');
		queue.offer('B');
		queue.offer('C');
		System.out.println(queue);
//		peek : 제거 없이 추출 
		System.out.println(queue.peek());
		
//		poll : 첫데이타를 삭제 하면서 추출   deQueue
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		
		System.out.println(queue.contains('A'));
		
		// 연결 리스트는 메모리에 접근할 때 앞에서부터 연결로 접근하기 때문에 크기가 커지면 최대 0.1초까지 차이가 난다.
		Queue<Character> queue2 = new ArrayDeque<>(10);
		queue2.offer('A');
		queue2.offer('B');
		queue2.offer('C');
		System.out.println(queue2.poll());
		System.out.println(queue2.poll());
		System.out.println(queue2.poll());
		
		/*
		 * PriorityQueue
		 *  - 정렬이 되는 queue
		 *  - 내부적으로 heap으로 구성되어 있다
		 *  - 저장시 시간 복잡도 logN, 추출시 시간 복잡도 logN
		 *    N개의 데이타를 저장 추출할 때 시간 복잡도 NlogN 
		 *    
		 */
		PriorityQueue<Integer> pq = new PriorityQueue<>(5);
		PriorityQueue<Top> pq1 = new PriorityQueue<>(3);

		pq1.offer(new Top(3, 1));
		pq1.offer(new Top(1, 3));
		pq1.offer(new Top(2, 2));
		pq1.offer(new Top(5, 2));
		pq1.offer(new Top(7, 2));
		
		System.out.println(pq1);
		System.out.println(pq1.poll().height);
		System.out.println(pq1.poll().height);
		System.out.println(pq1.poll().height);
		System.out.println(pq1.poll().height);
		System.out.println(pq1.poll().height);
		
		
		// offer : 큐에 추가가 성공하면 true를 반환하고, 실패하면 false를 반환
		
	}
}

class Top implements Comparable<Top> {
	int height, index;

	public Top(int height, int index) {
		super();
		this.height = height;
		this.index = index;
	}

	@Override
	public int compareTo(Top o) {
		// 오름차순 
		return this.height - o.height;
	}

	
	
}



