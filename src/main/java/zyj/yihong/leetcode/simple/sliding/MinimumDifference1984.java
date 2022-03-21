package zyj.yihong.leetcode.simple.sliding;

import zyj.yihong.leetcode.mid.queue.MaxQueue_J2_59;

import java.util.Arrays;

/**
 * 1984. 学生分数的最小差值
 * 给你一个 下标从 0 开始 的整数数组 nums ，其中 nums[i] 表示第 i 名学生的分数。另给你一个整数 k 。
 *
 * 从数组中选出任意 k 名学生的分数，使这 k 个分数间 最高分 和 最低分 的 差值 达到 最小化 。
 *
 * 返回可能的 最小差值 。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumDifference1984 {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        for (int i = k-1; i < nums.length ; i++) {
            int i1 = nums[i] - nums[i - k + 1];
            result = Math.min(result,i1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3,8,2,5,4};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
