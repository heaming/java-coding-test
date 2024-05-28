package programmers;
/*
* @Title: 영어 끝말잇기
* @Link:  https://school.programmers.co.kr/learn/courses/30/lessons/12981
* @Tag :
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordRelay {

    static class Solution {

        public int[] solution(int n, String[] words) {
            int[] answer = new int[]{0,0}; // 번호 / turn
            int turn = 0;
            Set<String> set = new HashSet<>(Arrays.stream(words).toList());

            char prev = words[0].charAt(0);
            System.out.println(set);

            for(int i=0; i<words.length; i++) {
                if(i%n==0) turn++;

                if(set.isEmpty() || !set.contains(words[i]) || (prev != words[i].charAt(0))) {
                    answer[1] = turn;
                    answer[0] = i%n+1;
                    return answer;
                }

                prev = words[i].charAt(words[i].length()-1);
                set.remove(words[i]);
            }

            return answer;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(Arrays.toString(solution.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}))); //3 3
            System.out.println(Arrays.toString(solution.solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"}))); // 0
            System.out.println(Arrays.toString(solution.solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"}))); // 1 3
        }
    }
}
