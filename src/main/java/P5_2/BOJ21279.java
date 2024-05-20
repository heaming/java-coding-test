package P5_2;

/*
 * @Title: 광부 호석
 * @Link: https://www.acmicpc.net/problem/21279
 * @Tag : 투포인터
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ21279 {
    static int N;
    static int C;

    static List<Stone>[] xlist = new ArrayList[100005];
    static List<Stone>[] ylist = new ArrayList[100005];
    static long v = 0;
    static long cnt = 0;

    static class Stone {
        int x;
        int y;
        long v;

        public Stone(int x, int y, long v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }

    static void del(int y, int x) {
        for(Stone stone:ylist[y]) {
            if(stone.x <= x) {
                cnt--;
                v -= stone.v;
            }
        }
    }

    static void add(int x, int y) {
        for(Stone stone : xlist[x]) {
            if(stone.y <= y) {
                cnt++;
                v += stone.v;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for(int i=0; i< ylist.length; i++) {
            ylist[i] = new ArrayList<>();
            xlist[i] = new ArrayList<>();
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            long v = Integer.parseInt(st.nextToken());

            xlist[x].add(new Stone(x,y,v));
            ylist[y].add(new Stone(x,y,v));
        }

        // sum(v) 일 때, c를 만족하는가?
        long answer = 0;
        int w = -1;
        int h = 100_000;

        while(w <= 100_000 && h >=0) {
            if(cnt > C) {
                del(h--, w);
            } else {
                add(++w, h);
            }

            if(cnt <= C) {
                answer = Math.max(answer, v);
            }

        }

        System.out.println(answer);

        br.close();
    }
}
