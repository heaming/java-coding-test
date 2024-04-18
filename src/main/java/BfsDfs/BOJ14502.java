package BfsDfs;

/*
 * @Title: 연구소
 * @Link: https://www.acmicpc.net/problem/14502
 */

import java.io.*;
import java.util.*;

public class BOJ14502 {
    static int N; // 세로
    static int M; //가로
    static int[][] map; // 0 빈칸 1 벽 2 바이러스
    static int blankCount;
    static int[][] blank;
    static boolean[][] visited;
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{1,-1,0,0};
    static int ans;

    // bfs() : 바이러스 퍼트리기
    static void spread() {
        // 큐에서 행과 열의 순서가 보장된다면 홀수로 빼는 것은 i, 짝수는 j -> Integer 사용 가능
        Queue<int[]> que = new LinkedList<>();

        // 모든 바이러스가 시작점으로 가능 -> 전부 큐에 넣어준다
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                visited[i][j] = false;
                if(map[i][j] == 2) {
                    que.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int x = cur[1];
            int y = cur[0];

            for(int i=0; i<4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if (nx < 1 || ny < 1 || nx > M || ny > N) continue;
                if (map[ny][nx] != 0) continue;
                if (visited[ny][nx]) continue;

                visited[ny][nx] = true;
                que.offer(new int[]{ny,nx});
            }
        }


        // 안전 영역 넓이 계산
        int cnt = 0;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(map[i][j] == 0 && !visited[i][j]) cnt++;
            }
        }

        ans = Math.max(ans,cnt);
    }


    // dfs() : idx번째 빈 칸에 벽을 세운다.
    static void build(int idx, int cnt) {
        // 3개를 모두 세움
        if(cnt == 3) {
            spread();
            return;
        }

        // 더이상 빈칸이 없는 경우
        if(idx>blankCount) return;

        // 1. 벽을 세운다
        map[blank[idx][0]][blank[idx][1]] = 1;
        build(idx+1, cnt+1);
        // 2. 벽을 세우지 않는다
        map[blank[idx][0]][blank[idx][1]] = 0;
        build(idx+1, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        blank = new int[N*M+1][2];
        visited = new boolean[N+1][M+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 빈칸 위치 모으기
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(map[i][j] == 0) {
                    blankCount++;
                    blank[blankCount][0] = i;
                    blank[blankCount][1] = j;
                }
            }
        }

        build(1,0);

        System.out.println(ans);

        br.close();
    }
}
