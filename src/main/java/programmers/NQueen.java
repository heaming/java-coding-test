package programmers;
/*
* @Title: N-Queen
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/1843
* @Tag : 백트래킹
*/

import java.util.Arrays;

public class NQueen {
    static class Solution {

        // 한 r,c에 하나씩
        static int n;
        static int[] spot;
        static int answer = 0;

        static boolean isPossible(int idx) {
            for(int j=0; j<idx; j++) {
                // 같은 열에 있는 queen 있을 시
                if(spot[idx] == spot[j]) return false;

                // 대각선
                if(Math.abs(idx-j) == Math.abs(spot[idx]-spot[j])) return false;
            }

            return true;
        }

        static void dfs(int idx) {

            if(idx>=n) {
                answer++;
                return;
            }

            for(int i=0; i<n; i++) {
                spot[idx] = i;
                if(isPossible(idx)) {
                    dfs(idx+1);
                }
            }
        }

        public int solution(int n) {
            Solution.n = n;
            spot = new int[n];

            dfs(0);

            return answer;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.solution(4)); // 2
        }
    }
}
