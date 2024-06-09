package me.yoosup.codingtest.inputoutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2588 {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s1 = Integer.parseInt(br.readLine());
        int s2 = Integer.parseInt(br.readLine());

        System.out.println(s1 * (s2 % 10));
        System.out.println(s1 * (s2 % 100 / 10));
        System.out.println(s1 * (s2 / 100));
        System.out.println(s1 * s2);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
