package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * 방문 처리 주의 - visited 혹은 dp 맵으로 방문 처리 하지 않으면 bfs로 계속 방문 -> 메모리, 시간 초과
 */


/* 14184 kb	112 ms	
 * 방문 처리 visited, cnt 포함 큐에 넣기
 */
public class Main_3055_G4_박은서 {
	
	static int R,C;
	static char[][] map;
	static boolean[][] visited;
	
	static int[] dy = {-1,1,0,0}, dx = {0,0,-1,1};

	static class player{
		int y,x,cnt;
		char type;
		
		@Override
		public String toString() {
			return "player [y=" + y + ", x=" + x + ", type=" + type + "]";
		}

		public player(int y, int x, int cnt, char type) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.type = type;
		}

	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		
		Deque<player> q = new ArrayDeque<>();
		player s = null;
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				char tmp = line.charAt(j);
			
				
				// 고슴도치
				if(tmp == 'S') {
					s = new player(i,j,0,'S');
					visited[i][j] = true;
				}
				
				//물
				else if(tmp == '*') {
					q.add(new player(i,j,0,'*'));
					visited[i][j] = true;
				}
				
				map[i][j] = tmp;
			}
		}
		
		// 고슴도치
		q.add(s);
		
		while(!q.isEmpty()) {
			
			player now = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int ny = now.y + dy[d], nx = now.x + dx[d];
				
				if(inRange(ny,nx)) {
					
					int next = map[ny][nx];
					// 고슴
					if(now.type == 'S') {
						
						if(next == 'D') {
							System.out.println(now.cnt + 1);
							return;
						}
						
						if((next == '.' || next == 'D') && !visited[ny][nx]) {
							visited[ny][nx] = true;
							q.add(new player(ny,nx,now.cnt + 1,now.type));
						}
					}
					
					// 물
					else if(now.type == '*') {
						if(next == '.' || next == 'S') {
							map[ny][nx] = '*';
							q.add(new player(ny,nx,now.cnt + 1, now.type));
						}
					}

				}
			}
			
			
		}
		
		System.out.println("KAKTUS");
	}
	
	
	static boolean inRange(int y, int x) {
		return -1 < y && y < R && -1 < x && x < C;
	}

}


/*
 * 	14332 kb	108 ms
 * 	
 * 방문처리와 cnt 동시에 하는 dp[][] 이용, 0 이면 방문 x
 * 
 */

//public class Main_3055_G4_박은서 {
//	
//	static int R,C;
//	static char[][] map;
//	static int[][] dp;
//	
//	static int[] dy = {-1,1,0,0}, dx = {0,0,-1,1};
//
//	static class player{
//		int y,x;
//		char type;
//		
//		@Override
//		public String toString() {
//			return "player [y=" + y + ", x=" + x + ", type=" + type + "]";
//		}
//
//		public player(int y, int x, char type) {
//			super();
//			this.y = y;
//			this.x = x;
//			this.type = type; //S : 고슴도치, * : 물
//		}
//		
//		
//	}
//	
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		R = Integer.parseInt(st.nextToken());
//		C = Integer.parseInt(st.nextToken());
//		map = new char[R][C];
//		dp = new int[R][C];
//		
//		Deque<player> q = new ArrayDeque<>();
//		player s = null;
//		
//		for (int i = 0; i < R; i++) {
//			String line = br.readLine();
//			for (int j = 0; j < C; j++) {
//				char tmp = line.charAt(j);
//			
//				
//				// 고슴도치
//				if(tmp == 'S') {
//					s = new player(i,j,'S');
//				}
//				
//				//물
//				else if(tmp == '*') {
//					q.add(new player(i,j,'*'));
//				}
//				
//				map[i][j] = tmp;
//			}
//		}
//		
//		// 고슴도치
//		q.add(s);
//		
//		while(!q.isEmpty()) {
//			
//			player now = q.poll();
////			print();
////			System.out.println();
////			dp();
////			System.out.println(now);
////			System.out.println();
//			
//			if(map[now.y][now.x] == 'D') {
//				System.out.println(dp[now.y][now.x]);
//				return;
//			}
//			
//			
//			for (int d = 0; d < 4; d++) {
//				int ny = now.y + dy[d], nx = now.x + dx[d];
//				
//				if(inRange(ny,nx)) {
//					
//					int next = map[ny][nx];
//					// 고슴
//					if(now.type == 'S') {
//						if((next == '.' || next == 'D') && dp[ny][nx] == 0) {
//							dp[ny][nx] = dp[now.y][now.x] + 1;
//							q.add(new player(ny,nx,now.type));
//						}
//					}
//					
//					// 물
//					else if(now.type == '*') {
//						if(next == '.' || next == 'S') {
//							map[ny][nx] = '*';
//							q.add(new player(ny,nx,now.type));
//						}
//					}
//
//				}
//			}
//			
//			
//		}
//		
//		System.out.println("KAKTUS");
//	}
//	
//	@Override
//	public String toString() {
//		return "Main_3055_G4_박은서 []";
//	}
//
//	static void print() {
//		for (int i = 0; i < R; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//	}
//	
//	static void dp() {
//		for (int i = 0; i < R; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
//	}
//	
//	
//	static boolean inRange(int y, int x) {
//		return -1 < y && y < R && -1 < x && x < C;
//	}
//
//}
