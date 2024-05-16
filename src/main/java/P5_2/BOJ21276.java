package P5_2;

/*
 * @Title: 계보 복원가 호석
 * @Link: https://www.acmicpc.net/problem/21276
 * @Tag: 위상정렬
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ21276 {
    static int N;
    static String[] names;
    static int M;
    static Map<String, Integer> map = new HashMap<>();
    static List<Integer>[] graph;
    static List<String> first = new ArrayList<>();
    static int[] indeg;
    static List<Integer>[] newChild;

    static void sort() {
        Queue<Integer> que = new LinkedList<>();
        for(int i=0; i<indeg.length; i++) {
            // 차수가 0이면 조상
            if(indeg[i] == 0) {
                first.add(names[i]);
                que.offer(i);
            }
        }

        while(!que.isEmpty()) {
            int cur = que.poll();

            for(int child : graph[cur]) {
                indeg[child]--;

                if(indeg[child] == 0) { // child의 부모가 cur
                    newChild[cur].add(child);
                    que.offer(child);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        names = new String[N];
        for(int i=0; i<N; i++) {
            names[i] = st.nextToken();
        }
        Arrays.sort(names);
        for(int i=0; i< names.length; i++) {
            map.put(names[i], i);
        }
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N];
        indeg = new int[N];
        newChild =new ArrayList[N];
        for(int i=0; i<N; i++) {
            graph[i] = new ArrayList<>();
            newChild[i] = new ArrayList<>();
        }

        // 1. 들어오는 간선 수 계산 : indeg[i] == 0 -> i는 정점
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            String x = st.nextToken(); // child
            String y = st.nextToken(); // parent
            indeg[map.get(x)]++; // child 차수
            graph[map.get(y)].add(map.get(x)); // p -> c
        }

        // 위상정렬
        sort();

        // print
        System.out.println(first.size());
        Collections.sort(first);
        for(String s : first) {
            System.out.print(s+" ");
        }
        System.out.print("\n");
        for(int i=0; i< names.length; i++) {
            System.out.print(names[i]+" "+newChild[i].size()+" ");
            Collections.sort(newChild[i]);
            for (int child : newChild[i]) {
                System.out.print(names[child]+" ");
            }
            System.out.print("\n");
        }

        br.close();
    }
}
