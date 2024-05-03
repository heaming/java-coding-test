package tree;

/*
 * @Title: 트리의 부모찾기
 * @Link: https://www.acmicpc.net/problem/11725
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11725 {
    static int N;
    static List<Integer>[] graph;
    static int[] visited;

    public static void dfs(int cur, int prev) {

        for(int node : graph[cur]) {
            if(node == prev) continue;
            visited[node] = cur;
            dfs(node, cur);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        visited = new int[N+1];

        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1, -1);

        for(int i=2; i<=N; i++) {
            System.out.println(visited[i]);
        }

        br.close();
    }
}
