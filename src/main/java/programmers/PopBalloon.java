package programmers;
/*
* @Title: 풍선터트리기
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/68646#qna
* @Tag : 투포인터
*/

import java.util.Arrays;

public class PopBalloon {

    static class Solution {
        public int solution(int[] a){
            int answer = 0;
            int left = 0;
            int right = a.length-1;
            int leftMin = a[left];
            int rightMin = a[right];

            while(left < right) { // 한 개는 남겨야하니까

                if(leftMin > rightMin) {
                    left++;

                    if(a[left] < leftMin) {
                        answer++;
                    }

                    leftMin = Math.min(leftMin, a[left]);
                } else {
                    right--;

                    if(a[right] < rightMin) {
                        answer++;
                    }
                    rightMin = Math.min(rightMin, a[right]);
                }
            }

            return answer+1;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
//            System.out.println(solution.solution(new int[]{9,-1,5})); // 3
            System.out.println(solution.solution(new int[]{-16,27,65,-2,58,-92,-71,-68,-61,-33})); // 3
        }
    }
}
