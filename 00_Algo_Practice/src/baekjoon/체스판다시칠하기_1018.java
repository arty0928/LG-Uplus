package baekjoon;
import java.util.*;
import java.io.*;

public class 체스판다시칠하기_1018 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] map =new int[M][N];
		
		for (int i = 0; i < M; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				char tmp = line.charAt(j);
				
				switch(tmp) {
					case 'B':
						map[i][j] = 0;
						break;
					default:
						map[i][j] = 1;
						break;
				}
			}
		}
		
		int answer =0;
		int pre = map[0][0];
		
		for (int i = 1; i < N; i++) {
			int cur = map[0][i];
			if(pre == cur) {
				answer ++;
				if(cur == 0) map[0][i] = 1;
				else map[0][i] = 0;
				
			}
			pre = map[0][i];
		}
		
		for (int i = 1; i < M; i++) {
			pre = map[i-1][0];
			
			for (int j = 0; j < N; j++) {
				int cur = map[i][j];
//				System.out.println("i = " + i + " j = " + j);
//				System.out.println(" pre =" + pre + " cur = " + cur+ " \n");
				
				if(pre == cur) {
//					System.out.println("same");
					answer ++;
					if(cur == 0) map[i][j] = 1;
					else map[i][j] = 0;
					
					pre = map[i][j];
				}
				pre = map[i][j];
			}
			
			print(map, M);
			
		}
		System.out.println(answer);
	}
	
	static void print(int[][] map, int M) {
		System.out.println();
		for (int i = 0; i < M; i++) {
			System.out.println(Arrays.toString(map[i]));
		}System.out.println();
	}

}
