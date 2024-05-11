package programmers;
/*
* @Title: 산 모양 타일링
* @Link:  https://school.programmers.co.kr/learn/courses/30/lessons/258705
* @Tag : dp
*/

import java.util.Arrays;

public class Kakao2024_MountainTiling {

    static class Solution {
        public int solution(int n, int[] tops) {
            int answer = 0;
            int[][] dp = new int[n+1][2]; // 0 마지막 칸 마름모 o / 1 마지막 칸 마름모 x

            dp[0][1] = 1;
            for(int i=1; i<=n; i++) {
                dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % 10007;

                if(tops[i-1] == 0) {
                    // 왼쪽에 마름모 (x 1)
                    dp[i][1] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][1]) % 10007;
                } else if (tops[i-1] == 1) {
                    // 왼쪽에 마름모(x 1, 2, 12)
                    dp[i][1] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][1] + dp[i-1][1] + dp[i-1][0]) % 10007;
                }
            }

            return (dp[n][0]+dp[n][1])%10007;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4, new int[]{1,1,0,1}));// 149
        System.out.println(solution.solution(2, new int[]{0,})); //11
//        System.out.println(Arrays.toString(solution.solution(2, 8))); //7704

    }
}
