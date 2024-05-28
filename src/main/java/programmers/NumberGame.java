package programmers;
/*
* @Title: 숫자게임
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/12987
* @Tag : 정렬
*/

import java.util.Arrays;

public class NumberGame {

    static class Solution {
        public int solution(int[] A, int[] B) {
            int answer = 0;

            Arrays.sort(A);
            Arrays.sort(B);

            int x = -1;

            for(int i=0;i<A.length;i++){
                for(int j=x+1; j<B.length; j++){
                    if(A[i] < B[j]){
                        x = j;
                        answer++;
                        break;
                    }
                }
            }

            return answer;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.solution(new int[]{5,1,3,7}, new int[]{2,2,6,8})); // 3
//            System.out.println(solution.solution(new int[]{2,2,2,2}, new int[]{1,1,1,1})); // 0
        }
    }
}
