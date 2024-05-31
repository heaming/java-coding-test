package dp;

/*
 * @Title: 스티커
 * @Link: https://www.acmicpc.net/problem/9465
 * @Tag : dp
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ9465 {


    static int T;
    static int n;
    static int[][] scores;

    static int[][] dp() {
        int[][] dy = new int[2][n+1]; // dy[층] -> i 떼는 경우를 센다
        // scores[0][0] dy[0] -> 뗄수 없음 scores[0][1] scores[1][0]
        // scores[1][0] dy[2*x+N]-> scores[0][0] scores[1][1]
        // scores[1][1] dy[2*x+N] -> scores[1][0] scores[1][2] scores[0][1]

        dy[0][1] = scores[0][1];
        dy[1][1] = scores[1][1];

        for(int i=2; i<=n; i++) {
            dy[0][i] = scores[0][i]+Math.max(dy[1][i-1], dy[1][i-2]);
            dy[1][i] = scores[1][i]+Math.max(dy[0][i-1], dy[0][i-2]);
        }

        return dy;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            scores = new int[2][n+1];
            for (int i = 0; i < 2; i++) { // 1
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) { // 1
                    scores[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] dp = dp();
            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }



        br.close();
    }
}
