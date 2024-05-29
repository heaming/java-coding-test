package programmers;
/*
* @Title: 디펜스 게임
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/142085
* @Tag : 우선순위큐
*/

import java.util.Arrays;
import java.util.PriorityQueue;

public class DepenceGame {

    static class Solution {
        static int[] enemy;
        static int n;
        static int k;

//        static boolean canDefence(int term) {
//            PriorityQueue<Integer> que = new PriorityQueue<>();
//            for(int i=0; i<=term; i++) {
//                que.offer(-1*enemy[i]);
//            }
//
//            for(int i=0; i<k; i++) {
//                if(!que.isEmpty()) que.poll();
//            }
//
//            int left = n;
//
//            while(!que.isEmpty()) {
//                int ce = que.poll();
//                left += ce;
//            }
//
//            return left >= 0;
//        }
//        public int solution(int n, int k, int[] enemy) {
//            Solution.enemy = enemy;
//            Solution.n = n;
//            Solution.k = k;
//
//            int answer = 0;
//            int left = 0;
//            int right = enemy.length;
//
//            while(left < right) {
//                int mid = (left+right)/2;
//
//                if(canDefence(mid)) {
//                    left = mid+1;
//                    answer = left;
//                } else {
//                    right = mid;
//                }
//            }
//
//
//            return answer;
//        }

        public int solution(int n, int k, int[] enemy) {
            int answer = 0;

            // k를 사용한 대상
            PriorityQueue<Integer> que = new PriorityQueue<>();

            for(int i=0; i<enemy.length; i++) {
                if(k>0) {
                    que.add(enemy[i]);
                    k--;
                } else {
                    int cur = enemy[i];

                    if(que.peek() < cur) {
                        cur = que.poll();
                        que.add(enemy[i]);
                    }

                    if(n >= cur) {
                        n -= cur;
                    } else break;
                }
                answer++;
            }


            return answer;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.solution(7,3,new int[]{4, 2, 4, 5, 3, 3, 1})); // 5
            System.out.println(solution.solution(2,4,new int[]{3,3,3,3})); // 4
        }
    }
}
