package programmers;
/*
* @Title: 야근 지수
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/12927
* @Tag :
*/

import java.util.*;

public class NightWork {

    static class Solution {

        // n시간 일했을 때, 남은 x 최소화
        // x일 때, n시간 일할 수 있나?
        public long solution(int n, int[] works) {
            long answer = 0;

            PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

            for (int work : works) {
                que.add(work);
            }

            for(int i=0; i<n; i++){
                if(que.isEmpty()) return 0;

                int work = que.poll();
                if (work == 0) return 0;

                que.add(work-1);
            }

            while (!que.isEmpty()) {
                answer += Math.pow(que.poll(), 2);
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4,new int[]{4,3,3})); // 12
        System.out.println(solution.solution(1,new int[]{2,1,2})); // 6
        System.out.println(solution.solution(3,new int[]{1,1})); // 0
    }

}
