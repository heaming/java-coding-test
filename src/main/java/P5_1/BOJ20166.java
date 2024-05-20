package P5_1;

/*
 * @Title: 문자열 지옥에 빠진 호석
 * @Link: https://www.acmicpc.net/problem/20166
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ20166 {
    static int N;
    static int M;
    static int K;
    static char[][] grid;
    static String[] god;
    static int[] cnt;
    static int[] dn = new int[]{0,0,-1,-1,-1,1,1,1};
    static int[] dm = new int[]{1,-1,-1,0,1,-1,0,1};


    static Map<String, Integer> map = new HashMap<>();

    static class Node {
        int n;
        int m;

        public Node(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    static void dfs(Node node, String str) {
        str += grid[node.n][node.m];
        map.put(str, map.getOrDefault(str, 0)+1);

        if(str.length() >=5) return;

        int cn = node.n;
        int cm = node.m;

        for(int i=0; i<8; i++) {
            int nn = cn+dn[i];
            int nm = cm+dm[i];

            if(nn==N+1) nn = 1;
            if(nm==M+1) nm = 1;
            if(nn==0) nn = N;
            if(nm==0) nm = M;

            dfs(new Node(nn, nm), str);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new char[N+1][M+1];
        god = new String[K];
        cnt = new int[K];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j=1; j<=M; j++) {
                grid[i][j] = s.charAt(j-1);
            }
        }

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            god[i] = st.nextToken();
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                dfs(new Node(i, j), "");
            }
        }

//        System.out.println(map);

        for(String str : god) {
            System.out.println(map.getOrDefault(str, 0));
        }

        br.close();
    }
}
