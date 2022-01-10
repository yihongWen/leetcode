package zyj.yihong.algorithm;


import java.util.Arrays;

/**
 * counting-sort
 * @author yihong
 */
public class CountSort {

    public static void sort(int[] arr){
        if (arr==null || arr.length<=1){
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int cur : arr) {
            if (cur>max){
                max = cur;
            }
        }

        countSort(arr, max);
    }

    public static void countSort(int[] arr,int max){
        int[] assistArr = new int[max+1];
        int[] retArr = new int[arr.length];

        // 计算assistArr
        for (int i = 0; i < arr.length; i++) {
            assistArr[arr[i]]++;
        }

        for (int i = 1; i < assistArr.length; i++) {
            assistArr[i] += assistArr[i-1];
        }


        for (int i = arr.length - 1; i >= 0; i--) {

            retArr[assistArr[arr[i]]-1] = arr[i];
            assistArr[arr[i]]--;
        }
        System.arraycopy(retArr,0,arr,0,arr.length);
    }

    public static void main(String[] args) {
        int[] testArr = {1,5,3,7,3,5};
        sort(testArr);

    }
}
