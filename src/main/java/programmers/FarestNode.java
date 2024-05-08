package programmers;
/*
* @Title: 가장 먼 노드
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/49189
* @Tag: 다익스트라
*/

import java.util.*;

public class FarestNode {
    static class Solution {
        static List<Info>[] graph;
        static int[] dist;

        static class Node {
            int idx;
            int dist;

            public Node(int idx, int dist) {
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
            PriorityQueue<Node> que = new PriorityQueue<>(Comparator.comparingInt(o1 -> o1.dist));
            que.offer(new Node(start, 0));
            dist[start] = 0;

            while(!que.isEmpty()) {
                Node cur = que.poll();

                if(dist[cur.idx] != cur.dist) continue;

                for(Info info : graph[cur.idx]) {
                    if(info.weight + dist[cur.idx] >= dist[info.to]) continue;

                    dist[info.to] = info.weight + dist[cur.idx];
                    que.offer(new Node(info.to, dist[info.to]));
                }
            }
        }

        public int solution(int n, int[][] edge) {
            int answer = 0;

            graph = new ArrayList[n+1];
            dist = new int[n+1];

            Arrays.fill(dist, 1, n+1, 20001);

            for(int i=0; i<=n; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int[] ed : edge) {
                graph[ed[0]].add(new Info(ed[1],1));
                graph[ed[1]].add(new Info(ed[0], 1));
            }

            dijkstra(1);

            int max = Arrays.stream(dist).max().getAsInt();

            for(int i: dist) {
                if (i==max) answer++;
            }

            return answer;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            // 3
            System.out.println(solution.solution(6,new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));

        }
    }
}
