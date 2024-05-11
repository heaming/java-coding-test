//package programmers;
///*
//* @Title: 표 병합
//* @Link:  https://school.programmers.co.kr/learn/courses/30/lessons/150366
//* @Tag :
//*/
//
//
//import java.util.*;
//
//public class Kakao2023_MergeTable {
//
//    static class Solution {
//        static String[][] table;
//        static Map<String, List<int[]>> address = new HashMap<>();
//        static List<List<int[][]>> merged = new ArrayList<>();
//
//        public String[] solution(String[] commands) {
//
//            table = new String[51][51];
//
//            for(String command : commands) {
//                String[] arr = command.split(" ");
//                String query = arr[0];
//
//                if("UPDATE".equals(query)) {
//                    String value;
//                    try {
//                        // 1
//                        int r = Integer.parseInt(arr[1]);
//                        int c = Integer.parseInt(arr[2]);
//                        value = arr[3];
//
//                        table[r][c] = value;
//                        List<int[]> list;
//
//                        if(address.get(value) != null) {
//                            list = address.get(value);
//                        } else {
//                            list = new ArrayList<>();
//                        }
//                        list.add(new int[]{r,c});
//                        address.put(value, list);
//                    } catch (NumberFormatException e) {
//                        // 2
//                        int r1 = Integer.parseInt(arr[1]);
//                        int c1 = Integer.parseInt(arr[2]);
//                        int r2 = Integer.parseInt(arr[3]);
//                        int c2 = Integer.parseInt(arr[4]);
//
//                        if(r1 == r2 && c1 == c2) continue;
//                        if(table[r1][c1].isEmpty()) {
//                            value = table[r2][c2];
//                            table[r1][c1] = table[r2][c2];
//                        } else {
//                            value = table[r1][c1];
//                            table[r2][c2] = table[r1][c1];
//                        }
//
//
//                    }
//                }
////
////                if("MERGE")
////
////                if("UNMERGE")
////
////                if("PRINT")
//            }
//
//
//            String[] answer = {};
//            return answer;
//        }
//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            System.out.println(Arrays.toString(solution.solution(new String[]{"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"})));
//        }
//    }
//}
