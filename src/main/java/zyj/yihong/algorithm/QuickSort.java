package zyj.yihong.algorithm;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author yihong
 */
public class QuickSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int[] result = partition2(arr, start, end);
            quickSort(arr, start, result[1]);
            quickSort(arr, result[0], end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int curValue = arr[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {

            if (curValue>arr[j]){
                i++;
                //交换
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        arr[end] = arr[i];
        arr[i] = curValue;
        return i;
    }

    /**
     * 三路快排
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static int[] partition2(int[] arr, int start, int end) {
       int lt = start;
       int eq = start+1;
       int gt = end+1;

       int curValue = arr[start];

       while (eq<gt){
            if (arr[eq]==curValue){
                eq++;
            }else if (arr[eq]<curValue){
                int temp = arr[eq];
                arr[eq] = arr[lt+1];
                arr[lt+1] = temp;
                eq ++;
                lt ++;

            }else if (arr[eq]>curValue){
                int temp = arr[eq];
                arr[eq] =arr[gt-1];
                arr[gt-1] = temp;
                gt--;
            }
       }
        arr[start] = arr[lt];
        arr[lt] = curValue;

        int[] result = {gt,lt};
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,3,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
