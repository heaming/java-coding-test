package programmers;
/*
* @Title: 카드 짝 맞추기
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/72415
* @Tag :
*/

import java.util.*;

public class Kakao2021_Card {

    // 가장 가까운 캐릭터부터 제거


    static class Node {
        int r;
        int c;
        int type;
        int dist;

        public Node(int r, int c, int type, int dist) {
            this.r = r;
            this.c = c;
            this.type = type;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }

    static class Solution {
        static int[] dr = {1,-1,0,0};
        static int[] dc = {0,0,1,-1};
        static Node start;
        static int[][] board;
        static int[][][] dist;

        static void dijkstra(Node start) {
            PriorityQueue<Node> que = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
            boolean[][] visited = new boolean[4][4];
            que.offer(start);
            dist[start.r][start.c][start.type] = 0;
            visited[start.r][start.c] = true;

            while(!que.isEmpty()) {
                Node cur = que.poll();

                if(dist[cur.r][cur.c][cur.type] != cur.dist) continue;

                for(int i=0; i<4; i++) {
                    int nr = start.r+dr[i];
                    int nc = start.c+dc[i];

                    if(nr==-1) nr=3;
                    if(nc==-1) nc=3;

                    if(nr<0 || nr>=4 ||nc<0||nc>=4) continue;
                    int nt = board[nr][nc];

//                    if(cur.type!=nt && cur.type !=0 && nt!=0) continue;
                    if(visited[nr][nc]) continue;
                    if(dist[nr][nc][nt] <= cur.dist+1) continue;

                    if(nt==cur.type && nt!=0) {
                        board[nr][nc] = 0;
                        nt = 0;
                        visited = new boolean[4][4];
                    }
                    dist[nr][nc][nt] = cur.dist+1;
                    que.offer(new Node(nr, nc, nt, cur.dist+1));
                    visited[nr][nc] = true;
                }
            }
        }

        public int solution(int[][] board, int r, int c) {
            int answer = 0;
            Solution.board = board;
            start = new Node(r, c, board[r][c], 0);
            dist = new int[4][4][9];

            for(int i=0; i<4; i++) {
                for(int j=0; j<4; j++) {
                    for(int k=0; k<=8; k++)
                        dist[i][j][k] = Integer.MAX_VALUE;
                }
            }

            dijkstra(start);
            System.out.println(Arrays.deepToString(dist));


            return answer;
        }
        public static void main(String[] args) throws Exception {
            Solution solution = new Solution();
            System.out.println(solution.solution(new int[][]{{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}}, 1, 0)); // 14
//            System.out.println(solution.solution(new int[][] {{3,0,0,2},{0,0,1,0},{0,1,0,0},{2,0,0,3}}, 0, 1)); // 16


        }
    }
}
