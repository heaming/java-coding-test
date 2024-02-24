package programmers;

import java.util.*;

/*
 * @Title: 프로세스
 * @Link: https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * */
public class Process_Que {

    static class Process {
        int priority;
        int location;

        public Process(){}
        public Process(int priority, int location) {
            this.location = location;
            this.priority = priority;
        }

        public String toString() {
            return "pri : " + priority + " / location : " + location;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> que = new LinkedList<>();
        Queue<Integer> highest = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<priorities.length; i++) {
            Process process = new Process(priorities[i], i);
            que.offer(process);
            highest.offer(process.priority);
        }

//        System.out.println(que);
//        System.out.println(highest);

        while(!que.isEmpty() && !highest.isEmpty()) {
            Process cur = que.poll();
            int high = highest.peek();

//            System.out.println("cur :: " + cur);
//            System.out.println("high :: " + high);

            if (cur.priority >= high) { // 차례인 경우
                answer++;
                highest.poll();

                if(cur.location == location) return answer;
            } else { // 차례가 아닌 경우
                que.offer(cur);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Process_Que solution = new Process_Que();

        System.out.println(solution.solution(new int[]{2, 1, 3, 2}, 2)); // 1
        System.out.println(solution.solution(new int[]{1, 1, 9, 1, 1, 1}, 0)); // 5
    }
}
