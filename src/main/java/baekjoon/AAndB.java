package baekjoon;

import java.util.Arrays;

/*
* @Title: A와 B
* @Link: https://www.acmicpc.net/problem/12919
* * */
public class AAndB {

    static boolean answer = false;

    static String addA(String cur) {
        return cur+"A";
    }

    static String addBAndReverse(String cur) {
        StringBuffer next = new StringBuffer(cur+"B");
        return next.reverse().toString();
    }

    static void dfs(String cur, String fin) {
        if(cur.equals(fin)) {
            answer = true;
        }
        if(cur.length() == fin.length()) return;

        dfs(addA(cur), fin);
        dfs(addBAndReverse(cur), fin);
    }
    static int solution(String s, String t) {
        dfs(s, t);
        System.out.println(answer);

        return answer ? 1 : 0 ;
    }

    public static void main(String[] args) {
        AAndB aAndB = new AAndB();

        System.out.println(aAndB.solution("A", "BABA")); // 1
        answer = false;
        System.out.println(aAndB.solution("BAAAAABAA", "BAABAAAAAB")); // 1
        answer = false;
        System.out.println(aAndB.solution("A", "ABBA")); // 0
        answer = false;
    }

}
