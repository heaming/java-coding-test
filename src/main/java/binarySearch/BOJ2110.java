package binarySearch;

/*
 * @Title: 공유기 설치
 * @Link: https://www.acmicpc.net/problem/2110
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2110 {
    // 가장 인접한 공유기, 최대 거리
    static int N;
    static int C;
    static int[] house;

    static boolean install(int dist) {
        int count = 1;
        int last = house[0];
        for(int i=1; i<N; i++) {
            if(house[i]-last >= dist) {
                count++;
                last = house[i];
            }
        }
        return count >= C;
    }

    static int binary(int left, int right) {
        int res = 0;

        while(left <= right) {
            int mid = (left+right)/2;

            if(install(mid)) {
                res= mid;
                left = mid+1;
            } else {
                right = mid-1;
            }

        }
        return res;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        house = new int[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            house[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(house);

        System.out.println(binary(1, 1000000000));

        br.close();
    }
}
