package dp;

/*
 * @Title: 카드 구매하기
 * @Link: https://www.acmicpc.net/problem/11052
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11052 {
    static int N;
    static int[] card;

    static void dp() {

        int[] dy = new int[N+1]; // 카드 2장을 살 때, a개

        // 카드 1개를 살 때 최댓값
        dy[0] = 0;

        for(int i=1; i<=N; i++) {
            for(int cnt=1; cnt<=i; cnt++) {
                dy[i] = Math.max(dy[i], dy[i-cnt]+card[cnt]);
            }
        }

        System.out.println(dy[N]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        card = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int t = 1; t<= N; t++) {
            card[t] = Integer.parseInt(st.nextToken());
        }

        dp();

        br.close();
    }
}
