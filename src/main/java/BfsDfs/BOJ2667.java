package BfsDfs;

/*
 * @Title: 단지번호붙이기
 * @Link: https://www.acmicpc.net/problem/2667
 */

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class BOJ2667 {
    static int N; // 정점 개수
    static int[][] map;
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{1,-1,0,0};
    static boolean[][] visited;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

   static int bfs(Node start) {

        Queue<Node> que = new LinkedList<>();
        que.offer(start);
        visited[start.y][start.x] = true;

        int cnt = 1;

        while(!que.isEmpty()) {
            Node cur = que.poll();
            int cx = cur.x;
            int cy = cur.y;

            for(int i=0; i<4; i++) {
                int nx = cx+dx[i];
                int ny = cy+dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[ny][nx] && map[ny][nx]==1) {
                    que.offer(new Node(nx, ny));
                    visited[ny][nx] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String st = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = st.charAt(j)-'0';
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j] && map[i][j]==1) {
                    int cnt = bfs(new Node(j, i));
                    if(cnt > 0) list.add(cnt);
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for(int i : list) {
            System.out.println(i);
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
