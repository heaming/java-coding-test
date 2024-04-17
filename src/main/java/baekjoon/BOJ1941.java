package baekjoon;

/*
 * @Title: 소문난 칠공주
 * @Link: https://www.acmicpc.net/problem/1941
 * @비트마스킹: https://yoo-dev.tistory.com/37
 */

import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1941 {

    static String[][] map;
    static List<List<Integer>> combis = new ArrayList<>();


    static void combi() {
        for(int i=1; i< 1<<26; i++) {
            List<Integer> temp = new ArrayList<>();
            if(Integer.bitCount(i) == 7) {
                for(int j=1; j<=25; j++) {
                    if((i & (1<<j)) >0) {
                        temp.add(j);
                    }
                }
            }
            if (temp.size() == 7) combis.add(temp);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new String[5][5];

//        for(int i=0; i<5; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for(int j=0; j<5; j++) {
//                map[i][j] = st.nextToken();
//            }
//        }

        // 인접한 7명 / S >= 4
        combi();
        System.out.println(combis);


        bw.flush();
        br.close();
        bw.close();
    }
}
