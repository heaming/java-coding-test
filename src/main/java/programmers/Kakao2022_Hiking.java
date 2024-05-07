package programmers;
/*
* @Title: 등산코스정하기
* @Link:  https://school.programmers.co.kr/learn/courses/30/lessons/118669
* @Tag :  다익스트라
*/

import java.util.*;
import java.util.stream.Collectors;

public class Kakao2022_Hiking {

    static class Solution {
        static List<Info>[] graph;

        static int[] dist;
        static int minDist;
        static int top;
        static List<Integer> summitList;
        static List<Integer> gateList;

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

        static void dijkstra(int[] starts) {
            PriorityQueue<Node> que = new PriorityQueue<>(Comparator.comparingInt(o-> o.dist));
            for(int start : starts) {
                que.offer(new Node(start, 0));
                dist[start] = 0;
            }

            while(!que.isEmpty()) {
                Node cur = que.poll();

                if(dist[cur.idx] != cur.dist) continue;

                for(Info info : graph[cur.idx]) {

                    if(Math.max(cur.dist, info.weight) >= dist[info.to]) continue;

                    dist[info.to] = Math.max(cur.dist, info.weight);

                    if(summitList.contains(info.to)) continue;

                    que.offer(new Node(info.to, dist[info.to]));
                }
            }
        }


        public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
            int[] answer = new int[2];

            summitList = Arrays.stream(summits).boxed().collect(Collectors.toList());
            gateList = Arrays.stream(gates).boxed().collect(Collectors.toList());
            graph = new ArrayList[n+1];
            minDist = Integer.MAX_VALUE;
            top = n+1;

            for(int i=1; i<=n; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int[] path : paths) {
                graph[path[0]].add(new Info(path[1], path[2]));
                graph[path[1]].add(new Info(path[0], path[2]));
            }

            dist = new int[n+1];
            Arrays.fill(dist, 1, n+1, 1000000001);
            dijkstra(gates);

            for(int summit : summits) {
                if (dist[summit] < minDist) {
                    top = summit;
                    minDist = dist[summit];
                } else if (dist[summit] == minDist && top > summit){
                    top = summit;
                }
            }

            answer[0] = top;
            answer[1] = minDist;

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(Arrays.toString(solution.solution(6, new int[][]{{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}}, new int[]{1, 3}, new int[]{5}))); // 5 3

//        System.out.println(Arrays.toString(solution.solution(7, new int[][]{{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}}, new int[]{1}, new int[]{2, 3, 4})));

        System.out.println(Arrays.toString(solution.solution(7, new int[][]{{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}}, new int[]{3, 7}, new int[]{1, 5})));
    }
}
