package bfs_dfs;

import java.io.*;
import java.util.*;
/*
 * 밖에서부터 돌면서 Q에 넣기, next가 1이면 큐에 넣기
 * 
 */
public class Main_2638_G3_치즈 {
	
	static int N,M;
	static int[][] map;
	static int[] dy = {-1,1,0,0}, dx = {0,0,-1,1};
 	static int cheeseCnt ;
 	static boolean[][] visited;
 	static List<int[]> list = new ArrayList<>();
 	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map =new int[N][M];
		cheeseCnt = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) {
					cheeseCnt++;
					list.add(new int[] {i,j});
				}
			}
		}
		
		visited = new boolean[N][M];
		
		int time = 0;
		while(cheeseCnt != 0) {
			for(int i = 0; i < N; i++) {
				Arrays.fill(visited[i], false);				
			}
			bfs(0,0);	// 외부 찾기
			melt();
			
			for(int i = 0; i <N; i++) {
				System.out.println(Arrays.toString(map[i]));
			}
			
			time++;
		
		}
		
		System.out.println(time);
	}
	
	// 외부 공기와 2개 이상 닿아있는지
	static boolean canMelt(int y, int x) {
		int count = 0;
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d], nx = x + dx[d];
			
			System.out.println("ny = " + ny + " nx = " + nx);
			if(inRange(ny,nx)) {
				if(map[ny][nx] == 2) count++; 
			}

			// -1의 개수가 2개 이상이면 
			if(count >= 2) {
				return true;
			}
		}
		
		return false;
	}
	
	// 1인 위치에서 사방 검사하여 녹을 치즈는 list에 저장하여 업데이트
	static void melt() {
	    for (int i = list.size() - 1; i >= 0; i--) {
	        int[] cur = list.get(i);
	        int cy = cur[0], cx = cur[1];
	        
	        System.out.println("-----------------");
	        System.out.println("cy = "+ cy + " cx = "  + cx);
	        System.out.println();
	        if (canMelt(cy, cx)) {
	        
	        	cheeseCnt--;
	            map[cy][cx] = 2;
	            list.remove(i);
	        
	        }
	    }
	}

	// 외부 공간을 2로 채우기
	static void bfs(int y, int x) {
		
		visited[0][0] = true;
		map[0][0] = 2;
		
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {y,x});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int ny = cur[0] + dy[d], nx = cur[1] + dx[d];
				
				if(inRange(ny,nx) && !visited[ny][nx] && map[ny][nx] == 0) {
					map[ny][nx] = 2;
					visited[ny][nx] = true;
					q.add(new int[] {ny,nx});
				}
				
			}
		}
		
		System.out.println("bfs");
		for(int i = 0; i <N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
		
	}
	
	static boolean inRange(int y, int x) {
		return -1 <y && y < N && -1 < x && x < M;
	}

}
