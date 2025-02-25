

package graph_0219;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * 
 * 
 * [ 어려웠던 점 ] 
 * 
 * 1. 문제에서 모서리는 지우고, 구멍은 남기는데
 * 	  모서리와 구멍을 어떻게 구분?
 * 
 * 	 => 치즈말고 공기 기준
 * 
 *   1) 외부 테두리 (0인 것을 넣고 bfs로 0이면 q에 넣고, 1이면 -1로 바꿔서 테두리 표시)
 *   2) 
 * 
 * 
 * 
 * DFS 
 * 		1. Origin, New map을 만든다.
 * 		2. for문 돌면서 방문 x && 1이면 dfs 시작.
 * 			lastCount += cnt;
 * 		
 * 		dfs
 * 			방문처리
 * 			사방 처리 :
 * 				!방문 && 1이면 
 * 					cnt ++;
 * 					dfs()
 * 				
 */
public class Main_2636_G4_치즈_prc {

	static int[][] originMap;
	static boolean[][] visited;
	static int N,M;
	static int count;
	
	static int[] dy = {-1,1,0,0}, dx = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		originMap = new int[N][M];

		count = 0; 		// 현재 치즈 개수
		int turn = 1;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < M; j++) {
				originMap[i][j] = Integer.parseInt(st.nextToken());
				
				if(originMap[i][j] == 1) count++;
			}
		}
		
		for (int j = 0; j < N; j++) {
			System.out.println(Arrays.toString(originMap[j]));
		}
		
		System.out.println("first count = " + count);
		System.out.println("-------------------");
		int lastCount = 0;
		
//		while(count != 0) {
	
			turn++;
			
			Deque<int[]> outQ = new ArrayDeque<>();
			outQ.add(new int[] {0,0});
			
				                                                                   
//			
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(originMap[i]));
//			}
//			System.out.println();

			lastCount = count;
			
			// 2. -1 인 것은 2로 바꾸고 갯수만큼 count--;
			while(!outQ.isEmpty()) {
				int[] cur = outQ.poll();
				
				

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
				
						if(originMap[i][j] == -1) {
							originMap[i][j] = 2;
							count--;
						}
						
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				System.out.println(Arrays.toString(originMap[i]));
			}
			System.out.println();
			
//		}
		
		System.out.println("turn = " + turn);
		System.out.println("last = " + lastCount);
	}
		
	
//	static void dfs(int y, int x) {
//		visited[y][x] = true;
//		
//		int ny, nx = 0;
//
//		/*
//		 * 인전합 치즈 개수 세기
//		 */
//		int count = 0;  //상하좌우 인접한 치즈의 개수
//		for (int d = 0; d < 4; d++) {
//			ny = y + dy[d]; nx = x + dx[d];
//
//			if(inRange(ny,nx) && originMap[ny][nx] == 0 || !inRange(ny,nx)) {
//				newMap[y][x] = 1;
//				break;
//			}
//		} 
//		
//		// 상하좌우로 연결 치즈 이동
//		for (int d = 0; d < 4; d++) {
//			ny = y + dy[d]; nx = x + dx[d];
//			
//			if(inRange(ny,nx) && !visited[ny][nx] && originMap[ny][nx] == 1) {
//				dfs(ny,nx);
//			}
//			
//		}
//		
//	}
	
	static boolean inRange(int y, int x) {
		return -1 < y && y < N && -1 < x && x < M;
	}
	
	
	static void print() {
		System.out.println("-----------origin" + " ------------------ ");

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(originMap[i][j]+" ");
			}System.out.println();
		}
	}

}


//package graph_0219;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
///*
// * [ 어려웠던 점 ] 
// * 
// * 1. 문제에서 모서리는 지우고, 구멍은 남기는데
// * 	  모서리와 구멍을 어떻게 구분?
// * 
// * 	 => 치즈말고 공기 기준
// * 
// * 
// * 
// * DFS 
// * 		1. Origin, New map을 만든다.
// * 		2. for문 돌면서 방문 x && 1이면 dfs 시작.
// * 			lastCount += cnt;
// * 		
// * 		dfs
// * 			방문처리
// * 			사방 처리 :
// * 				!방문 && 1이면 
// * 					cnt ++;
// * 					dfs()
// * 				
// */
//public class Main_2636_G4_치즈_prc {
//
//	static int[][] originMap, newMap;
//	static boolean[][] visited;
//	static int N,M;
//	
//	static int[] dy = {-1,1,0,0}, dx = {0,0,-1,1};
//	
//	public static void main(String[] args) throws Exception {
////		System.setIn(new FileInputStream("input.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		
//		originMap = new int[N][M];
//		visited = new boolean[N][M];
//		
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			
//			for (int j = 0; j < M; j++) {
//				originMap[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//				
//		newMap = new int[N][M];
//		int lastCount = 0;
//		int turn = 1;
//		
//		while(true) {
//			
//	
//			turn++;
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					
//					if(!visited[i][j] && originMap[i][j] == 1) {
//						dfs(i,j);
//					}
//				}
//			}
//			
//			print();
//			printNew();
//			
//			int remainCount = 0;
//			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					if(newMap[i][j] == 1) originMap[i][j] = 0;
//					if(newMap[i][j] == 1) remainCount++;
//				}
//			}
//			
//			if(remainCount == 0) break;
//			lastCount = remainCount;
//			
//			//newMap 초기화
//			for (int i = 0; i < N; i++) {
//				Arrays.fill(newMap[i], 0);
//			}
//			
//		}
//		
//		System.out.println(turn);
//		System.out.println(lastCount);
//		
//		
//	}
//	
//	static void dfs(int y, int x) {
//		visited[y][x] = true;
//		
//		int ny, nx = 0;
//
//		/*
//		 * 인전합 치즈 개수 세기
//		 */
//		int count = 0;  //상하좌우 인접한 치즈의 개수
//		for (int d = 0; d < 4; d++) {
//			ny = y + dy[d]; nx = x + dx[d];
//
//			if(inRange(ny,nx) && originMap[ny][nx] == 0 || !inRange(ny,nx)) {
//				newMap[y][x] = 1;
//				break;
//			}
//		} 
//		
//		// 상하좌우로 연결 치즈 이동
//		for (int d = 0; d < 4; d++) {
//			ny = y + dy[d]; nx = x + dx[d];
//			
//			if(inRange(ny,nx) && !visited[ny][nx] && originMap[ny][nx] == 1) {
//				dfs(ny,nx);
//			}
//			
//		}
//		
//	}
//	
//	static boolean inRange(int y, int x) {
//		return -1 < y && y < N && -1 < x && x < M;
//	}
//	
//	
//	static void print() {
//		System.out.println("-----------origin" + " ------------------ ");
//
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(originMap[i][j]+" ");
//			}System.out.println();
//		}
//	}
//	static void printNew() {
//		System.out.println("========= NEW =========\n");
//		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(newMap[i][j]+" ");
//			}System.out.println();
//		}
//	}
//
//}
