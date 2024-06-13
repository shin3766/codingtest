package me.yoosup.codingtest.programmers.md0611;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 다트게임_1차 {
    /*
    1. 숫자다음에는 문자가온다
    2. 문자다음에는 숫자가 오거나 특수문자가 온다.
    3. 숫자를 기준으로 스위치문을 만든다.

    1. 문자열을 숫자와 숫자 사이만 잘라주는 함수
    2. 잘린 문자열로 숫자를 뽑아내는함수
    3. 뽑힌 숫자로 S, D, T를 구별해서 점수를 내는 함수
    */

    public static void main(String[] args) {
        String[] arr = new String[3];
        String str = "1S2D*3T";

        String[] array = cutString(str, arr);

        System.out.println(Arrays.toString(array));
    }

    // 문자열을 조건에 맞게 잘라주는 함수
    public static String[] cutString(String str, String[] arr) {

        int split = 0;
        int idx = 0;

        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);

            // 스코어가 10인경우
            if (letter != 'S' && letter != 'D' && letter != 'T' &&
                    letter != '*' && letter != '#') {
                continue;
            }
            // 숫자외 다른 문자일경우
            else if (i < str.length() - 1) {
                if (letter == '1' && str.charAt(i + 1) == '0') {
                    continue;
                }
            } else {
                arr[idx] = str.substring(split, i);
                split = i;
                idx++;
            }
        }
        return arr;
    }

    // 점수를 계산하는 함수

}
