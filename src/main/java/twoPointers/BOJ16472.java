package twoPointers;

/*
 * @Title: 고냥이
 * @Link: https://www.acmicpc.net/problem/16472
 */

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16472 {
    static int N;
    static String str;
    static int kind;
    static int[] cnt;

    static void add(char x) { // x라는 알파벳 추가
         cnt[x-'a']++;
         if(cnt[x-'a'] == 1) kind++; // 새로운 문자가 추가 되었다는 뜻
    }

    static void erase(char x) { // x라는 알파벳 제거
        cnt[x-'a']--;
        if(cnt[x-'a'] == 0) kind--; // 문자가 사라졌다는 뜻
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        str = st.nextToken();
        int len = str.length();
        cnt = new int[26];

        int answer = 0;

        for(int right=0, left=0; right<len; right++) {
            // right번째 문자를 cnt 오른쪽에 추가
            add(str.charAt(right));

            // 불가능하면, 가능할 때까지 left 이동
            /*
            // 1. 알파벳 확인 -> 26번
            while(true) {
                kind = 0;
                for(int i=0; i<26; i++) {
                    if(cnt[i] != 0) kind++; // 새로운 알파벳이라면
                }
                if(kind <= N) break; // N이하라면 옮길 필요 없음

                erase(str.charAt(left));
                left++;
            }
            */

            // 2. kind가 변화되는 지점만 찾으면 된다 -> add() , erase()
            while(kind > N) {
                erase(str.charAt(left++));
            }

            // 정답 갱신
            answer = Math.max(answer, right-left+1);
        }

        System.out.println(answer);

        br.close();
    }
}
