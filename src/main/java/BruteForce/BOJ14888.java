package BruteForce;

/*
 * @Title: 연산자 끼워넣기
 * @Link: https://www.acmicpc.net/problem/14888
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {
    static int N;
    static int[] numbers;
    static int[] calc = new int[4]; // + - * /
    static int min = 1000000000;
    static int max = -1000000000;

    static void dfs(int idx, int res, int plus, int minus, int multi, int div) {
        if(idx >= N) {
            min = Math.min(res, min);
            max = Math.max(res, max);
            return;
        }


        if(plus > 0) {
            dfs(idx + 1, res + numbers[idx], plus-1, minus, multi, div);
        }
        if(minus > 0) {
            dfs(idx + 1, res - numbers[idx], plus, minus-1, multi, div);
        }
        if(multi > 0) {
            dfs(idx + 1, res * numbers[idx], plus, minus, multi-1, div);
        }
        if(div > 0) {
            dfs(idx + 1, res / numbers[idx], plus, minus, multi, div-1);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            calc[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, numbers[0], calc[0], calc[1], calc[2], calc[3]);
        System.out.println(max);
        System.out.println(min);
        br.close();
    }
}
