package programmers;
/*
* @Title: 삼총사
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/131705
* @Tag : 백트래킹
*/

public class ThreeFriends {
    static class Solution {

        static int answer = 0;
        static int[] number;

        static void dfs(int idx, int cnt, int sum, boolean[] visited) {

            if(cnt >= 3) {
                if(sum == 0) answer++;
                return;
            }

            for(int i=idx+1; i< number.length; i++) {
                if(visited[i]) continue;
                visited[i] = true;
                dfs(i, cnt+1, sum+number[i], visited);
                visited[i] = false;
            }
        }


        public int solution(int[] number) {
            Solution.number = number;

            for(int i=0; i<number.length; i++) {
                dfs(i, 1, number[i], new boolean[number.length]);
            }

            return answer;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.solution(new int[]{-2, 3, 0, 2, -5})); // 2
        }
    }
}
