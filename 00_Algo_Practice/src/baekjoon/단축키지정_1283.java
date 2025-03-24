package baekjoon;

import java.io.*;
import java.util.*;

/*
 * 그냥 if문으로 replace,,, 다 했는데도 문자열에 남아 있으면 NO
 * 
 */
public class 단축키지정_1283 {

	public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;	

        Set<Character> set = new HashSet<>(); // 단축키 지정
        StringBuilder sb = new StringBuilder(); // 정답 문자

		for(int i = 0 ; i < N; i++){
            String[] input = br.readLine().split(" ");
            boolean found = false; 
            StringBuilder line = new StringBuilder();

            System.out.println("입력 = " + input);
            // 각 단어의 첫글자 확인
            for(int j = 0, size = input.length;  j < size; j++){
                System.out.println(input[j]);
                char firstC = input[j].charAt(0);
                char upperC = Character.toUpperCase(firstC);
                char lowerC = Character.toLowerCase(firstC);

                System.out.println("firstC = " + firstC);

                if(!set.contains(upperC) && !set.contains(lowerC)){
                    set.add(firstC); // 대소문자 관계없이 저장

                    input[j] = "[" + firstC + "]" + input[j].substring(1);
                    System.out.println("found = " + input[i]);
                    found = true;
                    break;
                }
            }

            System.out.println("--------------앞에서 찾지 못함----------");
            //2. 맨 앞 문자로 찾지 못한 경우
            if(!found){
                for(int j = 0, size = input.length; j <size; j++){
                    
                    for(int k = 1; k < input[j].length(); k++){
                        char c = input[j].charAt(k);

                        char upperC = Character.toUpperCase(c);
                        char lowerC = Character.toLowerCase(c);

                        System.out.println("c = " + c);
                        // 단축키 지정 안되어 있으면
                        if(!set.contains(upperC) && !set.contains(lowerC)){
                            set.add(c);

                            input[j] = input[j].substring(0,k)+"["+c+"]"+input[j].substring(k+1);
                            System.out.println("found input = " + input);
                            found = true;
                            break ;
                        }
                    }
                    if(found) break;
                    
                }
            }
            
            line.append(String.join(" ", input));
            sb.append(line).append("\n");
        }
        System.out.println(sb);
	}

}

