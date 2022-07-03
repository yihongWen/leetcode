package zyj.yihong.leetcode.mid.sliding;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 */
public class MinSubArrayLen209 {
    /**
     * 滑动窗口、双指针
     * @param target
     * @param nums
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int start = 0;
        int curSum = 0;
        boolean exist = false;
        for (int i = 0; i < nums.length; i++) {
            curSum+=nums[i];
            while (curSum>=target){
                exist = true;
                result = Math.min(result,i-start+1);
                curSum-=nums[start];
                start++;
            }
        }
        return exist?result:0;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        int i = minSubArrayLen( 7,arr);
        System.out.println(i);
    }
}
