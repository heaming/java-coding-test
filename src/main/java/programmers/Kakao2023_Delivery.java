package programmers;
/*
* @Title: 택배 배달과 수거하기
* @Link:  https://school.programmers.co.kr/learn/courses/30/lessons/150369
* @Tag : 투포인터
*/

public class Kakao2023_Delivery {
    // 0 - 물류창고
    // 트럭 최대 용량 :: cap개
    // del : 배달할
    // pick : 수거할
    // 최소 이동거리
    // 모든 배달과 수거를 마치고 물류창고까지 돌아올 수 있는 최소 이동 거리는?
    // -> 조건 : 모든 d, p == 0 && 타겟 : 이동 거리

    static class Solution {

        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            long answer = 0;

            int d = 0;
            int p = 0;

            for(int i=n-1; i>=0; i--) {
                d += deliveries[i];
                p += pickups[i];

                while(d>0 || p>0) {
                    d -= cap;
                    p -= cap;
                    answer += (i+1) *2;
                }

            }
            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(42));
        Solution solution = new Solution();
        System.out.println(solution.solution(4, 5, new int[]{1,0,3,1,2}, new int[]{0,3,0,4,0})); // 16
        System.out.println(solution.solution(2, 7, new int[]{1,0,2,0,1,0,2}, new int[]{0,2,0,1,0,2,0})); //30
    }
}
