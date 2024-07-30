package me.yoosup.codingtest.algorithm.sort.sortPractice;

import java.util.Arrays;

public class select_sort_practice {
    /*
    리스트의 순서대로 움직이면서 자신보다 작은 수가 나오면 서로 바꾼다.
    이중 포문 사용 -> 최대 시간 복잡도 N^2
     */
    public static void main(String[] args) {
        int[] arr = new int[] {3, 1, 5, 6, 7, 4, 2, 9, 0, 8};

        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
