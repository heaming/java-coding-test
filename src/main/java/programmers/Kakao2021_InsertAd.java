package programmers;
/*
 * @Title: 광고 삽입
 * @Link: https://school.programmers.co.kr/learn/courses/30/lessons/72414#
 * @Tag: 배열, 누적합
 */
public class Kakao2021_InsertAd {
    static class Solution {

        public static int timeToInt(String str) {
            String[] arr = str.split(":");
            int hh = Integer.parseInt(arr[0]);
            int mm = Integer.parseInt(arr[1]);
            int ss = Integer.parseInt(arr[2]);
            return hh*3600 + mm*60 + ss;
        }

        public static String timeToString(long l) {
            String str = "";
            long hh = l/3600;
            long mm = (l-(3600*hh))/60;
            long ss = (l-3600*hh-60*mm);

            str += hh < 10 ? "0"+hh+":" : hh+":";
            str += mm < 10 ? "0"+mm+":" : mm+":";
            str += ss < 10 ? "0"+ss : ss;

            return str;
        }

        public String solution(String play_time, String adv_time, String[] logs) {

            int[] times = new int[360001];

            for(String log : logs) {
                String[] arr = log.split("-");
                int start = timeToInt(arr[0]);
                int end = timeToInt(arr[1]);

                // 보는 중
                times[start]++;
                // 안 봄
                times[end]--;
            }

            int playTime = timeToInt(play_time);
            int advTime = timeToInt(adv_time);

            for(int i=1; i<times.length; i++) {
                times[i] += times[i-1];
            }

            long max = 0;
            long standard = 0;
            int idx = 0;
            for(int i=advTime; i<=playTime; i++) {
                standard += times[i]-times[i-advTime];

                if(standard > max) {
                    idx = i-advTime+1;
                    max = standard;
                }
            }

            return timeToString(idx);
        }

    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        //01:30:59
        System.out.println(solution.solution("02:03:55","00:14:15",new String[]{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"}));

        //01:00:00
//        System.out.println(solution.solution("99:59:59", "25:00:00", new String[]{"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"}));

//        50:00:00
//        System.out.println(solution.solution("50:00:00", "50:00:00", new String[]{"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"}));
    }
}
