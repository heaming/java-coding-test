package programmers;
/*
* @Title: 불량 사용자
* @Link: https://school.programmers.co.kr/learn/courses/30/lessons/64064
* @Tag: dfs
*/

import java.util.*;
import java.util.stream.Collectors;

public class Kakao2019_BadUser {
    static class Solution {
        static List<Integer>[] candidate;
        static Set<Set<Integer>> group = new HashSet<>();

        static boolean[] visited;
        static int len;
        static void check(String[] user_id, String[] banned_id) {

            for(int i=0; i<banned_id.length; i++) {
                String ban = banned_id[i];

                for(int j=0; j<len; j++) {
                    String user = user_id[j];

                    if(ban.length() != user.length()) continue;

                    boolean match = true;

                    for(int k=0; k<user.length(); k++) {
                        if(ban.charAt(k) != '*' && user.charAt(k) != ban.charAt(k)) {
                            match = false;
                            break;
                        }
                    }

                    if(match) candidate[i].add(j);
                }
            }
        }

        static void dfs(int idx, List<List<Integer>> list, Set<Integer> set) {
            if(idx >= list.size()) {
                Set<Integer> clone = new HashSet<>(set);
                group.add(clone);
                return;
            }

            for(int i=0; i<list.get(idx).size(); i++) {
                int candiUser = list.get(idx).get(i);
                if(!visited[candiUser]) {
                    visited[candiUser] = true;
                    set.add(candiUser);
                    dfs(idx+1, list, set);
                    visited[candiUser] = false;
                    set.remove(candiUser);
                }
            }
        }
        public int solution(String[] user_id, String[] banned_id) {
            len = user_id.length;
            candidate = new ArrayList[len];
            visited = new boolean[len];
            for(int i=0; i<len; i++) {
                candidate[i] = new ArrayList<>();
            }

            check(user_id, banned_id);
            List<List<Integer>> list = Arrays.stream(candidate).filter(o -> !o.isEmpty()).collect(Collectors.toList());
            list.sort(Comparator.comparingInt(List::size));
            System.out.println(list);

            dfs(0,  list, new HashSet<Integer>());
            return group.size();
        }
        public static void main(String[] args) {
            Solution solution = new Solution();

            // 2
//            System.out.println(solution.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));
            // 2
//            System.out.println(solution.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}));
            // 3
//            System.out.println(solution.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));

        }
    }
}
