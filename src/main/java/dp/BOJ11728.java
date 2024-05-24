package dp;

/*
 * @Title: 포도주 시식
 * @Link: https://www.acmicpc.net/problem/2156
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11728 {



    static int n;
    static int[] wines;

    static void dp() {
        int[][] dy = new int[n+1][2]; // dy 0 안마신다 1 마신다

        dy[1][0] = 0;
        dy[1][1] = wines[1];
        if(n < 2) {
            System.out.println(Math.max(dy[n][0],dy[n][1]));
            return;
        }
        dy[2][0] = dy[1][1];
        dy[2][1] = wines[2]+dy[1][1];
        for(int i=3; i<=n; i++) {
            dy[i][0] = Math.max(dy[i-1][0], dy[i-1][1]);
            dy[i][1] = wines[i]+Math.max(wines[i-1]+dy[i-2][0], dy[i-1][0]);
        }

        System.out.println(Math.max(dy[n][0],dy[n][1]));

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        wines = new int[n+1];
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            wines[i] = Integer.parseInt(st.nextToken());
        }

        dp();


        br.close();
    }
}
