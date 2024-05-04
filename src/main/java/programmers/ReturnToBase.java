package programmers;
/*
 * @Title: 부대복귀
 * @Link: https://school.programmers.co.kr/learn/courses/30/lessons/132266
 * @Tag: 다익스트라
 */

import java.util.*;

public class ReturnToBase {
    static List<Info>[] graph;
    static int[] dist;

    static class Edge {
        int idx;
        int dist;

        public Edge(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static class Info {
        int to;
        int weight;

        public Info(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> que = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        que.offer(new Edge(start, 0));
        dist[start] = 0;

        while(!que.isEmpty()) {
            Edge cur = que.poll();

            if(dist[cur.idx] != cur.dist) continue;

            for(Info info : graph[cur.idx]) {
                if(dist[cur.idx] + info.weight >= dist[info.to]) continue;

                dist[info.to] = dist[cur.idx] + info.weight;
                que.offer(new Edge(info.to, dist[info.to]));
            }
        }
    }

    static class Solution {

        public int[] solution(int n, int[][] roads, int[] sources, int destination) {
            int[] answer = new int[sources.length];

            graph = new ArrayList[n+1];
            for (int i=1; i<=n; i++) {
                graph[i] = new ArrayList<>();
            }
            dist = new int[n+1];
            Arrays.fill(dist, 1, n+1, 100001);

            for(int[] road : roads) {
                graph[road[0]].add(new Info(road[1], 1));
                graph[road[1]].add(new Info(road[0], 1));
            }

            dijkstra(destination);

            for(int i=0; i<sources.length; i++) {
                int cur = sources[i];
                answer[i] = dist[cur] == 100001? -1 : dist[cur];
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 1,2
//        System.out.println(Arrays.toString(solution.solution(3, new int[][]{{1, 2}, {2, 3}}, new int[]{2, 3}, 1)));
        // 2 -1 0
        System.out.println(Arrays.toString(solution.solution(5, new int[][]{{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}}, new int[]{1, 3, 5}, 5)));
    }
}
