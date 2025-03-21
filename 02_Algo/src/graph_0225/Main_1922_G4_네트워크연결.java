package graph_0225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 49584 kb	508ms
 * 최소 신장 트리
 *	
 *	edge 오름차순 후 선택
 *		cycle 안 되게
 */
public class Main_1922_G4_네트워크연결 {

	static int V,E;
	static Edge[] edgeList;
	static int[] parents;
	
	static void make() {
		parents = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parents[i]= i;
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[aRoot] = bRoot;
		
		return true;
	}
	
	static class Edge implements Comparable<Edge>{
		int from,to,weight;

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]\n";
		}

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		edgeList = new Edge[E];
		StringTokenizer st;
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(from,to,w);
		}
		
		make();
		
		Arrays.sort(edgeList);
//		System.out.println(Arrays.toString(edgeList));
		
		int count = 0; // 몇개의 간선 연결
		int result = 0; // 누적 합
		
		for (Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				
				if(++count == V-1) break;
			}
		}
		
		System.out.println(result);
	}

}
