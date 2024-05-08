package BfsDfs;

/*
 * @Title: 숨바꼭질
 * @Link: https://www.acmicpc.net/problem/1697
 */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {

    static int N;
    static int K;
    static int[] spot;
    static boolean[] visit;

    static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.offer(N);
        visit[N] = true;

        while(!que.isEmpty()) {
            int cur = que.poll();

            int fx = cur-1;
            if(fx <= 100000 && fx >= 0 && !visit[fx]) {
                spot[fx] = spot[cur]+1;
                visit[fx] = true;
                que.offer(fx);
            };

            int sx = cur+1;
            if(sx <= 100000 && sx >= 0 && !visit[sx]) {
                spot[sx] = spot[cur] + 1;
                visit[sx] = true;
                que.offer(sx);
            }

            int tx = cur*2;
            if(tx <= 100000 && tx >= 0 && !visit[tx]) {
                spot[tx] = spot[cur] + 1;
                visit[tx] = true;
                que.offer(tx);
            }

        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visit = new boolean[100001];
        spot = new int[100001];

        bfs();
        System.out.println(spot[K]);

        bw.flush();
        br.close();
        bw.close();
    }
}
