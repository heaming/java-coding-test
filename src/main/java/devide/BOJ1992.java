package devide;

/*
 * @Title: 쿼드트리
 * @Link: https://www.acmicpc.net/problem/1992
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1992 {
    static int N;
    static int[][] map;

    static String ans = "";

    static void dfs(int n, int y, int x) {

        if(isSame(n, y, x)) {
            System.out.print(map[y][x]);
            return;
        }

        int mid = n/2;
        System.out.print("(");
        dfs(mid, y, x);
        dfs(mid, y, x+mid);
        dfs(mid, y+mid, x);
        dfs(mid, y+mid, x+mid);
        System.out.print(")");
    }

    static boolean isSame(int n, int y, int x){
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[y][x] != map[y+i][x+j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            for(int j=0; j<N; j++) {
                map[i][j] = temp.charAt(j)-'0';
            }
        }

        dfs(N, 0, 0);

        br.close();
    }
}
