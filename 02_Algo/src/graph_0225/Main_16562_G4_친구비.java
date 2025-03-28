package graph_0225;

import java.io.*;
import java.util.*;


/* 18768KB	172ms
 * 3차 - boolean으로 방문 처리할 필요 없이 parents[v] = v 면 루트
 */

public class Main_16562_G4_친구비 {
	
	static int V,E,W;
	static int[] parents;
	static int[] weight;

	static void make() {
		parents = new int[V];
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int v) {
		if(parents[v] == v) return v;
		
		return parents[v] = find(parents[v]);
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return;

		// 더 작은 친구비로
		if (weight[aRoot] < weight[bRoot]) {
		    parents[bRoot] = aRoot;
		} else {
		    parents[aRoot] = bRoot;
		}
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		weight = new int[V];
		
		for (int i = 0; i < V; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		
		make();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			
			union(from,to);
//			System.out.println(Arrays.toString(parents));
		}
		
		long result = 0;
		
		for(int i = 0; i < V; i++) {
			if(parents[i] == i) {
				result += weight[i];
			}
		}
		
		if(result > W) {
			System.out.println("Oh no");
			return;
		}
		System.out.println(result);
		
	}

}

/*
 * 	18436 KB	180 ms
 * 2차 - 부모의 부모로 이동 find
 * 
 */
//public class Main_16562_G4_친구비 {
//	
//	static int V,E,W;
//	static int[] parents;
//	static int[] weight;
//	static boolean[] visited;
//
//	static void make() {
//		parents = new int[V];
//		for (int i = 0; i < V; i++) {
//			parents[i] = i;
//		}
//	}
//	
//	static int find(int v) {
//		if(parents[v] == v) return v;
//		
//		return parents[v] = find(parents[v]);
//	}
//	
//	static void union(int a, int b) {
//		int aRoot = find(a);
//		int bRoot = find(b);
//		
//		if(aRoot == bRoot) return;
//
//		// 더 작은 친구비로
//		if (weight[aRoot] < weight[bRoot]) {
//		    parents[bRoot] = aRoot;
//		} else {
//		    parents[aRoot] = bRoot;
//		}
//	}
//
//	public static void main(String[] args) throws Exception {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		V = Integer.parseInt(st.nextToken());
//		E = Integer.parseInt(st.nextToken());
//		W = Integer.parseInt(st.nextToken());
//		
//		st = new StringTokenizer(br.readLine());
//		weight = new int[V];
//		
//		for (int i = 0; i < V; i++) {
//			weight[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		make();
//		
//		for (int i = 0; i < E; i++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			int from = Integer.parseInt(st.nextToken()) - 1;
//			int to = Integer.parseInt(st.nextToken()) - 1;
//			
//			union(from,to);
////			System.out.println(Arrays.toString(parents));
//		}
//		
//		boolean[] visited = new boolean[V];
//		
//		long result = 0;
//		for (int i = 0; i < V; i++) {
//			int root = find(i);
//			
//			if(!visited[root]) {
//				result += weight[root];
//				visited[root] = true;
//			}
//		}
//		
//		
//		if(result > W) {
//			System.out.println("Oh no");
//			return;
//		}
//		System.out.println(result);
//		
//		
//		
//	}
//
//}

/*
 * 22036kb	348ms
 * 반례
 * 	5 4 10000
	10 10 20 20 30
	1 3
	2 3
	5 4
	4 3
	
	답 : 10, 내 답 : 30
	
	중간에 부모가 바뀌면 연결된 자식도 새로운 부모로 변경되야 함.
	
	-> 1차 해결 : union에서 갱신할 때 update 함수로 for문 돌고 해당 v를 가지면 새로운 newV로 갱신
	-> 2차 해결 : 나중에 다시 추가할 때 부모의 부모로  18436	180
 */
//public class Main_16562_G4_친구비 {
//	
//	static int V,E,W;
//	static int[] parents;
//	static int[] weight;
//	static boolean[] visited;
//
//	static void make() {
//		parents = new int[V];
//		for (int i = 0; i < V; i++) {
//			parents[i] = i;
//		}
//	}
//	
//	static int find(int v) {
//		if(parents[v] == v) return v;
//		
//		return parents[v] = find(parents[v]);
//	}
//	
//	static void union(int a, int b) {
//		int aRoot = find(a);
//		int bRoot = find(b);
//		
//		if(aRoot == bRoot) return;
//
//		// 더 작은 친구비로
//		if (weight[aRoot] < weight[bRoot]) {
//		    parents[bRoot] = aRoot;
//		} else {
//		    parents[aRoot] = bRoot;
//		}
//	}
//
//	public static void main(String[] args) throws Exception {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		V = Integer.parseInt(st.nextToken());
//		E = Integer.parseInt(st.nextToken());
//		W = Integer.parseInt(st.nextToken());
//		
//		st = new StringTokenizer(br.readLine());
//		weight = new int[V];
//		
//		for (int i = 0; i < V; i++) {
//			weight[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		make();
//		
//		for (int i = 0; i < E; i++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			int from = Integer.parseInt(st.nextToken()) - 1;
//			int to = Integer.parseInt(st.nextToken()) - 1;
//			
//			union(from,to);
////			System.out.println(Arrays.toString(parents));
//		}
//		
//		boolean[] visited = new boolean[V];
//		
//		long result = 0;
//		for (int i = 0; i < V; i++) {
//			int root = find(i);
//			
//			if(!visited[root]) {
//				result += weight[root];
//				visited[root] = true;
//			}
//		}
//		
//		
//		if(result > W) {
//			System.out.println("Oh no");
//			return;
//		}
//		System.out.println(result);
//		
//		
//		
//	}
//
//}
