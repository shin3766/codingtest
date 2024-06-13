package me.yoosup.codingtest.algorithm.sort;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.Arrays;

public class quick_sort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 7, 9, 6, 5, 1};

        quick(arr, 0, arr.length - 1);

        System.out.println("arr = " + Arrays.toString(arr));
    }

    public static void quick(int[] array, int start, int end) {
        if (start >= end) { //원소가 1개일 경우
            return;
        }

        int pivot = start; // 피벗은 기준점
        int left = start + 1;
        int right = end;
        // 오른쪽 값이 왼쪽 값보다 끌때만 반복 (교차점에서 베이스를 삽입해야하기 때문)
        while (right >= left) {
            // 기준보다 작은 값 찾기
            while(left <= end && array[left] <= array[pivot]) {
                left += 1;
            }
            while(right > start && array[right] >= array[pivot]) {
                right -= 1;
            }

            if(left > right) { // 엇갈렸다면 피벗과 작은 데이터의 위치 교체
                int tmp = array[pivot];
                array[pivot] = array[right];
                array[right] = tmp;
            } else { // 엇갈리지 않았다면 작은값과 큰값을 바꿈
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }

            quick(array, start, right - 1);
            quick(array, right + 1, end);
        }

    }
}
