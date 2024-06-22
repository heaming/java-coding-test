package stack;

/*
 * @Title: 문자열 폭발
 * @Link: https://www.acmicpc.net/problem/9935
 * @Tag : 스택
 *  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9935 {
    static String str;
    static String target;
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        str = br.readLine();
        target = br.readLine();

        for(int i=0; i<str.length(); i++) {
            stack.push(str.charAt(i));

            if(stack.size() >= target.length()) {
                boolean flag = true;
                for(int j=0; j<target.length(); j++) {
                    if(stack.get(stack.size()-target.length()+j) != target.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    for(int j=0; j<target.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        for(char c:stack) {
            sb.append(c);
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb);
        br.close();
    }
}
