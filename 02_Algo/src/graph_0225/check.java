package graph_0225;

import java.util.Arrays;
import java.util.Scanner;

public class check {
    static int N, M, K;
    static int[] parents;
    static int[] friendFee;

    public static void make() {
        parents = new int[N]; // 배열 할당 추가
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }

    public static int find(int v) {
        if (parents[v] == v) return v;
        return parents[v] = find(parents[v]); // 패스 압축 적용
    }

    public static void union(int v, int w) {
        int vRoot = find(v);
        int wRoot = find(w);

        if (vRoot == wRoot) return; // 이미 같은 그룹이면 종료

        // 비용이 더 적은 쪽으로 합치기
        if (friendFee[vRoot] < friendFee[wRoot]) {
            parents[wRoot] = vRoot;
        } else {
            parents[vRoot] = wRoot;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 학생 수
        M = sc.nextInt(); // 친구 관계 수
        K = sc.nextInt(); // 가지고 있는 돈

        friendFee = new int[N];

        for (int i = 0; i < N; i++) {
            friendFee[i] = sc.nextInt(); // 친구비 입력
        }

        make(); // 유니온 파인드 초기화

        // 친구 관계 입력 및 연결
        for (int i = 0; i < M; i++) {
            int v = sc.nextInt() - 1;
            int w = sc.nextInt() - 1;
            union(v, w); // 친구 관계 연결
            System.out.println(Arrays.toString(parents));
        }

        // 최소 비용 계산
        int total = 0;
        boolean[] visited = new boolean[N];

        System.out.println(Arrays.toString(parents));

        for (int i = 0; i < N; i++) {
            int root = find(i);
            
            System.out.println("root = " + root + "  i = " + i);
            if (!visited[root]) { // 방문하지 않은 루트라면
                total += friendFee[root]; // 최소 비용 추가
                visited[root] = true;
            }
        }

        // 돈이 부족하면 "Oh no" 출력
        if (total > K) {
            System.out.println("Oh no");
        } else {
            System.out.println(total);
        }

        sc.close();
    }
}
