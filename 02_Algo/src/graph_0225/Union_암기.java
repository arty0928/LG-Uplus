package graph_0225;

public class Union_암기 {
	
		static int N;
		static int[] parents;

	static void make() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
		
	
	static int find(int v) {
		if(parents[v] == v) return v;
		
		return parents[v] = find(parents[v]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[aRoot] = bRoot;
		
		return true;
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N = 6;
		parents = new int[6];
	}

}
