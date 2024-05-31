package dp;

/*
 * @Title: 암호코드
 * @Link: https://www.acmicpc.net/problem/2011
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2011 {
    static String N;
    static int len;
    static int MOD = 1000000;

    static int charToNum(char c) {
        return c-64;
    }

    static char numToStr(int n) {
        return (char) (n+64);
    }

    static boolean check(char a, char b) {
        if(a=='0') return false;
        if(a=='1') return true;
        if(a >= '3') return false;
        return b <= '6';
    }

    static void dp() {
        int[] dy = new int[len];

        if(N.charAt(0) != '0') {
            dy[0] = 1;
        }

        for(int i=1; i<len; i++) {
            // i번 단독 해석 가능 {
            if(N.charAt(i) != '0') {
                dy[i] = dy[i-1];
            }

            // i-1 i -> 2 6 z로 해석 가능
            if(check(N.charAt(i-1), N.charAt(i))) {
                if(i >= 2) {
                    dy[i] += dy[i-2];
                } else {
                    dy[i] += 1;
                }
                dy[i] %= MOD;
            }
        }
        System.out.println(dy[len-1]);


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = st.nextToken();
        len = N.length();

        dp();
        br.close();
    }
}
