package programmers;
/*
* @Title: 쿼드압축 후 개수 세기
* @Link:  https://school.programmers.co.kr/learn/courses/30/lessons/68936
* @Tag : 분할정복
*/

import java.util.Arrays;

public class QuadPress {

    static class Solution {

        static int[][] arr;
        static int[] answer = new int[2];

        static void dfs(int n, int r, int c) {

            if (isSame(n, r, c)) {
                int t = arr[r][c];
                answer[t]++;
                return;
            }

            int mid = n/2;

            dfs(mid, r, c);
            dfs(mid, r, c+mid);
            dfs(mid, r+mid, c);
            dfs(mid, r+mid, c+mid);
        }

        static boolean isSame(int n, int r, int c) {

            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(arr[r][c] != arr[r+i][c+j]) return false;
                }
            }
            return true;
        }


        public int[] solution(int[][] arr) {
            Solution.arr = arr;

            dfs(arr.length, 0,0);
            return answer;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(Arrays.toString(solution.solution(new int[][]{{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}})));
        }
    }
}
