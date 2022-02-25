package zyj.yihong.algorithm;

import java.util.Arrays;

public class SelectSort {
    public static void sort(int[] arr){
        int curMax = Integer.MIN_VALUE;
        int curMaxIndex = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (curMax<=arr[j]){
                    curMax = arr[j];
                    curMaxIndex=j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[curMaxIndex];
            arr[curMaxIndex] = temp;
            curMaxIndex = 0;
            curMax = Integer.MIN_VALUE;
        }
    }

    public static void main(String[] args) {
        int[] testArr = {5,4,8,9};
        sort(testArr);
        System.out.println(Arrays.toString(testArr));
    }
}
