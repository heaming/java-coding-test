package binarySearch;

/*
 * @Title: 공정 컨설턴트 호석
 * @Link: https://www.acmicpc.net/problem/22254
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ22254 {
    static int N;
    static int X;
    static int[] arr;

    static boolean canMake(int k) {

        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i=1; i<=k; i++) {
            que.offer(0);
        }

        for(int i=1; i<=N; i++) {
            int cur = que.poll();
            if(cur+arr[i] > X) return false;
            que.add(cur+arr[i]);
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int left = 1;
        int right = N;

        while(left <= right) {
            int mid = (left+right)/2;

            if(canMake(mid)) {
                answer = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        System.out.println(answer);

        br.close();
    }
}
