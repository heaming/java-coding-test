package dijkstra;

/*
 * @Title: 최소비용 구하기
 * @Link: https://www.acmicpc.net/problem/1916
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1916 {
    static int N; // 도시 (노드)
    static int M; // 버스 (간선)
    static int start;
    static int end;
    static int[] dist;
    static List<Info>[] list;

    static class Info {
        int to;
        int weight;

        public Info(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }

    static class City {
        int idx;
        int dist;

        public City(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "City{" +
                    "idx=" + idx +
                    ", dist=" + dist +
                    '}';
        }
    }

    static void dijkstra(int start) {

        PriorityQueue<City> que = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        que.offer(new City(start, 0));
        dist[start] = 0;

        while(!que.isEmpty()) {
//            System.out.println(que);
            City city = que.poll();

            if(city.dist != dist[city.idx]) continue;

            for(Info info : list[city.idx]) {
                if(info.weight + dist[city.idx] >= dist[info.to]) continue;
//                System.out.println(info);
                dist[info.to] = info.weight + dist[city.idx];
//                System.out.println("dist :: "+Arrays.toString(dist));
                que.offer(new City(info.to, dist[info.to]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];

        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[from].add(new Info(to, w));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // x도시까지 가는 거리
        dist = new int[N+1];
        // 초기화
        Arrays.fill(dist, 1, N+1, 100000001);

        dijkstra(start);
        System.out.println(dist[end]);

        br.close();
    }
}
