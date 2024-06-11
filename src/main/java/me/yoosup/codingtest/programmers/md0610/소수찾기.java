package me.yoosup.codingtest.programmers.md0610;

import java.util.HashSet;
import java.util.Set;

/**
 * 소수찾기 :: https://school.programmers.co.kr/learn/courses/30/lessons/12921
 *
 * 풀이과정
 * 1. DFS알고리즘을 선택
 * 2. visited[] 설정후
 */
public class 소수찾기 {
    public static void main(String[] args) {
        int answer = 1;
        int n = 10000;

        for (int i = 3; i <= n; i++) {
            if (isPrime(i)) {
                answer += 1;
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2 ; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
