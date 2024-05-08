package programmers;
/*
* @Title: 매출하락최소화
* @Link:  https://school.programmers.co.kr/learn/courses/30/lessons/72416
* @Tag :  dfs, dp
*/

import java.util.*;
import java.util.stream.Collectors;

public class Kakao2021_MinimalSales {

    static class Solution {

        static List<Integer>[] graph;
        static int[][] dy; // 0 참석 x -> 1 참석
        static int[] sales;

        static void dfs(int idx) {
            dy[idx][0] = 0;
            dy[idx][1] = sales[idx-1];

            if(graph[idx].isEmpty()) return;

            int min = Integer.MAX_VALUE;

            for(int child : graph[idx]) {
                dfs(child);
                if(dy[child][0] < dy[child][1]) {
                    dy[idx][0] += dy[child][0];
                    dy[idx][1] += dy[child][0];
                    min = Math.min(min, dy[child][1]-dy[child][0]);
                } else {
                    dy[idx][0] += dy[child][1];
                    dy[idx][1] += dy[child][1];
                    min = 0;
                }
            }

            dy[idx][0] += min;
        }

        public int solution(int[] sales, int[][] links) {
            int len = sales.length;
            Solution.sales = sales;
            graph = new ArrayList[len+1];
            dy = new int[300001][2];
            for(int i=1; i<=len; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int[] link : links) {
                graph[link[0]].add(link[1]);
            }
            dfs(1);

            return Math.min(dy[1][0], dy[1][1]);
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] s1 = {14, 17, 15, 18, 19, 14, 13, 16, 28, 17};
            int[][] l1 ={{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}};

//            int[] s2={5, 6, 5, 3, 4};
//            int[][] l2= {{2,3}, {1,4}, {2,5}, {1,2}}; //	6
//            int[] s3={5, 6, 5, 1, 4};
//            int[][] l3={{2,3}, {1,4}, {2,5}, {1,2}};//	5
//            int[] s4={10, 10, 1, 1};
//            int[][] l4 = {{3,2}, {4,3}, {1,4}};//	2
            System.out.println(solution.solution(s1, l1)); //44
        }
    }
}
