package graph_0219;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
/**
 * - map을 구역 나누기 문제 
 *   - 같은 구역인 경우 count세기 
 *   - 모든 노드를 1번씩만 탐색하기 때문에 dfs, bfs 모두 가능 
 *   - 전체 맵을 반복하면서 
 *     방문하지 않은 노드라면 그 노드 부터 같은 구역인지 (dfs, bfs) 탐색하기 
 *     
 * - 적녹색약
 *   1. 비적녹색약인을 위한 버전으로 구역 탐색하고 
 *   2. 적녹색약인을 위해 visits 초기화 하고
 *      map의 정보를 G->R로 바꾸거나 R->G으로 바꾼후 구역 탐색하기 
 */

/*
 * DFS 
 */
public class Main_10026_G5_적록색약 {
	static int N;
    static char map[][];
    static boolean visits[][];
    static int dr[] = {-1,0,0,1};
    static int dc[] = {0,1,-1,0};
 
    public static void main(String args[]) throws Exception{
 
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        map = new char[N][N];
        visits = new boolean[N][N];
 
        for (int i=0; i<N; i++){
        	// toCharArray() : 문자열을 문자 배열로 변환하는 함수
        	map[i] = in.readLine().toCharArray();
        }
        
        /*
         * 비적녹색약
         */
        int disabled = 0, non = 0;
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visits[i][j]) {
//					dfs(i,j);
					bfs(i,j);
					non ++; // 구역 증가
				}
			}
		}
        
        /*
         * 적녹색약
         * 	visit 초기화
         *  G -> R 
         */
//        visits = new boolean[N][N];    -> 한번만 하면 이게 낫지만
        for (int i = 0; i < N; i++) { // -> 여러 번 초기화하는 경우, 계속 다시 선언하지 않고 fill이 낫다.
			Arrays.fill(visits[i], false);
		}
        
        // G -> R
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 'G') map[i][j] = 'R';
			}
		}
        
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
        		if(!visits[i][j]) {
//        			dfs(i,j);
        			bfs(i,j);
        			disabled ++; // 구역 증가
        		}
        	}
        }
        
        System.out.println(non + " " + disabled);
    }
    
    
    //16320 KB	140ms
    public static void bfs(int y, int x) {
    	
    	Deque<int[]> q = new ArrayDeque<>();
    	q.add(new int[] {y,x});
    	visits[y][x] = true;
    	
    	char color = map[y][x];
    	
    	while(!q.isEmpty()) {
    		int[] next = q.poll();
    		
    		for (int d = 0; d < 4; d++) {
				int ny = next[0] + dr[d], nx = next[1] + dc[d];
				
				if(inRange(ny,nx,N) && !visits[ny][nx] && map[ny][nx] == color) {
					visits[ny][nx] = true;
					q.add(new int[] {ny,nx});
				}
			}
    	}
    	
    }
 
    //16120KB	132ms
    public static void dfs(int y, int x ){
    	visits[y][x] = true;
    	char color = map[y][x];
    	
    	// 같은 color 면 계속 탐색, 다르면 멈춤
    	for (int d = 0; d < 4; d++) {
			int ny = y + dr[d], nx = x + dc[d];
			
			if(inRange(ny,nx,N) && !visits[ny][nx] && map[ny][nx] == color) {
				dfs(ny,nx);
			}
		}
        
    }
    
    static boolean inRange(int y, int x, int N) {
    	return -1<y && y < N && -1 < x && x < N;
    }
}
