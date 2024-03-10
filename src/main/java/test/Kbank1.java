package test;

import java.util.Arrays;

class Kbank1 {


    public int[] solution(String[] card) {
        int[] answer = new int[13];
        int[] amountMm = new int[13];

        for(int i=0; i<card.length; i++) {
            String[] content = card[i].split(" ");
            String[] date = content[0].split("/");
            int mm = Integer.parseInt(date[0]);
            int dd = Integer.parseInt(date[1]);
            int amount = Integer.parseInt(content[1]); // 금액
            int im = Integer.parseInt(content[2]); // 할부
            if(im == 1 || mm == 12) answer[0] += (int) Math.ceil((double) amount * 0.01);
            if(mm < 12) {


                for (int j = 0; j < im; j++) {
                    if (mm < 12) {
                        if (mm + j <= 12) {
                            answer[mm + j] += (int) Math.ceil((double) amount / im);
                        } else {
                            answer[12] += (int) Math.ceil((double) amount / im);
                        }
                    }
                }
            } else {
                answer[12] += amount;
            }
        }
        System.out.println(Arrays.toString(answer));



        return answer;
    }

    public static void main(String[] args) {
        Kbank1 solution = new Kbank1();

        System.out.println(solution.solution(new String[]{"02/05 15000 2", "03/11 5541 1", "03/31 10000 3", "03/31 100 1", "05/15 10000 2", "10/10 12345 1", "11/22 5999 4", "12/01 901 10"})); // 2150
        System.out.println(solution.solution(new String[]{"02/01 12001 12", "12/30 101 2"})); // 1500
    }
}
