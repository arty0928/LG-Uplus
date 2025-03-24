package two_pointer;

import java.util.*;
import java.io.*;

public class 복호화_네이버기출 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String M = br.readLine();
		String K = br.readLine();
		System.out.println("M = " + M);
		System.out.println("K = " + K);
		
		StringBuilder sb = new StringBuilder();
		
		int i = 0, j = 0;
		
		// i가 M.size - 1, j가 K.size - 1까지 오면 끝
		while(true) {
			
			if(i == M.length() - 1 && j == K.length() - 1) break;

			if(M.charAt(i)  == K.charAt(j) && j < K.length() - 1) {
				j++;
			}else {
				sb.append(M.charAt(i));
			}
			i++;
			System.out.println("sb = " +sb);
		}
		
		System.out.println(sb);
	}

}
