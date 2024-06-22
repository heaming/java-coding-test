package prefix_sum;

/*
 * @Title: 수열
 * @Link: https://www.acmicpc.net/problem/2259
 * @Tag : 구간 합
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2559 {
    static int N;
    static int K;
    static int[] arr;
    static int[] prefix;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        prefix = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i-1]+arr[i];
        }

        for(int i=K; i<=N; i++) {
            max = Math.max(prefix[i]-prefix[i-K], max);
        }

        System.out.println(max);

        br.close();
    }
}
