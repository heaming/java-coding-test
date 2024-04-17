package baekjoon;

/*
 * @Title: 빙산
 * @Link: https://www.acmicpc.net/problem/2573
 */

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2573 {
    static int N; // 행 y
    static int M; // 열 x
    static int[][] map;
    static int[] dx = new int[]{0,0,1,-1};
    static int[] dy = new int[]{1,-1,0,0};

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static void dfs(Node node, boolean[][] visited) {
        int x = node.x;
        int y = node.y;

        visited[y][x] = true;

        for(int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>0 && nx < M-1 && ny>0 && ny < N-1 && !visited[ny][nx] && map[ny][nx] > 0) {
                dfs(new Node(nx, ny), visited);
            }
        }
    }

    static int counting() {
        int cnt = 0;
        boolean[][] visited = new boolean[N][M];

        for(int i=1; i<N-1; i++) {
            for(int j=1; j<M-1; j++) {
                if(map[i][j] > 0 && !visited[i][j]) {
                    dfs(new Node(j, i), visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void melting() {
        boolean[][] visited = new boolean[N][M];

        Queue<Node> que = new LinkedList<>();
        for(int i=1; i<N-1; i++) {
            for(int j=1; j<M-1; j++) {
                if(map[i][j] > 0) {
                    que.offer(new Node(j, i));
                    visited[i][j] = true;
                }
            }
        }

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int cx = cur.x;
            int cy = cur.y;
            int seaside = 0;

            for(int l=0; l<4; l++) {
                int nx = cx+dx[l];
                int ny = cy+dy[l];

                if(nx>=0 && nx<M && ny>=0 && ny<N && !visited[ny][nx] && map[ny][nx] == 0) {
                    seaside++;
                }
            }

            map[cy][cx] = Math.max(map[cy][cx] - seaside, 0);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // y
        M = Integer.parseInt(st.nextToken()); // x
        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 덩어리 계산 dfs
        int answer = 0;
        int ice;
        while((ice=counting()) < 2) {
            if(ice == 0) {
                answer = 0;
                break;
            } else if(ice >= 2) {
                break;
            }
            melting();
            answer++;
        }
        System.out.println(answer);


        // 2. 빙하 녹이기 bfs

        bw.flush();
        br.close();
        bw.close();
    }
}
