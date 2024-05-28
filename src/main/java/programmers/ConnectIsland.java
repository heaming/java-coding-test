package programmers;
/*
* @Title: 섬 연결하기
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/42861
* @Tag : 다익스트라
*/

import java.util.*;

public class ConnectIsland {
    static List<Info>[] graph;
    static int[] dist;
    static boolean[] visited;

    static class Info {
        int to;
        int cost;

        public Info(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static int dijkstra(int start) {

        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Info> que = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        que.offer(new Info(start, 0));
        dist[start] = 0;

        while(!que.isEmpty()){
            Info cur = que.poll();
            visited[cur.to] = true;

            if(dist[cur.to] != cur.cost) continue;

            for(Info info : graph[cur.to]) {
                if(visited[info.to]) continue;
                if(dist[info.to] <= info.cost) continue;

                dist[info.to] = info.cost;
                que.offer(new Info(info.to, dist[info.to]));
            }
        }

        return Arrays.stream(dist).sum();
    }

    static class Solution {
        public int solution(int n, int[][] costs) {
            int answer = Integer.MAX_VALUE;

            graph = new ArrayList[n];
            dist = new int[n];
            for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

            for(int[] cost : costs) {
                int a = cost[0];
                int b = cost[1];
                int c = cost[2];
                graph[a].add(new Info(b, c));
                graph[b].add(new Info(a, c));
            }

            for(int i=0; i<n; i++) {
                visited =new boolean[n];
                answer = Math.min(dijkstra(i), answer);
            }
            return answer;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.solution(4,new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}})); // 1
            System.out.println(solution.solution(4,new int[][] {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}})); // 1
            System.out.println(solution.solution(5,new int[][]{{0,1,1},{3,4,1},{1,2,2},{2,3,4}})); // 1
            // 159
            System.out.println(solution.solution(7,new int[][]{{2, 3, 7}, {3, 6, 13}, {3, 5, 23}, {5, 6, 25}, {0, 1, 29}, {1, 5, 34}, {1, 2, 35}, {4, 5, 53}, {0, 4, 75}})); // 1
        }
    }
}
