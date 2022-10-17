package zyj.yihong.leetcode.special.top.stack;

import java.util.Stack;

/**
 * 769. 最多能完成排序的块
 * 给定一个长度为 n 的整数数组 arr ，它表示在 [0, n - 1] 范围内的整数的排列。
 *
 * 我们将 arr 分割成若干 块 (即分区)，并对每个块单独排序。将它们连接起来后，使得连接的结果和按升序排序后的原数组相同。
 *
 * 返回数组能分成的最多块数量。
 */
public class MaxChunksToSorted_M_769 {
    public int maxChunksToSorted(int[] arr) {
        // 使用单调栈
        // 1、什么时候可以是一个新的区？：当前元素比之前的所有值都大，此时可以另外一个区
        // 2、如果出现一个较少的元素，此时只能跟前面的区融合，也可能将前面的多个区合成一个

        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for (int i = 1; i < arr.length ; i++) {
            if (arr[i]>arr[stack.peek()]){
                stack.add(i);
                continue;
            }

            Integer curMaxValueIndex = stack.pop();
            while (!stack.isEmpty()&&arr[stack.peek()]>arr[i]){
                stack.pop();
            }

            // 至少保证一个
            stack.add(curMaxValueIndex);
        }

        return stack.size();
    }

    public int maxChunksToSorted1(int[] arr) {
        // 数组中数据为0～n-1
        // 只需要找到段中最大值==index时,则说明后面段没有更小的值
        int curMax = 0;
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
             curMax = Math.max(curMax, arr[i]);
            if (curMax==i){
                ans++;
            }
        }
        return ans;
    }
}
