package permutation;

import java.util.*;
import java.io.*;

/*
 * 70220 KB	788 ms
 * - 1차 : BitMask
 */

public class N과M_15649 {

	static int N,K;
	static int[] numbers; // 순열을 담을 데이터
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		numbers = new int[K];
		
		permutation(0, 0);
	}
	
	static void permutation(int depth, int flag) {
		
		if(depth == K) {
			System.out.println(Arrays.toString(numbers).replace("[", "").replace("]", "").replace(",", ""));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			
			if((flag & 1 << i ) != 0) continue;
			
			numbers[depth] = i + 1;
			
			permutation(depth + 1, (flag | 1 << i));
		}
	}

}
