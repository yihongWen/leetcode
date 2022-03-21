package zyj.yihong.leetcode.simple.sliding;

/**
 * 643. 子数组最大平均数 I
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 *
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMaxAverage643 {
    public static double findMaxAverage(int[] nums, int k) {
        int curSum = 0;
        int maxSum;
        for (int i = 0; i < k; i++) {
            curSum += nums[i];
        }
        maxSum = curSum;
        for (int i = k; i < nums.length; i++) {
            curSum = curSum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, curSum);
        }
        return (double) maxSum/k;
    }

    public static void main(String[] args) {
        int[] arr = {1,12,-5,-6,50,3};
        int k = 4;
        double maxAverage = findMaxAverage(arr, k);
        System.out.println(maxAverage);
    }
}
