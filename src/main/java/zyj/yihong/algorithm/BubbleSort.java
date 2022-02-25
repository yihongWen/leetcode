package zyj.yihong.algorithm;

import java.util.Arrays;

public class BubbleSort {

    public static void sort(int[] arr){
        for (int i = arr.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void sortOpt(int[] arr){
        for (int i = arr.length - 1; i >= 1; i--) {
            boolean modifyFlag = true;
            for (int j = 0; j < i; j++) {
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    modifyFlag = false;
                }
            }
            if (modifyFlag){
                return;
            }
        }
    }


    public static void main(String[] args) {
        int[] testArr = {5,4,8,9};
        sortOpt(testArr);
        System.out.println(Arrays.toString(testArr));
    }
}
