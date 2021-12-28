package zyj.yihong.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * 一些基本的排序算法
 * @author yihong
 */
public class Sort {

    /**
     * 插入排序
     * @param arr
     * @return
     */
    private static int[] insertSort(int[] arr){

        int[] ints = Arrays.copyOf(arr, arr.length);

        if (ints==null||ints.length<2){
            return ints;
        }

        for (int i = 1; i < ints.length; i++) {
            int temp = ints[i];

            int j = i-1;
            while (j>=0 && temp<ints[j]){
                ints[j+1] = ints[j];
                j--;
            }
            ints[j+1] = temp;
        }
        return ints;
    }


    /**
     * 希尔排序（缩小增量排序）
     * @param arr 给定数组
     * @return
     */
    private static int[] shellSort(int[] arr){

        int length = arr.length;

        // 使用3k+1的增量：1，4，13，40，121
        int k = 1;
        while(3*k+1<length){
            k = 3*k+1;
        }
        for (; k >=1 ; k = k/3) {
            for (int i = k; i < length; i++) {
                int j = i;
                int temp = arr[j];
                while(j-k>=0&&temp<arr[j-k]){
                    //
                    arr[j] = arr[j-k];
                    j = j -k;
                }
                arr[j] = temp;
            }
        }
        return arr;
    }

    /**
     * 并归排序合并
     * 一个数组存在两段已经是有序的数组进行合并成一个有序的数组
     * @param arr 数组
     * @param start 开始位置
     * @param mid 中间（第一段结束）
     * @param end 结束（第二段结束）
     */
    public static void merge(int[] arr,int start,int mid,int end){
        // 初始化两个数组的长度
        int n1 = mid - start+1;
        int n2 = end - mid;

        int[] leftArr = new int[n1+1];
        int[] rightArr = new int[n2+1];
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[start+i];
        }

        for (int i = 0; i < n2; i++) {
            rightArr[i] = arr[mid+i+1];
        }

        leftArr[leftArr.length-1] = Integer.MAX_VALUE;
        rightArr[rightArr.length-1] = Integer.MAX_VALUE;

        // 合并排序
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = start; i <= end ; i++) {
            if (rightArr[rightIndex]<leftArr[leftIndex]){
                arr[i] = rightArr[rightIndex];
                rightIndex++;
            }else {
                arr[i] = leftArr[leftIndex];
                leftIndex++;
            }
        }
    }

    /**
     * 并归排序--分治
     * @param arr
     * @param start
     * @param end
     */
    public static void mergeSortDivide(int[] arr, int start, int end){
        if (arr==null || arr.length<1){
            return;
        }

        if (start<end){
            int q = (end+start)/2;
//            调试用于输出
//            System.out.println("当前的中间值q: "+q);
            mergeSortDivide(arr,start,q);
            mergeSortDivide(arr,q+1,end);
            merge(arr,start,q,end);
        }
    }

    public static int[] mergeSort(int[] arr){
        int[] ints = Arrays.copyOf(arr, arr.length);
        mergeSortDivide(ints,0,ints.length-1);
        return ints;
    }


    /**
     * 用于验证自己写的排序是否正确
     * @throws Exception
     */
    private static void validSort() throws Exception {
        // 随机生成0-50个元素的int类型素组
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int length = random.nextInt(49)+1;
            int[] ints = new int[length];
            for (int j = 0; j < length; j++) {
                ints[j] = random.nextInt();
            }
            // 使用插入排序
//            int[] myInsertSort = insertSort(ints);

//           使用shell排序
//           int[] myInsertSort =  shellSort(ints);

//            并归排序
            int[] myInsertSort =  mergeSort(ints);
            Arrays.sort(ints);

            if (!Arrays.equals(myInsertSort, ints)){
                throw new Exception("测试不通过！！！");
            }
        }

        System.out.println("测试通过！！！");
    }

    public static void main(String[] args) throws Exception {
        validSort();
    }
}
