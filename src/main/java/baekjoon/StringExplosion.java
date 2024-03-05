package baekjoon;

/*
 * @Title: 문자열폭발
 * @Link: https://www.acmicpc.net/problem/9935
상근이는 문자열에 폭발 문자열을 심어 놓았다. 폭발 문자열이 폭발하면 그 문자는 문자열에서 사라지며, 남은 문자열은 합쳐지게 된다.

폭발은 다음과 같은 과정으로 진행된다.

문자열이 폭발 문자열을 포함하고 있는 경우에, 모든 폭발 문자열이 폭발하게 된다. 남은 문자열을 순서대로 이어 붙여 새로운 문자열을 만든다.
새로 생긴 문자열에 폭발 문자열이 포함되어 있을 수도 있다.
폭발은 폭발 문자열이 문자열에 없을 때까지 계속된다.
상근이는 모든 폭발이 끝난 후에 어떤 문자열이 남는지 구해보려고 한다. 남아있는 문자가 없는 경우가 있다. 이때는 "FRULA"를 출력한다.

폭발 문자열은 같은 문자를 두 개 이상 포함하지 않는다.

입력
첫째 줄에 문자열이 주어진다. 문자열의 길이는 1보다 크거나 같고, 1,000,000보다 작거나 같다.

둘째 줄에 폭발 문자열이 주어진다. 길이는 1보다 크거나 같고, 36보다 작거나 같다.

두 문자열은 모두 알파벳 소문자와 대문자, 숫자 0, 1, ..., 9로만 이루어져 있다.

출력
첫째 줄에 모든 폭발이 끝난 후 남은 문자열을 출력한다.
*
* mirkovC4nizCC44 C4 // mirkovniz
* 12ab112ab2ab 12ab // FRULA
 */
public class StringExplosion {

    static String boyermoore(String text, String pattern, int idx) {

        if(text.indexOf(pattern) < 0) return text;
        int textLen = text.length();

        int patternLen = pattern.length();
        int[] skipTable = new int[Character.MAX_VALUE + 1]; // 건너뛰기 표

        int pt = 0;  // text pointer
        int pp = 0; // pattern pointer

//        abcccdab
//        ccd
//        [STEP1] skipTable [3,3,3,3,3,3,3,3,3,3,3...]
//        [STEP2] [3,3,3,2,3..] -> [3,3,1,2,3..] -> [3,3,0,2,3]
//
//
        // STEP1 :: skipTable 초기화
        for(pt = 0; pt <= Character.MAX_VALUE; pt++) {
            skipTable[pt] = patternLen;
        }

        // STEP2
        for(pt = 0; pt < patternLen -1; pt++) {
            skipTable[pattern.charAt(pt)] = patternLen-pt-1;
        }

//        int idx = -1;

        Loop1:
        while(pt < textLen) {
            pp = patternLen - 1;

            Loop2:
            while(text.charAt(pt) == pattern.charAt(pp)) {
                if(pp == 0) {
                    idx = pt;
                    break Loop1;
                }
                pp--;
                pt--;
            }
            pt += (skipTable[text.charAt(pt)] > patternLen - pp) ? skipTable[text.charAt(pp)] : patternLen - pp;
        }

        if(idx > -1) {
            System.out.println(idx);
            System.out.println(text);
        } else {
            return " idx == -1";
        }


        if(idx < textLen && idx > -1) {
            String next = text.substring(0, idx) + text.substring(idx + patternLen);
            System.out.println("TEXT : "+ next);
            if(next.length() < 1) {
                return "FRULA";
            } else if(idx > -1) {
                boyermoore(next, pattern, idx);
                return next;
            }
                    }

        if(text.length() < 1) {
            return "FRULA";
        } else if(idx > -1) {
            boyermoore(text, pattern, idx);
            return text;
        }

        System.out.println(text + " ::::: ?!?!?");
        return text;
    }

//    static int boyermoore(String text, String pattern) {
//        int textLen = text.length();
//
//        int patternLen = pattern.length();
//        int[] skipTable = new int[Character.MAX_VALUE + 1]; // 건너뛰기 표
//
//        int pt = 0;  // text pointer
//        int pp = 0; // pattern pointer
//
////        abcccdab
////        ccd
////        [STEP1] skipTable [3,3,3,3,3,3,3,3,3,3,3...]
////        [STEP2] [3,3,3,2,3..] -> [3,3,1,2,3..] -> [3,3,0,2,3]
////
////
//        // STEP1 :: skipTable 초기화
//        for(pt = 0; pt <= Character.MAX_VALUE; pt++) {
//            skipTable[pt] = patternLen;
//        }
//
//        // STEP2
//        for(pt = 0; pt < patternLen -1; pt++) {
//            skipTable[pattern.charAt(pt)] = patternLen-pt-1;
//        }
//        while(pt < textLen) {
//            pp = patternLen - 1;
//
//            while(text.charAt(pt) == pattern.charAt(pp)) {
//                if(pp == 0) {
//                    return pt;
//                }
//                pp--;
//                pt--;
//            }
//            pt += (skipTable[text.charAt(pt)] > patternLen - pp) ? skipTable[text.charAt(pp)] : patternLen - pp;
//        }
//
//        return -1;
//    }

    static String solution(String[] arr) {
        String base = arr[0];
        String bomb = arr[1];
//        = boyermoore(base, bomb);
////        int idx =  boyermoore(base, bomb);
//
//
//        while(base.length() > 0) {
//
//            idx = boyermoore(base, bomb);
//
//            if(idx < 0) return text;
//            text = text.substring(0, idx) + text.su;;;;Lbstring(idx+bomb.length());
//
//            if(text.length() < 1) {
//                return "FRULA";
//            }
//
//        }
//        System.out.println("얍" + boyermoore("mirkovnizC4", "C4"));
        return "[return]" + boyermoore(base, bomb, -1);

//        return boyermoore(base, bomb);
    }

    public static void main(String[] args) {
        StringExplosion stringExplosion = new StringExplosion();

        System.out.println("answer :: " +stringExplosion.solution(new String[]{"mirkovC4nizCC44", "C4"})); // mirkovniz
        System.out.println("answer :: " +stringExplosion.solution(new String[]{"mirkovnizC4", "C4"})); // mirkovniz
        System.out.println("answer :: " +stringExplosion.solution(new String[]{"12ab112ab2ab", "12ab"}));// FRULA
        System.out.println("answer :: " +stringExplosion.solution(new String[]{"12ab", "12cd"}));// FRULA
    }
}
