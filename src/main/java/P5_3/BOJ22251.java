package P5_3;

/*
 * @Title: 빌런 호석
 * @Link: https://www.acmicpc.net/problem/22251
 * @Tag : 구현
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ22251 {
    static int N;
    static int K;
    static int P;
    static int X;
    static int[][] light = {
        {1, 1, 1, 0, 1, 1, 1},
        {0, 0, 1, 0, 0, 1, 0},
        {1, 0, 1, 1, 1, 0, 1},
        {1, 0, 1, 1, 0, 1, 1},
        {0, 1, 1, 1, 0, 1, 0},
        {1, 1, 0, 1, 0, 1, 1},
        {1, 1, 0, 1, 1, 1, 1},
        {1, 0, 1, 0, 0, 1, 0},
        {1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 0, 1, 1}
    };

    // x -> y 할 때 차이
    static int cntDiff(int x, int y) {
        int res = 0;
        for(int i=0; i<7; i++) {
            if(light[x][i] != light[y][i]) res++;
        }
        return res;
    }

    static int diff(int x, int y) {
        int res = 0;
        for(int i=1; i<= K; i++) {
            res += cntDiff(x%10, y%10);
            x /= 10;
            y /= 10;
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int answer = 0;

        for(int i=1; i<=N; i++) {
            if(i == X) continue;
            if(diff(i, X) <= P) answer++;
        }

        System.out.println(answer);
        br.close();
    }
}
