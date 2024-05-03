package topologicalSort;

/*
 * @Title: ACM Craft
 * @Link: https://www.acmicpc.net/problem/1005
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1005 {
    static int T;
    static int N;
    static int K;
    static int[] times;
    static int W;
    static List<Integer>[] graph;
    static int[] indeg;
    static int[] done;

    static BufferedReader br;
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        times = new int[N+1];
        indeg = new int[N+1];
        done = new int[N+1];

        st = new StringTokenizer(br.readLine());
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
        }

        for(int i=1; i<=K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            indeg[y]++;
        }
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
    }

    static int sort() {
        Queue<Integer> que = new LinkedList<>();

        // 제일 앞에 '정렬될 수 있는 정점 찾기
        for(int i=1; i<=N; i++) {
            if(indeg[i]==0) {
                que.offer(i);
                done[i] = times[i];
            }
        }

        // *** 위상 정렬 순서대로 done 계산 같이 해주기
        // 1. 정렬 결과 추가하기
        // 2. 정점과 연결된 간선 제거
        // 3. 새롭게 정렬될 수 있는 정점
        while(!que.isEmpty()) {
            int cur = que.poll();
            for(int child : graph[cur]) {
                indeg[child]--;

                if(indeg[child] == 0) {
                    que.offer(child);
                }

                done[child] = Math.max(done[child], done[cur] + times[child]);
            }
        }

        return done[W];
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for(int i=0; i<T; i++) {
            input();
            int answer = sort();
            System.out.println(answer);
        }

        br.close();
    }
}
