package me.yoosup.codingtest.algorithm.dfsbfs;

public class dfs타겟넘버 {
    /*
    https://school.programmers.co.kr/learn/courses/30/lessons/43165
     */
    static int answer = 0;

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        dfs(0, 0, numbers, target);

        System.out.println("answer = " + answer);
    }


    public static void dfs(int start, int idx, int[] numbers, int target) {
        if (idx == numbers.length) {
            if (start == target) {
                answer++;
            }
            return;
        }
        dfs(start + numbers[idx], idx + 1, numbers, target);
        dfs(start - numbers[idx], idx + 1, numbers, target);
    }
}

