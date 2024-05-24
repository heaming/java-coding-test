package dp;

/*
 * @Title: 내려가기
 * @Link: https://www.acmicpc.net/problem/2096
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2096 {

    static void dp(){
        int[][] min = new int[N+1][3];
        int[][] max = new int[N+1][3];

        for(int i=2; i<=N; i++) {
            for(int j=0; j<3; j++) {
                min[i][j] = 900_000;
                max[i][j] = 0;
            }
        }

        for(int i=0; i<3; i++) {
            min[1][i] = map[1][i];
            max[1][i] = map[1][i];
        }

        for(int i=2; i<=N; i++) {
            for(int prev=0; prev<3; prev++) {
                for(int cur : new int[]{prev-1, prev, prev+1}) {
                    if(cur<0 || cur>=3) continue;
                    min[i][cur] = Math.min(min[i-1][prev]+map[i][cur], min[i][cur]);
                    max[i][cur] = Math.max(max[i-1][prev]+map[i][cur], max[i][cur]);
                }
            }
        }

        int a = Arrays.stream(max[N]).max().getAsInt();
        int b = Arrays.stream(min[N]).min().getAsInt();
        System.out.println(a + " " + b);
    }



    static int N;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N+1][3];
        for(int i = 1; i<= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp();


        br.close();
    }
}
