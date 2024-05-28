package P5_3;

/*
 * @Title: 트리 디자이너 호석
 * @Link: https://www.acmicpc.net/problem/22253
 * @Tag : 트리, dp
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ22253 {
    static int N;
    static int[] arr;
    static List<Integer>[] graph;
    static int MOD = 1000000007;
    static int[][] dy;

    static void dfs(int cur, int prev) {
        dy[cur][arr[cur]] = 1;

        for(int next : graph[cur]) {
            if(next == prev) continue;
            dfs(next, cur);

            // cur을 켜지 않은 경우 : 뒷자리가 어떤 것인지 상관x
            for(int num=0; num<=9; num++) {
                dy[cur][num] += dy[next][num];
                dy[cur][num] %= MOD;
            }

            // cur을 켠 경우 : cur>=num 되어야함
            for(int num=arr[cur]; num<=9; num++) {
                dy[cur][arr[cur]] += dy[next][num];
                dy[cur][arr[cur]] %= MOD;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        dy = new int[N+1][10];
        graph = new List[N+1];
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
        }

        for(int i=1; i<=N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1, -1);

        int answer = 0;
        for(int i=0; i<=9; i++) {
            answer += dy[1][i];
            answer %= MOD;
        }

        System.out.println(answer);

        br.close();
    }
}
