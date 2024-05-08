package BfsDfs;

/*
 * @Title: 탈출
 * @Link: https://www.acmicpc.net/problem/3055
 */

import java.io.*;
import java.util.*;

public class BOJ3055 {

    static int R;
    static int C;
    static char[][] roads;

    static Queue<Node> waterQue = new LinkedList<>();
    static int[][] water;
    static int[][] dist;

    static int[] dx = new int[]{0,0,1,-1};
    static int[] dy = new int[]{1,-1,0,0};

    static Node start;
    static Node end;
    static boolean[][] visited;

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static void water() {
        while (!waterQue.isEmpty()) {
            Node cur = waterQue.poll();
            int cc = cur.c;
            int cr = cur.r;

            for(int i=0; i<4; i++) {
                int nr = cr+dy[i];
                int nc = cc+dx[i];

                if(nr == end.r && nc == end.c) continue;

                if(nr>=0 && nr<R && nc>=0 && nc<C && !visited[nr][nc] && roads[nr][nc] != 'X') {
                    water[nr][nc] = water[cr][cc]+1;
                    visited[nr][nc] = true;
                    waterQue.offer(new Node(nr, nc));
                }
            }

        }
    }

    static void find() {
        Queue<Node> que = new LinkedList<>();
        que.offer(start);
        visited = new boolean[R][C];
        visited[start.r][start.c] = true;

        while(!que.isEmpty()) {
            Node cur = que.poll();
            int cr = cur.r;
            int cc = cur.c;

            for (int i=0; i<4; i++) {
                int nr = cr+dx[i];
                int nc = cc+dy[i];

                if(nc>=0 && nc<C && nr>=0 && nr<R && !visited[nr][nc] && roads[nr][nc] != 'X') {
                    int time = dist[cr][cc]+1;
                    if(time < water[nr][nc] || (nc==end.c && nr == end.r)) {
                        dist[nr][nc] = time;
                        que.offer(new Node(nr, nc));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        roads = new char[R][C];
        water = new int[R][C];
        dist = new int[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j=0; j<C; j++) {
                char point = str.charAt(j);
                roads[i][j] = point;
                water[i][j] = -1;
                if(point == '*') {
                    water[i][j] = 0;
                    waterQue.offer(new Node(i, j));
                    visited[i][j] = true;
                } else if (point == 'S') {
                    start = new Node(i, j);
                } else if (point == 'D') {
                    end = new Node(i, j);
                }
            }
        }

        water();
        find();
        System.out.println(dist[end.r][end.c] > 0 ? dist[end.r][end.c] : "KAKTUS");

        bw.flush();
        br.close();
        bw.close();
    }

}
