package greedy_0220;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * 1차 - PQ + hm
 * 		PQ에 데드라인 오름차순, 컵라면 내림차순으로 정렬.
 * 		하루에 한 개 씩 가능 -> 데드라인을 key로 두고 PQ 돌면서 
 * 			hm에 contains : 기존 value와 비교 후 업데이트
 * 					
 * 				else: hm.add(d,s)	
 * 						score 누적
 */
public class Main_1781_G2_컵라면 {
	
	static int deadline,score;

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
	    
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
	    	 
			@Override
			public int compare(int[] o1, int[] o2) {
				
				int result = o1[0] - o2[0];
				
				return result == 0 ? o2[1] - o1[1] : result;
			}
	     });
	     
	     for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			pq.add(new int[] {d,s});
		}

	     PriorityQueue<Integer> scorePQ = new PriorityQueue<>();
	     
	     while(!pq.isEmpty()) {
	    	 int[] cur = pq.poll();
	    	 int d = cur[0], s = cur[1];
	    	 
	    	 if(scorePQ.size() < d) scorePQ.offer(s);
	    	 else {
	    		 if(scorePQ.peek() < s) {
	    			 scorePQ.poll();
	    			 scorePQ.offer(s);
	    		 }
	    	 }
	     }
	     
	     long result = 0;
	     for (Integer integer : scorePQ) {
			result += integer;
		}
	     System.out.println(result);
	}

}
