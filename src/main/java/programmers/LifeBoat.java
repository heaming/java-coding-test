package programmers;

public class LifeBoat {
    static class Solution {

        int solution(int[] people, int limit) {

        }


    }

    public static void main(String[] args) {
        Solution solution = new Solution();;


        System.out.println(solution.solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(solution.solution(new int[]{70, 80, 50}, 100));
    }
}
/*
무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 합니다. 구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.

예를 들어, 사람들의 몸무게가 [70kg, 50kg, 80kg, 50kg]이고 구명보트의 무게 제한이 100kg이라면 2번째 사람과 4번째 사람은 같이 탈 수 있지만 1번째 사람과 3번째 사람의 무게의 합은 150kg이므로 구명보트의 무게 제한을 초과하여 같이 탈 수 없습니다.

구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.

사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때, 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요.

제한사항
무인도에 갇힌 사람은 1명 이상 50,000명 이하입니다.
각 사람의 몸무게는 40kg 이상 240kg 이하입니다.
구명보트의 무게 제한은 40kg 이상 240kg 이하입니다.
구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없습니다.
입출력 예
people	limit	return
[70, 50, 80, 50]	100	3
[70, 80, 50]	100	3
※ 2023년 07월 31일 테스트 케이스가 추가되었습니다. 기존에 제출한 코드가 통과하지 못할 수 있습니다.

Solution.java
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;

        while(left <= right) {
            if(people[left] + people[right] <= limit) {
                left++;
            }
              //  left++;
                right--;

            answer++;
        }

        return answer;


        }
}
1
import java.util.*;
2
​
3
class Solution {
4
    public int solution(int[] people, int limit) {
5
        int answer = 0;
6
​
7
        Arrays.sort(people);
8
        int left = 0;
9
        int right = people.length-1;
10
​
11
        while(left <= right) {
12
            if(people[left] + people[right] <= limit) {
13
                left++;
14
            }
15
              //  left++;
16
                right--;
17

18
            answer++;
19
        }
20
​
21
        return answer;
22
​
23
​
24
        }
25
}
실행 결과
실행 결과가 여기에 표시됩니다.
 */