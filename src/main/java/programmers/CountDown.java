package programmers;
/*
* @Title: 카운트다운
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/131129
* @Tag :
*/

import java.util.Arrays;

public class CountDown {

    static class Solution {

        // left < cur -> 실격
        // single || bull 더 큰사람 // 선공
        // 최소한의 다트로 0점
        // dp[i] = [숫자 i까지 이동하는데 필요한 다트 수, 그 때의 싱글+불 수

        static int MOD = Integer.MAX_VALUE;
        public int[] solution(int target) {
            int[][] dp = new int[target+1][2];

            dp = new int[target+1][2];
            for(int i=1; i<=target; i++){
                dp[i][0] = Integer.MAX_VALUE;
                dp[i][1] = 0;
            }

            for(int i=1; i<=target; i++){
                for(int cur=1; cur<=20; cur++){
                    // bull
                    if(i>=50){
                        if(dp[i][0] > dp[i-50][0]+1){ //더 적게 던지는 경우로 갱신
                            dp[i][0] = dp[i-50][0]+1;
                            dp[i][1] = dp[i-50][1]+1;
                        } else if(dp[i][0] == dp[i-50][0]+1){ //같은 다트 수라면, 불/싱글을 더 많이 쏘는 경우로 갱신
                            dp[i][1] = Math.max(dp[i][1], dp[i-50][1]+1);
                        }
                    }

                    //싱글을 쏘는 경우
                    if(i>=cur){
                        if(dp[i][0] > dp[i-cur][0]+1){
                            dp[i][0] = dp[i-cur][0]+1;
                            dp[i][1] = dp[i-cur][1]+1;
                        } else if(dp[i][0] == dp[i-cur][0]+1){
                            dp[i][1] = Math.max(dp[i][1], dp[i-cur][1]+1);
                        }
                    }

                    //더블을 쏘는 경우
                    if(i>=2*cur){
                        if(dp[i][0] > dp[i-2*cur][0]+1){
                            dp[i][0] = dp[i-2*cur][0]+1;
                            dp[i][1] = dp[i-2*cur][1];
                        }

                    }

                    //트리플을 쏘는 경우
                    if(i-3*cur>=0){
                        if(dp[i][0] > dp[i-3*cur][0]+1){
                            dp[i][0] = dp[i-3*cur][0]+1;
                            dp[i][1] = dp[i-3*cur][1];
                        }
                    }


                }
            }

            return dp[target];
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(Arrays.toString(solution.solution(21))); // 1,0
            System.out.println(Arrays.toString(solution.solution(58))); // 2,2
        }
    }
}
