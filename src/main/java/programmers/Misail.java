package programmers;
/*
* @Title: 요격시스템
* @Link:  https://school.programmers.co.kr/learn/courses/30/lessons/181188
* @Tag :
*/

import java.util.Arrays;

public class Misail {

    static class Solution {
        public int solution(int[][] targets) {
            int answer = 0;
            int[] during = new int[100];

            Arrays.sort(targets, (o1,o2) -> o1[1]-o2[1]);


            int x = 0;
            for(int i=0; i<targets.length; i++) {
                int cur = targets[i][0];

                if(cur >= x) {
                    answer++;
                    x = targets[i][1];
                }
            }

            return answer;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            // 3
            System.out.println(solution.solution(new int[][]{{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}}));
        }
    }
}
