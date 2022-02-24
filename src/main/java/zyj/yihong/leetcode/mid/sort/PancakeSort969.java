package zyj.yihong.leetcode.mid.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 arr ，请使用 煎饼翻转 完成对数组的排序。
 *
 * 一次煎饼翻转的执行过程如下：
 *
 * 选择一个整数 k ，1 <= k <= arr.length
 * 反转子数组 arr[0...k-1]（下标从 0 开始）
 * 例如，arr = [3,2,1,4] ，选择 k = 3 进行一次煎饼翻转，反转子数组 [3,2,1] ，得到 arr = [1,2,3,4] 。
 *
 * 以数组形式返回能使 arr 有序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次10 * arr.length 范围内的有效答案都将被判断为正确。
 */
public class PancakeSort969 {
    /**
     * 找到当前最大的值，然后放置到当前的最后一位
     * @param arr
     * @return
     */
    public static List<Integer> pancakeSort(int[] arr) {
        List<Integer> retList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            // 找到当前最大的值
            int curMax = arr[0];
            int curMaxIndex = 0;
            for (int j = 1; j < arr.length - i; j++) {
                if (curMax<arr[j]){
                    curMax = arr[j];
                    curMaxIndex = j;
                }
            }

            // 判断是否在正确的位置上
            if (curMaxIndex== arr.length-1-i){
                continue;
            }
            retList.add(curMaxIndex+1);
            retList.add(arr.length-i);
            reverse(arr,curMaxIndex);
            reverse(arr,arr.length-1-i);
        }
        return retList;
    }

    /**
     * 逆序
     * @param arr
     * @param endIndex
     */
    private static void reverse(int[] arr,int endIndex){
        int i = 0;
        int j = endIndex;
        while (i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] reArr = {3,2,4,1};
        List<Integer> list = pancakeSort(reArr);
        System.out.println(list);
    }

//
//[4,2,4,3]
}
