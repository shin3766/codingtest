package me.yoosup.codingtest.programmers.md0609;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 카드뭉치 :: https://school.programmers.co.kr/learn/courses/30/lessons/159994
 * <p>
 * 풀이과정
 * 0. 모든 배열을 Queue로 만든다.
 * 1. goal을 먼저 확인하고 빼낸다.
 * 2. cards1을 확인한다. 있으면 빼낸다.
 * 3. cards2을 확인한다. 있으면 빼낸다.
 * 4. goal이 남았는데 빼낼수 없다면 완성되지 않는 goal이므로 No
 * 5. goal이 비어있다면 Yes
 */
public class 카드뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";

        // cards1 큐
        Queue<String> q1 = new LinkedList<>(Arrays.asList(cards1));
        // cards2 큐
        Queue<String> q2 = new LinkedList<>(Arrays.asList(cards2));
        // goal 큐
        Queue<String> g = new LinkedList<>(Arrays.asList(goal));

        while (!g.isEmpty()) {
            String word = g.poll();

            if (word.equals(q1.peek())) {
                q1.poll();
            } else if (word.equals(q2.peek())) {
                q2.poll();
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}

