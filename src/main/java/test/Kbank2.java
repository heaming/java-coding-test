package test;

import java.util.ArrayList;
import java.util.List;

class Kbank2 {
    static List<Integer> list = new ArrayList<>();
    static int answer = 0;
    static void dfs(int[] rates, int userW, int userD, int day) {
        if (userW < 0) {
            return;
        }
        if(day > rates.length) {
            if(userW > 0) answer = Math.max(answer, userW);
            return;
        }

        int rate = rates[day-1];
        // 살 수 있는 경우
        if(userD == 0) {
            dfs(rates, userW-rate, 1, day + 1);
            // 안 산다
            dfs(rates, userW, 0, day + 1);
        } else if(userD == 1) {
            // 판다
            dfs(rates, userW+rate, 0, day + 1);
            // 안판다
            dfs(rates, userW, 1, day + 1);
        }
    }
//    public int solution(int k, int[] rates) {
//        // 1달러 구입 여부
//
//        dfs(rates, k, 0, 1);
//        return answer;
//    }

    static int solution(int k, int[] rates) {
        int rateLen = rates.length;
        int[][] dp = new int[rateLen+1][2]; // dp[day][userD] userD 0구입가능 / 1구입불가능

        for(int[] arr : dp) {
            arr[0] = -1;
            arr[1] = -1;
        }

        dp[0][0] = k;

        for (int day=1; day<=rateLen; day++) {
            int rate = rates[day-1];

            dp[day][1] = dp[day-1][1];
            if(dp[day-1][0] >= rate) { // 구입 가능
                dp[day][1] = Integer.max(dp[day-1][0]-rate, dp[day-1][1]);
            }

            dp[day][0] = dp[day-1][0];
            if(dp[day-1][1] >= 0) { // 팔기 가능
                dp[day][0] = Integer.max(dp[day-1][1]+rate, dp[day-1][0]);
            }
        }
        return Integer.max(dp[rateLen][0], dp[rateLen][1]);
    }

    public static void main(String[] args) {
        Kbank2 solution = new Kbank2();

        System.out.println(solution.solution(1000, new int[]{1200, 1000, 1100, 1200, 900, 1000, 1500, 900, 750, 1100})); // 2150
        System.out.println(solution.solution(1500, new int[]{1500, 1400, 1300, 1200})); // 1500
    }
}

