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

public class BOJ11725_2 {
    static int N;
    static List<Integer>[] graph;
    static int[] parent;

    static void dfs(int cur, int prev) {

        parent[cur] = prev;

        for(int next : graph[cur]) {
            if(next == prev) continue;

            dfs(next, cur);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        parent = new int[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=2; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1, -1);

        for(int i=2; i<=N; i++) {
            System.out.println(parent[i]);
        }

        br.close();
    }
}
