package sort;

/*
 * @Title: 수열정렬
 * @Link: https://www.acmicpc.net/problem/1015
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1015 {
    static int N;
    static Elem[] arr;


    static class Elem implements Comparable<Elem> {
        int num; // A[idx]의 원래 값
        int idx; // A배열의 idx 위치를 기억하는 변수

        public Elem(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Elem other){
            // 1. num의 비내림차순
            if(this.num != other.num) return this.num - other.num;
            // 2. num이 같으면 idx 오름차순
            return this.idx - other.idx;

            // 자바  : 이미 idx 순으로 들어가기 때문에 num이 같으면 idx 오름차순 비교 필요없음
            //      : Object의 경우, Stable 0
            // -> return this.num - other.num;  // 이것만 써두됨
        }

        @Override
        public String toString() {
            return "Elem{" +
                    "num=" + num +
                    ", idx=" + idx +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new Elem[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr[i] = new Elem(Integer.parseInt(st.nextToken()), i);
        }

        // 1. B배열 정렬하기
        Arrays.sort(arr);

        // 2. B배열의 값을 이용해서 P배열 채우기
        int[] P =  new int[N];
        for(int i=0; i<N; i++) {
            P[arr[i].idx] = i;
        }

        for(int i: P) {
            System.out.print(i+" ");
        }

        br.close();
    }
}
