package greedy_0220;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 많은 점수를 받기 위해 
 * 데드라인이 짧은 과제 중 점수가 높은 것부터 해결하기.
 */
public class Main_13904_G3_과제_greedy {
	
	static int deadline,score;

	public static void main(String[] args) throws Exception {
		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	     int N = Integer.parseInt(in.readLine());

	     
//	     1. 과제와 점수를 담을 PQ를 선언한다.                                                                          
//	        과제들을 데드라인이 짧고 점수을 오름차순으로 정렬한다.                                                                
//	        점수 PQ를 사용하는 이유: 데드라인은 좀 느리지만 점수가 높다면 어떤것을 하는게 더 좋은지 비교해야 하므로
	     
	     //int[] 0 : 데드라인, 1 : 점수
	     PriorityQueue<int[]> homework = new PriorityQueue<>(new Comparator<int[]>() {
	    	 
	    	 @Override
	    	 public int compare(int[] a, int[] b) {
	    		 int result = a[0] - b[0]; // 데드라인 오름차순
	    		 
	    		 // 데드라인이 같으면 점수 내림차순
//	    		 if(result == 0) {
//	    			 return b[1] - a[1];
//	    		 }
//	    		 
//	    		 return result;

	    		 return result == 0? b[1]-a[1] : result; // 데드라인 같으면 점수 내림차순
	    	 }
	     
	     });
	     
	     
//	     2. 데이타 입력 받기. 
	     for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			deadline = Integer.parseInt(st.nextToken());
			score = Integer.parseInt(st.nextToken());
			
			homework.offer(new int[] {deadline,score});
			
		}
	     
	     // 선택한 과제의 점수 PQ , Comparator를 지정하지 않으면 오름차순 정렬
	     PriorityQueue<Integer> scorePQ = new PriorityQueue<>();
	     
//	     3. 모든 과제들을 탐색 시도                                    
	     while(!homework.isEmpty()) {
//	        3.1 과제를 꺼내와 점수PQ의 size 와 과제 데드라인을 비교한다.                                                       
//	            ==> 점수 PQ의 size == 단위 시간 == 데드라인                                                          

	    	 int[] hw = homework.poll();
	    	 int d = hw[0];
	    	 int s = hw[1];
	    	 
	    	 if(scorePQ.size() < d) {
//	        3.2 데드라인보다 PQ size가 작다면 해당 과제는 수행할 수 있는 과제 이므롷                                                
//	            바로 점수PQ에 넣는다.                                                                             
	    		 scorePQ.offer(s);
	    	 }else {
//	        3.3 데드라인이 같거나 크다면 점수PQ의 가장 낮은 점수와 비교해서                                                        
//	            현재 과제의 점수가 높다면  기존 낮은 점수를 제거하고 현재 과제의 점수를 넣는다.                                            
//	                                                                                                      
	    		 if(scorePQ.peek() < s) {
	    			 scorePQ.poll(); 		// 기존의 낮은 점수 없애고
	    			 scorePQ.offer(s); 		// 현재 과제의 점수를 넣는다.
	    		 }
	    	 }
	    	 
	     }
//	     4. 점수를 합계를 내고 출력한다.  
	     int result = 0;
	     for (Integer integer : scorePQ) {
			result += integer;
		}
	     
	     System.out.println(result);

	}

}
