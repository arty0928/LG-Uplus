package fillCell;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 가로, 세로의 길이가 N인 N x N 정사각 행렬이 있다. 
 * 이 행렬의 각각의 값으로서 0에서 9 사이의 수가 무작위로 넣어진다고 하자. 
 * 이 때 그 행렬 내에서 주위를 둘러싸고 있는 다른 모든 수들 보다 
 * 큰 수와 작은 수가 각각 몇 개인지를 구하는 프로그램을 작성하여라
 * 
 * [제한 조건]
 * 1. N은 3 이상 50 이하의 정수이다.
 * 2. 행렬의 가장자리에 있는 수는 8개의 수로 둘러싸여 있지 않으므로
 *    "주위를 둘러싸고 있는 다른 모든 수들보다 큰 수, 혹은 작은 수"가 될 수 없다.
 * [입력]
 * 입력은 다음과 같이 구성되어 있다.
 * 첫 번째 줄에는 테스트 케이스의 개수 T가 주어진다.
 * 그 다음 T 개의 테스트 케이스가 차례로 주어진다. 
 * 각 테스트 케이스는 다음과 같이 구성 되어 있다. 
 *    첫 줄에 정 사각 행렬의 크기 N이 주어진다. 
 *    그 다음 N 줄에 걸쳐 정 사각 행렬의 각 행의 값이 순서대로 주어진다. 
 * [출력]
 * 각 줄은 #x로 시작하고 (x는 테스트 케이스 번호) 공백을 하나 둔 다음, 
 * 문제에서 요구한 큰 수의 개수, 
 * 그리고 작은 수의 개수를 공백을 두어 차례로 출력한다. 
 *
 * [결과]
 * #1 6 4
 * #2 1 1
 */
public class RandomNumberPattern {
	static int N, big, small;
	
	static int[] dy = {-1,-1,-1,0,1,1,1,0};
	static int[] dx = {-1,0,1,1,1,0,-1,-1};
	static int d = 8;
	static int[][] map;
	
	// 1 ~ N-1 범위
	// 좌상 기준을 CHECK
	// check * map[nr][nc] > 0 : 같음
	//                     < 0 : 다름 -> return ;
	// 예외 처리 : 기준 - 주변 == 0 인 경우도 안되니까 return
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/fillCell/RandomNumberPattern.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		
		for (int test_case = 1; test_case <=T; test_case++) {
			N = sc.nextInt();
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			big = 0;
			small = 0;
			
			// 1 ~ N-1 돌면서 8방 확인
				for (int r = 1; r < N - 1; r++) {
					for (int c = 1; c < N - 1; c++) {
						check8dir(r,c);
					}
				
				}
			System.out.println("#"+test_case+" "+ big +" "+ small);
		}
	}
	
	static void check8dir(int y, int x) {
		
	}
	
	
	
	// 2차 : 곱하기 연산을 안하면서 8방을 다 안 돌고 가지치기 목표.
	//	그런데 최악의 경우,
	//		가지치기가 통하지 않는 모두 더 크거나, 더 작거나 하는 경우
	//		코드의 if 문이 불필요함.
	//		최악의 경우, 불필요한 if 문을 계속 확인하게 됨. if 문이 4개이므로 O(4N * 8)
	//		8방을 다 검사하더라도 if문이 없는 것이 나을 수도. O(2N * 8)
//	static void check8dir(int y, int x) {
//		
//		// 현재 위치에서 좌상 좌표가 기준
//		int curValue  = map[y][x];
//
//		boolean isBig = true;
//		boolean isSmall = true;
//		
//		// 나머지 방향 (상부터 좌까지 시계방향으로 탐색)
//		for (int i = 0; i < d; i++) {
//			int nr = y + dy[i];
//			int nc = x + dx[i];
//			
//			int neighbor = map[nr][nc];
//			
//			// 위에서부터 빠름
//				//			>
//				//			>=
//				//			==
//			
//			if(neighbor == curValue) return;
//			
//			if(neighbor <= curValue) isSmall = false;
//			else if(neighbor >= curValue) isBig = false;
//			
//			// 가장 크지도 않고 && 가장 작지도 않다
//			if(!isBig && !isSmall) return;
//		}
//
//		if (isSmall) small++;
//		if (isBig) big++;
//	}

	
	
	//1차 : 주변 좌표 불필요한 분리, 빼기 연산, 곱하기 연산 오래 걸림
//	static void check8dir(int y, int x) {
//		
//			// 현재 위치에서 좌상 좌표가 기준
//			int curValue  = map[y][x];
//			int nr = y + dy[0];
//			int nc = x + dx[0];
//			
//			int check = curValue - map[nr][nc];
//			
//			// 좌상이 현재위치와 같은 경우, 제일 작은 수도, 제일 큰 수도 안되므로 더 계산하지 않고 끝
//			if(check == 0) return;
//			
//			// 나머지 방향 (상부터 좌까지 시계방향으로 탐색)
//			for (int i = 1; i < d; i++) {
//				nr = y + dy[i];
//				nc = x + dx[i];
//				
//				// 나머지 방향과 현재 위치와의 계산
//				int newCal = curValue - map[nr][nc];
//				
//				if (newCal * check <= 0) return;
//			}
//
//		
//		if(check < 0) {
//			small++;
//		}else {
//			big++;
//		}
//	}
	
	static boolean inRange(int y, int x, int N) {
		return y > -1 && y < N && x > -1 && x < N;
	}
}







