package me.yoosup.codingtest.algorithm.sort;

import java.util.Arrays;

public class select_sort {
    public static void main(String[] args) {
        int[] arr = {2,4,3,7,9,6,5,1};

        for(int i = 0; i < arr.length; i++) {
            // min 인덱스를 i로 할때
            int min_idx = i;
            for(int j = i + 1; j < arr.length; j++) {
                if (arr[min_idx] > arr[j]) {
                    min_idx = j;
                }
            }
                if(arr[min_idx] != arr[i]) {
                    int tmp = arr[min_idx];
                    arr[min_idx] = arr[i];
                    arr[i] = tmp;
                }
        }
        System.out.println("arr = " + Arrays.toString(arr));
    }
}
