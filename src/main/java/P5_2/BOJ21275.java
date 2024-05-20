package P5_2;

/*
 * @Title: 폰 호석만
 * @Link: https://www.acmicpc.net/problem/21275
 * @Tag : 완전탐색
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21275 {
    static String A;
    static String B;
    static long maximum = Long.MAX_VALUE;

    static int toTen(char c) {
        if('0' <= c && c <= '9') return c-'0';
        return c-'a'+10;
    }

    static long convertTo(String str, int base) {
        long res = 0;

        for(char c: str.toCharArray()) {
            if(toTen(c) >= base) return -1;
            if(res > (maximum - toTen(c))/base) return -1;
            res = res*base + toTen(c);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = st.nextToken();
        B = st.nextToken();
        long answer = -1;
        long answerA = 0;
        long answerB = 0;

        for(int a=2; a<=36; a++) {
            long aa = convertTo(A,a);
            if(aa == -1) continue;
            for(int b=2; b<=36; b++) {
                if(a == b) continue;

                long bb = convertTo(B,b);
                if(bb == -1) continue;

                if(aa == bb) {
                    if(answer == -1) {
                        answer = bb;
                        answerA = a;
                        answerB = b;
                    } else {
                        System.out.println("Multiple");
                        return;
                    }
                }
            }
        }

        if(answer == -1) System.out.println("Impossible");
        else System.out.println(answer+" "+answerA+" "+answerB);



        br.close();
    }
}
