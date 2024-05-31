package programmers;
/*
* @Title: 이중우선순위큐
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/42628
* @Tag :
*/

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DoublePriorityQueue {

    static class Solution {
        public int[] solution(String[] operations) {
            int[] answer = new int[2];
            PriorityQueue<Integer> minQue = new PriorityQueue<>();
            PriorityQueue<Integer> maxQue = new PriorityQueue<>(Collections.reverseOrder());

            for(String op : operations) {
                String[] arr = op.split(" ");
                String s = arr[0];
                int n = Integer.parseInt(arr[1]);

                if(s.equals("I")) {
                    minQue.offer(n);
                    maxQue.offer(n);
                } else if(!maxQue.isEmpty() && n == 1) {
                    int max = maxQue.poll();
                    minQue.remove(max);
                } else if(!minQue.isEmpty() && n == -1) {
                    int min = minQue.poll();
                    maxQue.remove(min);
                }
            }

            // System.out.println(maxQue);
            // System.out.println(minQue);

            answer[0] = !maxQue.isEmpty() ? maxQue.poll() : 0;
            answer[1] = !minQue.isEmpty() ? minQue.poll() : 0;

            return answer;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            // 0 0
//            System.out.println(solution.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}));
            System.out.println(solution.solution(new String[]{"I 16","I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}));


            // 333 -45
            System.out.println(solution.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}));
        }
    }
}
