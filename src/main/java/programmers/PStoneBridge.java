package programmers;
/*
* @Title: 징검다리
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/43236
* @Tag : 이분탐색
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PStoneBridge {
    // 조건 : n개의 바위 제거
    // 타겟 : 최단 거리
    // x 거리일 때, n개의 바위가 제거되었나?

    static class Solution {
        public int solution(int distance, int[] rocks, int n) {
            int answer = 0;

            Arrays.sort(rocks);

            int L = 1;
            int R = distance;

            while(L <= R) {
                int mid = (L+R)/2;
                int prev = 0;
                int cnt = 0;

                for(int i=0; i<rocks.length; i++) {
                    int rock = rocks[i];

                    if(rock - prev < mid) {
                        cnt++;
                    } else {
                        prev = rock;
                    }

                    if(i==rocks.length-1) {
                        if(distance - prev < mid) cnt++;
                    }
                }

                if(cnt <= n) {
                    L = mid +1;
                    answer = mid;
                } else {
                    R = mid-1;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(25,new int[]{2, 14, 11, 21, 17}, 2)); // 4
    }
}
