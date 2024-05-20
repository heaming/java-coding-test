package programmers;
/*
* @Title: 테이블 해시 함수
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/147354
* @Tag :
*/

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TableHash {

    static class Solution {
        public int solution(int[][] data, int col, int row_begin, int row_end) {
            int answer = -1;
            int[] SI = new int[data.length+1];


            // 1. 정렬
            Arrays.sort(data, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[col-1] == o2[col-1]) return o2[0]-o1[0];

                    return o1[col-1]-o2[col-1];
                }
            });

            System.out.println(Arrays.deepToString(data));

            // 2. S_i
            for(int i=row_begin; i<=row_end; i++) {
                int row = i-1;

                for(int j=0; j<data[0].length; j++) {
                    SI[i] += data[row][j]%i;
                }

                answer = answer >= 0 ? answer^SI[i] : SI[i];
            }

            return answer;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            // 4
            System.out.println(solution.solution(new int[][]{{2,2,6},{1,5,10},{4,2,9},{3,8,3}},2,2,3));
        }
    }
}
