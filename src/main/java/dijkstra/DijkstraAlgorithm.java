package dijkstra;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    static int N;
    static int[] dist;
    static List<Edge>[] edges;

    static class Info {
        int idx;
        int dist;

        public Info(int num, int dist) {
            this.idx = num;
            this.dist = dist;
        }
    }

    static class Edge {
        int weight;
        int to;

        public Edge(int weight, int to) {
            this.weight = weight;
            this.to = to;
        }
    }

    static void dijkstra(int start) {
        // 1. 모든 정점에 대해 무한대로 거리 초기화
        // [중요!!!✨] answer로 나올 수 있는 최댓값보다 더 크게 초기화
        for(int i=1; i<=N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // 최소값 뽑는 힙 생성
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparing(o -> o.dist));
//        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist-o2.dist);

        // 2. 시작점에 대한 정보 추가
        pq.add(new Info(start, 0));
        dist[start] = 0;

        // 거리 배열 갱신
        while(!pq.isEmpty()) {
            Info info = pq.poll();

            // 꺼낸 정보가 최신이랑 다르면, 의미없다 -> 버린다!
            if(dist[info.idx] < info.dist) continue;

            // 최소라면, 연결된 모든 간선 정보 갱신
            for(Edge e : edges[info.idx]) {
                // 거쳐서 간게 지금나온 값보다 크면 의미없다 -> 버린다!
                if(dist[info.idx] + e.weight >= dist[e.to]) continue;

                dist[e.to] = dist[info.idx]+e.weight;
                // e.to까지 더 빨리 갈 수 있어?
                pq.add(new Info(e.to, dist[e.to]));
            }



        }

    }

}
