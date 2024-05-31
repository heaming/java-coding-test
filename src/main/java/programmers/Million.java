package programmers;
/*
* @Title: 억억단을 외우자
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/138475
* @Tag :
*/

import java.util.*;

public class Million {

    static class Solution {

        static int prime(int n) {
            Map<Integer, Integer> primes = new HashMap<>();

            for(int i=2; i<=Math.sqrt(n); i++) {
                while(n%i == 0) {
                    primes.put(i, primes.getOrDefault(i, 0)+1);
                    n /= i;
                }
            }

            if(n != 1) primes.put(n, primes.getOrDefault(n, 0)+1);

            int cnt = 1;
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(primes.entrySet());
            for(Map.Entry<Integer, Integer> l : list) {
                cnt *= (l.getValue()+1);
            }

            return cnt;
        }


        public int[] solution(int e, int[] starts) {
            int[] answer = new int[starts.length];
            int[][] dy = new int[e+1][2]; //0 최대 약수 개수 1최대 약수 위치
            dy[e][0] = prime(e);
            dy[e][1] = e;

            for(int i=e-1; i>=1; i--) {
                int cnt = prime(i);

                if(cnt >= dy[i+1][0]) {
                    dy[i][0] =cnt;
                    dy[i][1] = i;
                } else {
                    dy[i][0] = dy[i+1][0];
                    dy[i][1] = dy[i+1][1];
                }
            }

            for(int i=0; i<starts.length; i++) {
                answer[i] = dy[starts[i]][1];
            }

            return answer;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(Arrays.toString(solution.solution(8, new int[]{1, 3, 7}))); // 6 6 8
        }
    }
}
