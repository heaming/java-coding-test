package twoPointers;

/*
 * @Title: 좋다
 * @Link: https://www.acmicpc.net/problem/1253
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1253 {
    static int N;
    static int[] arr;

    // targetIdx번째 원소가 서로 다른 두 수의 합으로 표현이 되는가?
    static boolean isEqual(int targetIdx) {
        int target = arr[targetIdx];
        int left = 1;
        int right = N;

        while(left < right) {
            if (left==targetIdx) {
                left++;
            } else if (right==targetIdx) {
                right--;
            } else {
                if(arr[left]+arr[right] == target) return true;

                if(arr[left]+arr[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int answer = 0;
        Arrays.sort(arr, 1, N+1);

        for(int i=1; i<=N; i++) {
            if(isEqual(i)) answer++;
        }

        System.out.println(answer);

        br.close();
    }
}
