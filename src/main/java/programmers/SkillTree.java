package programmers;
/*
* @Title: 스킬트리
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/49993
* @Tag :
*/

import java.util.*;

public class SkillTree {

    static class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            Map<Character, Integer> rank = new HashMap<>();
            rank.put(skill.charAt(0), -1);

            for(int i=1; i<skill.length(); i++) {
                rank.put(skill.charAt(i), i-1);
            }

            for(String tree : skill_trees) {
                boolean[] done = new boolean[skill.length()];
                boolean flag = true;

                for(int i=0; i<tree.length(); i++) {
                    if(!flag) break;

                    char cur = tree.charAt(i);

                    if(!rank.containsKey(cur)) continue;

                    if(rank.get(cur) == -1) {
                        done[0] = true;
                    } else {
                        int prev = rank.get(cur);
                        if(!done[prev]) {
                            flag = false;
                        } else {
                            done[skill.indexOf(cur)] = true;
                        }
                    }
                }
                if(flag) answer++;

            }
            return answer;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"})); // 2
        }
    }
}
