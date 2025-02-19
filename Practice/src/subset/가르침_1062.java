package subset;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* [ 접근 과정 2 ] 
 * 1. split으로 앞뒤 4개씩 자르고, a n t i c 포함 여부 확인하는 것이 시간 낭비
 * 		문자 길이 최대 15를 돌면서 a n t i c 5개의 문자를 확인 -> 15 * 5		
 * 		문자 최대 50개
 * 	
 *  	=> 50 * 15 * 5 만큼 더 소요
 *  
 * 
 * 2. 그냥 바로 비트마스크가 빠름
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * [ 접근 과정 1]
	 * 1. 앞 뒤 anta-, -tica replace로 삭제
	 * 
	 * 2. a n t i c 는 없애기
	 * 
	 * 2. K  -5 <= 0,
	 * 		0 출력하고 끝내기
	 * 
	 * 	  K -= 5 로 업데이트
	 * 
	 * 3. 각 알파벳 등장 누적합 내림차순
	 * 
	 * -> 26C(K-5)
	 * 
	 * 4. 각 소문자 - 'a'
	 *    조합한 단어들로 해당 단어들 읽을 수 있는지 비트마스크 & 연산
 */
public class 가르침_1062 {

	static int N,K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		

	}

}
