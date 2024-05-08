package BruteForce;

/*
 * @Title: N Queen
 * @Link: https://www.acmicpc.net/problem/9663
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9663 {
    static int N;
    static int[] col;
    static int answer = 0;

    static boolean attackable(int r1, int c1, int r2, int c2) {
        if(c1 == c2) return true;
        if(r1-c1 == r2-c2) return true;
        if(r1+c1 == r2+c2) return true;
        return false;
    }

    static boolean check() {
        for(int i=1; i<=N; i++){
            // (i, col[i])
            for(int j=1; j<=i; j++) {
                // (j, col[j])
                if(attackable(i, col[i], j, col[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    static void solution(int row) {
        if(row == N+1) {
            answer++;
        } else {
            for(int c=1; c<=N; c++) {
                boolean possible = true;
                // row 행의 c열에 놓을 수 있으면
                for(int i=1; i<=row-1; i++) {
                    if(attackable(row, c, i, col[i])) {
                        possible = false;
                        break;
                    }
                }

                if(possible) {
                    col[row] = c;
                    solution(row+1);
                    col[row] = 0;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        col = new int[N+1];

        solution(1);
        System.out.println(answer);

        br.close();
    }
}
