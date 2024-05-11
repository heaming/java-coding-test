package programmers;
/*
* @Title: 등굣길
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/42898
* @Tag : dp
*/

import java.util.Arrays;

public class GoToSchool {

    static class Solution {

        static int MOD = 1_000_000_007;
        public int solution(int m, int n, int[][] puddles) {
            int answer = 0;
            int[][] dp = new int[m+1][n+1];

            for(int i=1; i<=m; i++) {
                for(int j=1; j<=n; j++) {
                    dp[i][j] = 1;
                }
            }

            for(int[] puddle : puddles) {
                dp[puddle[0]][puddle[1]] = 0;
            }

            dp[1][1] = 1;

            for(int i=1; i<=m; i++) {
                for(int j=1; j<=n; j++) {
                    if(i==1 && j==1 || dp[i][j] == 0) continue;

                    dp[i][j] = (dp[i-1][j]+ dp[i][j-1])%MOD;
                }
            }

            return (dp[m][n])%MOD;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.solution(4, 3, new int[][]{{2, 2}})); // 4
        }
    }
}
