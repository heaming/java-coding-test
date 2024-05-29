package programmers;
/*
* @Title: 양궁대회
* @Link:  https://school.programmers.co.kr/learn/courses/30/lessons/92342
* @Tag :
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Kakao2022_Archery {

    static class Solution {
        static int[] info;

        static int[] ryan = new int[11];
        static int max = -1;
        static List<int[]> answer = new ArrayList<>();

        static void combi(int n, int depth) {
            if(depth == n) {
                int calc = calcScore();
                if(max < calc) {
                    answer.clear();
                    answer.add(ryan);
                    max = calc;
                } else if(max == calc) {
                    answer.add(ryan);
                }
                return;
            }

            for(int i=0; i<=10 && ryan[i] <= info[i]; i++) {
                ryan[i]++;
                combi(n, depth+1);
                ryan[i]--;
            }
        }

        static int calcScore() {
            int as = 0;
            int rs = 0;

            for(int i=0; i<=10; i++) {
                if(info[i] == 0 && ryan[i] ==0) continue;

                if(info[i] >= ryan[i]) {
                    as += (10 - i);
                } else {
                    rs += (10-i);
                }
            }

            return rs-as>=0 ? rs-as : -1;
        }


        public int[] solution(int n, int[] info) {
            Solution.info = info;

            combi(n, 0);

            return answer.get(0);
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            //
            System.out.println(Arrays.toString(solution.solution(5, new int[]{2,1,1,1,0,0,0,0,0,0,0}))); //4 5
//            System.out.println(Arrays.toString(solution.solution(2, 1))); //-1
//            System.out.println(Arrays.toString(solution.solution(2, 8))); // 4 4
        }
    }
}
