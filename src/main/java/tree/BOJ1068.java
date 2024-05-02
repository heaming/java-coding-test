package tree;

/*
 * @Title: 트리
 * @Link: https://www.acmicpc.net/problem/1068
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1068 {
    static int N;
    static List<Integer>[] graph;
    static int erase;
    static int root;
    static int[] leaf;

    public static void dfs(int cur) {

        if(graph[cur].isEmpty()) {
            leaf[cur] = 1;
        }

        for(int child : graph[cur]) {
            dfs(child);
            leaf[cur] += leaf[child];
        }

    }

    public static void erased() {
        for(int i=0; i<N; i++) {
            if(graph[i].contains(erase)) {
                graph[i].remove(graph[i].indexOf(erase));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N];
        leaf = new int[N];

        for (int i=0; i<N; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent==-1) {
                root = i;
                continue;
            }
            graph[parent].add(i);
        }

        st = new StringTokenizer(br.readLine());
        erase = Integer.parseInt(st.nextToken());

        erased();

        if(root != erase) dfs(root);

        System.out.println(leaf[root]);

        br.close();
    }
}
