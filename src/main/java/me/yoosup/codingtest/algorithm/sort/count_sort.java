package me.yoosup.codingtest.algorithm.sort;

import java.util.Arrays;

public class count_sort {
    public static void main(String[] args) {
        int[] arr = {2,4,3,7,9,6,5,1};
        int[] countArr = new int[10];
        int[] sortedarr = new int[arr.length];
        int idx = 0;

        for (int k : arr) {
            countArr[k] += 1;
        }

        for(int i = 0; i < countArr.length; i++) {
            for( int j = 0; j < countArr[i]; j++) {
                sortedarr[idx++] = i;
                System.out.printf(i + " ");
            }
        }
        System.out.println();
        System.out.println("arr = " + Arrays.toString(sortedarr));
    }
}
