package tree;

/*
 * @Title: 회사 문화1
 * @Link: https://www.acmicpc.net/problem/14267
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ14267 {
    static int n;
    static int m;
    static int[] result;
    static List<Integer>[] graph;

    static void dfs(int cur, int prev) {

        result[cur] += result[prev];

        for(int next : graph[cur]) {
            dfs(next, cur);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        result = new int[n+1];
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=1; i<=n; i++) {
            int b = Integer.parseInt(st.nextToken());
            if(b == -1) continue;
            graph[b].add(i);
        }

        for(int i = 1; i<=m; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            result[idx] += w;
        }

        dfs(1, 0);

        for(int i=1; i<=n; i++) System.out.print(result[i]+" ");

        br.close();
    }
}
