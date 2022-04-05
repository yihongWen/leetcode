package zyj.yihong.leetcode.mid.dp;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProfit309 {
    public int maxProfit(int[] prices) {
        // 每天最大收益的状态可以存在3中状态：手持、不持且冷冻期、不持非冷冻
        int state1 = -prices[0];
        int state2 = 0;
        int state3 = 0;

        for (int i = 1; i < prices.length; i++) {
            int nextState1 = Math.max(state1, state3 - prices[i]);
            int nextState2 = state1 + prices[i];
            int nextState3 = Math.max(state2, state3);
            state1 = nextState1;
            state2 = nextState2;
            state3 = nextState3;
        }
        return Math.max(state2,state3);
    }
}
