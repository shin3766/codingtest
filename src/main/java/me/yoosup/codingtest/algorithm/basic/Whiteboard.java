package me.yoosup.codingtest.algorithm.basic;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Whiteboard {
    public static void main(String[] args) throws IOException {

        System.out.println(checkPrime(131));
    }

    public static boolean checkPrime(int num) {
        int check = (int) Math.sqrt(num);
        for(int i = 2; i <= check; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
