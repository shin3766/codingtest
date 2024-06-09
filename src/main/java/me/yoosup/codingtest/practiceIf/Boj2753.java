package me.yoosup.codingtest.practiceIf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2753 {
    public static int Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        if (a % 4 == 0 && a % 100 != 0) {
            return 1;
        } else if (a % 400 == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(Solution());
    }
}
