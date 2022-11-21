package zyj.yihong.leetcode.random_select.nov;

// 983. 最低票价
public class MincostTickets_M_983 {
    private int[] days;
    private int[] costs;
    private int[] dp;
    private int[] costTime = new int[]{1,7,30};
    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs =costs;
        dp = new int[days.length];
        return dfs(0);
    }


    // 记忆化搜索
    public int dfs(int dayIndex){
        if (dayIndex>= days.length){
            return 0;
        }

        if (dp[dayIndex]!=0){
            return dp[dayIndex];
        }


        dp[dayIndex] = Integer.MAX_VALUE;
        int curIndex = dayIndex;
        for (int i = 0; i < 3; i++) {
            while (curIndex<days.length && days[curIndex]<days[dayIndex]+costTime[i]){
                curIndex++;
            }
            dp[dayIndex] = Math.min(dp[dayIndex],dfs(curIndex)+costs[i]);
        }

        return dp[dayIndex];

    }

    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        MincostTickets_M_983 mincostTickets_m_983 = new MincostTickets_M_983();
        int i = mincostTickets_m_983.mincostTickets(days, costs);
        System.out.println(i);
    }


}
