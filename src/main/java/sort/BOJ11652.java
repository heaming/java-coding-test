package sort;

/*
 * @Title: 카드
 * @Link: https://www.acmicpc.net/problem/11652
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ11652 {
    static int N;
    static long[] arr;
    static long curCnt;
    static long maxCnt;
    static long maxNum;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new long[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        curCnt = 1;
        maxCnt = 1;
        maxNum = arr[0];

        for(int i=1; i<N; i++) {
            if(arr[i-1] == arr[i]) {
                curCnt++;
            } else {
                curCnt = 1;
            }

            if(curCnt > maxCnt) {
                maxNum = arr[i];
                maxCnt = curCnt;
            }
        }

        System.out.println(maxNum);

        br.close();
    }
}
