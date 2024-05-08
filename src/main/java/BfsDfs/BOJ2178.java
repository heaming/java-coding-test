package BfsDfs;

/*
 * @Title: 미로탐색
 * @Link: https://www.acmicpc.net/problem/2178
 */

import java.io.*;
import java.util.*;

public class BOJ2178 {

    static int N;
    static int M;
    static int[][] roads;
    static int[] dn = {1,-1,0,0};
    static int[] dm = {0,0,1,-1};


    static class Node{
        int n;
        int m;

        public Node(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    static void bfs() {

        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(0,0));
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;

        while(!que.isEmpty()) {
            Node cur = que.poll();
            int cn = cur.n;
            int cm = cur.m;

            for(int i=0; i<4; i++) {
                int nn = cn+dn[i];
                int nm = cm+dm[i];

                if(nn>=0 && nn<N && nm>=0 && nm<M && roads[nn][nm] == 1) {
                    roads[nn][nm] += roads[cn][cm];
                    que.offer(new Node(nn, nm));
                    visited[nn][nm] = true;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        roads = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0; j<M; j++) {
                roads[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        bfs();
        System.out.println(roads[N-1][M-1]);


        bw.flush();
        br.close();
        bw.close();
    }
}
