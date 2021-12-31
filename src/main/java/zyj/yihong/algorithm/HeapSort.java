package zyj.yihong.algorithm;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author yihong
 */
public class HeapSort {

    /**
     * 获取左节点
     *
     * @param i
     * @return
     */
    private static int getLeft(int i) {
        return 2 * i + 1;
    }

    /**
     * 获取右节点
     *
     * @param i
     * @return
     */
    private static int getRight(int i) {
        return 2 * i + 2;
    }

    /**
     * 获取当前节点的父节点
     * @param i
     * @return
     */
    private int getParent(int i) {
        if (i % 2 == 0) {
            return i / 2 - 1;
        } else {
            return i / 2;
        }
    }

    /**
     * 维护堆的性质
     */
    private static void heapify(int[] arr, int index,int curHeapSize) throws Exception {
        if (index > curHeapSize) {
            throw new Exception("下标值不正确....");
        }
        int large = index;
        int left = getLeft(index);
        int right = getRight(index);
        if (left <= curHeapSize && arr[left] > arr[large]) {
            large = left;
        }

        if (right <= curHeapSize && arr[right] > arr[large]) {
            large = right;
        }
        // 判断当前是否已经满足
        if (large != index) {
            int temp = arr[index];
            arr[index] = arr[large];
            arr[large] = temp;
            heapify(arr, large,curHeapSize);
        }
    }

    /**
     * 建堆
     */
    private static void buildHeap(int[] arr) throws Exception {
        if (arr==null || arr.length==1){
            return;
        }

        int start;
        if (arr.length%2==0){
            start = arr.length/2-1;
        }else {
            start = arr.length/2;
        }

        for (int i = start; i >= 0 ; i--) {
            heapify(arr,i,arr.length-1);
        }
    }


    public static void heapSort(int[] arr) throws Exception {
        if (arr == null || arr.length==1){
            return;
        }

        buildHeap(arr);
        int curSize = arr.length-1;

        while(curSize>0){
            int temp = arr[0];
            arr[0] = arr[curSize];
            arr[curSize] = temp;
            curSize--;
            heapify(arr,0,curSize);
        }
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {16,4,10,14,7,9,3,2,8,1};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
