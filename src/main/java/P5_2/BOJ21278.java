package P5_2;

/*
 * @Title: 호석이 두마리 치킨
 * @Link: https://www.acmicpc.net/problem/21278
 * @Tag : 플루이드 와샬
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ21278 {
    static int N;
    static int M;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];

        int answer = Integer.MAX_VALUE;
        int city1 = 0;
        int city2 = 0;


        for(int i=0; i<=N; i++) {
            for(int j=0; j<=N; j++) {
                map[i][j] = i == j ? 0 : 100*100;
            }
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }

        // i -> stop -> j :: x = stop 일때, 거리
        for(int stop=1; stop<=N; stop++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    map[i][j] = Math.min(map[i][stop]+map[stop][j], map[i][j]);
                }
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                int time = 0;

                for(int stop=1; stop<=N; stop++) {
                    if(stop == i || stop == j) continue;
                    time += Math.min(map[i][stop], map[j][stop]);
                }

                if(time < answer) {
                    answer = time;
                    city1 = Math.min(i,j);
                    city2 = Math.max(i,j);
                }
            }
        }

        System.out.println(city1 +" "+ city2+" " +answer*2);

        br.close();
    }
}
