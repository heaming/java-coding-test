package P5_2;

/*
 * @Title: 짠돌이 호석
 * @Link: https://www.acmicpc.net/problem/21277
 * @Tag : 배열 회전
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ21277 {
    static int N1;
    static int M1;
    static int[][] p1;
    static int[][] p2;
    static int N2;
    static int M2;
    static int answer = Integer.MAX_VALUE;

    static int[][] rotation(int[][] puzzle) {
        int cn = puzzle.length;
        int cm = puzzle[0].length;

        int[][] nextPuzzle = new int[cm][cn];

        for(int i=0; i<cn; i++) {
            for(int j=0; j<cm; j++) {
                nextPuzzle[j][cn-i-1] = puzzle[i][j];
            }
        }

        return nextPuzzle;
    }

    static boolean possible(int shiftN, int shiftM) {
        for(int i=0; i<N1; i++) {
            for(int j=0; j<M1; j++) {
                if(p1[i][j] == 0) continue;
                int bn = i+shiftN;
                int bm = i+shiftM;

                if(bn >= 0 && bn <p2.length && bm >=0 && bm <p2[0].length && p2[bn][bm] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N1 = Integer.parseInt(st.nextToken());
        M1 = Integer.parseInt(st.nextToken());
        p1 = new int[N1][M1];
        for(int i=0; i<N1; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j=0; j<M1; j++) {
                p1[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        st = new StringTokenizer(br.readLine());
        N2 = Integer.parseInt(st.nextToken());
        M2 = Integer.parseInt(st.nextToken());
        p2 = new int[N2][M2];
        for(int i=0; i<N2; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j=0; j<M2; j++) {
                p2[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        // 90 180 270 회전
        for(int i=0; i<4; i++) {
            p2 = rotation(p2);
            for(int shiftN=-50; shiftN<=50; shiftN++) {
                for(int shiftM=-50; shiftM<=50; shiftM++) {
                    if(possible(shiftN, shiftM)) {
                        int n = Math.max(N2-1, shiftN+N1-1) - Math.min(0, shiftN)+1;
                        int m = Math.max(M2-1, shiftM+M1-1) - Math.min(0, shiftM)+1;
                        answer = Math.min(n*m, answer);
                    }
                }
            }
        }

        System.out.println(answer);



        br.close();
    }
}
