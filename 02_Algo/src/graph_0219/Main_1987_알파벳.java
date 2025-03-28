package graph_0219;

import java.io.*;
import java.util.StringTokenizer;

/* 15216 KB	160 ms
 * 2차 - 비트마스크 추가
 * 		dfs는 최악의 경우 O(N^2), dfs를 쓰는 경우는 메모이제이션
 */
public class Main_1987_알파벳 {

	static int R,C;
	static int[][] map;
	static int[][] visited;
	
	static int[] dy = {-1,1,0,0}, dx = {0,0,-1,1};
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visited = new int[R][C];
		answer = 0;
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < C; j++) {
				map[i][j] = (int) line.charAt(j) - 'A';
			}
		}
		
		dfs(0,0, 1 << map[0][0], 1);
		System.out.println(answer);
	}
	
	static void dfs(int y, int x, int bit, int cnt) {
		
		answer = Math.max(answer, cnt);
		
		if(answer == 26) return;
		
		visited[y][x] = bit;
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d], nx = x + dx[d];
			
			if(!inRange(ny,nx)) continue;
			
			// 해당 위치에 알파벳이 없고, 
			if((bit & (1 << map[ny][nx])) == 0 && 
					// 현재 bit에 next 알파벳을 추가한 것과 기존 것이 다르면 방문
					(bit | 1 << map[ny][nx]) != visited[ny][nx]) {
					
				dfs(ny,nx, bit | 1 << map[ny][nx], cnt + 1);
			}
			
		}
	}
	
	static boolean inRange(int y, int x) {
		return -1 < y && y < R && -1 < x && x < C;
	}

}


/*
 * 15448 kb	896 ms	
 */
//public class Main_1987_알파벳 {
//
//	static int R,C;
//	static char[][] map;
//	static boolean[] visited;
//	static int[] dy = {-1,1,0,0}, dx = {0,0,-1,1};
//	static int answer;
//	
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		R = Integer.parseInt(st.nextToken());
//		C = Integer.parseInt(st.nextToken());
//		
//		map = new char[R][C];
//		visited = new boolean[26];
//		answer = 0;
//		
//		for (int i = 0; i < R; i++) {
//			String line = br.readLine();
//			
//			for (int j = 0; j < C; j++) {
//				map[i][j] = line.charAt(j);
//			}
//		}
//		
//		dfs(0,0,1);
//		System.out.println(answer);
//	}
//	
//	static void dfs(int y, int x, int cnt) {
//		
//		answer = Math.max(answer, cnt);
//		
//		char cur = map[y][x];
////		System.out.println("y = " + y + "  x = " + x + "  cur = " + cur + "  cnt = " + cnt);
//		
//		visited[cur - 'A'] = true;
//		
//		for (int d = 0; d < 4; d++) {
//			int ny = y + dy[d] , nx = x + dx[d];
//			
//			if(inRange(ny,nx) && !visited[map[ny][nx]-'A']) {
//				dfs(ny,nx,cnt+1);
//				visited[map[ny][nx] - 'A'] = false;
//			}
//		}
//	}
//	
//	static boolean inRange(int y, int x) {
//		return -1 < y && y < R && -1 < x && x < C;
//	}
//
//}
