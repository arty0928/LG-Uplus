package Queue;

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

// 1168 요세푸스 2 : 플레티넘3 나중에 풀기

/* 14860 KB	132ms
* 4차 - 반복해서 q에 넣지 않고, mod를 사용하여 k번째 위치 값을 빼기
*/
public class 요세푸스문제_1158_박은서 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new LinkedList<>();

		for(int i = 1; i < N + 1; i++) {
			list.add(i);
		}
		/*
		 * 원형으로 돌면서 K번째 인덱스일 때 뺀다.
		 */
		int rank = K;
		sb.append("<");
		
		for(int i = 0; i < N; i++) {
			
			sb.append(list.remove(rank-1));
			
			/*
			 * rank + K
			 * 		-1 : 방금 빠진 사람
			 * 		-1 : 사람은 1부터지만, 인덱스는 0부터
			 * 
			 * N - i - 1
			 * 		-i : 지금까진 빠진 횟수
			 * 		-1 : 사람은 1부터지만, 인덱스는 0부터
			 * 
			 */
			if(i < N - 1) {
				rank = (rank + K - 1 -1 ) % (N-i-1) + 1;
				sb.append(", ");
			}
		}
		sb.append(">");
		
		System.out.println(sb);
	}

}

/* 15304 KB	 228 ms
* 3차 - k for문으로 처리하기
* 		 - poll 한 후, 변수에 저장하지 않고 바로 뒤에 넣기
*/
//public class 요세푸스문제_1158_박은서 {
//
//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		int N = Integer.parseInt(st.nextToken());
//		int K = Integer.parseInt(st.nextToken());
//		
//		List<Integer> list = new LinkedList<>();
//
//		Deque<Integer> q = new ArrayDeque<>(N);
//		for(int i = 1; i < N + 1; i++) {
//			q.add(i);
//		}
//		
//		/*
//		 * 원형으로 돌면서 K번째 일때는 정답에 넣고, 아니면 계속 Q에 넣는다.
//		 */
//		while (!q.isEmpty()) {
//			
//			for (int i = 1; i < K; i++) {
//				q.offer(q.poll());
//			}
//			list.add(q.poll());
//			
//		}
//		
//		String result = list.toString().replace("[", "<").replace("]", ">");
//		
//		System.out.println(result);
//	}
//
//}


/* 
 * 293928 KB	464 ms	
 * 2차 - 불필요한 자료구조 제거, 시간 단축
 */

//public class 요세푸스문제_1158_박은서 {
//
//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		int N = Integer.parseInt(st.nextToken());
//		int K = Integer.parseInt(st.nextToken());
//		
//		List<Integer> list = new LinkedList<>();
//
//		Deque<Integer> q = new ArrayDeque<>(N);
//		for(int i = 1; i < N + 1; i++) {
//			q.add(i);
//		}
//		
//		/*
//		 * 원형으로 돌면서 K번째 일때는 정답에 넣고, 아니면 계속 Q에 넣는다.
//		 */
//		int count = 0;
//		while (!q.isEmpty()) {
//			int tmp = q.poll();
//			count++;
//			
//			if(count == K) {
//				count = 0;
//				list.add(tmp);
//			}else {
//				q.offer(tmp);
//			}
//			
//		}
//		
//		String result = list.toString().replace("[", "<").replace("]", ">");
//		
//		System.out.println(result);
//	}
//
//}


/*
 * 294100 KB	500 ms	
 * 1차 - 큐
 * 		- 큐에 넣고 앞에서부터 뺀다.
 * 		- 뺄 때마다 count++
 * 		- count == K 인 경우, 더 이상 뒤에 넣지 않고 list에 추가
 * 		  아닌 경우, 큐에 다시 넣음.
 * 
 * 
 */

//public class 요세푸스문제_1158_박은서 {
//
//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		int N = Integer.parseInt(st.nextToken());
//		int K = Integer.parseInt(st.nextToken());
//		
//		List<Integer> list = new LinkedList<>();
//		
//		Deque<Integer> q = new ArrayDeque<>(N);
//		for(int i = 1; i < N + 1; i++) {
//			q.add(i);
//		}
//		
//		/*
//		 * 원형으로 돌면서 K번째 일때는 정답에 넣고, 아니면 계속 Q에 넣는다.
//		 */
//		int count = 0;
//		while (!q.isEmpty()) {
//			int tmp = q.poll();
//			count++;
//			
//			if(count == K) {
//				count = 0;
//				list.add(tmp);
//			}else {
//				q.offer(tmp);
//			}
//			
//		}
//		
//		String result = "<" + list.stream()
//							.map(String::valueOf)
//							.collect(Collectors.joining(", ")) + ">";
//		
//		System.out.println(result);
//	}
//
//}
