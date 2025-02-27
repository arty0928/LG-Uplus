package chapter02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IOTest3_scanner {

	public static void main(String[] args) throws Exception {
		//키보드로부터 읽기
//		Scanner scan = new Scanner(System.in);
		
		//파일로부터 읽기
		Scanner scan = new Scanner(new File("input.txt"));
		
		int n = 5;
		for (int i = 0; i < n; i++) {
			System.out.println(scan.nextInt());
		}
	}
	
	
	//메서드 밖에 있는 애들한테는 static 붙이자
	static String input="10 9 8 11 5";
	
	
	

}
