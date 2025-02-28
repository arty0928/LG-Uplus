package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 그냥 if문으로 pi contains -> replace,,, 다 했는데도 문자열에 남아 있으면 NO
 */
public class Main_14405_S5_피카츄 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
			// 이렇게 나눠서 한다며 replace 는 정답, replaceAll은 오답
			line = line.replace("pi", "");
			line = line.replace("ka", "");
			line = line.replace("chu", "");
			
			
			// 이것만 하면 정답
//			line = line.replaceAll("pi|ka|chu", ""); // pi, ka, chu를 동시에 치환
		
		if(line.equals("")) System.out.println("YES");
		else System.out.println("NO");
	}

}

