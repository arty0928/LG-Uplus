package greedy_0220;

import java.io.BufferedReader;

/*
 * 
 * 1. N X N 을 다 돌면서 1인 갯수를 더하기.
 * 		그 총 갯수가 N X N 갯수가 아니라면 재귀
 * 
 * 		sum = 0 		-> 모두 0
 * 		sum = N X N 	-> 모두 1
 * 
 * 
 */
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2630_S2_색종이만들기 {
	
	static int N, blue, white;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		 N = Integer.parseInt(in.readLine());
		 
		 map = new int[N][N];
		 blue =0; white =0;
		 
		 for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		 
		 backtrack(0,0,N);
		 System.out.println(white);
		 System.out.println(blue);
	}
	
	static void backtrack(int y, int x, int size) {

		/*
		 * 제일 좌측 상단이 기준
		 * 	만약 현재 파티션이 모두 같은 색상이라면
		 * 	현재 색상을 1 증가시키고 
		 * 반환
		 */
		
		if(check(y,x,size)) {
			
			int color = map[y][x];
			
			if(color == 1) {
				blue++;
			}
			else {
				white++;
			}
			return;
		}
		
		
		int half = size >> 1;
		backtrack(y, x, half);
		backtrack(y, x + half, half);
		backtrack(y + half, x, half);
		backtrack(y + half, x + half, half);
	
		
	}
	
	static boolean check(int y, int x, int size) {
		int color = map[y][x];
		
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if(map[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}
}