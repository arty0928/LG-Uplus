package greedy_0220;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * N 이 5의 배수인 경우
 * 
 * N 이 3의 배수인 경우
 * 
 * N 이 5의 배수 && 3의 배수인 경우
 * 
 * 	하지만 반례, 6 일 때, 답은 2지만 1이 나옴
 *
 */
public class Main_2839_S4_설탕배달_greed {
	public static final int M = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int count = 0; 
		
		while(N >= 0) {
			
			// 1. 5의 배수인 경우
			if(N%5==0) {
				count += N / 5;
				System.out.println(count);
				return;
			}
			
			// 5의 배수가 아닌 경우, 3을 하나씩 빼고 다시 5의 배수인지 확인
			N -= 3;
			count++;
		}
		
		if(N < 0) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(count);
		
	} // end of main
} // end of class