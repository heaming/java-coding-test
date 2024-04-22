package binarySearch;

/*
 * @Title: 두 용액
 * @Link: https://www.acmicpc.net/problem/2470
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2470 {
    static int N;
    static int[] arr;
    static int binary(int left, int right, int x) {
        int res = right+1;

        while(left <= right) {
            int mid = (left+right)/2;

            if(arr[mid] >= x) {
                res = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return res;
    }

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

        int min = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;

        for(int i=0; i<N-1; i++) {
            int res = binary(i+1, N-1, -arr[i]);

            if(i < res-1 && Math.abs(arr[i]+arr[res-1]) < min) {
                min = Math.abs(arr[i]+arr[res-1]);
                a = arr[i];
                b = arr[res-1];
            }

            if(res < N && Math.abs(arr[i]+arr[res]) < min) {
                min = Math.abs(arr[i]+arr[res]);
                a = arr[i];
                b = arr[res];
            }
        }

        System.out.println(a + " " + b);

        br.close();
    }
}
