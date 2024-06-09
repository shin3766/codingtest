package me.yoosup.codingtest.programmers.md0609;

import java.util.Arrays;
import java.util.Collections;

public class 과일장수 {
    class Solution {

    /*
    첫번째 풀이   06/09
    1. score을 정렬한후 앞에서부터 m개씩 빼서 새로운 배열을 만든다.
    2. score의 최소숫자는 맨뒤에 있으므로 맨뒤 숫자를 빼서 m을 곱한다.
    3. result에 모두 합산한다.
    4. 스트림을 사용했다. 시간이 오래걸렸는데 더 좋은 방법이 있는지 알아봐야겠다.
    */

        public int solution(int k, int m, int[] score) {
            int answer = 0;
            int[] arr = Arrays.copyOf(score, score.length);

            Integer[] arrInt = Arrays.stream(arr).boxed().toArray(Integer[]::new);
            Arrays.sort(arrInt, Collections.reverseOrder());

            arr = Arrays.stream(arrInt)
                    .mapToInt(Integer::intValue)
                    .toArray();

            int check = 0;
            int sum = 0;


            while (check < score.length) {
                int[] box = new int[m];
                box = Arrays.copyOfRange(arr, check, check + m);
                sum += Arrays.stream(box).min().getAsInt() * m;
                check += m;
            }

            return sum;
        }
    }
}
