package programmers;
/*
* @Title: 인사고과
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/152995
* @Tag : 정렬
*/

import java.util.*;

public class Promotion {

    static class Solution {

        public int solution(int[][] scores) {
            int answer = 1;
            int[] wanho = scores[0].clone();

            Arrays.sort(scores, ((o1, o2) -> {
                if(o1[0] == o2[0]) return o2[1]-o1[1];
                return o1[0] - o2[0];
            }));

            int maxScore = 0;
            for(int[] score : scores) {

                if(score[1] < maxScore) {
                    if(score[0] == wanho[0] && score[1] == wanho[1]) return -1;
                } else {
                    maxScore = Math.max(maxScore, score[1]);
                    if(score[0]+score[1] > wanho[0]+wanho[1]) answer++;
                }

            }
            return answer;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            // 4
//            System.out.println(solution.solution(new int[][]{{2,2},{1,4},{3,2},{3,2},{2,1}}));
            System.out.println(solution.solution(new int[][]{{4,3},{5,2},{5,1},{4,5},{4,4}}));
        }
    }
}
