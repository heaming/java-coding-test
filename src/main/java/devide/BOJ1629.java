package devide;

/*
 * @Title: 곱셈
 * @Link: https://www.acmicpc.net/problem/1629
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1629 {
    static int A;
    static int B;
    static int C;

    static int answer;

    // 지수함수의 곱 : 2^n * 2^m = 2^(n+m)
    // 나머지 연산의 분배법칙 : (A*B)%C = (A%C)*(B%C)

    static long dfs(int a, int b) {
        // b가 짝수인 경우 dfs(a,b) = dfs(a, b/2)+dfs(a, b/2)
        // b가 홀수인 경우 dfs(a,b) = dfs(a,b/2)+dfs(a,b/2)*dfs(a,1)

        if(b==1) return a%C;

        long mid = dfs(a, b/2);
        if(b%2 ==0){
            return (mid*mid)%C;
        }
        return (((mid*mid)%C)*a)%C;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(dfs(A, B));
        br.close();
    }
}
