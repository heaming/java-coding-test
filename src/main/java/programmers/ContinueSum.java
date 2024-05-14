package programmers;
/*
* @Title: 연속 펄스 부분 수열의 합
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/161988
*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class ContinueSum {

    static class Solution {

        public long solution(int[] sequence) {
            long answer = 0;
            long[][] dp = new long[sequence.length][2]; // 0 짝수는 *1 홀수는 *-1 // 1 짝수는 *-1 혹 *1

            dp[0][0] = sequence[0];
            dp[0][1] = sequence[0] * -1;

            answer = Math.max(dp[0][0], answer);
            answer = Math.max(dp[0][1], answer);

            for(int i=1; i<sequence.length; i++) {
                dp[i][0] = Math.max(dp[i-1][1]+sequence[i], sequence[i]);
                dp[i][1] = Math.max(dp[i-1][0]-sequence[i], sequence[i]*-1);

                answer = Math.max(answer, dp[i][0]);
                answer = Math.max(answer, dp[i][1]);
            }
            // System.out.println(Arrays.deepToString(dp));

            return answer;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.solution(new int[]{2, 3, -6, 1, 3, -1, 2, 4})); // 10
        }

    }
}
