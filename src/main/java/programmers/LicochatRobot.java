package programmers;
/*
* @Title: 리코쳇로봇
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/169199
* @Tag : bfs, 구현
*/

import java.util.*;

public class LicochatRobot {


    static class Solution {

        static String[] board;

        static class Node {
            int r;
            int c;

            public Node(int r, int c) {
                this.r = r;
                this.c = c;
            }
        }

        static int[] dr = {0,0,1,-1};
        static int[] dc = {1,-1,0,0};

        public int solution(String[] board) {
            int answer = 0;
            Solution.board = board;
            Node start = null;
            Node end = null;
            boolean[][] visited = new boolean[board.length][board[0].length()];
            int[][] map = new int[board.length][board[0].length()];

            for(int i=0; i< board.length; i++) {
                for(int j=0; j<board[0].length(); j++) {
                    if(board[i].charAt(j) == 'R') start = new Node(i, j);
                    if(board[i].charAt(j) == 'G') end = new Node(i, j);
                }
            }

            Queue<Node> que = new LinkedList<>();
            que.offer(start);
            visited[start.r][start.c] = true;

            while(!que.isEmpty()) {
                Node cur = que.poll();

                if(cur.r == end.r && cur.c == end.c) break;

                for(int i=0; i<4; i++) {
                    int nr = cur.r;
                    int nc = cur.c;

                    while (true) {
                        nr += dr[i];
                        nc += dc[i];

                        if(nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length()) {
                            nr -= dr[i];
                            nc -= dc[i];
                            break;
                        }

                        if(board[nr].charAt(nc) == 'D') {
                            nr -= dr[i];
                            nc -= dc[i];
                            break;
                        }
                    }

                    if(visited[nr][nc]) continue;

                    visited[nr][nc] = true;
                    map[nr][nc] += map[cur.r][cur.c]+1;
                    que.offer(new Node(nr, nc));
                }
            }

            answer = map[end.r][end.c];
            return answer > 0 ? answer : -1 ;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
//            System.out.println(solution.solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."})); // 7
            System.out.println(solution.solution(new String[]{".D.R", "....", ".G..", "...D"})); // -1
        }
    }
}
