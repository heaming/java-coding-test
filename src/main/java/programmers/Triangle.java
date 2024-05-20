package programmers;
/*
* @Title: 정수 삼각형
* @Link:  https://school.programmers.co.kr/learn/courses/30/lessons/43105
* @Tag : dp
*/

import java.util.Arrays;

public class Triangle {

    static class Solution {
        public int solution(int[][] triangle) {
            int[][] dp = new int[triangle.length][triangle.length]; // 0 왼쪽 1 오른쪽

            dp[0][0] = triangle[0][0];

            for(int i=1; i<triangle.length; i++) {
                dp[i][0] = triangle[i][0] + dp[i-1][0];

                for(int j=1; j<i+1; j++) {
                    dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1] , dp[i-1][j]);
                }

            }
            return Arrays.stream(dp[triangle.length-1]).max().getAsInt();
        }
        public static void main(String[] args) {
            Solution solution = new Solution();//30
            System.out.println(solution.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
        }
    }
}
