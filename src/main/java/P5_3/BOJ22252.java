package P5_3;

/*
 * @Title: 정보 상인 호석
 * @Link: https://www.acmicpc.net/problem/22252
 * @Tag :
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ22252 {
    static int Q;
    static Map<String, PriorityQueue<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Q = Integer.parseInt(st.nextToken());

        long sum = 0;

        for(int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int len = Integer.parseInt(st.nextToken());

            // 고릴라 정보
            if(q == 1) {
                PriorityQueue<Integer> que = map.getOrDefault(name, new PriorityQueue<>(Collections.reverseOrder()));
                for(int j=0; j<len; j++) {
                    int k = Integer.parseInt(st.nextToken());
                    que.offer(k);
                }
                map.put(name, que);
            } else {
                if(!map.containsKey(name)) continue;
                PriorityQueue<Integer> que = map.get(name);
                while(!que.isEmpty() && len>0) {
                    sum += que.poll();
                    len--;
                }
                map.put(name, que);
            }

        }

        System.out.println(sum);

        br.close();
    }
}
