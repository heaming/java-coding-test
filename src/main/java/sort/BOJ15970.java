package sort;

/*
 * @Title: 화살표 그리기
 * @Link: https://www.acmicpc.net/problem/15970
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15970 {
    static int N;
    static List<Integer>[] arr; // 위치 , 색
    static int answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());
            arr[color].add(idx);
        }

        for(int i=0; i<N+1; i++) {
            if(!arr[i].isEmpty()) {
                List<Integer> temp = arr[i];
                Collections.sort(temp);


                for(int j=0; j<temp.size(); j++) {
                    if(j==0) {
                        answer += temp.get(j + 1) - temp.get(j);
                        continue;
                    }

                    if(j==temp.size()-1) {
                        answer += temp.get(j) - temp.get(j-1);
                        continue;
                    }

                    answer += Math.min(Math.abs(temp.get(j)- temp.get(j-1)), Math.abs(temp.get(j+1) - temp.get(j)));
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}
