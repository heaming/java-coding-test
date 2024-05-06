package programmers;
/*
* @Title: 미로 탈출 명령어
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/150365
*/


public class Kakao2023_EscapeMaze {
    static class Solution {
        public String solution(int n, int m, int x, int y, int r, int c, int k) {
            String answer = "";
            int distance = Math.abs(r-x) + Math.abs(c-y);
            System.out.println(distance);

            // 이동할 수 없음
            if (distance > k) return "impossible";
            if ((k-distance)%2 > 0) return "impossible";

            // 아래 쪽으로 이동해야하는 수
            int down = Math.max(r-x, 0);
            // 왼쪽으로 이동해야하는 수
            int left = Math.max(y-c, 0);
            // 오른쪽으로 이동해야하는 수
            int right = Math.max(c-y, 0);
            // 위로 이동해야하는 수
            int up = Math.max(x-r,0);

            // 이외 상쇄 du lr rl ud
            int pair = Math.abs(distance-k)/2;
            System.out.println(down+" "+left+" "+right+" "+up+ " "+pair);

            for(int i=0; i<k; i++) {
                if((down>0 || pair>0) && x < n) {
                    answer += "d";

                    if(down > 0) {
                        down--;
                    } else {
                        pair--;
                        up++;
                    }

                    x++;
                } else if((left>0 || pair>0) && y>1) {
                    answer += "l";

                    if(left > 0) {
                        left--;
                    } else {
                        pair--;
                        right++;
                    }

                    y--;
                } else if ((right>0 || pair>0) && y<m) {
                    answer += "r";

                    if(right>0) {
                        right--;
                    } else {
                        pair--;
                        left++;
                    }

                    y++;
                } else {
                    answer += "u";
                    if(up>0) {
                        up--;
                    } else {
                        pair--;
                        down++;
                    }
                    x--;
                }

            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // dllrl
        System.out.println(solution.solution(3,4,2,3,3,1,5));
        // dr
//        System.out.println(solution.solution(2,2,1,1,2,2,2));
        // impossible
        System.out.println(solution.solution(3,3,1,2,3,3,4));
    }
}
