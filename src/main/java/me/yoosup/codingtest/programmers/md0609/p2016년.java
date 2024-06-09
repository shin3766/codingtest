package me.yoosup.codingtest.programmers.md0609;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 2016년 :: https://school.programmers.co.kr/learn/courses/30/lessons/12901
 * 1. date와 month를 올바르게 정의한다.
 *   - 고려사항
 *   1. 1월1일은 금요일이므로 date배열의 시작은 금요일
 *   2. month에서 해당 달 이전의 날 모두 더하기. 예) 5월일 경우 5월의 날들을 더하지 않는다. 4월까지의 날짜만 더함
 *   3. b일을 일 계산에 더한다.
 *   4. date 배열은 0부터 세므로 a * month + b = c일 때 c에서 1을 빼고 7로 나눈 나머지를 date배열의 index로 넣는다.
 *   5. 성공!
 */
public class p2016년 {
    public String solution(int a, int b) {
        String answer = "";
        String[] date = {"FRI","SAT","SUN","MON","TUE","WED","THU"};

        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 0;

        for(int i = 0; i < a-1; i++) {
            days += month[i];
        }

        days = (days + b - 1) % 7;

        return date[days];
    }
}
