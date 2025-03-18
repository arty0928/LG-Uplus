package greedy;

import java.io.*;
import java.util.*;

public class 볼모으기_17615 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String line = br.readLine();
		
		int Rcnt = 0, Bcnt = 0;
		for (int i = 0; i < N; i++) {
			char now = line.charAt(i);
			
			if(now == 'R') Rcnt++;
			else Bcnt++;
		}
		
		int result = N;
	
		result = Math.min(result, Rcnt - countFromLeft(line, N, 'R'));
		result = Math.min(result, Rcnt - countFromRight(line, N, 'R'));
		result = Math.min(result, Bcnt - countFromLeft(line, N, 'B'));
		result = Math.min(result, Bcnt - countFromRight(line, N, 'B'));
		
		System.out.println(result);

	}
	
	static int countFromLeft(String line, int N, char c) {
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			if(line.charAt(i) != c) break;
			count++;
		}
		return count;
	}
	
	static int countFromRight(String line, int N, char c) {
		
		int count = 0;
		for (int i = N - 1; i > 0; i--) {
			if(line.charAt(i) != c) break;
			count++;
		}
		return count;
	}

}
