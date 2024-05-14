package P5_1;

/*
 * @Title: 꿈틀꿈틀 호석 애벌레 - 기능성
 * @Link: https://www.acmicpc.net/problem/20167
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ20167 {
    static int N;
    static int K;
    static int[] degree;

    static int max = 0;

    static void eat(int idx, int energy, int total) {
        if(energy >= K) {
            total += energy-K;
            energy = 0;
        }

        if(idx>N) {
            max = Math.max(total, max);
            return;
        }

        // 안먹다 -> energy == 0
        if(energy == 0) {
            eat(idx + 1, energy, total);
        }
        // 먹다 -> 앞에서 안 먹은 경우, 앞에서 먹고 energy < k 인 경우
        eat(idx+1, energy+degree[idx], total);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        degree = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            degree[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++) {
            eat(i, 0, 0);
        }


        System.out.println(max);
        br.close();
    }
}
