package dp;

/*
 * @Title: 피보나치 함수
 * @Link: https://www.acmicpc.net/problem/1003
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1003 {
    static int T;

    static void dp(int x) {

        int[] zero = new int[x+1];
        int[] one = new int[x+1];

        zero[0] = 1;
        one[0] = 0;

        if(x == 0) {
            System.out.println(zero[0] +" "+one[0]);
            return;
        }

        zero[1] = 0;
        one[1] = 1;

        if(x == 1) {
            System.out.println(zero[1] +" "+one[1]);
            return;
        }
        zero[2] = zero[0]+zero[1];
        one[2] = one[1]+one[0];
        for(int i=3; i<=x; i++) {
            zero[i] = zero[i-1]+zero[i-2];
            one[i] = one[i-1]+one[i-2];
        }

//        System.out.println(Arrays.toString(zero));
//        System.out.println(Arrays.toString(one));
        System.out.println(zero[x] + " " +one[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            dp(x);
        }


        br.close();
    }
}
