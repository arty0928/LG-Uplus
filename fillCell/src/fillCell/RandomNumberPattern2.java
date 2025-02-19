package fillCell;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
public class RandomNumberPattern2 {
    static int N, big, small;
    static int[][] map;

    static int[] dy = {-1,-1,-1,0,1,1,1,0};
    static int[] dx = {-1,0,1,1,1,0,-1,-1};

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/fillCell/RandomNumberPattern.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            big = 0;
            small = 0;

            // 1 ~ N-1 돌면서 8방 확인
            for (int r = 1; r < N - 1; r++) {
                for (int c = 1; c < N - 1; c++) {
                    check8dir(r, c);
                }
            }
            System.out.println("#" + test_case + " " + big + " " + small);
        }
    }

    static void check8dir(int y, int x) {
        int currentValue = map[y][x];
        boolean isBig = true;
        boolean isSmall = true;

        for (int i = 0; i < 8; i++) {
            int nr = y + dy[i];
            int nc = x + dx[i];
            int neighborValue = map[nr][nc];

            // 같은 경우, 더 큰 수도, 더 작은 수도 안됨.
            if (currentValue <= neighborValue) isBig = false;
            if (currentValue >= neighborValue) isSmall = false;

            // 둘 중 하나가 false가 되면 더 이상 확인할 필요 없음
            if (!isBig && !isSmall) return;
        }

        if (isBig) big++;
        if (isSmall) small++;
    }
}
