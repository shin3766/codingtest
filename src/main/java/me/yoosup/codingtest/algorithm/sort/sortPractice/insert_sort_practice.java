package me.yoosup.codingtest.algorithm.sort.sortPractice;

import java.util.Arrays;

public class insert_sort_practice {
    /*
    지정한 인덱스의 요소의 왼쪽이랑만 비교한다. 조건에 해당하면 두 요소의 위치를 바꾼다.
     */
    public static void main(String[] args) {
        int[] arr = new int[] {3, 1, 5, 6, 7, 4, 2, 9, 0, 8};

        for(int i = 1; i < arr.length; i++){
            for(int j = i; j > 0; j--) {
                if(arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j-1] = tmp;
                } else {
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
