package programmers;
/*
* @Title: 최적의 행렬 곱셈
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/12942
* @Tag :
*/

import java.util.*;

import static java.lang.Math.min;

public class TheBestMultiple {

    static class Solution {

        static int[][] dp;

        public int solution(int[][] matrix_sizes) {
            int len = matrix_sizes.length;
            dp = new int[len][len];

            for(int i=0; i<len; i++) {
                for(int j=0; j<len; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }

            for(int i=0; i<len; i++) { // matrix[i] 행렬의 곱셈
                for(int j=0; j<len-i; j++) { // 시작 행렬
                    int a = j;
                    int b = j+i;

                    // 자기 자신은 곱할 수 없음
                    if(a==b) {
                        dp[a][b] = 0;
                    } else {
                        for (int k = a; k < b; k++) {
                            dp[a][b] = min(dp[a][b], dp[a][k] + dp[k + 1][b] + matrix_sizes[a][0] * matrix_sizes[k][1] * matrix_sizes[b][1]);
                        }
                    }
                }
            }

            return dp[0][dp[0].length-1];
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{5,3}, {3,10}, {10,6}})); // 270
    }

}
