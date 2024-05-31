package tree;

/*
 * @Title: 트리와 쿼리
 * @Link: https://www.acmicpc.net/problem/15681
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15681 {
    static int N;
    static int R;
    static int Q;
    static List<Integer>[] graph;
    static int[] cnt;

    static void dfs(int cur, int prev) {

        cnt[cur] = 1;

        for(int next : graph[cur]) {
            if(next == prev) continue;
            dfs(next, cur);
            cnt[cur] += cnt[next];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=1; i<=N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        cnt = new int[N+1];
        dfs(R, -1);

        for(int i=1; i<=Q; i++) {
            st = new StringTokenizer(br.readLine());
            System.out.println((cnt[Integer.parseInt(st.nextToken())]));
        }

        br.close();
    }
}
