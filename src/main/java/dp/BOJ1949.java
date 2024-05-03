package dp;

/*
 * @Title: 우수 마을
 * @Link: https://www.acmicpc.net/problem/15681
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1949 {

    // 주민수 합 최대
    // 우수 마을끼리는 인접해 있지 않다 -> tree[i] 0 : tree[i].get(x) x
    // 우수마을로 선정되어 있지 못한 마을은 적어도 하나의 우수 마을과 인접

    static int N; // 노드 수
    static int[] people;
    static List<Integer>[] tree;
    static int[][] dy;

    static void dfs(int x, int prev) {
        dy[x][1] = people[x];

        for(int y : tree[x]) {
            if(y == prev) continue;
            dfs(y, x);
            dy[x][0] += Math.max(dy[y][0], dy[y][1]);
            dy[x][1] += dy[y][0];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        people = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            people[i]= Integer.parseInt(st.nextToken());
        }
        tree = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 1; i<= N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        dy = new int[N+1][2];
        dfs(1,-1);

        System.out.println(Math.max(dy[1][0], dy[1][1]));


        br.close();
    }
}
