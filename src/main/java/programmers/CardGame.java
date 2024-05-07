package programmers;
/*
* @Link:  https://school.programmers.co.kr/learn/courses/30/lessons/258707
*/
import java.util.*;
import java.util.stream.Collectors;

public class CardGame {

    static List<Integer> userCards = new ArrayList<>();
    static List<Integer> leftCards = new ArrayList<>();

    static boolean calc(int n, List<Integer> a, List<Integer> b) {

        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                if (a.get(i) + b.get(j) == n+1) {
                    int aa = a.get(i);
                    int bb = b.get(j);
                    a.remove(Integer.valueOf(aa));
                    b.remove(Integer.valueOf(bb));

                    return true;
                }
            }
        }

        return false;
    }
    static class Solution {
        public int solution(int coin, int[] cards) {
            int answer = 1;
            int n = cards.length;
            int idx;

            for(idx= 0; idx < n/3; idx++) {
                userCards.add(cards[idx]);
            }

            while(idx < n) {

                leftCards.add(cards[idx++]);
                leftCards.add(cards[idx++]);

                if(userCards.size() > 1 && calc(n, userCards, userCards)) {
                    answer++;
                } else if (coin > 0  && calc(n, userCards, leftCards)) {
                    answer++;
                    coin--;
                } else if(coin > 1 && calc(n, leftCards, leftCards) ) {
                    answer++;
                    coin-=2;
                } else {
                    break;
                }

            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(solution.solution(4, new int[] {3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4})); // 5
//        System.out.println(solution.solution(3, new int[] {1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11, 12})); // 2
//        System.out.println(solution.solution(2, new int[] {5, 8, 1, 2, 9, 4, 12, 11, 3, 10, 6, 7})); // 4
        System.out.println(solution.solution(10, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18})); // 1
    }
}
