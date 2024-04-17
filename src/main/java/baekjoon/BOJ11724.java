package baekjoon;

/*
 * @Title: 연결 요소의 개수
 * @Link: https://www.acmicpc.net/problem/11724
 */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11724 {
    static int N; // 정점 개수
    static int M; // 간선 개수
    static int[][] map;
    static boolean[] visited;

    static void dfs(int idx, boolean[] visited) {
        visited[idx] = true;

        for(int i=1; i<=N; i++) {
            if(i == idx) continue;
            if(!visited[i] && map[idx][i] == 1) {
                dfs(i, visited);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        visited = new boolean[N+1];

        int answer = 0;

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }

        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                dfs(i, visited);
                answer++;
            }
        }

        System.out.println(answer);

        bw.flush();
        br.close();
        bw.close();
    }
}
