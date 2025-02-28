package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 그냥 if문으로 replace,,, 다 했는데도 문자열에 남아 있으면 NO
 * 
 */
public class Main_14405_S5_피카츄 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
			// 오답 반례 kpia
		/*
		 * 
//		 */
//			line = line.replace("pi", "");
//			System.out.println("1번 line = " + line);
//			
//			line = line.replace("ka", "");
//			System.out.println("2번 line = " + line);
//			
//			line = line.replace("chu", "");
//			System.out.println("3번 line = " + line);
			
			
			// 오답 반례 kpia
		/*
		 * replaceAll 은 [정규식 기반]으로 동작 
		 * 		: 의도한 대로 순차적으로 문자열을 처리하지 않고 일치하는 패턴을 찾아서 모두 제거
		 * 
		 * 		여기서 pi, ka, chu 를 정규식 패턴으로 사용 
		 * 		-> 정규식 패턴으로 사용하지 않기 위해 replace 사용
		 * 
		 * 반례 : kpia -> YES 나옴 (정답: NO)
		 */
			line = line.replaceAll("pi", "");
			System.out.println("4번 line = " + line);
			line = line.replaceAll("ka", "");
			System.out.println("4번 line = " + line);
			line = line.replaceAll("chu", "");
			System.out.println("4번 line = " + line);
		
			
			// 정답
//			line = line.replaceAll("pi|ka|chu", ""); // pi, ka, chu를 동시에 치환
		
			
			/*
			 * 성공
			 */
			line = line.replaceAll("pi", " ");
			System.out.println("4번 line = " + line);
			line = line.replaceAll("ka", " ");
			System.out.println("4번 line = " + line);
			line = line.replaceAll("chu", " ");
			System.out.println("4번 line = " + line);
		
			/*
			 * 성공
			 */
			line = line.replace("pi", "");
			System.out.println("4번 line = " + line);
			line = line.replace("ka", "");
			System.out.println("4번 line = " + line);
			line = line.replace("chu", "");
			System.out.println("4번 line = " + line);
		
			
			
		if(line.equals("")) System.out.println("YES");
		else System.out.println("NO");
	}

}

