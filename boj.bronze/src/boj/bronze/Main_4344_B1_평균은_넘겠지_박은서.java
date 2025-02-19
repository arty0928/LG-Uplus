package boj.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//메모리  : 15560kb
//시간 	: 152ms
public class Main_4344_B1_평균은_넘겠지_박은서 {

	public static void main(String[] args) throws Exception {

		//입력 처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테케수
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < t; tc++) {
			// 테케별 읽기
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			// N 읽고 배열 생성
			int n = Integer.parseInt(st.nextToken());
			int[] scores = new int[n];
			
			int total = 0;
			// N 개의 데이터 읽기
			for (int i = 0; i < n; i++) {
				scores[i] = Integer.parseInt(st.nextToken());
				total += scores[i];
			}
			
			//평균 계산하기
			double avg = (double) total / n;
			
			
			//학생 성적이 평균을 넘는지 체크하고 count 세기
			int count = 0;
			for (int i = 0; i < scores.length; i++) {
				if (scores[i] > avg) {
					count++;
				}
			}
			
			//count / N -> 비율 구하기		
			//출력 처리 -> 소수 3째자리까지 출력(반올림)
			// % 자체를 출력하고 싶다면 %% 처럼 2번 써주기
			System.out.printf("%.3f%%\n", (double)count/n*100);
			
		}
		
		
		
	}

}
