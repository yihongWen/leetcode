package zyj.yihong.leetcode.mid.queue;

/**
 * 2073. 买票需要的时间
 * 有 n 个人前来排队买票，其中第 0 人站在队伍 最前方 ，第 (n - 1) 人站在队伍 最后方 。
 *
 * 给你一个下标从 0 开始的整数数组 tickets ，数组长度为 n ，其中第 i 人想要购买的票数为 tickets[i] 。
 *
 * 每个人买票都需要用掉 恰好 1 秒 。一个人 一次只能买一张票 ，如果需要购买更多票，他必须走到  队尾 重新排队（瞬间 发生，不计时间）。如果一个人没有剩下需要买的票，那他将会 离开 队伍。
 *
 * 返回位于位置 k（下标从 0 开始）的人完成买票需要的时间（以秒为单位）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/time-needed-to-buy-tickets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TimeRequiredToBuy2073 {
    /**
     *
     * @param tickets
     * @param k
     * @return
     */
    public int timeRequiredToBuy(int[] tickets, int k) {
        int timeOfBuy = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i<=k){
                timeOfBuy+= Math.min(tickets[i],tickets[k]);
            }else {
                timeOfBuy+= Math.min(tickets[i],tickets[k]-1);
            }
        }
        return timeOfBuy;
    }
}
