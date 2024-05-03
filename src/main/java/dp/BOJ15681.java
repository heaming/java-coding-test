package dp;

/*
 * @Title: 트리와 쿼리
 * @Link: https://www.acmicpc.net/problem/15681
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15681 {
    static int N; // 노드 수
    static int R; // 루트 번호
    static int Q; // 쿼리 수
    static int U;
    static List<Integer>[] tree;
    static int[] dy;

//    dy[x] 계산
    static void dfs(int x, int parent) {
        dy[x] = 1;

        for(int y:tree[x]) {
            if(y==parent) continue;
            dfs(y, x);
            dy[x] += dy[y];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        tree = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            tree[i] = new ArrayList<>();
        }
        dy = new int[N+1];


        for(int i = 1; i<= N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(R, -1);

        for(int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            U = Integer.parseInt(st.nextToken());
            System.out.println(dy[U]);
        }

        br.close();
    }
}
