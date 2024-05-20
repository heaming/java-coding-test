package programmers;
/*
* @Title: N으로 표현
* @Link:  https://school.programmers.co.kr/learn/courses/30/lessons/42895
* @Tag : dp
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class NExpression {

    static class Solution {
        public int solution(int N, int number) {
            int answer = 9;

            Set<Integer>[] list = new HashSet[9];

            for(int i=0; i<=8; i++) {
                list[i] = new HashSet<>();
                if(i==0) continue;
                int x = Integer.parseInt(String.valueOf(N).repeat(i));
                list[i].add(x);
            }

            for(int i=1; i<=8; i++) {
                for(int j=1; j<=i; j++) {
                    Iterator<Integer> it1 = list[j].iterator();
                    while(it1.hasNext()) {
                        int a = it1.next();
                        if(a == number) answer = Math.min(answer, i);
                        if(list[i-j].isEmpty()) continue;
                        Iterator<Integer> it2 = list[i-j].iterator();
                        while(it2.hasNext()) {
                            int b = it2.next();
                            list[i].add(a+b);
                            list[i].add(a-b);
                            list[i].add(a*b);

                            if(b != 0) list[i].add(a/b);
                        }
                    }
                }
            }

            return answer >= 9 ? -1 : answer;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.solution(5,12)); //4
            System.out.println(solution.solution(2,11)); // 3
            System.out.println(solution.solution(5,31168)); // -1
        }
    }
}
