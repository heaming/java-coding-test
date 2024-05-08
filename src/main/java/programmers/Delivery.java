package programmers;
/*
 * @Title: 배달
 * @Link: https://school.programmers.co.kr/learn/courses/30/lessons/12978
 * @Tag: 다익스트라
 */

import java.util.*;

public class Delivery {
    static List<Info>[] graph;
    static int[] dist;

    static class City {
        int idx;
        int dist;

        public City(int idx, int dist) {
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

        PriorityQueue<City> que = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        que.offer(new City(start, 0));
        dist[start] = 0;

        while(!que.isEmpty()) {
            City cur = que.poll();

            if(cur.dist != dist[cur.idx]) continue;

            for(Info info : graph[cur.idx]) {
                if(dist[cur.idx] + info.weight >= dist[info.to]) continue;

                dist[info.to] = dist[cur.idx] + info.weight;
                que.offer(new City(info.to, dist[info.to]));
            }
        }
    }


    static class Solution {

        public int solution(int N, int[][] road, int K) {
            int answer = 0;

            graph = new ArrayList[N+1];
            dist = new int[N+1];
            for(int i=1; i<=N; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int[] r : road) {
                int a = r[0];
                int b = r[1];
                int d = r[2];

                graph[a].add(new Info(b, d));
                graph[b].add(new Info(a, d));
            }

            Arrays.fill(dist, 1, N+1, 100001);
            dijkstra(1);
//            System.out.println(Arrays.toString(dist));

            for(int i=1; i<=N; i++) {
                if(dist[i] <= K) answer++;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 4
//        System.out.println(solution.solution(5, new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}}, 3));
        // 4
        System.out.println(solution.solution(6, new int[][]{{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}}, 4));

    }
}
