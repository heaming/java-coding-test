package BruteForce;

/*
 * @Title: 부분 수열의 합
 * @Link: https://www.acmicpc.net/problem/1182
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182 {
    static int N;
    static int S;
    static int[] numbers;
    static int answer = 0;

    static void dfs(int k, int value) {
        if(k==N+1) {
            if(value == S) answer++;
        } else {
            dfs(k+1, value+numbers[k]);
            dfs(k+1, value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, 0);

        if(S==0) answer--;
        System.out.println(answer);

        br.close();
    }
}
