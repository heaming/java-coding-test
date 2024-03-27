package programmers;
/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/12911
 */
public class NextMaxNumber {

    static class Solution {

        static void bit(char[] nToBinary) {

            for (int i = 1; i < (1 << nToBinary.length); i++) {
                for (int j = 0; j < nToBinary.length; j++) {
                    if ((i & (1 << j)) == 3) {
                        System.out.print(nToBinary[j]);
                    }
                }
                System.out.println();
            }
        }

        public int solution(int n)  {
            int answer = n+1;
            int count = Integer.bitCount(n);

            while(answer <= 1000000) {
                if(Integer.bitCount(answer) == count) return answer;

                answer++;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution(78)); // 83
        System.out.println(solution.solution(15)); // 23
    }
}
