package baekjoon;

/*
* @Title: 세 친구
* @Link: https://www.acmicpc.net/problem/17089
* N명의 사람이 있고, 여기서 세 사람 A, B, C를 고르려고 한다. 세 사람은 모두 친구여야 한다.

세 사람을 고르는 방법은 매우 많이 있을 수 있다. 이때, A의 친구 수 + B의 친구 수 + C의 친구 수가 최소가 되어야 한다. 친구 수의 합을 계산할 때, 세 사람은 빼고 계산해야 한다. 즉, A의 친구 수를 계산할 때, B와 C는 빼고 계산해야 하고, B의 친구 수를 계산할 때는 A와 C, C의 친구 수를 계산할 때는 A와 B를 빼고 계산해야 한다.

입력
첫째 줄에 사람의 수 N(3 ≤ N ≤ 4,000), 친구 관계의 수 M(0 ≤ M ≤ 4,000)이 주어진다. 둘째 줄부터 M개의 줄에는 친구 관계를 의미하는 두 정수 A, B가 주어진다. 친구 관계는 A와 B, 그리고 B와 A가 친구라는 것을 의미한다.

사람은 1번부터 N번까지 번호가 매겨져 있다. 같은 친구 관계가 두 번 이상 주어지는 경우는 없다.

출력
첫째 줄에 A의 친구 수 + B의 친구 수 + C의 친구 수의 최솟값을 출력한다. 만약, 문제 조건대로 세 사람을 고를 수 없는 경우에는 -1을 출력한다.
* */


import java.util.*;

/*
1 {2,3} 0
2 {1,3,4} 1
3 {1,2,4} 1
4 {2,3,5}
5 {4}

1 {2,7}
2 {1,6}
3 {6}
4
5
6 {2,3}
7 {1}
 */
public class BOJ17089 {

    static int solution(int people, int rels, int[][] relations) {
        int answer = Integer.MAX_VALUE;

        // 관계도 만들기
        int[][] check = new int[people+1][people+1];

        for (int i = 0; i < relations.length; i++) {
            int[] rel = relations[i];
            check[rel[0]][rel[1]] = 1;
            check[rel[0]][0] += 1;
            check[rel[1]][rel[0]] = 1;
            check[rel[1]][0] += 1;
        }

        for(int[] ar : check) System.out.println(Arrays.toString(ar));

        List<List<Integer>> combi = new ArrayList<>();

        for(int i=0; i<(1 << people); i++) {
            List<Integer> sub  = new ArrayList<>();
            if(Integer.bitCount(i) == 2) { // 2명 조합
                for(int j=0; j<people; j++) {
                    if((i & (1<<j)) > 0) {
                        sub.add(j+1);
                    }
                }
                combi.add(sub);
                int first = sub.get(0);
                int second = sub.get(1);

                if(check[first][second] == 1) { // 만약 둘이 칭구라면
                    System.out.println("a :: " +first);
                    System.out.println("b :: " +second);


                    for(int idx=1; idx < check[first].length; idx++) {
                        if(check[first][idx] == 1 && check[second][idx] == 1) {
                            System.out.println("c :: "+idx);
                            System.out.println("++++++++++++++++++++++++");
                            answer = answer < check[first][0] + check[second][0] + check[idx][0] - 2*3 ? answer : check[first][0] + check[second][0] + check[idx][0] - 2*3;
                        }
                    }
                }
            }
        }

        return answer < Integer.MAX_VALUE ? answer : -1;
    }


    public static void main(String[] args) {
        BOJ17089 threeFriends = new BOJ17089(); // 2

        System.out.println(threeFriends.solution(5, 6, new int[][]{{1,2}, {1,3}, {2,3}, {2,4}, {3,4},{4,5}})); // 2
        System.out.println(threeFriends.solution(7,4, new int[][]{{2,1},{3,6},{6,2},{1,7}})); // -1
    }
}
