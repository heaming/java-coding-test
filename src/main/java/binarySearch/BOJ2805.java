package binarySearch;

/*
 * @Title: 나무 자르기
 * @Link: https://www.acmicpc.net/problem/2805
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2805 {
    static int N; // 나무 수
    static long M; // 나무의 길이
    static long[] trees;

    static long calc(long[] trees, long h) {
        long res = 0;
        for(long tree : trees) {
            if(tree >= h) res += tree-h;
        }
        return res;
    }

    static long binary(long h) {
        long res = 0;

        long min = 1;
        long max = trees[N-1];

        while(min <= max) {
            long mid = (min+max)/2;

            if(calc(trees, mid) >= h) {
                min = mid+1;
                res = mid;
            } else {
                max = mid-1;
            }
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        trees = new long[N];

        for(int i=0; i<N; i++) {
            trees[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(trees);
        long answer = Long.MIN_VALUE;

        answer = Math.max(binary(M), answer);
        System.out.println(answer);

        br.close();
    }
}
