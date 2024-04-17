package baekjoon;

/*
 * @Title: 바이러스
 * @Link: https://www.acmicpc.net/problem/2606
 */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2606 {
    static int N; // 컴퓨터 수
    static int M; // 간선 개수
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        boolean[] visited = new boolean[N+1];

        int answer = 0;

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }

        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        visited[1] = true;

        while(!que.isEmpty()) {
            int cur = que.poll();

            for(int i=1; i<=N; i++) {
               if(!visited[i] && map[cur][i] == 1) {
                   answer++;
                   visited[i] = true;
                   que.offer(i);
               }
            }
        }



        System.out.println(answer);

        bw.flush();
        br.close();
        bw.close();
    }
}
