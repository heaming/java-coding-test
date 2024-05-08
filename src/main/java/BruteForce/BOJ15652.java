package BruteForce;

/*
 * @Title: n과 m
 * @Link: https://www.acmicpc.net/problem/15652
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15652 {
    static int N;
    static int M;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    static void solution(int k) {
        if(k == M+1) {
            for(int i=1; i<=M; i++) {
                sb.append(selected[i]).append(" ");
            }
            System.out.println(sb);
            sb = new StringBuilder();
        } else {
            int start = selected[k-1];
            if(start==0) start = 1;
            for(int cur=start; cur<=N; cur++) {
                    selected[k] = cur;
                    solution(k + 1);
                    selected[k] = 0;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M+1];

        solution(1);

        br.close();
    }
}
