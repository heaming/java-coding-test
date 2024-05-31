package devide;

/*
 * @Title: Z
 * @Link: https://www.acmicpc.net/problem/1074
 * @Tag: 분할정복
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1074 {
    static int N;
    static int r;
    static int c;

    static int answer = 0;

    static void recursive(int n, int rr, int cc) {
        // 2^n == 1 << n
        int size = 1 << n;
        int mid = size/2;

        if(n == 0) {
            return;
        }

        if(rr<mid && cc<mid) {
            recursive(n-1, rr, cc);
        } else if(rr<mid && cc>=mid) {
            answer += mid*mid;
            recursive(n-1, rr, cc-mid);
        } else if(rr>=mid && cc<mid) {
            answer += mid*mid*2;
            recursive(n-1, rr-mid, cc);
        } else {
            answer += mid*mid*3;
            recursive(n-1, rr-mid, cc-mid);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // 0. 좌상 / 우상 / 좌하 / 우하
        // 1. (r,c)가 어느 영역에 있는지
        // r<mid c<mid -> 좌상
        // r<mid c>=mid -> 우상
        // r>=mid c<mid -> 좌하
        // r>=mid c>=mid -> 우하
        // 2. mid=n/2 :: 2^(n/2) + 자신의 위치
        // 좌상 : (r,c)
        // 우상 : 4+(r,c)
        // 좌하 : 4+4+(r,c)
        // 우하 : 4+4+4+(r,c)

        recursive(N, r, c);
        System.out.println(answer);


        br.close();
    }
}
