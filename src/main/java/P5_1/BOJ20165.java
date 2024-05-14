package P5_1;

/*
 * @Title: 인내의 도미노 장인 호석
 * @Link: https://www.acmicpc.net/problem/20165
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ20165 {
    static int N; // 행
    static int M; // 열
    static int R; // 라운드 횟수
    static int[][] domino;
    static String[][] map;
    static Queue<Operation> que = new LinkedList<>();


    static class Operation {
        int n;
        int m;
        String d;

        public Operation(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public Operation(int n, int m, String d) {
            this.n = n;
            this.m = m;
            this.d = d;
        }
    }

    static class Node {
        int n;
        int m;

        public Node(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    static int totalScore = 0;

    static void play() {

        while(!que.isEmpty()) {
            Operation op = que.poll();
            int score = 0;
            Queue<Node> nodes = new LinkedList<>();
            nodes.offer(new Node(op.n, op.m));

            while(!nodes.isEmpty()) {
                Node node = nodes.poll();

                if(node.n > N || node.n < 1 || node.m > M || node.m < 1) continue;

                if(op.d == null) {
                    if(map[node.n][node.m].equals("F")) {
                        map[node.n][node.m] = "S";
                    }
                    continue;
                }

                if(map[node.n][node.m].equals("F")) continue;

                map[node.n][node.m] = ("F");
                score++;

                for(int i=1; i<domino[node.n][node.m]; i++) {
                    if (op.d.equals("N")) {
                        nodes.offer(new Node(node.n-i, node.m));
                    } else if (op.d.equals("S")) {
                        nodes.offer(new Node(node.n+i, node.m));
                    } else if (op.d.equals("E")) {
                        nodes.offer(new Node(node.n, node.m+i));
                    } else if (op.d.equals("W")) {
                        nodes.offer(new Node(node.n, node.m-i));
                    }
                }
            }

            totalScore += score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        domino = new int[N+1][M+1];
        map = new String[N+1][M+1];

        for(String[] s : map) {
            Arrays.fill(s, "S");
        }


        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                domino[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            que.offer(new Operation(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), st.nextToken()));
            st = new StringTokenizer(br.readLine());
            que.offer(new Operation(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        play();

        System.out.println(totalScore);
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }


        br.close();
    }
}
