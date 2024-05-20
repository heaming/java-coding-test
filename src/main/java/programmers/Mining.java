package programmers;
/*
* @Title: 광물캐기
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/172927
* @Tag :
*/

import java.util.Arrays;

public class Mining {

    static class Solution {
        static int[] mineral;
        static int answer = Integer.MAX_VALUE;

        static void dfs(int dia, int iron, int stone, int idx, int total) {

            if(dia==0 && iron==0 && stone==0) {
                answer = Math.min(answer, total);
                return;
            }

            if(idx>=mineral.length) {
                answer = Math.min(answer, total);
                return;
            }

            int time = Math.min(mineral.length - idx, 5);

            if(dia>0) {
                int temp = 0;
                int i;
                for(i=idx; i<idx+time; i++) {
                    temp++;
                }

                dfs(dia - 1, iron, stone, i, total+temp);
            }

            if(iron>0) {
                int temp = 0;
                int i;
                for(i=idx; i<idx+time; i++) {
                    if(mineral[i] == 0) {
                        temp += 5;
                    } else {
                        temp += 1;
                    }
                }

                dfs(dia, iron-1, stone, i, total+temp);
            }

            if(stone>0) {
                int temp = 0;
                int i;
                for(i=idx; i<idx+time; i++) {
                    if(mineral[i] == 0) {
                        temp += 25;
                    } else if(mineral[i] == 1) {
                        temp += 5;
                    } else {
                        temp += 1;
                    }
                }

                dfs(dia, iron, stone-1, i, total+temp);
            }
        }

        public int solution(int[] picks, String[] minerals) {
            Solution.mineral = new int[minerals.length];

            for(int i=0; i< minerals.length; i++) {
                if(minerals[i].equals("diamond")) Solution.mineral[i] = 0;
                if(minerals[i].equals("iron")) Solution.mineral[i] = 1;
                if(minerals[i].equals("stone")) Solution.mineral[i] = 2;
            }


            dfs(picks[0], picks[1], picks[2], 0, 0);


            return answer;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
//            System.out.println(solution.solution(new int[]{1,3,2}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"})); //12
            // 50
            System.out.println(solution.solution(new int[]{0,1,1}, new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"}));
        }
    }
}
