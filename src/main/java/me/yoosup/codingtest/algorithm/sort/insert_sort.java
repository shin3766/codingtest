package me.yoosup.codingtest.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class insert_sort {
    // 기준은 배열의 첫번째값으로 하기로 할때,

    public static void main(String[] args) {
        int[] arr = {2,4,3,7,9,6,5,1};
        for (int i = 1; i < arr.length; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[j] < arr[j-1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                } else {
                    break;
                }
                System.out.println("Arrays.asList(arr) = " + Arrays.toString(arr));

            }
        }
    }
}
