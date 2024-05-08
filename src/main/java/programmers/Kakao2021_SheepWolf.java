package programmers;
/*
* @Title: 양과 늑대
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/92343
* @Tag:
*/

import java.util.*;

public class Kakao2021_SheepWolf {
    static class Solution {
        static List<Integer>[] graph;
        static int[] info;
        static int max = 0;

        static void dfs(int x, int sheep, int wolf, List<Integer> next) {
            if(info[x] == 0) {
                sheep++;
            } else {
                wolf++;
            }

//            System.out.println("[x] :: "+x);
//            System.out.println("sheep : "+sheep+" // wolf : "+wolf);

            if(sheep <= wolf) return;

            max = Math.max(max, sheep);
//            System.out.println("max -> "+max);

            List<Integer> updated = new ArrayList<>(next);
            updated.remove(Integer.valueOf(x));

            if(!graph[x].isEmpty()) {
                updated.addAll(graph[x]);
            }

//            System.out.println("[updated] :: "+updated);
//            System.out.println();

            for(int nx : updated) {
                dfs(nx, sheep, wolf, updated);
            }

        }

        public int solution(int[] info, int[][] edges) {
            graph = new ArrayList[info.length];
            Solution.info = info;
            for(int i = 0; i< graph.length; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int[] edge : edges) {
                graph[edge[0]].add(edge[1]);
            }

            List<Integer> list = new ArrayList<>();
            list.add(0);
            dfs(0,0,0,list);
            return max;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 5
        System.out.println(solution.solution(new int[]{0,0,1,1,1,0,1,0,1,0,1,1}, new int[][]{{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}}));
        // 5
//        System.out.println(solution.solution(new int[]{0,1,0,1,1,0,1,0,0,1,0}, new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}}));
    }
}
