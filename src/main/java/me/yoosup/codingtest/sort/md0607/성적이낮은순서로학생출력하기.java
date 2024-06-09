package me.yoosup.codingtest.sort.md0607;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class 성적이낮은순서로학생출력하기 {
    public static void main(String[] args) {
        Student[] stuList = {
                new Student("홍길동", 95),
                new Student("이순신", 77)
        };

        List<String> sl = Arrays.stream(stuList)
                .sorted(Comparator.comparing(
                        Student::getScore)
                )
                .map(Student::getName)
                .toList();

        System.out.println(sl);
    }
}

class Student {
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
