package bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 14316 kb	112ms
 * 입력 받음과 동시에 처리하기
 * count = - 1 로 초기화	
 * 
 * IF input == C 면 :
 * 		count ++;
 * 		추가
 * 		continue
 *
 * 이미 c를 만난 상태
 * IF COUNT != -1:
 * 		count++
 * 
 * map에 추가
 */
public class Main_10709_S1_박은서_prc {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < H; i++) {
			String line = br.readLine();
			
			int count = -1;
			
			for (int j = 0; j < W; j++) {
				char input = line.charAt(j);
				
				if(input == 'c') {
					count = 0;
					sb.append(count).append(" ");
					continue;
				}
				if(count != -1) count ++;
				
				sb.append(count).append(" ");
			}
			sb.append("\n");
		}		
		
		System.out.println(sb);
	}

}
