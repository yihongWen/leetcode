package zyj.yihong.leetcode.simple.sort;

import java.util.Arrays;

/**
 * 给定由一些正数（代表长度）组成的数组 nums ，返回 由其中三个长度组成的、面积不为零的三角形的最大周长 。如果不能形成任何面积不为零的三角形，返回 0。
 */
public class LargestPerimeter976 {
    /**
     * 组成三角形的充分必要条件：两边之和要大于第三边
     *
     * @param nums
     * @return
     */
    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        int i = largestPerimeter(nums);
        System.out.println(i);
    }
}
