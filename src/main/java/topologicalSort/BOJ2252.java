package topologicalSort;

/*
 * @Title: 줄 세우기
 * @Link: https://www.acmicpc.net/problem/2252
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2252 {
    static int N;
    static int M;
    static List<Integer>[] graph;
    static int[] indeg;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indeg = new int[N+1];
        graph = new ArrayList[N+1];

        for(int i=0; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            graph[prev].add(next);
            indeg[next]++;
        }

        Queue<Integer> que = new LinkedList<>();

        for(int i=1; i<=N; i++) {
            if(indeg[i]==0) que.offer(i);
        }

        while (!que.isEmpty()) {
            int cur = que.poll();
            System.out.println(cur+" ");

            for(int child : graph[cur]) {
                indeg[child]--;
                if(indeg[child] == 0) que.offer(child);
            }
        }

        br.close();
    }
}
