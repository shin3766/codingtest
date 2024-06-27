package me.yoosup.codingtest.programmers.md0627;

import java.util.StringTokenizer;
import java.util.stream.Stream;

public class 신규아이디추천 {
    // 1. 모든 대문자를 소문자로 치환하는 메서드

    // 2. 소문자, 숫자, -, _, . 제외 전부 삭제하고 이어붙이는 메서드

    // 3. 마침표가 두개 이상이면 1개로 바꾸는 메서드

    // 4. 마침표가 처음이나 끝이면 제거

    // 5. 빈 문자열이면 a 대입

    // 6. 길이가 15이상이면 16부터 전부 자르기 -> 마침표가 마지막이면 삭제

    // 7. 6단계 진행한 후 길이가 2자 이하라면 마지막 문자를 3자가 될때까지 반복하는 메서드

    public static void main(String[] args) {
        String id = "...!@BaT#*..y.abcdefghijklm";
        String answer = "";

        // 1단계
        answer = id.toLowerCase();

        // 2단계
        answer = answer.replaceAll("[^-_.a-z0-9]", "");

        // 3단계
        answer = answer.replaceAll("[.]{2,}", ".");

        // 4단계
        answer = answer.replaceAll("^[.]|[.]$", "");

        // 5단계
        if(answer.equals("")) {
            answer += "a";
        }

        // 6단계
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer.replaceAll("[.]$", "");
        }

        // 7단계
        if (answer.length() <= 2) {
            while(answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
            }
        }

        System.out.println("answer = " + answer);
    }
}
