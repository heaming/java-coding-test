package programmers;
/*
* @Title: 길 찾기 게임
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/42892
* @Tag: 트리
*/

import java.util.*;

public class Kakao2019_DirectionsGame {
    static class Solution {

        static class Node {
            int idx;
            int x;
            int y;

            public Node(int idx, int x, int y) {
                this.idx = idx;
                this.x = x;
                this.y = y;
            }
        }

        public int[][] solution(int[][] nodeinfo) {
            int[][] answer = {};
            return answer;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();

            // [[7,4,6,9,1,8,5,2,3],[9,6,5,8,1,4,3,2,7]]
            System.out.println(solution.solution(new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}}));

        }
    }
}
