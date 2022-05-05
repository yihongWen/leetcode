package zyj.yihong.leetcode.simple.arr;

/**
 * 908. 最小差值 I
 */
public class SmallestRangeI908 {
    public static int smallestRangeI(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max<nums[i]){
                max = nums[i];
            }

            if (min>nums[i]){
                min=nums[i];
            }
        }
        return max-min>=2*k?max-min-2*k:0;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,6};
        int k = 3;
        int i = smallestRangeI(nums, k);
        System.out.println(i);
    }
}
