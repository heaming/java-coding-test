package programmers;
/*
* @Title: 다단계 칫솔 판매
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/77486
* @Tag :
*/

import java.util.*;

public class SaleToothBrush {

    static class Solution {
        static Map<String, Integer> res = new HashMap<>();
        static Map<String, String> tree = new HashMap<>();

        static void toBoss(String cur, int money) {

            int bossPercent = money/10;
            res.put(cur, res.getOrDefault(cur,0)+money-bossPercent);

            if(tree.containsKey(cur) && bossPercent > 0) {
                toBoss(tree.get(cur), bossPercent);
            }
        }

        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            int[] answer = new int[enroll.length];

            for(int i=0; i<referral.length; i++) {
                if(referral[i].equals("-")) continue;

                tree.put(enroll[i],referral[i]);
            }

            // 판매수익
            for(int i=0; i<seller.length; i++) {
                toBoss(seller[i], amount[i]*100);
            }

            for(int i=0; i<enroll.length; i++) {
                answer[i] = res.getOrDefault(enroll[i], 0);
            }
            return answer;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(Arrays.toString(solution.solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                    new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                    new String[]{"young", "john", "tod", "emily", "mary"},
                    new int[]{12, 4, 2, 5, 10})));
            System.out.println(Arrays.toString(solution.solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                    new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                    new String[]{"sam", "emily", "jaimie", "edward"},
                    new int[]{2, 3, 5, 4})));
        }
    }
}
