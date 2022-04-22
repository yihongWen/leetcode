package zyj.yihong.leetcode.mid.dp;

/**
 * 396. 旋转函数
 * 给定一个长度为 n 的整数数组 nums 。
 *
 * 假设 arrk 是数组 nums 顺时针旋转 k 个位置后的数组，我们定义 nums 的 旋转函数  F 为：
 *
 * F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
 * 返回 F(0), F(1), ..., F(n-1)中的最大值 。
 *
 * 生成的测试用例让答案符合 32 位 整数。

 */
public class MaxRotateFunction396 {

    public static int maxRotateFunction(int[] nums) {
        int dp = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            dp += i*nums[i];
            sum+=nums[i];
        }
        int max = dp;

        for (int i = 1; i <nums.length ; i++) {
            dp = dp+sum- nums.length*nums[nums.length-i];
            max = Math.max(max,dp);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,6};
        System.out.println(maxRotateFunction(arr));
    }
}
