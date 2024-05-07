package programmers;
/*
* @Title: 금과 은 운반하기
* @Link:  https://school.programmers.co.kr/learn/courses/30/lessons/86053
* @Tag :  이분탐색
*/

import java.util.*;
import java.util.stream.Collectors;

public class DeliverGoldSilver {

    static class Solution {
        // Q : 원하는 a,b 만큼 가져오는 최소시간
        // -> x 시간일때, a,b만큼 가져올 수 있나?
        // a <= Gmax , b <= Smax
        // --> a+b <= Gmax+Smin == Gmin+Smax
        public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
            long answer = (long) (10e9*2*10e5*2);
            int len = g.length;
            long left = 1;
            long right = (long) (10e9*2*10e5*2);

            while(left <= right) {
                long mid = (left+right)/2;
                int gold = 0;
                int silver = 0;
                int total = 0;

                for(int i=0; i<len; i++) {
                    int cg = g[i];
                    int cs = s[i];
                    int cw = w[i];
                    long ct = t[i];

                    // mid 시간 안에 몇 번 왕복 가능?
                    long move = mid/(ct*2);
                    // 편도 계산
                    if((mid %(ct*2)) >= ct) move++;

                    // 마을의 금의 양 vs 옮길 수 있는 양 비교
                    // 마을의 금이 더 작다면 금의 전부를 옮긴다.
                    gold += Math.min(cg, move*cw);
                    silver += Math.min(cs, move*cw);
                    total += Math.min(cg+cs,move*cw);
                }

                if(a<=gold && b<=silver && a+b<=total) {
                    right = mid-1;
                    answer= mid;
                } else {
                    left = mid+1;
                }
            }

            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 50
//        System.out.println(solution.solution(10,10, new int[]{100}, new int[]{100}, new int[]{70}, new int[]{10} ));
        // 499
        System.out.println(solution.solution(90,500, new int[]{70,70,0}, new int[]{0,0,500}, new int[]{100,100,2}, new int[]{4,8,1}));
    }
}
