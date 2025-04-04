package greedy_0220;

import java.io.*;
import java.util.*;

/**
 * 많은 점수를 받기 위해 
 * 데드라인이 짧은 과제 중 점수가 높은 것부터 해결하기.
 * 
 * 1. PQ에 과제 데드라인 오름차순, 점수 내림차순 
 * 2. PQ를 돌면서
 * 		선택 PQ (오름차순)
 * 		1. 선택 PQ 사이즈 < N : 아직 더 넣을 수 있다.
 * 			넣고 continue;
 * 		2. 선택 PQ 사이즈 == N : (이미 다 차있다)
 * 			맨 앞에서 부터 == 제일 score가 작은 애부터 빼기
 * 
 * 3. 선택 PQ 돌면서 누적 합.
 */

public class Main_13904_G3_과제_prc {
	
	static int deadline,score;

	public static void main(String[] args) throws Exception {
		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	     int N = Integer.parseInt(in.readLine());
	     StringTokenizer st;
	     
	     PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
	    	 
	    	 @Override
	    	 public int compare(int[] o1, int[] o2) {
	    		 int result = o1[0] - o2[0]; 
	    		 
	    		 // 데드라인이 같다면 점수 내림차순
	    		 return result == 0 ? o2[1] - o1[1] : result; 
	    	 }
	     });
	     
	     for (int i = 0; i < N; i++) {
	    	 st = new StringTokenizer(in.readLine());
	    	 
	    	 int d = Integer.parseInt(st.nextToken());
	    	 int s = Integer.parseInt(st.nextToken());
	    	 
	    	 pq.offer(new int[] {d,s});
		}
	    
	     PriorityQueue<Integer> scorePQ = new PriorityQueue<>();
	     
	     while(!pq.isEmpty()){
	    
	    	 int[] cur = pq.poll();
	    	 int d = cur[0], s = cur[1];
	    	 
	    	 // 아직 다 안 찼으면 넣기
	    	 // d 가 1이고 scorePQ가 비었다면 첫째 날에 과제를 할 수 있다
	    	 if(scorePQ.size() < d) {
				scorePQ.offer(s);
			}
	
	    	 /*
			    	  선택 pq가 다 찼거나 더 커진다면 제일 작은 scorePQ.peek과 비교
			    	  s > scorePQ.peek 이면 peek 빼고 넣기
			    	 scorePQ에 이미 들어가 있는 애들은 현재 d 보다 데드라인이 빠른 애들. (PQ에 넣을 때 데드라인 오름차순으로 정렬했기 때문)
			    	 그럼 새로운 score를 넣을지 말지를 선택하기 위해
			    	 scorePQ에 있는 제일 작은 점수와 비교.

	    	  */

	    	 
	    	 else {
	    		 
	    		 if(scorePQ.peek() < s) {
	    			 scorePQ.poll(); // 점수가 제일 낮은 것 뽑기
	    			 scorePQ.offer(s);
	    		 }
	    	 }
		}
	     
	     int result = 0;
	     for (Integer integer : scorePQ) {
			result +=integer;
		}
	     
	     System.out.println(result);
	     
	}
	
	static void print(PriorityQueue<Integer> pq) {
		for (int s : pq) {
			System.out.print(s + " ");
		}
		
		System.out.println();
	}

}
