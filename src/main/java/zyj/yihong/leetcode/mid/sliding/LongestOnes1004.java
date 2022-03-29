package zyj.yihong.leetcode.mid.sliding;

/**
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 */
public class LongestOnes1004 {
    public int longestOnes(int[] nums, int k) {
        // 使用双指针，计算出右端点的位置，当使用可K次不满足的情况时左端点向右边移动
        int curUseNum = 0;
        int curMaxLength = 0;
        int left = 0;
        int right = 0;

        for (; right < nums.length; right++) {
            int curNum = nums[right];
            if (curNum==0){
                curUseNum++;
            }
            while (curUseNum>k){
                int c1 = nums[left];
                if (c1==0){
                    curUseNum--;
                }
                left++;
            }
            curMaxLength = Math.max(right-left+1,curMaxLength);
        }
        return curMaxLength;
    }
}
