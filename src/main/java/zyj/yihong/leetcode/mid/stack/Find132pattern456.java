package zyj.yihong.leetcode.mid.stack;

import java.util.Stack;

/**
 * 456. 132 模式
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 *
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/132-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Find132pattern456 {
    /**
     * 使用单调栈,从右向左枚举1，
     * 3，2，4，2，3
     * @param nums
     * @return
     */
    public static boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[nums.length-1]);
        int max_2 = Integer.MIN_VALUE;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i]<max_2){
                return true;
            }
            while (!stack.isEmpty()&& stack.peek()<nums[i]){
                max_2 = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,0,3,4};
        boolean pattern = find132pattern(arr);
        System.out.println(pattern);
    }

}
