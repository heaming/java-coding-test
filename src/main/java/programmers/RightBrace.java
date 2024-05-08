package programmers;
/*
* @Title: 올바른 괄호의 갯수
* @Link:  https://school.programmers.co.kr/learn/courses/30/lessons/12929
* @Tag : DP
*/

public class RightBrace {

    static class Solution {
        static int answer = 0;

        public int solution(int n) {
            int[] dy = new int[n + 1];
            dy[0] = 1;
            dy[1] = 1;

            for (int i = 2; i <= n; i++) {
                for(int j = 0; j < i; j++) {
                    dy[i] += dy[i - j - 1] * dy[j];
                }
            }
            return dy[n];
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.solution(2)); //2
            System.out.println(solution.solution(4)); // 5
        }
    }
}

