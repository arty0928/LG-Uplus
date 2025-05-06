import java.util.*;

/*
    dp로 r+1 c+1길이만큼 해서 0행, 0열에 0으로 초기화
    1이면 
        좌, 상, 왼상 min + 1 
    dp는 해당 위에서 만들 수 있는 정사각형의 변의 길이
    max 업데이트 

    answer * answer
*/
class Solution {
    public int maximalSquare(char[][] matrix) {
        int r = matrix.length, c = matrix[0].length;

        int[][] dp = new int[r+1][c+1];
        int answer = 0;

        for(int i = 1; i <= r; i++){
            for(int j = 1; j <= c; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i- 1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        return answer* answer;
    }
}