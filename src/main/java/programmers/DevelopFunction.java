package programmers;

import java.util.*;

/*
<pre>
@Title: 프로그래머스: 기능개발
@Link: https://school.programmers.co.kr/learn/courses/30/lessons/42586
</pre>
*/
public class DevelopFunction {

    class Solution {
        public List solution(int[] progresses, int[] speeds) {
            List answer = new ArrayList();
            List dates = new ArrayList();
            int cnt = 0;

            for(int i = 0; i < progresses.length; i++) {
                int date = (int) Math.ceil((double)( 100 - progresses[i] ) / speeds[i]);
                dates.add(date);
            }

            for(int i = 0; i < dates.size(); i++) {
                int date = (int) dates.get(i);
                if(date > cnt) {
                    answer.add(1);
                    cnt = date;
                } else {
                    int last = (int) answer.get(answer.size()-1);
                    answer.set(answer.size()-1, last+1);
                }
            }

            return answer;
        }
    }
}
