package binarySearch;

/*
 * @Title: 먹을 것인가 먹힐 것인가
 * @Link: https://www.acmicpc.net/problem/7795
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ7795 {
    static int T; // 테스트케이스 개수
    static int N;
    static int M;
    static List<int[]> A;
    static List<int[]> B;

    static void binary(int[] a, int[] b) {
        int answer = 0;

        // a[i] > b[x]
        for(int i=0; i<a.length; i++) {
            int temp = 0;
            int left = 0;
            int right = b.length-1;

            while(left <= right) {
                int mid = (left+right) / 2;

                if(b[mid] < a[i]) {
                    left = mid+1;
                    temp = mid+1;
                } else {
                    right = mid-1;
                }
            }
            answer += temp;
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        A = new ArrayList<>();
        B = new ArrayList<>();

        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int[] a = new int[N];
            int[] b = new int[M];

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                b[j] = Integer.parseInt(st.nextToken());
            }

            // 1. 정렬
            Arrays.sort(b);

            A.add(a);
            B.add(b);
//            System.out.println(Arrays.toString(A.get(i)));
//            System.out.println(Arrays.toString(B.get(i)));
        }

        for(int i=0; i<T; i++) {
            binary(A.get(i), B.get(i));
        }


        br.close();
    }
}
