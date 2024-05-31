package dp;

/*
 * @Title: 1,2,3 더하기
 * @Link: https://www.acmicpc.net/problem/5557
 * @Tag: dp
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ5557 {
    static int N;
    static int[] nums;

    static void dp() {

        long[][] dy = new long[N+1][21];
        // 1번에서 nums[i] 이 되는 경우
        dy[1][nums[1]] = 1;

        for(int i=2; i<=N; i++) {
            for(int prev=0; prev<=20; prev++) {
                for(int cur : new int[]{prev-nums[i], prev+nums[i]}) {
                    if(cur < 0 || cur > 20) continue;
                    dy[i][cur] += dy[i-1][prev];
                }
            }
        }

        System.out.println(dy[N-1][nums[N]]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        nums = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp();

        br.close();
    }
}
