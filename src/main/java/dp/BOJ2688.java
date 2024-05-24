package dp;

/*
 * @Title: 줄어들지 않아
 * @Link: https://www.acmicpc.net/problem/2688
 * @Tag : dp
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2688 {


    static int T;
    static int n;

    static long[][] dp() {
        long[][] dy = new long[65][10]; // 길이가 n이고, num으로 끝나는 갯수 [N][0~9]

        for(int num=0; num<=9; num++) {
            dy[1][num] = 1;
        }

        // dy[1][1] -> 1
        // dy[2][1] -> 01 11
        // dy[1][0] 0 dy[1][1] 1 dy[1][2] 2
        // dy[2][2] -> 02 12 22

        for(int i=2; i<=64; i++) {
            for(int num=0; num<=9; num++) {
                for(int prev=0; prev<=num; prev++) {
                    dy[i][num] += dy[i-1][prev];
                }
            }
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
            long[][] dp = dp();
            long sum = 0;
            for(int num=0; num<=9; num++) {
                sum += dp[n][num];
            }
            System.out.println(sum);
        }



        br.close();
    }
}
