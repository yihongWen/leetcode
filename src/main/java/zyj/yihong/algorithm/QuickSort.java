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
            int partition = partition(arr, start, end);
            quickSort(arr, start, partition - 1);
            quickSort(arr, partition + 1, end);
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

    public static void main(String[] args) {
        int[] arr = {2,8,7,1,3,5,6,4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
