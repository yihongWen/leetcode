package zyj.yihong.leetcode.random_select.seg;

import java.util.Stack;

// 1475. 商品折扣后的最终价格
public class FinalPrices_S_1475 {
    public int[] finalPrices(int[] prices) {
        // 直接遍历查找
        int[] ans = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int temp = 0;
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j]<=prices[i]){
                    temp = prices[j];
                    break;
                }
            }
            ans[i] = prices[i]-temp;
        }
        return ans;
    }


    public int[] finalPricesByStack(int[] prices) {
        // 使用单调栈：从最后一个开始计算
        // 由于题目限定最小下标，当出现元素比栈中的元素要小时，此时栈中元素较大的值一定是用不上的
        int[] ans = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = prices.length - 1; i >= 0; i--) {

            // 处理栈
            while (!stack.isEmpty()&&stack.peek()>=prices[i]){
                stack.pop();
            }
            ans[i] = stack.isEmpty()?prices[i]:prices[i]-stack.peek();
            stack.push(prices[i]);
        }

        return ans;

    }

}
