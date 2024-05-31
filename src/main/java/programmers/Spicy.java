package programmers;
/*
* @Title: 더맵게
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/42626
* @Tag : 우선순위큐
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Spicy {

    static class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;

            PriorityQueue<Integer> que = new PriorityQueue<>();
            for(int i : scoville) {
                que.offer(i);
            }

            while(que.size() > 1) {
                int cur = que.poll();

                if(cur >= K) break;

                int next = que.poll();

                que.offer(cur+(next*2));
                answer++;
            }

            if(!que.isEmpty()) {
                int last = que.poll();
                if(last < K) return -1;
            }

            return answer;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.solution(new int[]{1,2,3,9,10,12}, 7)); // 2
        }
    }
}
