package me.yoosup.codingtest.programmers.md0530;

import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 가장가까운같은글자 {
    static String s1 = "banana";
    static String s2 = "foobar";

    /*
    1. 문자열의 문자 하나씩 map의 key로, index를 value로 넣는다.
    2. 문자열을 돌면서 새로운 문자면 map에 추가
    3. 중복된 문자면 index를 비교해서 값에 추가
    */

    /*
    이중 for문을 써서 구현해보자
     */
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        char[] carr = s1.toCharArray();
        StringTokenizer st = new StringTokenizer(s1);

        while(st.hasMoreTokens()) {
            String check = st.nextToken();
            map.putIfAbsent(check, s1.indexOf(check));
        }
    }
}
