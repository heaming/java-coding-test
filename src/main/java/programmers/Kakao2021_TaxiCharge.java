package programmers;
/*
* @Title: 합승 택시 요금
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/72413
* @Tag: 다익스트라
*/

import java.util.*;

public class Kakao2021_TaxiCharge {

    /*
    * n : 지점갯수
    * s : 출발지
    * a A도착 b B도착
    * [c d f] c-d f원 n*(n-1)/2
    *  */

    static class Solution {
        static int[] dist;
        static List<Info>[] infoList;

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
            int dist;

            public Info(int to, int dist) {
                this.to = to;
                this.dist = dist;
            }
        }

        static void dijk(int start) {
            PriorityQueue<Node> que = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
            que.offer(new Node(start, 0));
            dist[start] = 0;

            while(!que.isEmpty()) {
                Node node = que.poll();

                if(node.dist != dist[node.idx]) continue;

                for(Info info : infoList[node.idx]) {
                    if(dist[node.idx]+info.dist >= dist[info.to]) continue;

                    dist[info.to] = dist[node.idx]+info.dist;
                    que.offer(new Node(info.to, dist[info.to]));
                }
            }
        }

        public int solution(int n, int s, int a, int b, int[][] fares) {

            int answer = Integer.MAX_VALUE;
            // 최신 거리 정보
            dist = new int[n+1];
            // 지점 정보
            infoList = new ArrayList[n+1];

            Arrays.fill(dist, 1, n+1, 100000*200+1);
            for(int i=1; i<=n; i++) {
                infoList[i] = new ArrayList<>();
            }

            for(int[] fare : fares) {
                int n1 = fare[0];
                int n2 = fare[1];
                int d = fare[2];
                infoList[n1].add(new Info(n2, d));
                infoList[n2].add(new Info(n1, d));
            }

            dijk(s);
            //System.out.println(Arrays.toString(dist));
            int[] together = dist.clone();

            for(int i=1; i<=n; i++) {
                if(i==s) continue;
                dist = together.clone();
                dijk(i);
                //System.out.println(Arrays.toString(dist));
                answer = Math.min(together[i] + dist[a] + dist[b] ,answer);
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 82
        System.out.println(solution.solution(6,4,6,2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));
//        System.out.println(solution.solution(2, 7, new int[]{1,0,2,0,1,0,2}, new int[]{0,2,0,1,0,2,0})); //30
    }
}
