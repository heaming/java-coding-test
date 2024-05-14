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

        public int solution(String arr[]) {
            int numCnt = arr.length/2+1;
            minDp = new int[numCnt+1][numCnt+1];
            maxDp = new int[numCnt+1][numCnt+1];

            Arrays.stream(minDp).forEach(i -> Arrays.fill(i, Integer.MAX_VALUE));
            Arrays.stream(maxDp).forEach(i -> Arrays.fill(i, Integer.MIN_VALUE));

            for(int i=0; i<numCnt; i++) {
                maxDp[i][i] = Integer.parseInt(arr[i*2]);
                minDp[i][i] = Integer.parseInt(arr[i*2]);
            }

            for(int step=1; step<numCnt; step++) { // i, j 간격
                for(int i=0; i<numCnt-step; i++) {

                    int j = i+step;

                    for(int k=i; k<j; k++) {
                        if("+".equals(arr[k*2+1])) {
                            minDp[i][j] = Math.min(minDp[i][j], minDp[i][k]+minDp[k+1][j]);
                            maxDp[i][j] = Math.min(maxDp[i][j], maxDp[i][k]+maxDp[k+1][j]);
                        } else {
                            minDp[i][j] = Math.min(minDp[i][j], minDp[i][k]-maxDp[k+1][j]);
                            maxDp[i][j] = Math.min(maxDp[i][j], maxDp[i][k]-minDp[k+1][j]);
                        }
                    }
                }
            }


            return maxDp[0][numCnt-1];
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.solution(new String[]{"1", "-", "3", "+", "5", "-", "8"})); // 1
            System.out.println(solution.solution(new String[]{"5", "-", "3", "+", "1", "+", "2", "-", "4"})); // 3
        }
    }
}
