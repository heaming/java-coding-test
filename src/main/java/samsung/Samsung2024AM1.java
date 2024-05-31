//package samsung;
//
///*
// * @Title: 고대 문명 유적 탐사
// * @Link: https://www.codetree.ai/training-field/frequent-problems/problems/ancient-ruin-exploration/description?page=1&pageSize=20
// * @Tag :
// */
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Samsung2024AM1 {
//
//    static int K;
//    static int M;
//    static int[][] map;
//    static int[] pieces;
//    static int[] dy = new int[]{0,0,1,-1};
//    static int[] dx = new int[]{1,-1,0,0};
//
//    static class Node {
//        int y;
//        int x;
//
//        public Node(int y, int x) {
//            this.y = y;
//            this.x = x;
//        }
//    }
//
//    static int[][] rotation(int[][] arr, int y, int x) {
//        int[][] temp = new int[6][6];
//        for(int i=1; i<=5; i++) {
//            for(int j=1; j<=5; j++) {
//                temp[i][j] = arr[i][j];
//            }
//        }
//
//        for(int i=0; i<3; i++) {
//            for(int j=0; j<3; j++) {
//                temp[y+j][x+3-i-1] = arr[y+i][x+j];
//            }
//        }
//
//        return temp;
//    }
//
//    static int find(int[][] arr) {
//        int cnt = 0;
//        boolean[][] visited = new boolean[6][6];
//
//        for(int i=1; i<=5; i++) {
//            for(int j=1; j<=5; j++) {
//
//
//
//            }
//        }
//        Queue<Node> que = new LinkedList<>();
//        que.offer(new Node(1,1));
//
//
//
//
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        K = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        map = new int[6][6];
//        pieces = new int[M];
//
//        for(int i=1; i<=5; i++) {
//            st = new StringTokenizer(br.readLine());
//            for(int j=1; j<=5; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        st = new StringTokenizer(br.readLine());
//        for(int i=0; i<M; i++) {
//            pieces[i] = Integer.parseInt(st.nextToken());
//        }
//
//
//        map = rotation(map, 2,2);
//        for(int[] a : map) {
//            System.out.println(Arrays.toString(a));
//        }
//
//
//        br.close();
//    }
//}
