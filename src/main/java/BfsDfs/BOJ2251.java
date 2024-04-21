package BfsDfs;

/*
 * @Title: 물통
 * @Link: https://www.acmicpc.net/problem/2251
 */

import java.io.*;
import java.util.*;

public class BOJ2251 {
    static int[] bottles = new int[3];
    static List<Integer> answer = new ArrayList<>();
    static boolean[][][] visited;

    static class State {
        int[] x;

        public State(int[] x) {
            this.x = new int[3];

            for(int i=0; i<3; i++) {
                this.x[i] = x[i];
            }
        }

        State move(int from, int to, int[] bottles) {
            // from -> to
            int[] nx = new int[]{x[0], x[1], x[2]};

            if(x[from] + x[to] >= bottles[to]) {
                nx[from] -= bottles[to] - x[to];
                nx[to] = bottles[to];
            } else {
                nx[to] += nx[from];
                nx[from] = 0;
            }
            return new State(nx);
        }
    }

    static void bfs(int a, int b, int c) {
        Queue<State> que = new LinkedList<>();

        visited[a][b][c] = true;
        que.offer(new State(new int[]{a, b, c}));

        while (!que.isEmpty()) {
            State cur = que.poll();
            if(cur.x[0] == 0) answer.add(cur.x[2]);

            for(int from=0; from<3; from++) {
                for(int to=0; to<3; to++) {
                    if(from == to) continue;

                    State next = cur.move(from, to, bottles);
                    if(!visited[next.x[0]][next.x[1]][next.x[2]]) {
                        que.offer(next);
                        visited[next.x[0]][next.x[1]][next.x[2]] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<3; i++) {
            bottles[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[bottles[0]+1][bottles[1]+1][bottles[2]+1];
        bfs(0, 0, bottles[2]);

        Collections.sort(answer);
        for(int i: answer) {
            System.out.print(i+" ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
