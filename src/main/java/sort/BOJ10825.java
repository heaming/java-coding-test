package sort;

/*
 * @Title: 국영수
 * @Link: https://www.acmicpc.net/problem/10825
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ10825 {
    static int N;
    static Score[] arr;

    static class Score implements Comparable<Score> {
        String name;
        int kor;
        int eng;
        int math;

        public Score(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public String toString() {
            return "Score{" +
                    "name='" + name + '\'' +
                    ", kor=" + kor +
                    ", eng=" + eng +
                    ", math=" + math +
                    '}';
        }

        @Override
        public int compareTo(Score other) {
            // 국어 점수 내림차순
            if (other.kor != this.kor) return other.kor - this.kor;
            // 영어 점수 오름차순
            if (other.eng != this.eng) return this.eng - other.eng;
            // 수학 점수 내림차순
            if (other.math != this.math) return other.math - this.math;

            // 이름 오름차순 : String.compareTo
            return name.compareTo(other.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new Score[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            arr[i] = new Score(name, kor, eng, math);
        }

        // 국어 점수 내림차순 -> 영어점수 오름차순 -> 수학점수 내림차순 -> 이름 오름차순
        Arrays.sort(arr);

        for(Score score : arr) {
            System.out.println(score.name);
        }

        br.close();
    }
}
