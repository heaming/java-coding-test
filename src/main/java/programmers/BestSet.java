package programmers;
/*
* @Title: 최고의 집합
* @Link:  https://school.programmers.co.kr/learn/courses/30/lessons/12938
* @Tag :
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestSet {

    static class Solution {
        public int[] solution(int n, int s) {
            if(n > s) return new int[]{-1};

            int[] answer = new int[n];
            int idx = 0;
            while(n > 0) {
                answer[idx] = s/n;
                s -= answer[idx];
                n--;
                idx++;
            }

            return answer;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(Arrays.toString(solution.solution(2, 9))); //4 5
            System.out.println(Arrays.toString(solution.solution(2, 1))); //-1
            System.out.println(Arrays.toString(solution.solution(2, 8))); // 4 4
        }
    }
}
