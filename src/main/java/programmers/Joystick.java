package programmers;
/*
* @Title: 조이스틱
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/42860
* @Tag : 그리디
*/

import java.util.Arrays;

public class Joystick {
    static class Solution {
        public int solution(String name) {
            int answer = 0;
            int move = name.length() - 1;
            for(int i=0; i<name.length(); i++){
                answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);

                int next = i+1;
                while(next < name.length() && name.charAt(next) == 'A') {
                    next++;
                }

                move = Math.min(move, (i*2)+name.length()-next);
                move = Math.min(move, (name.length()-next)*2+i);
            }
            answer += move;
            return answer;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
//            System.out.println(solution.solution("JEROEN")); // 56
            System.out.println(solution.solution("JAN")); // 23
//            System.out.println(solution.solution("JAZ")); // 11
        }
    }
}
