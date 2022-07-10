package zyj.yihong.leetcode.special.top.prefix_sum;

import java.util.Stack;

/**
 * 1124. 表现良好的最长时间段
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 * <p>
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 * <p>
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 * <p>
 * 请你返回「表现良好时间段」的最大长度。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-well-performing-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestWPI_M_1124 {
    public static int longestWPI(int[] hours) {
        // 0-1处理
        for (int i = 0; i < hours.length; i++) {
            hours[i] = hours[i] > 8 ? 1 : -1;
        }

        // 处理前缀和
        int[] preSum = new int[hours.length + 1];
        for (int i = 0; i < hours.length; i++) {
            preSum[i + 1] = preSum[i] + hours[i];
        }

        // 借助单调栈计算i-j的最大范围
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < preSum.length; i++) {
            if (stack.isEmpty()) {
                stack.add(i);
                continue;
            }

            if (preSum[stack.peek()] > preSum[i]) {
                stack.add(i);
            }
        }

        int ans = 0;

        int right = preSum.length - 1;
        while (right>=0) {
            if (preSum[right] > preSum[stack.peek()]) {
                ans = Math.max(ans, right - stack.peek());
                stack.pop();
                if (stack.isEmpty()){
                    break;
                }
                continue;
            }
            right--;
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {6,9, 9};
        int i = longestWPI(arr);
        System.out.println(i);
    }
}
