package graph_0225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 	51044 kb	600ms
 */
public class Main_1197_최소스패닝트리 {

	static int V,E;
	static int[] parents;
	static Edge[] edgeList;
	
	static void make() {
		parents = new int[V+1];
		
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
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

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		edgeList = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(from,to,w);
		}
		
		make();
		Arrays.sort(edgeList);
		
		int count = 0;
		int result = 0;
		
		for (Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(++count == V-1) break;
			}
		}
		
		System.out.println(result);
	}

}
