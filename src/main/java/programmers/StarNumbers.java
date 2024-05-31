package programmers;
/*
* @Title: 스타수열
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/70130
* @Tag :
*/

import java.util.Arrays;

public class StarNumbers {

    static class Solution {
        public int solution(int[] a) {
            int answer = 0;

            if(a.length == 0 || a.length%2 >0) return 0;

            int[] temp = new int[a.length+2];
            int[] check = new int[a.length+2];
            for(int i=1; i<temp.length-1; i++) {
                temp[i] = a[i-1];
            }
            temp[0] = a[0];
            temp[1] = a[a.length-1];

            for(int i=1; i<temp.length; i++) {
//                if(temp[i])
            }





            return answer;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.solution(new int[]{0})); // 0
            System.out.println(solution.solution(new int[]{5,2,3,3,5,3})); // 4
            System.out.println(solution.solution(new int[]{0,3,3,0,7,2,0,2,2,0})); // 8
        }
    }
}
