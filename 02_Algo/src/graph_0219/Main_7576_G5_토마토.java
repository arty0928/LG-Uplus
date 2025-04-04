package graph_0219;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 	111400 KB	580ms
public class Main_7576_G5_토마토 {

	static int N, M ;
	static int[] dy = {-1,1,0,0}, dx = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[M][N];
		Deque<int[]> q = new ArrayDeque<>();
		int answer = 0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) q.add(new int[] {i,j,0});
			}
		}
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0], x = cur[1], dis = cur[2];
			
			answer = Math.max(answer, dis);
			
			int ny, nx = 0;
			for (int d = 0; d < 4; d++) {
				ny = y + dy[d]; nx = x + dx[d];
				
				if(inRange(ny,nx) && map[ny][nx] == 0) {
					map[ny][nx] = dis + 1;
					q.add(new int[] {ny,nx,dis+1});
				}
				
			}
			
		}
		
		top:
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) {
					answer = -1;
					break top;
				}
			}
		}

		System.out.println(answer);
		
		
	}
	
	static boolean inRange(int y, int x) {
		return -1 <y && y < M && -1 < x && x < N;
	}

}
