package programmers;
/*
* @Title: 기지국 설치
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/12979
* @Tag :
*/

import java.util.*;

public class InstallBroadCast {

    static class Solution {

        public int solution(int n, int[] stations, int w) {
            int answer = 0;

            int idx = 1;
            for(int st : stations) {
                if(st-w > 0) {
                    answer += Math.ceil((st-w-idx) / (w*2+1));
                    idx += w+1;
                }
            }

            if(idx-1 < n) {
                answer += Math.ceil((n-idx-1) / (w*2+1));
            }

            return answer;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.solution(11, new int[]{4,11}, 1)); // 3
            System.out.println(solution.solution(16, new int[]{9}, 2)); // 3
            System.out.println(solution.solution(3, new int[]{2}, 1)); // 3
        }
    }
}
