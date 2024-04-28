package dp;

/*
 * @Title: 파일 합치기
 * @Link: https://www.acmicpc.net/problem/11066
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11066 {
    static int T;
    static int K;
    static int[] cases;
    static int[][] dy;
    static int[][] sum;

    static void calcSum() {
        for(int i=1; i<= K; i++) {
            for(int j=i; j<=K; j++) {
                sum[i][j] = sum[i][j-1]+cases[j];
            }
        }
    }

    public static void dp() {
        calcSum();
        dy = new int[K+1][K+1];

        for(int len=2; len <= K; len++) {
            for(int i=1; i<= K-len+1; i++) {
                int j= i+len-1;
                dy[i][j] = Integer.MAX_VALUE;

                for(int k=i; k<j; k++) {
                    dy[i][j] = Math.min(dy[i][j], dy[i][k]+dy[k+1][j]+sum[i][j]);
                }
            }
        }
        System.out.println(dy[1][K]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for(int j=0; j<T; j++) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            cases = new int[K+1];
            sum = new int[K+1][K+1];
            st = new StringTokenizer(br.readLine());

            for(int i=1; i<=K; i++){
                cases[i] = Integer.parseInt(st.nextToken());
            }
            dp();
        }
        br.close();
    }
}
