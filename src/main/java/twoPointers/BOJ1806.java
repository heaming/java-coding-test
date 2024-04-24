package twoPointers;

/*
 * @Title: 부분합
 * @Link: https://www.acmicpc.net/problem/1806
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1806 {
    static int N;
    static int S;
    static int[] arr;

    static int twoPointer() {
        int right = 0;
        int answer = N+1;
        int sum = 0;

        for(int left=1; left<=N; left++) {
            // left-1 을 구간에서 제외하기
            sum -= arr[left-1];

            // right를 옮길 수 있을 때까지 옮기기
            while(right+1 <= N && sum < S) {
                sum += arr[++right];
            }

            // [left ... right]의 합 = sum
            if(sum >= S) {
                answer = Math.min(answer, right - left +1);
            }
        }
        return answer == N+1 ? 0 : answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(twoPointer());


        br.close();
    }
}
