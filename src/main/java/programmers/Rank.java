package programmers;
/*
* @Title: 순위
* @Link:  https://school.programmers.co.kr/learn/courses/30/lessons/49191?language=java
* @Tag : 플로이드 와샬
*/

import java.util.*;

public class Rank {

    static class Solution {
        public int solution(int n, int[][] results) {
            int answer = 0;
            int[][] rank = new int[n+1][n+1];

            for(int[] result : results) {
                int winner = result[0];
                int loser = result[1];
                rank[winner][loser] +=1;
                rank[loser][winner] -=1;
            }


            for(int target=1; target<=n; target++) {
                for(int i=1; i<=n; i++) {
                    for(int j=1; j<=n; j++) {
                        if(i==target || j==target) continue;
                        if(rank[i][target]==1 && rank[target][j]==1) { // i > target > j
                            rank[i][j] = 1;
                        } else if(rank[i][target]==-1 && rank[target][j]==-1) { // j>target>i
                            rank[i][j] = -1;
                        }
                    }
                }
            }

            for(int i=1; i<=n; i++) {
                int games = 0;
                for(int j=1; j<=n; j++) {
                    if(rank[i][j] != 0) games++;
                }
                if(games == n-1) answer++;
            }

            System.out.println();
            for(int[] r : rank) {
            System.out.println(Arrays.toString(r));
            }

            return answer;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            //2
            System.out.println(solution.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
        }
    }
}
