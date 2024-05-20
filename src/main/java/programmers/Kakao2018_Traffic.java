package programmers;
/*
* @Title: 최고의 집합
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/17676
* @Tag :
*/

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Kakao2018_Traffic {

    static class Solution {
        public static int solution(String[] lines) throws Exception {
            SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss.SSS");

            int[] cnt = new int[lines.length];
            int answer = 0;

            for(int i=0; i<lines.length; i++) {
                String[] prev = lines[i].split(" ");
                Date prevDate = df.parse(prev[1]);
                long prevTime = prevDate.getTime();

                for(int j=i; j<lines.length; j++) {
                    String[] next = lines[j].split(" ");
                    Date nextDate = df.parse(next[1]);
                    double during = Double.parseDouble(next[2].substring(0, next[2].length()-1));

                    long nextStart = (long) (nextDate.getTime() - during*1000 + 1);

                    if(prevTime + 1000 >= nextStart) {
                        cnt[i] += 1;
                        answer = Math.max(answer, cnt[i]);
                    }
                }
            }

            return answer;

        }
        public static void main(String[] args) throws Exception {
            Solution solution = new Solution();
            System.out.println(solution.solution(new String[]{"2016-09-15 01:00:04.002 2.0s",
                    "2016-09-15 01:00:07.000 2s"})); // 2
            System.out.println(solution.solution(new String[]{"2016-09-15 20:59:57.421 0.351s",
                    "2016-09-15 20:59:58.233 1.181s",
                    "2016-09-15 20:59:58.299 0.8s",
                    "2016-09-15 20:59:58.688 1.041s",
                    "2016-09-15 20:59:59.591 1.412s",
                    "2016-09-15 21:00:00.464 1.466s",
                    "2016-09-15 21:00:00.741 1.581s",
                    "2016-09-15 21:00:00.748 2.31s",
                    "2016-09-15 21:00:00.966 0.381s",
                    "2016-09-15 21:00:02.066 2.62s"})); // 7

        }
    }
}
