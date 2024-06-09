package me.yoosup.codingtest.sort.md0607;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class 두배열의원소교체 {
    //flatmap을 사용해보자
    // 06-07 첫번째시도 :: 틀림!
    public static void main(String[] args) {
        int[] arrayA = {1, 2, 5, 4, 3};
        int[] arrayB = {5, 5, 6, 6, 5};

        Stream<int[]> intArrStream = Stream.of(
                arrayA,
                arrayB
        );

        Stream<Integer> intStream = intArrStream.flatMapToInt(Arrays::stream)
                .boxed();

        int arraySumC = intStream
                .sorted(Collections.reverseOrder())
                .limit(arrayA.length)
                .mapToInt(i -> i)
                .sum();

        System.out.println("arraySumC = " + arraySumC);
    }
}
