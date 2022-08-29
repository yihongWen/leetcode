package zyj.yihong.leetcode.random_select.aug;


//1464. 数组中两元素的最大乘积
//给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
//2 <= nums.length <= 500
//1 <= nums[i] <= 10^3
public class MaxProduct_S_1464 {
    public int maxProduct(int[] nums) {
        // max1 max0分别为最大和次最大的两个值
        int max0 = nums[0];
        int max1 = nums[1];
        if (max1<max0){
            int swap = max0;
            max0 = max1;
            max1 = swap;
        }

        for (int i = 2; i < nums.length ; i++) {
            if (nums[i]>max1){
                max0 = max1;
                max1 = nums[i];
            }else if (nums[i]>max0){
                max0 = nums[i];
            }
        }

        return (max0-1)*(max1-1);
    }
}
