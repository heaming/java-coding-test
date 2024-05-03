package programmers;
/*
* @Title: 주사위 고르기
* @Link:  https://school.programmers.co.kr/learn/courses/30/lessons/258709
*/

public class Kakao2024_Dice {
    // A가 무조건 승리하면 되는 것

    static class Solution {
        public int[] solution(int[][] dice) {
            int[] answer = {};
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // [1,4]
        System.out.println(solution.solution(new int[][]{{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}}));
        // 2
        System.out.println(solution.solution(new int[][]{{1, 2, 3, 4, 5, 6}, {2, 2, 4, 4, 6, 6}}));
        // 1 3
        System.out.println(solution.solution(new int[][]{{40, 41, 42, 43, 44, 45}, {43, 43, 42, 42, 41, 41}, {1, 1, 80, 80, 80, 80}, {70, 70, 1, 1, 70, 70}}));
    }
}
