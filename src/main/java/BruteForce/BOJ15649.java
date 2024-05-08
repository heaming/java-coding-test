package BruteForce;

/*
 * @Title: n과 m
 * @Link: https://www.acmicpc.net/problem/15649
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {
    static int N;
    static int M;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    static void solution(int k, boolean[] visited) {
        if(k == M+1) {
            for(int i=1; i<=M; i++) {
                sb.append(selected[i]).append(" ");
            }
            System.out.println(sb);
            sb = new StringBuilder();
        } else {
            for(int cur=1; cur<=N; cur++) {
                if(!visited[cur]) {
                    selected[k] = cur;
                    visited[cur] = true;
                    solution(k + 1, visited);
                    selected[k] = 0;
                    visited[cur] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M+1];

        solution(1, new boolean[N+1]);

        br.close();
    }
}
