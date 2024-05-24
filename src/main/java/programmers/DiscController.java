package programmers;
/*
* @Title: 디스크컨트롤러
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/42627
* @Tag :
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class DiscController {

    static class Solution {

        static class Job {
            int start;
            int during;

            public Job(int start, int during) {
                this.start = start;
                this.during = during;
            }
        }

        public int solution(int[][] jobs) {
            int answer = 0;

            PriorityQueue<Job> que = new PriorityQueue<>(Comparator.comparingInt(o -> o.start));
            PriorityQueue<Job> waiting = new PriorityQueue<>(Comparator.comparingInt(o -> o.during));

            for(int[] job : jobs) {
                int start = job[0];
                int during = job[1];
                que.offer(new Job(start, during));
            }

            int now = 0;

            while(!que.isEmpty() || !waiting.isEmpty()) {

                // now에 요청들어온 작업 전부 waiting에 넣는다
                while(!que.isEmpty() && que.peek().start <= now) {
                    waiting.offer(que.poll());
                }

                // wating이 비어있다면 now = 요청들어온 시간
                if(waiting.isEmpty()) {
                    now = que.peek().start;
                } else {
                    Job minDuring = waiting.poll();
                    answer += now+minDuring.during- minDuring.start;
                    now += minDuring.during;
                }
            }


            return answer/jobs.length;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            // 9
            System.out.println(solution.solution(new int[][]{{0,3},{1,9},{2,6}}));
        }
    }
}
