package programmers;
/*
* @Title: 도둑질
* @Link:  https://school.programmers.co.kr/learn/courses/30/lessons/42897
* @Tag : dp
*/

import java.util.Arrays;

public class Rob {

    static class Solution {
        public int solution(int[] money) {
            int cnt = money.length;

            int[] dp1 = new int[cnt];
            int[] dp2 = new int[cnt];

            // 0번집 o
            dp1[0] = money[0];
            dp1[1] = Math.max(money[0], money[1]);

            for(int i=2; i<cnt-1; i++) {
                dp1[i] = Math.max(dp1[i-1], money[i]+dp1[i-2]);
            }

            // 0번집 x
            dp2[0] = 0;
            dp2[1] = money[1];
            for(int i=2; i<cnt; i++) {
                dp2[i] = Math.max(dp2[i-1], money[i]+dp2[i-2]);
            }

//            System.out.println(Arrays.toString(dp1));
//            System.out.println(Arrays.toString(dp2));

            return Math.max(dp1[cnt-2], dp2[cnt-1]);
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.solution(new int[]{1,2,3,1})); //4
            System.out.println(solution.solution(new int[]{1,1,4,1,4})); //8
            System.out.println(solution.solution(new int[]{1000,0,0,1000,0,0,1000,0,0,1000})); //3000
            System.out.println(solution.solution(new int[]{1000,1,0,1,2,1000,0})); //2001
            System.out.println(solution.solution(new int[]{1000,0,0,0,0,1000,0,0,0,0,0,1000})); //2000
            System.out.println(solution.solution(new int[]{1,2,3,4,5,6,7,8,9,10})); //30
            System.out.println(solution.solution(new int[]{0,0,0,0,100,0,0,100,0,0,1,1})); //201
            System.out.println(solution.solution(new int[]{11,0,2,5,100,100,85,1})); //198
            System.out.println(solution.solution(new int[]{1,2,3})); //3
        }
    }
}
