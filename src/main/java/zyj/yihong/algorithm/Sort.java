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
           int[] myInsertSort =  shellSort(ints);

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
