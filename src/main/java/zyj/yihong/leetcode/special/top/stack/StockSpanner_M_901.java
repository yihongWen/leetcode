package zyj.yihong.leetcode.special.top.stack;

import java.util.Stack;

/**
 * 901. 股票价格跨度
 * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 *
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 *
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
 */
public class StockSpanner_M_901 {
    private Stack<Integer> stockPriceStack;
    private Stack<Integer> stockContinuousStack;
    public StockSpanner_M_901() {
        stockContinuousStack = new Stack<>();
        stockPriceStack = new Stack<>();
    }

    public int next(int price) {
        int continuous = 1;
        while (!stockPriceStack.isEmpty()&& stockPriceStack.peek()<=price){
            continuous+=stockContinuousStack.pop();
            stockPriceStack.pop();
        }
        stockPriceStack.push(price);
        stockContinuousStack.push(continuous);

        return continuous;
    }

    public static void main(String[] args) {
//        ["StockSpanner","next","next","next","next","next","next","next"]
//[[],[100],[80],[60],[70],[60],[75],[85]]
        StockSpanner_M_901 stockSpanner_m_901 = new StockSpanner_M_901();
        System.out.println(stockSpanner_m_901.next(100));
        System.out.println(stockSpanner_m_901.next(80));
        System.out.println(stockSpanner_m_901.next(60));
        System.out.println(stockSpanner_m_901.next(70));
        System.out.println(stockSpanner_m_901.next(60));
        System.out.println(stockSpanner_m_901.next(75));
        System.out.println(stockSpanner_m_901.next(85));


    }


}
