package programmers;
/*
* @Title: 입국심사
* @Link:  https://school.programmers.co.kr/learn/courses/30/lessons/43238
* @Tag : 이분탐색
*/

import java.util.Arrays;

public class PEntryScreening {
    // 조건 : 모든 사람이 심사
    // 타겟 : 시간 최소
    // x분 일 때, n명의 심사가 끝났나?

    static class Solution {

        public long solution(int n, int[] times) {
            long answer = Long.MAX_VALUE;

            Arrays.sort(times);

            long L = 1;
            long R = 1000000000L * times.length;

            while (L <= R) {
                long mid = (L+R)/2;
                long cnt = 0;

                for(long time : times) {
                    cnt += mid/time;
                }

                if(cnt >= n) {
                    R = mid-1;
                    answer = mid;
                } else {
                    L = mid+1;
                }


            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(6,new int[]{7,10})); // 28
    }
}
