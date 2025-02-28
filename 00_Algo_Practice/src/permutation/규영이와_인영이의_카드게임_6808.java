package permutation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 무승부는 나올 수가 없음. 이기는 사람이 두 카드 모두 가져가기 때문.

/* 
 * 2차 - bitmask (38ms)
 * 
 * 	boolean[] visited -> int[]
 * 		선택   : 1
 *   	미선택  : 0
 *    -> 비트마스크
 * 
 */
public class 규영이와_인영이의_카드게임_6808 {

	static final int N = 18;					// 전체 카드 수
	static final int HALF_N = 9;				// 한 명이 가져가는 카드 수 (18/2)
		
	static int[] gyuCard = new int[HALF_N];		// 규영이의 카드 배열
	static int[] inCard = new int[HALF_N];		// 인영이의 카드 배열
	
	static int gyuWin, inWin;					// 규영이, 인영이의 승리 횟수
	static int[] visited;						// 1 ~ 18번 숫자 방문 체크 배열 (비트마스크)

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("input.txt"));	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		long start = System.currentTimeMillis();
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			gyuWin = 0;
			inWin = 0;
			gyuCard = new int[HALF_N];
			inCard = new int[HALF_N];
			visited = new int[N + 1];

			for (int i = 0; i < HALF_N; i++) {
				int tmp = Integer.parseInt(st.nextToken());

				gyuCard[i] = tmp;		// 규영이 카드 저장
				visited[tmp] = 1;		// 해당 카드는 규영이가 가져감
			}
			
			// 규영이가 선택하지 않은 나머지 9개의 숫자로 인영이 카드 배열 만들기
			int data = 0;
			for (int i = 1; i < N + 1; i++) {
				if(visited[i] == 0) {
					inCard[data++] = i;
				}
			}

			// 인영이 카드로 순열 만들기
			permutation(0, 0, 0, 0);

			System.out.println("#" + tc + " " + gyuWin + " " + inWin);
		}
		
		long end = System.currentTimeMillis();
		System.out.printf("time:%dms%n",end-start);
		
	}

	private static void permutation(int depth, int flag, int gyuSum, int inSum) {

		// 9 장의 카드를 모두 선택한 경우
		if (depth == HALF_N) {
			if (gyuSum > inSum) gyuWin++; // 규영이 승리
			if (gyuSum < inSum) inWin++;  // 인영이 승리
		
			return;
		}

		for (int i = 1; i <= HALF_N; i++) {
			
			// 이미 선택한 카드의 경우
			if ((flag & 1 << i) != 0) continue;
			
			int gyu = gyuCard[depth];  //현재 선택된 규영이 카드
			int in = inCard[i-1];      //현재 선택된 인영이 카드 :  인덱스니까 -1
			
			
			
	        // 인영이의 카드 선택 과정 출력
			// Depth: 8, Gyu Card: 17, In Card: 6, Flag: 11111 11110
			// 1을 선택하지 않은 상태, 2 ~ 9는 모두 선택.
//	        System.out.printf("Depth: %d, Gyu Card: %d, In Card: %d, Flag: %s%n",
//            depth, gyu, in, Integer.toBinaryString(flag | (1 << i)));


			// i번째 위치에 1 추가 == 카드 i를 선택
			if(gyu > in) permutation(depth + 1, flag | 1 << i, gyuSum + in + gyu, inSum); // 규영이가 더 큰 경우
			else permutation(depth + 1, flag | 1 << i, gyuSum, inSum + in + gyu);		  // 인영이가 더 큰 경우
		}

	}

}



/*
 * 1차 : boolean 배열 (176 ms)
 
  	  { 접근 방법 } 
	 * 1. 18개 중에 각각 1개를 뽑는다.
		 * if count == 9 : return
		 * 
		 * for (int i = 0; i < 18; i++)
		 * 		
		 * 		// 이미 뽑힌 애면
		 * 		if((flag & 1 << i ) != 0) continue;
		 * 
		 * 
	 * 2. card1 >  card2 :
		 * 		sum1 += car1 + card2
		 * 	
		 * => 인영이가 뽑은 것을 따로 저장하지 않고 visitied로 하면 sum에 더해지면서 재귀를 탈출했을 때 sum도 다시 빼야함.
		 * 	  번거로우니 그냥 각각 배열 만들고 저장.	
		 * 
 */
//public class 규영이와_인영이의_카드게임_6808 {
//
//	static final int N = 18;
//	static final int HALF_N = 9;
//	static int[] gyuCard = new int[HALF_N];
//	static int[] inCard = new int[HALF_N];
//	static int gyuWin, inWin;
//
//	static boolean[] visited;
//
//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//
//		System.setIn(new FileInputStream("input.txt"));	
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
//		long start = System.currentTimeMillis();
//
//		for (int tc = 1; tc <= T; tc++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			gyuWin = 0;
//			inWin = 0;
//			gyuCard = new int[HALF_N];
//			inCard = new int[HALF_N];
//			visited = new boolean[N + 1];
//
//			for (int i = 0; i < HALF_N; i++) {
//				int tmp = Integer.parseInt(st.nextToken());
//
//				gyuCard[i] = tmp;
//				visited[tmp] = true;
//			}
//
//			permutation(0);
//
//			System.out.println("#" + tc + " " + gyuWin + " " + inWin);
//		}
//		
//		long end = System.currentTimeMillis();
//		System.out.printf("time:%dms%n",end-start);
//		
//	}
//
//	private static void permutation(int depth) {
//
//		if (depth == HALF_N) {
//			int gyuSum = 0, inSum = 0;
//
//			for (int i = 0; i < HALF_N; i++) {
//				if (gyuCard[i] > inCard[i]) {
//					gyuSum += gyuCard[i] + inCard[i];
//				} else if (gyuCard[i] < inCard[i]) {
//					inSum += gyuCard[i] + inCard[i];
//				}
//			}
//
//			if (gyuSum > inSum)
//				gyuWin++;
//			if (gyuSum < inSum)
//				inWin++;
//
//		}
//
//		for (int i = 1; i <= N; i++) {
//			if (visited[i] == true)
//				continue;
//
//			inCard[depth] = i;
//			visited[i] = true;
//			permutation(depth + 1);
//			visited[i] = false;
//		}
//
//	}
//
//}
