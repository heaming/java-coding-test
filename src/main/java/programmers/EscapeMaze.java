package programmers;
/*
* @Title: 미로탈출
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/159993
* @Tag :
*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class EscapeMaze {

    static class Solution {

        static int[] da = new int[]{0,0,1,-1};
        static int[] db = new int[]{1,-1,0,0};

        static class Node {
            int a;
            int b;

            public Node(int a, int b) {
                this.a = a;
                this.b = b;
            }

            public Node(){}
        }

        public int solution(String[] maps) {
            int answer = 0;
            int[][] map = new int[maps.length][maps[0].length()];
            Node start = new Node();
            Node lev = new Node();
            Node end = new Node();

            for(int i=0; i<maps.length; i++) {
                int s = maps[i].indexOf('S');
                int l = maps[i].indexOf('L');
                int e = maps[i].indexOf('E');

                if(s>-1) start = new Node(i, s);
                if(l>-1) lev = new Node(i, l);
                if(e>-1) end = new Node(i, e);
            }

            Queue<Node> que = new LinkedList<>();
            que.offer(start);

            while(!que.isEmpty()) {
                Node cur = que.poll();

                if(cur.a == lev.a && cur.b == lev.b) {
                    que.clear();
                    break;
                }

                for(int i=0; i<4; i++) {
                    int na = cur.a+da[i];
                    int nb = cur.b+db[i];

                    if(na<0 || na>=map.length || nb<0 || nb>=map[0].length) continue;
                    if(maps[na].charAt(nb) == 'X') continue;
                    if(map[na][nb] > 0) continue;

                    map[na][nb] = map[cur.a][cur.b]+1;
                    que.offer(new Node(na, nb));
                }
            }

            if(map[lev.a][lev.b] <= 0)  {
                return -1;
            }

            answer += map[lev.a][lev.b];

            map = new int[maps.length][maps[0].length()];
            que.offer(lev);

            while(!que.isEmpty()) {
                Node cur = que.poll();

                if(cur.a == end.a && cur.b == end.b) {
                    break;
                }

                for(int i=0; i<4; i++) {
                    int na = cur.a+da[i];
                    int nb = cur.b+db[i];

                    if(na<0 || na>=map.length || nb<0 || nb>=map[0].length) continue;
                    if(maps[na].charAt(nb) == 'X') continue;
                    if(map[na][nb] > 0) continue;

                    map[na][nb] = map[cur.a][cur.b]+1;
                    que.offer(new Node(na, nb));
                }
            }

            if(map[end.a][end.b] <= 0)  {
                return -1;
            }
            answer += map[end.a][end.b];

            return answer > 0 ? answer : -1;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            // 16
            System.out.println(solution.solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}));
            // -1
//            System.out.println(solution.solution(new String[]{"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"}));
        }

    }
}
