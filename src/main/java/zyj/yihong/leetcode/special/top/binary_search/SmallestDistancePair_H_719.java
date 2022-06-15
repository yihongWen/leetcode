package zyj.yihong.leetcode.special.top.binary_search;

import java.util.Arrays;

/**
 * 719. 找出第 K 小的数对距离
 * 数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。
 *
 * 给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。返回 所有数对距离中 第 k 小的数对距离。
 *
 */
public class SmallestDistancePair_H_719 {
    public int smallestDistancePair(int[] nums, int k) {
        // 对数组进行排序，排序后可以找到最大的距离，根据距离进行二分，对于给定的某个距离，计算出小于等于该距离的个数
        // 根据个数进行二分，对于计算个数也可以进行二分查找
        Arrays.sort(nums);
        int maxDis = nums[nums.length-1]-nums[0];
        int left = 0;
        int right = maxDis;
        while (left<=right){
            int mid = left+((right-left)>>1);
            int curDisCount = 0;
            for (int i = 0; i < nums.length; i++) {
                // 枚举右边的端点
                curDisCount+=curDisCount(nums,i,nums[i]-mid);
            }

            // 细节：这一步保证left：一定是数组中两个数的差值
            if (curDisCount>=k){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    private int curDisCount(int[] nums,int endIndex,int dis){
        // 数据是有序的，可以进行二分查找
        int left = 0;
        int right = endIndex;
        while (left<right){
            int mid = left+((right-left)>>1);
            if (nums[mid]<dis){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return endIndex-left;
    }

    public static void main(String[] args) {
        int[] arr =  {1,3,1};
        SmallestDistancePair_H_719 smallestDistancePair719 = new SmallestDistancePair_H_719();
        int i = smallestDistancePair719.smallestDistancePair(arr, 1);
        System.out.println(i);
    }
}
