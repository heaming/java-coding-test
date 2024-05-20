package programmers;
/*
* @Title: 상담원 인원
* @Link:  https://school.programmers.co.kr/learn/courses/30/lessons/214288
* @Tag : 우선순위 큐
*/

import java.util.*;

public class CountConsultunt {

    static class Solution {
        // 유형 k
        // 멘토 수 n
        // [start, during, c유형]
        // x시간일 때 reqs.length만큼 상담을 끝낼 수 있나?

        static int[][] reqs;

        static List<Info>[] kinds;
        static int answer = 0;

        static class Info {
            int start;
            int end;

            public Info(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

        public int solution(int k, int n, int[][] reqs) {
            Solution.reqs = reqs;

            kinds = new ArrayList[k+1];
            for(int i=1; i<=k; i++) {
                kinds[i] = new ArrayList<>();
            }

            // 1. kinds : 유형별 대기하는 사람
            for(int i=0; i<reqs.length; i++) {
                int start = reqs[i][0];
                int during = reqs[i][1];
                int kind = reqs[i][2];
                kinds[kind].add(new Info(start, start+during));
            }

            // 2. 유형별 상담사 수에 따른 대기시간 계산
            int[][] wating = new int[k+1][n+1];
            for(int kind=1; kind<=k; kind++) {
                if(kinds[kind].isEmpty()) continue;

                for(int mento=1; mento<=(n-k)+1; mento++) {
                    // 상담시간 계산
                    int watingTime = 0;

                    // 끝나는 시간 저장
                    PriorityQueue<Integer> que = new PriorityQueue<>();
                    for(Info info : kinds[kind]) {
                        // 빈 상담원이 있을 경우
                        if(que.isEmpty() || que.size() < mento) {
                            que.offer(info.end);
                        } else {
                            // 가장 빨리 끝난 시간
                            int earlyEndTime = que.poll();

                            if(info.start < earlyEndTime) { // 대기 있음
                                watingTime += earlyEndTime - info.start;
                                que.offer(earlyEndTime+(info.end-info.start));
                            } else { // 대기 없음
                                que.offer(info.end);
                            }
                        }
                    }

                    wating[kind][mento] = watingTime;
                }
            }

            System.out.println(Arrays.deepToString(wating));

            // 3. 상담원 배치
            int[] mentos = new int[k+1];
            int leftMento = n-k;
            // 각 유형별로 1명 이상 있어야 한다.
            for(int i=1; i<=k; i++) {
                mentos[i] = 1;
            }

            // 4. 대기 시간이 가장 많이 줄어드는 유형에 상담사 추가 배치
            while(leftMento-- > 0) {
                int maxReduce = 0;
                int maxReduceType = 0;

                for(int type=1; type<=k; type++) {
                    int curMentoCnt = mentos[type];
                    int curWatingTime = wating[type][curMentoCnt];
                    int nextWatingTime = wating[type][curMentoCnt+1];
                    int reduce = curWatingTime-nextWatingTime;

                    if(reduce >= maxReduce) {
                        maxReduceType = type;
                        maxReduce = reduce;
                    }
                }

                mentos[maxReduceType]++;
            }

            System.out.println(Arrays.toString(mentos));


            for(int kind=1; kind<=k; kind++) {
                answer += wating[kind][mentos[kind]];
            }

            return answer;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.solution(3,5,new int[][]{{10, 60, 1}, {15, 100, 3}, {20, 30, 1}, {30, 50, 3}, {50, 40, 1}, {60, 30, 2}, {65, 30, 1}, {70, 100, 2}}));
        }
    }
}
