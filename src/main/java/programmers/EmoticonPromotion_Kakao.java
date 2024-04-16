package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
<pre>
@Title: 프로그래머스: 이모티콘할인행사
@Link: https://school.programmers.co.kr/learn/courses/30/lessons/150368

</pre>
*/
public class EmoticonPromotion_Kakao {
    static int[] percents = new int[]{10,20,30,40};
    static int[] combi;
    static List<int[]> combiArr = new ArrayList<>();
    static void combi(int[] percents, int cnt, int m) {
        if(cnt >= m) {
            System.out.println(Arrays.toString(combi));
            int[] temp = combi.clone();
            combiArr.add(temp);
            return;
        }

        for(int i=0; i< percents.length; i++) {
            combi[cnt] = percents[i];
            combi(percents, cnt+1, m);
        }

    }

    static class Solution {
        public static int[] solution(int[][] users, int[] emoticons) {
            int[] answer = new int[2];
            combi = new int[emoticons.length];
            combi(percents, 0, emoticons.length);

            for(int j=0; j< combiArr.size(); j++) {
                int[] combis = combiArr.get(j);
                int join = 0;
                int money = 0;

                for(int i=0; i < users.length; i++) { // new int[][]{{40, 10000}, {25, 10000}}
                    int userDc = users[i][0];
                    int userM = users[i][1];
                    int userSum = 0;

                    for(int k=0; k < emoticons.length; k++) { // new int[]{7000, 9000}
                        if(userDc <= combis[k]) {
                            userSum += emoticons[k] * (100-combis[k]) / 100;
                        }
                    }

                    if(userSum >= userM) {
                        join++;
                    } else {
                        money += userSum;
                    }
                }

                if(answer[0] > join || (answer[0] == join && answer[1] > money)) {
                    continue;
                } else {
                    answer[0] = join;
                    answer[1] = money;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000, 9000} ))); //{1, 5400}
        System.out.println(Arrays.toString(Solution.solution(new int[][]{{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}},
                new int[]{1300, 1500, 1600, 4900} ))); //{4, 13860}
    }
}
