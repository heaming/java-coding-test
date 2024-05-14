package P5_1;

/*
 * @Title: 골목 대장 호석 - 기능성
 * @Link: https://www.acmicpc.net/problem/20168
 * @Tag : 다익스트라, 이분탐색
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ20168 {
    static int N;
    static int M;
    static int A;
    static int B;
    static int C;
    static List<Info>[] list;
    static long[] dist;
    static long answer;

    static class Cross {
        int idx;
        long dist;

        public Cross(int idx, long dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static class Info {
        int to;
        long weight;

        public Info(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static boolean dijkstra(long sum) {
        Arrays.fill(dist,1,N+1, 10000000000000001L);

        PriorityQueue<Cross> que = new PriorityQueue<>(Comparator.comparingLong(o -> o.dist));
        que.offer(new Cross(A, 0));
        dist[A] = 0;

        while(!que.isEmpty()) {
            Cross cur = que.poll();

            if(cur.dist != dist[cur.idx]) continue;

            for(Info info : list[cur.idx]) {
                if(info.weight > sum) continue;
                if(dist[cur.idx] + info.weight < dist[info.to]) {
                    dist[info.to] = dist[cur.idx] + info.weight;
                    que.offer(new Cross(info.to, dist[info.to]));
                }
            }
        }

        return dist[B] <= C;
    }

    static long binary() {

        long left = 1;
        long right = 1000000001;
        answer = right;

        while(left <= right) {
            long mid = (left+right)/2;

            if(dijkstra(mid)) {
                answer = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return answer == 1000000001 ? -1 : answer;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        dist = new long[N+1];
        list = new ArrayList[N+1];

        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Info(b,c));
            list[b].add(new Info(a,c));
        }

        answer = binary();

        System.out.println(answer);
        br.close();
    }
}
