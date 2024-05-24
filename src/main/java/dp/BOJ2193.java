package dp;

/*
 * @Title: 이친수
 * @Link: https://www.acmicpc.net/problem/2193
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2193 {


    static int N;

    static void dp(int N) {
        long[][] dy = new long[91][2]; //[n자리][0//1]

        //0 dy[1][0]
        //1 dy[1][1] 1

        //1 dy[2][0] 10
        //0 dy[2][1]

        //1 dy[3][0] 100
        //1 dy[3][1] 101

        //2 dy[4][0] 1000 1010
        //1 dy[4][1] 1001

        //3 dy[5][0] 10000 10010 10100
        //2 dy[5][1] 10001 10101

        dy[1][0] = 0;
        dy[1][1] = 1;
        dy[2][0] = 1;
        dy[2][1] = 0;

        for(int i=3; i<=90; i++) {
            dy[i][0] = dy[i-1][0]+dy[i-1][1];
            dy[i][1] = dy[i-1][0];
        }

        System.out.println(dy[N][0]+dy[N][1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp(N);

        br.close();
    }
}
