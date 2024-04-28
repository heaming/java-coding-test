package dp;

/*
 * @Title: 계단 오르기
 * @Link: https://www.acmicpc.net/problem/2579
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2579 {
    static int n;
    static int[] stair;
    static int[][] dy; // 0 이전 안밟음 1 밟음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        stair = new int[n+1];
        dy = new int[n+1][2];

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            stair[i] = Integer.parseInt(st.nextToken());
        }

        dy[1][0] = 0;
        dy[1][1] = stair[1];

        if(n >=2) {
            dy[2][0] = stair[2];
            dy[2][1] = stair[1]+stair[2];
        }

        for(int i=3; i<=n; i++) {
            dy[i][0] = Math.max(dy[i-2][0]+stair[i], dy[i-2][1]+stair[i]);
            dy[i][1] = dy[i-1][0]+stair[i];
        }

        System.out.println(Math.max(dy[n][1], dy[n][0]));

        br.close();
    }
}
