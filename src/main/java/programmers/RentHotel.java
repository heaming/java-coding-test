package programmers;
/*
* @Title: 호텔대실
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/155651
* @Tag : 우선순위 큐
*/

import java.util.*;

public class RentHotel {

    static class Solution {

        public int solution(String[][] book_time) {
            PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparing(o -> o[1]));
            List<int[]> times = new ArrayList<>();

            for(int i=0; i<book_time.length; i++) {
                String[] startToStr = book_time[i][0].split(":");
                String[] endToStr = book_time[i][1].split(":");

                int start = Integer.parseInt(startToStr[0])*60+Integer.parseInt(startToStr[1]);
                int end = Integer.parseInt(endToStr[0])*60+Integer.parseInt(endToStr[1])+10;

                times.add(new int[]{start, end});
            }

            Collections.sort(times, Comparator.comparingInt(o -> o[0]));

            for(int[] time : times) {
                // 시작
                if(que.isEmpty()) {
                    que.offer(time);
                    continue;
                }

                int[] cur = que.peek();
                int end = cur[1];

                if(time[0] >= end) {
                    que.poll();
                }
                que.offer(time);
            }

            return que.size();
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.solution(new String[][]{{"5:00","15:00"},{"10:00","20:00"},{"20:30","23:00"},{"15:30","23:30"}}));
            // 1
//            System.out.println(solution.solution(new String[][]{{"09:10", "10:10"}, {"10:20", "12:20"}}));
            // 3
//            System.out.println(solution.solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}}));
        }
    }
}
