package dp;

/*
 * @Title: 오르막수
 * @Link: https://www.acmicpc.net/problem/11057
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11057 {
    static int N;
    static int MOD = 10007;

    static void dp(){

        // 길이가 n이고 num으로 끝나는 수
        int[][] dy = new int[N+1][10];

        for(int num=0; num<=9; num++) {
            dy[1][num] = 1;
        }

        for(int i=2; i<=N; i++) {
            for(int num=0; num<=9; num++) {
                for(int prev=0; prev<=num; prev++) {
                    dy[i][num] += dy[i - 1][prev]%MOD;
                }
            }
        }

        int sum = 0;
        for(int i=0; i<=9; i++) {
            sum += dy[N][i]%MOD;
        }
        System.out.println(sum%MOD);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp();

        br.close();
    }
}
