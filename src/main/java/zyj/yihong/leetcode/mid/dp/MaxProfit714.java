package zyj.yihong.leetcode.mid.dp;

/**
 * 714. 买卖股票的最佳时机含手续费
 * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProfit714 {
    public static int maxProfit(int[] prices, int fee) {
        // 定义dp状态：
        // state1: 手持最大收益
        // state2: 没有持最大收益
        int state1 = -prices[0];
        int state2 = 0;

        for (int i = 1; i < prices.length; i++) {
            int nextState1 = Math.max(state1, state2 - prices[i]);
            int nextState2 = Math.max(state2, state1 + prices[i] - fee);
            state1 = nextState1;
            state2 = nextState2;
        }
        return Math.max(state1,state2);
    }

    public static void main(String[] args) {
        int[] price = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int maxProfit = maxProfit(price, fee);
        System.out.println(maxProfit);
    }
}
