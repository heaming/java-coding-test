package twoPointers;

/*
 * @Title: List of Unique Numbers
 * @Link: https://www.acmicpc.net/problem/13144
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ13144 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        int[] cnt = new int[100000+1];

        // 각 left 마다 right를 최대한 옮겨준다
        for (int left=1, right=0; left<=N; left++) {
            // right를 옮길 수 있을 만큼 옮긴다
            while(right+1<=N && cnt[arr[right+1]] == 0) {
                right++;
                cnt[arr[right]]++;
            }

            answer += right-left+1;
            cnt[arr[left]]--;
        }

        System.out.println(answer);

        br.close();
    }
}
