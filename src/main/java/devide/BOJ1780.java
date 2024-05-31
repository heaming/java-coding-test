package devide;

/*
 * @Title: 종이의 개수
 * @Link: https://www.acmicpc.net/problem/1780
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1780 {
    static int N;
    static int[][] map;

    static int[] answer = new int[3];

    static void dfs(int n, int r, int c) {

        if(isSame(n, r, c)) {
            if(map[r][c] == -1) answer[0]++;
            if(map[r][c] == 0) answer[1]++;
            if(map[r][c] == 1) answer[2]++;

            return;
        }

        int div = n/3;
        dfs(div, r, c);
        dfs(div, r, c+div);
        dfs(div, r, c+(div*2));
        dfs(div, r+div, c);
        dfs(div, r+div*2, c+div);
        dfs(div, r+(div*2), c);
        dfs(div, r+div, c+div);
        dfs(div, r+(div*2), c+(div*2));
        dfs(div, r+div, c+(div*2));
    }


    static boolean isSame(int n, int r, int c) {

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
                if(map[r][c] != map[r+i][c+j]) return false;
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
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dfs(N, 0,0);

        for(int i :answer) System.out.println(i);

        br.close();
    }
}
