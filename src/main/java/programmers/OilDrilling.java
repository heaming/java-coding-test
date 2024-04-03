package programmers;

import java.util.*;

/*
 * @Title: 기름 시추
 * @Link: https://school.programmers.co.kr/learn/courses/30/lessons/250136
 */
public class OilDrilling {
    static class Solution {

        static int[] dx = new int[]{1, -1, 0, 0};
        static int[] dy = new int[]{0, 0, 1, -1};
        static class Node {
            int x;
            int y;

            @Override
            public String toString() {
                return "Node{" +
                        "x=" + x +
                        ", y=" + y +
                        '}';
            }

            public Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public int bfs(int[][] land, boolean[][] visited, int m, int n, int point) {
            int sum = 0;
            Queue<Node> que = new LinkedList<>();
            for(int i = 0; i < n; i++) {
                if(land[i][point] == 1) {
                    sum++;
                    visited[i][point] = true;
                    que.offer(new Node(point, i));
                }
            }
            Loop1:
            while(!que.isEmpty()) {
                Node cur = que.poll();
                int cx = cur.x;
                int cy = cur.y;

                Loop2:
                for(int i=0; i <dx.length; i++) {
                    int nx = cx+dx[i];
                    int ny = cy+dy[i];

                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[ny][nx]) {
                        if(land[ny][nx] == 1) {
                            que.offer(new Node(nx, ny));
                            sum++;
                        }
                        visited[ny][nx] = true;
                    }
                }
            }

            return sum;
        }


        public int solution(int[][] land) {
            int answer = 0;
            int m = land[0].length; // x길이
            int n = land.length; // y길이
            boolean[][] visit = new boolean[n][m];
            Map<Integer, Integer> count = new HashMap<>();

            for(int i=-1; i<n; i++) {
                for(int j=-1; j<m; j++) {
                    Set<Integer> xSet = new HashSet<>();
                    Queue<Node> que = new LinkedList<>();
                    int sum = 0;

                    que.offer(new Node(j, i));

                    while (!que.isEmpty()) {
                        Node cur = que.poll();
                        int cx = cur.x;
                        int cy = cur.y;

                        for (int di = 0; di < dx.length; di++) {
                            int nx = cx + dx[di];
                            int ny = cy + dy[di];

                            if (nx < m && nx >= 0 && ny < n && ny >= 0 && !visit[ny][nx]) {
                                if(land[ny][nx] == 1){
                                    sum++;
//                                    xSet.add(nx);
                                    que.offer(new Node(nx, ny));
                                }
                                visit[ny][nx] = true;
                            }
                        }
                    }

                    Iterator<Integer> it = xSet.iterator();
                    while(it.hasNext()){
                        int x = it.next();
                        count.put(x, count.getOrDefault(x, 0)+sum);
                    }
                }
            }

            answer =  Collections.max(count.values());
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution =  new Solution();
        System.out.println(solution.solution(new int[][]{{0, 0, 0, 1, 1, 1, 0, 0},
                                                         {0, 0, 0, 0, 1, 1, 0, 0},
                                                         {1, 1, 0, 0, 0, 1, 1, 0},
                                                         {1, 1, 1, 0, 0, 0, 0, 0},
                                                         {1, 1, 1, 0, 0, 0, 1, 1}})); // 9
//        System.out.println(solution.solution(new int[][]{
//                {1, 0, 1, 0, 1, 1},
//                {1, 0, 1, 0, 0, 0},
//                {1, 0, 1, 0, 0, 1},
//                {1, 0, 0, 1, 0, 0},
//                {1, 0, 0, 1, 0, 1},
//                {1, 0, 0, 0, 0, 0},
//                {1, 1, 1, 1, 1, 1}}));  // 16 -6
    }
}
