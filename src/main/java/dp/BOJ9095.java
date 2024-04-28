package dp;

/*
 * @Title: 1,2,3 더하기
 * @Link: https://www.acmicpc.net/problem/9095
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ9095 {
    static int T;
    static int[] Q;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        Q = new int[T];

        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            Q[i] = Integer.parseInt(st.nextToken());
        }

        dy = new int[12];

        // 초기값 설정
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;

        // 점화식 토대로 dy 채우기
        for(int i=4; i<=11; i++) {
            dy[i] = dy[i-1] + dy[i-2] + dy[i-3];
        }

        for(int i=0; i<T; i++) {
            int n = Q[i];
            System.out.println(dy[n]);
        }
        br.close();
    }
}
