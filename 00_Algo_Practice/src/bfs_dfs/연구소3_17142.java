
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class 연구소3_17142 {

    static int N, M, min;
    static int[][] board;
    static List<pos> virus;

    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        virus = new ArrayList<>();

        min = Integer.MAX_VALUE;
        int target = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 2) {
                    virus.add(new pos(i, j, 0));
                } else if (tmp == 0) {
                    target++;
                }
                board[i][j] = tmp;
            }
        }

        if (target == 0) {
            System.out.println(0);
            return;
        }

        makeComb(0, new ArrayList<>(), target);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(min);
    }

    static int bfs(List<pos> v, int target) {

        Deque<pos> q = new ArrayDeque<>();
        int[][] copy = copyMap();

        for (pos p : v) {
            q.add(p);
            copy[p.y][p.x] = 1;
        }

        while (!q.isEmpty()) {
            pos cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d], nx = cur.x + dx[d];

                if (inRange(ny, nx) && copy[ny][nx] != 1) {

                    if (copy[ny][nx] == 0) {
                        target--;
                    }
                    if (target == 0) {
                        return cur.count + 1;
                    }

                    copy[ny][nx] = 1;

                    q.add(new pos(ny, nx, cur.count + 1));

                }
            }
        }
        return Integer.MAX_VALUE;
    }

    static int[][] copyMap() {
        int[][] copy = new int[N][N];

        for (int i = 0; i < N; i++) {
            copy[i] = Arrays.copyOf(board[i], N);
        }
        return copy;
    }

    static boolean inRange(int y, int x) {
        return -1 < y && y < N && -1 < x && x < N;
    }

    static void makeComb(int start, List<pos> cur, int target) {
        if (cur.size() == M) {
            min = Math.min(min, bfs(cur, target));
            return;
        }

        for (int i = start, size = virus.size(); i < size; i++) {
            cur.add(virus.get(i));
            makeComb(i + 1, cur, target);
            cur.remove(cur.size() - 1);
        }
    }

    static class pos {

        int y, x, count;

        public pos(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
}
