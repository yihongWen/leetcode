package zyj.yihong.leetcode.random_select.aug;

// 413. 等差数列划分
// 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
//子数组 是数组中的一个连续序列。
public class NumberOfArithmeticSlices_M_413 {
    public static int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }

        int d = nums[1] - nums[0];

        // 子数组是原数组中的一个连续序列
        int t = 0;
        int ans = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == d) {
                t++;
            } else {
                d = nums[i] - nums[i - 1];
                t = 0;
            }
            ans += t;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 9, 17, 11};
        int i = numberOfArithmeticSlices(arr);
        System.out.println(i);
    }
}
