package programmers;
/*
* @Title: 양과 늑대
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/92343
* @Tag:
*/

import java.util.*;

public class Kakao2021_SheepWolf {

    static List<Info>[] lists;
    static int[] dist;
    static int cnt;

    static class Node {
        int idx;
        int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "idx=" + idx +
                    ", dist=" + dist +
                    '}';
        }
    }

    static class Info {
        int to;
        int dist;

        public Info(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "to=" + to +
                    ", dist=" + dist +
                    '}';
        }
    }

    static void dijks(int start) {
        PriorityQueue<Node> que = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        // 루트 노드에는 항상 양이 있음
        que.offer(new Node(start, 0));
        dist[start] = 0;

        while(!que.isEmpty()) {
            Node node = que.poll();

            if(node.dist != dist[node.idx]) continue;

            for(Info info : lists[node.idx]) {
                if(dist[node.idx] >= dist[info.to]) continue;

                if(dist[info.to] == 0) cnt++;
                dist[info.to] = dist[node.idx];
                que.offer(new Node(info.to, dist[info.to]));
            }
        }
    }

    static class Solution {
        public int solution(int[] info, int[][] edges) {
            int answer = 0;

            int infoLen = info.length;

            lists = new ArrayList[infoLen];
            dist = new int[infoLen];
            for(int i=0; i<infoLen; i++) {
                lists[i] = new ArrayList<>();
            }

            for(int[] edge: edges) {
                lists[edge[0]].add(new Info(edge[1], info[edge[1]]));
            }

            for(List<Info> i : lists) {
                System.out.println(i);
            }

            cnt = 0;
            dijks(0);

            System.out.println(Arrays.toString(dist));
            System.out.println(cnt);

            return cnt;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 5
//        System.out.println(solution.solution(new int[]{0,0,1,1,1,0,1,0,1,0,1,1}, new int[][]{{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}}));
        // 5
        System.out.println(solution.solution(new int[]{0,1,0,1,1,0,1,0,0,1,0}, new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}}));
    }
}
