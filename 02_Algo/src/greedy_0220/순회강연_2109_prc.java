package greedy_0220;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import javax.print.attribute.standard.PrintQuality;

public class 순회강연_2109_prc {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				int result = o1[0]-o2[0];
				
				return result == 0 ? o2[1] - o1[1] : result;
			}
			
		});

		
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {d,p});
		}

		PriorityQueue<Integer> scorePQ = new PriorityQueue<>();
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int d = cur[0], p = cur[1];
			
			
			// 아직 날짜가 남으면 넣기
			if(scorePQ.size() < d) {
				scorePQ.offer(p);
			}
			else {
				if(scorePQ.peek() < p) {
					scorePQ.poll();
					scorePQ.offer(p);
				}
			}
			
		}
		
		int result = 0;
		
		for (Integer integer : scorePQ) {
			result += integer;
		}
		
		System.out.println(result);
		
		

	}

}
