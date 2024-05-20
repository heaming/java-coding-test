package programmers;
/*
* @Title: 무인도
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/154540
* @Tag :
*/

import java.util.*;
import java.util.stream.Collectors;

public class DesertIsland {

    static class Solution {
        static int[] dx = new int[]{0,0,-1,1};
        static int[] dy = new int[]{1,-1,0,0};

        static boolean[][] visited;

        public int[] solution(String[] maps) {
            List<Integer> answer = new ArrayList<>();
            visited = new boolean[maps.length][maps[0].length()];

            for(int i=0; i< maps.length; i++) {
                for(int j=0; j<maps[0].length(); j++) {
                    if(!visited[i][j] && maps[i].charAt(j) != 'X') {
                        Queue<int[]> que = new LinkedList<>();
                        que.offer(new int[]{i, j});
                        visited[i][j] = true;
                        int cnt = 0;
                        cnt += Integer.parseInt(String.valueOf(maps[i].charAt(j)));

                        while(!que.isEmpty()) {
                            int[] cur = que.poll();

                            for(int k=0; k<4; k++) {
                                int ni = cur[0]+dx[k];
                                int nj = cur[1]+dy[k];

                                if(ni>=0 && ni< maps.length && nj>=0 && nj<maps[0].length() && !visited[ni][nj] && maps[ni].charAt(nj) != 'X') {
                                    visited[ni][nj] = true;
                                    cnt+= Integer.parseInt(String.valueOf(maps[ni].charAt(nj)));
                                    que.offer(new int[]{ni, nj});
                                }

                            }

                        }

                        if(cnt != 0) answer.add(cnt);
                    }
                }
            }

            if(answer.isEmpty()) return new int[]{-1};

            Collections.sort(answer);

            return answer.stream().mapToInt(i->i).toArray();
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            // 1 1 27
            System.out.println(Arrays.toString(solution.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"})));
            // -1
//            System.out.println(Arrays.toString(solution.solution(new String[]{"XXX", "XXX", "XXX"})));
        }
    }
}
