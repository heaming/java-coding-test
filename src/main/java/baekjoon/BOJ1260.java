package baekjoon;

/*
 * @Title: DFS와 BFS
 * @Link: https://www.acmicpc.net/problem/1260
 */

import java.util.*;
import java.io.*;

public class BOJ1260 {
    static int N; // 정점 개수
    static int M; // 간선 개수
    static int V; // 시작
    static int[][] map;
    static String dfs = "";
    static String bfs = "";

    static void dfs(int node, boolean[] visited) {
        visited[node] = true;
        dfs += node+" ";

        for(int i=0; i<=N; i++) {
            if(i == node) continue;
            if(map[node][i] == 1 && !visited[i]) {
                dfs(i, visited);
            }
        }
    }

    static void bfs(int node, boolean[] visited) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(node);
        visited[node] = true;

        while(!que.isEmpty()) {
            int cur = que.poll();
            bfs += cur+" ";

            for(int i=1; i<=N; i++) {
                if(map[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    que.offer(i);
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
        V = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }

        boolean[] visited = new boolean[N+1];
        dfs(V, visited);
        visited = new boolean[N+1];
        bfs(V, visited);

        System.out.println(dfs);
        System.out.println(bfs);

        bw.flush();
        br.close();
        bw.close();
    }
}
