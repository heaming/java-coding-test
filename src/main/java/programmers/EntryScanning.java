package programmers;
/*
* @Title: 입국심사
* @Link:  https://school.programmers.co.kr/learn/courses/30/lessons/43238
* @Tag :
*/

import java.util.Arrays;

public class EntryScanning {

    static class Solution {
        public long solution(int n, int[] times) {
            long answer = 0;

            Arrays.sort(times);
            long left = times[0];
            long right = times[times.length-1]* 100_000L;

            while(left <= right){
                long mid = (left+right)/2;
                long cnt = 0;

                for(int time : times) {
                    cnt += (mid/time);
                }

                if(cnt>=n) {
                    answer = mid;
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }

            return answer;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.solution(6, new int[]{7,10})); //28
        }
    }
}
