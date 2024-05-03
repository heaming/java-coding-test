package dp;

/*
 * @Title: 2*N타일링
 * @Link: https://www.acmicpc.net/problem/11726
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11726 {
    static int n;
    static int[] dy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dy = new int[n+1];

        // 1세로 2가로
        // 1*i + 2*j = N
        // 1 1 1 2 / 2 2 1 / 1 1 1 1 1 / 1 2 2 / 2 1 1
        // dy[1] = 1
        // dy[2] = 2
        // dy[3] = 3 -> 1 1 1 / 1 2 / 2 1
        // dy[4] = 5 -> 1 1 1 1 / 1 1 2 / 1 2 1 / 2 1 1 / 2 2
        // dy[5] = 8 -> 1 1 1 1 1 / 1 1 1 2 / 1 1 2 1 / 1 2 1 1 / 2 1 1 1 / 2 2 1 / 2 1 2 / 1 2 2

        dy[1] = 1;
        dy[2] = 2;
        for(int i=3; i<=n; i++) {
            dy[i] = (dy[i-1]+dy[i-2])%10007;
        }

        System.out.println(dy[n]%10007);

        br.close();
    }
}
