package subset;

import java.io.*;
import java.util.*;

/*
 * 	14160KB	100ms
 * 		클래스 선언 -> int 배열
 * 		순열 대신 재귀 선택 / 비선택 부분집합
 */
public class 도영이가_만든_맛있는_음식_2961 {

static int N, ans;
static List<int[]> foods; //재료 저장

public static void main(String[] args) throws Exception {
	System.setIn(new FileInputStream("input.txt"));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	N = Integer.parseInt(br.readLine());
	ans = Integer.MAX_VALUE;
	foods = new ArrayList<>();
	
	StringTokenizer st;
	for (int i = 0; i < N; i++) {
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		foods.add(new int[] {S,B});
	}
	
	combination(0,1,0,0);
	
	System.out.println(ans);
}

private static void combination(int depth, int s, int b, int count) {

	/*
	 * 재귀로 다시 돌아오기 때문에 depth로 하면 아무것도 포함하지 않은 상태도 ans 업데이트가 된다.
	 * 		count 값으로 포함한 food의 갯수 표시
	 */
	if(count > 0) ans = Math.min(ans, Math.abs(s-b));
	
	if(depth == N) return;
	
	
	combination(depth + 1, s * foods.get(depth)[0], b + foods.get(depth)[1], count + 1);
	combination(depth + 1, s, b, count);
	}

}


/* 
 * 14132KB	104ms	
 * 1차 - 순열 이용한 부분집합
 */

//public class 도영이가_만든_맛있는_음식_2961 {
//	
//	static int N, ans;
//	static List<food> foods;
//	static food[] input;
//	
//	static class food{
//		int S,B;
//
//		public food(int s, int b) {
//			super();
//			S = s;
//			B = b;
//		}
//
//		@Override
//		public String toString() {
//			StringBuilder builder = new StringBuilder();
//			builder.append("food [S=");
//			builder.append(S);
//			builder.append(", B=");
//			builder.append(B);
//			builder.append("]");
//			return builder.toString();
//		}
//	
//	}
//
//	public static void main(String[] args) throws Exception {
////		System.setIn(new FileInputStream("input.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		N = Integer.parseInt(br.readLine());
//		foods = new ArrayList<>();
//		input = new food[N];
//		ans = Integer.MAX_VALUE;
//		
//		StringTokenizer st;
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
//			int S = Integer.parseInt(st.nextToken());
//			int B = Integer.parseInt(st.nextToken());
//			
//			input[i] = new food(S,B);
//		}
//		
//		combination(0,0);
//		
//		System.out.println(ans);
//	}
//
//	private static void calFood(int depth) {
//		
//		int S_SUM = 1, B_SUM = 0;
//		
//		for(int i = 0; i < depth; i++) {
//			S_SUM *= foods.get(i).S;
//			B_SUM += foods.get(i).B;
//		}
//		ans = Math.min(ans, Math.abs(B_SUM - S_SUM));
//	}
//
//	private static void combination(int depth, int start) {
//		
//		if(depth > N) return;
//
//		if(depth !=0) calFood(depth);
//		
//		for (int i = start; i < N; i++) {
//			foods.add(input[i]);
//			combination(depth + 1, i +1 );
//			foods.remove(foods.size()-1);
//		}
//	}
//
//}
