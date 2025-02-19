package chapter02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOTest1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		/*
		 * System.in : keyboard로 부터 입력
		 */
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		 * System.in은 기본적으로 keyboard로부터 입력받지만
		 * 다른 대상으로부터 입력 받을 경우 setIn(입력 받을 대상) 함수로 설정.
		 */
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		System.out.println(line);
	}

}
