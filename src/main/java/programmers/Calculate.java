package programmers;
/*
* @Title: 사칙연산
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/1843
* @Tag : dp
*/

import java.util.*;

public class Calculate {

    static class Solution {
        static int[][] minDp;
        static int[][] maxDp;
        static int[] numbers;

        public int solution(String arr[]) {
            int answer = -1;
            int numCnt = arr.length/2+1;
            numbers = new int[numCnt];

            for(int i=0; i<numCnt; i++) {
                numbers[i] = Integer.parseInt(arr[i*2]);
            }

            System.out.println(Arrays.toString(numbers));


            minDp = new int[numCnt+1][numCnt+1];
            maxDp = new int[numCnt+1][numCnt+1];

            for(int step=0; step<arr.length; step++) { // i, j 간격
                for(int i=0; i<arr.length-step; i++) {

                    int j = i+step;

                    if(step == 0) {
                        minDp[i][i] = Integer.parseInt(arr[i*2]);
                        maxDp[i][i] = Integer.parseInt(arr[i*2]);
                    } else {
                        for(int k=i; k<j; k++) {
//                            if("+".equals(arr[k])) {
////                                maxDp[i][j] = Math.min(minDp[i][j], )
//                            }
                        }
                    }



                }
            }


            return answer;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.solution(new String[]{"1", "-", "3", "+", "5", "-", "8"})); // 1
            System.out.println(solution.solution(new String[]{"5", "-", "3", "+", "1", "+", "2", "-", "4"})); // 3
        }
    }
}
