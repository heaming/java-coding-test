package twoPointers;

/*
 * @Title: 두 용액
 * @Link: https://www.acmicpc.net/problem/2470
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        int left = 0;
        int right = N-1;

        while(left < right) { // left == right -> 용액이 1개뿐인 상황
            int sum = arr[left] + arr[right];
            if(Math.abs(sum) < answer) {
                answer = Math.abs(sum);
                a = arr[left];
                b = arr[right];
            }

            if(sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(a + " " + b);

        br.close();
    }
}
