package combination;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백설공주와_일곱난쟁이 {

	static int[] input = new int[9];
	static int[] result = new int[7];
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		combination(0,0,0);
	}
	
	private static void combination(int depth, int start, int sum) {
		
		if(depth == 7) {
			
			if(sum == 100) {
				for (int num : result) {
					System.out.println(num);
				}				
			}
			return;
		}
		
		for (int i = start; i < 9; i++) {
			result[depth] = input[i];
			combination(depth +1 , i + 1, sum + input[i]);
		}
		
		
	}

}
