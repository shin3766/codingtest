package me.yoosup.codingtest.programmers.md0610;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 실패율 :: https://school.programmers.co.kr/learn/courses/30/lessons/42889
 * 풀이과정
 * 1. stages는 stages의 크기가 사람수, 인덱스에 담고있는 실패정보는 인덱스에 있다.
 * 2. 실패 확률을 구하기위해 for문을 돌린다. -> int i = 1부터 인덱스가 1인 경우 실패한사람수를 센다.
 * 3. 실패확률은 실패한 사람수 / stages.length.
 * 4. 구한 실패확률을 새로운 double map에 더한다.
 * 5. 이때 double의 key는 실패확률, 요소는 스테이지정보를 담고 있다.
 * 6. 이를 내림차순 정렬한다.
 * 7. double map의 요소를 array로 뽑아낸다.
 */
public class 실패율 {
    static double[] stageFail;
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 4, 3, 3};

        stagefail(stages, N);

        System.out.println("stageFail = " + Arrays.toString(stageFail));

        HashMap<Integer, Double> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            map.put(i+1, stageFail[i]);
        }
    }

    public static double[] stagefail(int[] stages, int N) {
        stageFail = new double[N];
        int fails = 0;
        int preFails = fails;
        int entire = stages.length;

        for(int j = 0; j < N; j++) {
            for (int i = 0; i < stages.length; i++) {
                if (j + 1 == stages[i]) {
                    fails++;
                }
            }
            stageFail[j] = (double) (fails - preFails) / (entire -preFails);
        }

        return stageFail;
    }
}
