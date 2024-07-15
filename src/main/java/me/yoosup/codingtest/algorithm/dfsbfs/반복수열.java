package me.yoosup.codingtest.algorithm.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 반복수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> numList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();

        Integer start = null;
        Integer power = null;
        while (st.hasMoreTokens()) {
            start = Integer.parseInt(st.nextToken());
            power = Integer.parseInt(st.nextToken());
        }

        numList.add(start);

        /*
        풀이하는 방법
        1. 수열을 두개를 두고 푼다?
        하나는 새로운 숫자 계산 및 추가, 하나는 intCount으로 중복 수 세기

        2. 계산하고 배열에 넣는다.
        3. count는 새로운 수가 배열에 있는지 없는지 확인후,
        있으면 기존 수 배열의 인덱스를 가져와 count를 +1 시킨다.
        4. 없으면, 새롭게 인덱스를 추가한후 카운트 1을 올린다.

        배열이 자유자재로 늘어날 것이므로, 둘다 List<Integer>을 사용해야한다.
         */
        while (true) {
            int temp = numList.get(numList.size() - 1);
            int newNum = 0;

            while(temp != 0) {
                newNum += (int) Math.pow(temp % 10, (double) power);
                temp /= 10;
            }
            if (numList.contains(newNum)) {
                int ans = numList.indexOf(newNum);
                System.out.println(ans);
                break;
            }
            numList.add(newNum);
        }
    }
}
