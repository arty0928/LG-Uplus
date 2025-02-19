package two_pointer;

import java.io.*;
import java.util.*;

/* 32716 KB	 320 ms
 * 
 * 3차 - HashSet 
 * 		hashSet도 hashmap과 함께 탐색 : O(1)
 * 		=> 시간은 hashMap과 비슷, value를 가지고 있지 않아서 공간 복잡도는 더 좋음.
 */

public class 두_수의_합_3273_S3_ {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
//		Map<Integer,Integer> hm = new HashMap<>();
		Set<Integer> hs = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			hs.add(Integer.parseInt(st.nextToken()));
		}
		
		int X = Integer.parseInt(br.readLine());
		
		int count = 0;
		
		for (int k : hs) {
			if(hs.contains(X-k)) {
				count++;
			}
		}
		
		System.out.println(count / 2);
	}

}



/* 27728 KB	368 ms	
 * 
 * 2차 풀이 - two-pointer O(NlogN)
 * 
 * 		1 ) 정렬 		O(NlogN)
 * 		2 ) 투 포인터 	O(N)
 */

//public class 두_수의_합_3273_S3_ {
//
//	public static void main(String[] args) throws Exception {
//// TODO Auto-generated method stub
//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//int N = Integer.parseInt(br.readLine());
//
//StringTokenizer st = new StringTokenizer(br.readLine());
//Map<Integer,Integer> hm = new HashMap<>();
//
//for (int i = 0; i < N; i++) {
//	int tmp = Integer.parseInt(st.nextToken());
//	hm.putIfAbsent(tmp, 0);
//}
//
//int X = Integer.parseInt(br.readLine());
//
//int count = 0;
//for (int key : hm.keySet()) {
//	if(hm.containsKey(X-key)) {
//		count++;
//	}
//}
//
//System.out.println(count / 2);
//}
//
//}


/* 32808 KB	320 ms
 * 
 * 1차 풀이 - HashMap O(N)
 * 
 */

//public class 두_수의_합_3273_S3_ {
//
//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		Map<Integer,Integer> hm = new HashMap<>();
//		
//		for (int i = 0; i < N; i++) {
//			int tmp = Integer.parseInt(st.nextToken());
//			hm.putIfAbsent(tmp, 0);
//		}
//		
//		int X = Integer.parseInt(br.readLine());
//		
//		int count = 0;
//		for (int key : hm.keySet()) {
//			if(hm.containsKey(X-key)) {
//				count++;
//			}
//		}
//		
//		System.out.println(count / 2);
//	}
//
//}
