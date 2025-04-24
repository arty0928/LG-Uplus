package baekjoon;
import java.util.*;
import java.io.*;

public class 체스판다시칠하기_1018 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[][] map =new boolean[M][N];
		
		for (int i = 0; i < M; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				char tmp = line.charAt(j);
				
				if(tmp == 'B') map[i][j] = false;
				else map[i][j] = true;
			}
		}
		
		int answer = 64;
		for(int i = 0; i <= M -8; i++) {
			for(int j = 0; j <= N- 8; j++) {
				answer = Math.min(answer, cal(true, i, j,map));
				answer = Math.min(answer, cal(false, i,j,map));
			}
		}
		System.out.println(answer);
		
	}
	
	static int cal(boolean first, int y, int x,boolean[][] map) {
		
		boolean[][] copy = new boolean[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				copy[i][j] = map[y+i][x+j];
			}
		}
		
		boolean pre = first;
		int count = 0;
		
		for (int i = 0; i < 8; i++) {
			if(i != 0) {
				pre = copy[i-1][0];
			}				

			for (int j = 0; j < 8; j++) {
				if(pre == copy[i][j]) {
					pre = !pre;
					copy[i][j] = pre;
					count++;
				}
				pre = copy[i][j];
			}
		}
		return count;
		
	}

}
