package programmers;


import java.util.*;

/*
 * @Title: 도넛과 막대그래프
 * @Link: https://school.programmers.co.kr/learn/courses/30/lessons/258711?language=java
 * return 정점, 도넛모양, 막대, 8자
 * 1. 들어오는 간선이 존재하지 않고, 나가는 간선이 2개 이상인 정점을 찾습니다. 이러한 정점은 하나만 존재하며, 해당 정점이 생성된 정점입니다.
   2. 생성된 정점과 연결된 간선의 개수를 셉니다. 해당 간선들의 개수는 모양 그래프의 총개수와 동일합니다.
   3. 생성된 정점과 연결된 간선을 모두 삭제합니다.
   4. 들어오는 간선이 없는 정점의 개수 혹은 나가는 간선이 없는 정점의 개수를 셉니다. 해당 정점들은 각 막대 모양 그래프마다 하나씩만 존재하기 때문에 해당 정점들의 개수는 막대 모양 그래프의 개수와 동일합니다.
   5. 들어오는 간선이 2개이면서 나가는 간선이 2개인 정점의 개수를 셉니다. 해당 정점들은 각 8자 모양 그래프마다 하나씩만 존재하기 때문에, 해당 정점들의 개수는 8자 모양 그래프의 개수와 동일합니다.
   6. 모양 그래프의 총 개수에서 4번과 5번에서 센 정점들의 개수를 뺍니다. 구한 값은 도넛 모양 그래프의 개수와 동일합니다.
 */
class DonutAndStickGraph {

    static int count;
    static Map<Integer, Node> baseMap;

    static class Node {
        int no;
        Set<Node> in;
        Set<Node> out;

        public Node(){}

        public Node(int no) {
            this.no = no;
            this.in = new HashSet<>();
            this.out = new HashSet<>();
        }

        public Node(int no, Set<Node> in, Set<Node> out) {
            this.no = no;
            this.in = in;
            this.out = out;
        }

        @Override
        public String toString() {
            return "[Node"+ no + "] in::"+in.size()+"  out::"+out.size();
        }
    }

    static Node findRoot(int[][] edges, Map<Integer, Node> map) {
        Node root = new Node();

        // 정점 찾기 :: in 0개 out 2개 이상
        Iterator<Integer> keys = map.keySet().iterator();

        while(keys.hasNext()) {
            int key = keys.next();
            Node node = map.get(key);

            if(node.in.isEmpty() && node.out.size() >= 2) {
                root = node;
                break;
            }
        }

        return root;
    }

    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        Node top;
        int donut = 0;
        int stick = 0;
        int eight = 0;
        baseMap = new HashMap<>();

        // Node setting
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];

            Node startNode = baseMap.getOrDefault(start, new Node(start));
            Node endNode = baseMap.getOrDefault(end, new Node(end));
            endNode.in.add(startNode);
            startNode.out.add(endNode);
            baseMap.put(end, endNode);
            baseMap.put(start, startNode);
        }

        // 정점 찾기 :: in 0개 out 2개 이상
        top = findRoot(edges, baseMap);
        count = top.out.size(); // 간선 수

        Iterator<Integer> keys = baseMap.keySet().iterator();

        while(keys.hasNext()) {
            int key = keys.next();

            if (key == top.no) continue;

            // 정점과 연결 끊기
            Node node = baseMap.get(key);
            node.in.removeIf(i -> i.no == top.no);
            System.out.println("in :: " +node.in);
            node.out.removeIf(i -> i.no == top.no);



            System.out.println("node" + node);

            // stick graph
            if(node.in.isEmpty() || node.out.isEmpty()) stick++;
            if(node.in.size() == 2 && node.out.size() == 2) eight++;
        }

        answer[0] = top.no;
        answer[2] = stick;
        answer[3] = eight;
        answer[1] = count-stick-eight;

        return answer;
    }

    public static void main(String[] args) {
        DonutAndStickGraph solution = new DonutAndStickGraph();

        System.out.println(solution.solution(new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}})); // 	[2, 1, 1, 0]
        System.out.println(solution.solution(new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}})); // [4, 0, 1, 2]

    }
}

