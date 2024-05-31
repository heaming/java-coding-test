package programmers;
/*
* @Title: 시소 짝꿍
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/152996
* @Tag :
*/

import java.util.Arrays;

public class SeeSaw {

    static class Solution {
        public long solution(int[] weights) {
            long answer = 0;
            int[] dist = new int[4001];
            int[] real = new int[1001];

            for(int i=0; i<weights.length; i++) {
                int d2 = weights[i]*2;
                int d3 = weights[i]*3;
                int d4 = weights[i]*4;

                answer += dist[d2];
                answer += dist[d3];
                answer += dist[d4];

                if(real[weights[i]] > 0) {
                    answer -= real[weights[i]]*2;
                }

                real[weights[i]]++;
                dist[d2]++;
                dist[d3]++;
                dist[d4]++;
            }
            return answer;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.solution(new int[]{100,180,360,100,270})); // 4
        }
    }
}
