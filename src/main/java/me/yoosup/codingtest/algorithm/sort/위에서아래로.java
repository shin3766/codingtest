package me.yoosup.codingtest.algorithm.sort;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class 위에서아래로 {
    public static void main(String[] args) {
        List<Integer> l = Stream.of(15, 27, 12)
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println(l);
    }
}
