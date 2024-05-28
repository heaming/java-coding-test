package P5_3;

/*
 * @Title: 호석사우로스
 * @Link: https://www.acmicpc.net/problem/22255
 * @Tag : 다익스트라
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ22255 {
    static int N;
    static int M;
    static int[] start;
    static int[] end;
    static int[][] map;
    static int[][][] dist;
    static int[][][] directions = {
            {{1,0},{-1,0}},
            {{0,1},{0,-1}},
            {{1,0},{0,1},{-1,0},{0,-1}}
    };

    static class Info {
        int y;
        int x;
        int move;
        int dist;

        public Info(int y, int x, int move, int dist) {
            this.y = y;
            this.x = x;
            this.move = move;
            this.dist = dist;
        }
    }

    static void dijkstra(int[] start) {

        PriorityQueue<Info> que = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        que.offer(new Info(start[0], start[1], 0, 0));
        dist[start[0]][start[1]][0] = 0;

        while(!que.isEmpty()) {
            Info cur = que.poll();

            if(dist[cur.y][cur.x][cur.move] != cur.dist) continue;

            int moveCnt = cur.move == 2 ? 4 : 2;
            for(int k=0; k<moveCnt; k++) {
                int ny = cur.y+directions[cur.move][k][0];
                int nx = cur.x+directions[cur.move][k][1];

                if(ny <1 || ny > N || nx <1 || nx>M) continue;
                if(map[ny][nx] == -1) continue;

                int nmove = (cur.move+1)%3;
                int ndist = cur.dist + map[ny][nx];

                if(dist[ny][nx][nmove] <= ndist) continue;

                dist[ny][nx][nmove] = ndist;
                que.offer(new Info(ny, nx, nmove, ndist));
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        start = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        end = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        map = new int[N+1][M+1];
        dist = new int[N+1][M+1][3]; // i행 j열에 3K+move번의 이동

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                for(int k=0; k<3; k++) {
                    dist[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        dijkstra(start);

        int ans = Integer.MAX_VALUE;
        for (int move = 0; move < 3; move++) {
            ans = Math.min(ans, dist[end[0]][end[1]][move]);
        }
        if (ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);

        br.close();
    }
}
