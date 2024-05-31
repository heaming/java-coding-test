package programmers;
/*
* @Title: 스티커 모으기
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/12971
* @Tag : dp
*/

import java.util.Arrays;

public class CollectStickers {

    static class Solution {
        public int solution(int sticker[]) {
            int[][] dy1 = new int[sticker.length][2]; // i를 떼는 경우 안떼는 경우
            int[][] dy2 = new int[sticker.length][2]; // i를 떼는 경우 안떼는 경우

            dy1[0][0] = 0;
            dy1[0][1] = sticker[0];

            if(sticker.length <= 1) return sticker[0];

            dy1[1][0] = dy1[0][1];
            dy1[1][1] = sticker[1];

            if(sticker.length <= 2) return Math.max(sticker[0], sticker[1]);

            for(int i=2; i<sticker.length-1; i++) {
                dy1[i][0] = Math.max(dy1[i-1][1], dy1[i-2][1]);
                dy1[i][1] = sticker[i]+Math.max(dy1[i-1][0], dy1[i-2][1]);
            }

            dy2[1][0] = 0;
            dy2[1][1] = sticker[1];
            dy2[2][0] = dy2[2][1];
            dy2[2][1] = sticker[2];

            for(int i=3; i<sticker.length; i++) {
                dy2[i][0] = Math.max(dy2[i-1][1], dy2[i-2][1]);
                dy2[i][1] = sticker[i]+Math.max(dy2[i-1][0], dy2[i-2][1]);
            }

            System.out.println(Arrays.deepToString(dy1));
            System.out.println(Arrays.deepToString(dy2));

            return Math.max(Math.max(dy1[sticker.length-2][0], dy2[sticker.length-1][1]), Math.max(dy1[sticker.length-2][1], dy2[sticker.length-1][0]));
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
//            System.out.println(solution.solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10})); // 36
//            System.out.println(solution.solution(new int[]{1,3,2,5,4})); // 8
            System.out.println(solution.solution(new int[]{5, 1, 16, 17, 16})); // 32
        }
    }
}
