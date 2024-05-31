package devide;

/*
 * @Title: 수 정렬하기2
 * @Link: https://www.acmicpc.net/problem/2751
 * @Tag: 합병정렬, 분할정복
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2751 {
    static int N;
    static int[] arr;
    static int[] temp;

    static void divide(int start, int end) {
        if(start == end) return;
        int mid = (start+end)/2;

        divide(start, mid);
        divide(mid+1, end);
        combine(start, end);
    }

    static void combine(int start, int end) {
        int mid = (start+end)/2;

        int left = start;
        int right = mid+1;
        int newIdx = start;

        while(left<=mid && right<=end) {
            if(arr[left] < arr[right]) {
                temp[newIdx++] = arr[left++];
            } else {
                temp[newIdx++] = arr[right++];
            }
        }

        while(left <= mid) {
            temp[newIdx++] = arr[left++];
        }

        while(right<= end) {
            temp[newIdx++] = arr[right++];
        }

        for(int i=start; i<=end; i++) {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        temp = new int[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        divide(0, N-1);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) sb.append(arr[i]).append("\n");

        System.out.println(sb);

        br.close();
    }
}
