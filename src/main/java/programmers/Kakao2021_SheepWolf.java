package programmers;
/*
* @Title: 양과 늑대
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/92343
* @Tag:
*/

import java.util.*;

public class Kakao2021_SheepWolf {
    static class Solution {
        static List<Integer>[] list;
        static int[] info;
        static int[][] dy; // 0 dfs // 1 bfs

        static void dfs(int x, int prev) {
//            dy[x][0]

        }

        static void bfs() {

        }

        public int solution(int[] info, int[][] edges) {
            int answer = 0;

            list = new ArrayList[info.length];
            Solution.info = info;
            for(int i=0; i<list.length; i++) {
                list[i] = new ArrayList<>();
            }

            for(int[] edge : edges) {
                list[edge[0]].add(edge[1]);
            }


            return answer;
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
