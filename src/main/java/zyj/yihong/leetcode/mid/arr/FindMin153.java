package zyj.yihong.leetcode.mid.arr;

import java.util.Arrays;

/**
 * 153. 寻找旋转排序数组中的最小值
 *
 */
public class FindMin153 {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (min>nums[i]){
                min = nums[i];
            }
        }
        return min;
    }

    public static int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while (left<right){
            int mid = (right-left)/2+left;
            if (nums[mid]>nums[right]){
                left = mid+1;
            }else if (nums[mid]<nums[right]){
                right = mid;
            }else {
                right=right-1;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] arr = {3,1,3};
        int min2 = findMin2(arr);
        System.out.println(min2);
    }
}
