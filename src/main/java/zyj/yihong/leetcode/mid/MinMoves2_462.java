package zyj.yihong.leetcode.mid;

import java.util.Arrays;

/**
 * 462. 最少移动次数使数组元素相等 II
 * 给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。
 * @author yihong
 */
public class MinMoves2_462 {

    /**
     * 本质上就是找中位数
     * @param nums
     * @return
     */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int midIndex  = nums.length/2;
        int minValue = 0;

        for (int i = 0; i < nums.length; i++) {
            minValue = minValue + Math.abs(nums[i]-nums[midIndex]);
        }
        return minValue;
    }

    public static int minMoves2_1(int[] nums) {
        int midIndexValue = getMidIndexValue(nums);
        int minValue = 0;

        for (int i = 0; i < nums.length; i++) {
            minValue = minValue + Math.abs(nums[i]-midIndexValue);
        }
        return minValue;
    }

    /**
     * 获取无序数组中某个位置的值且该值是排序后的
     * 使用快排的方式进行查找
     * @param nums
     * @return
     */
    public static int getMidIndexValue(int[] nums){
        int start = 0;
        int end = nums.length-1;
        int midIndex = end/2;

       while (start<=end){
           if (start==end){
               return nums[start];
           }
           int partition = partition(nums, start, end);
           if (partition<midIndex){
               start = partition+1;
           }else if (partition>midIndex){
               end = partition-1;
           }else {
               return nums[partition];
           }
       }
       return nums[0];
    }

    public static int partition(int[] nums,int start,int end){
        int curValue = nums[end];
        int i = start-1;

        for (int j = start; j <end ; j++) {
            if (nums[j]<curValue){
                // 交换
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

            }
        }

        // 替换最后的位置
        nums[end] = nums[i+1];
        nums[i+1] = curValue;
        return i+1;
    }

    public static void main(String[] args) {
        int[] arr =  {2,1,3};
//        int value = getMidIndexValue(arr);
        int ret = minMoves2_1(arr);
        System.out.println(ret);
//        int partition = partition(arr, 0, arr.length - 1);
//        System.out.println(partition);

//        System.out.println(value);
    }
}
