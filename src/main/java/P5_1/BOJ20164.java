package P5_1;

/*
 * @Title: 홀수 홀릭 호석
 * @Link: https://www.acmicpc.net/problem/20164
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ20164 {
    static String N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;


    static int cnt(String s) {
        int cnt = 0;

        for(int i=0; i<s.length(); i++) {
            if(Integer.parseInt(String.valueOf(s.charAt(i)))%2 == 1) cnt++;
        }

        return cnt;
    }


    static void dfs(String str, int odd) {
        int cnt = cnt(str);

        // 한자리 종료
        if(str.length() <= 1) {
            max = Math.max(odd+cnt, max);
            min = Math.min(odd+cnt, min);
            return;
        }


        // 두 자리 -> 각자리 합하기
        if(str.length() == 2) {
            int sum = Integer.parseInt(str.substring(0, 1)) + Integer.parseInt(str.substring(1));
            dfs(String.valueOf(sum), odd+cnt);
        } else {
        // 세 자리 -> x에서 끊어서 3개로 분할 3개를 더함
            for(int i=1; i<str.length()-1; i++) {
                for(int j=i+1; j<str.length(); j++) {
                    int a = Integer.parseInt(str.substring(0,i));
                    int b = Integer.parseInt(str.substring(i, j));
                    int c = Integer.parseInt(str.substring(j));

                    dfs(String.valueOf(a+b+c), odd+cnt);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = st.nextToken();

        dfs(N, 0);

        System.out.println(min + " " + max);

        br.close();
    }
}
