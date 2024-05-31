package programmers;
/*
* @Title: 과제 진행하기
* @Link:  https://school.programmers.co.kr/learn/courses/30/lessons/176962
* @Tag :
*/

import java.util.*;
import java.util.stream.Collectors;

public class ProcessingAssignment {

    static class Solution {

        static class Info {
            String name;
            int start;
            int during;

            public Info(String name, int start, int during) {
                this.name = name;
                this.start = start;
                this.during = during;
            }
        }

        public String[] solution(String[][] plans) {
            List<String> answer = new ArrayList<>();

            PriorityQueue<Info> que = new PriorityQueue<>(Comparator.comparingInt(o -> o.start));
            Stack<Info> remain = new Stack<>();

            for(String[] plan : plans) {
                String[] startStr = plan[1].split(":");
                int start = Integer.parseInt(startStr[0])*60 + Integer.parseInt(startStr[1]);
                int during = Integer.parseInt(plan[2]);
                Info info = new Info(plan[0], start, during);
                que.offer(info);
            }

            Info prev = que.poll();
            int now = prev.start;

            while(true) {
                Info next = que.peek();

                // prev 못 끝냄
                if(!que.isEmpty() && now+prev.during > next.start) {
                    remain.push(new Info(prev.name, prev.start, prev.during-(next.start-now)));
                    now = next.start;
                    prev = que.poll();
                } else { // prev 끝냄
                    answer.add(prev.name);
                    now += prev.during;

                    // 바로 새로 시작할 것이 있음
                    if(!que.isEmpty() && now<=next.start) {
                        prev = que.poll();
                    } else if(!remain.isEmpty()) {
                        prev = remain.pop();
                    } else if(!que.isEmpty()) {
                        prev = que.poll();
                        now = prev.start;
                    } else break;
                }
            }
            return answer.toArray(new String[0]);
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
//            System.out.println(Arrays.toString(solution.solution(new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}})));
            System.out.println(Arrays.toString(solution.solution(new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}})));

        }
    }
}
