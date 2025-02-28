package subset;

import java.io.*;
import java.util.*;

/*
 * 13C6~7 이라 안전 (왜냐면 25C13이 최대니까)
 * 
 *  거리 계산 :
 *  	1. 유클리드 거리
 *  	2. 맨해튼 거리
 * 
 */

public class 치킨배달 {

	static List<int[]> chickenList, houseList; 
	static int ans,N,M;
	
	public static void main(String[] args) throws Exception {
		
//		System.setIn(new FileInputStream("input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		chickenList = new ArrayList<>();
		houseList = new ArrayList<>();
		ans = Integer.MAX_VALUE;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				
				// 치킨집이라면
				if(tmp == 2) {
					chickenList.add(new int[] {i,j});
				}
				else if (tmp == 1) {
					houseList.add(new int[] {i,j,Integer.MAX_VALUE});
				}
			}
		}
	
		// 전체 map 에서 1를 기준으로 2와의 거리를 구한다.
		int C = chickenList.size();
		List<int[]> cur = new ArrayList<>();
		combi(0,C, cur);
	
		System.out.println(ans);
}
	
	
	private static int distance(int y1, int y2, int x1, int x2) {
		return Math.abs(y1-y2) + Math.abs(x1-x2);
	}
	
	private static void calDis(List<int[]> cur) {
		int sum = 0;
		
		for(int j = 0, size = houseList.size(); j < size; j++) {
			int hy = houseList.get(j)[0], hx = houseList.get(j)[1], hd = houseList.get(j)[2]; 
			
			for(int i = 0 ; i < M; i++) {
				int cy = cur.get(i)[0], cx = cur.get(i)[1];
				hd = Math.min(hd, distance(hy,cy,hx,cx));
			}
			sum += hd;
		}
		ans = Math.min(ans, sum);
	}
	
	// 깊이, 시작, 뽑을 개수, 전체 ChickenList 길이
	private static void combi(int start, int C, List<int[]> cur) {
		
		//모두 뽑은 상황
		if(cur.size() == M) {
			calDis(cur);
			return;
		}
		
		for (int i = start; i < C; i++) {
			int[] chicken = chickenList.get(i);
			
			cur.add(new int[] {chicken[0], chicken[1]});
			combi(i + 1, C, cur);
			cur.remove(cur.size()-1);
		}
		
	}

}
