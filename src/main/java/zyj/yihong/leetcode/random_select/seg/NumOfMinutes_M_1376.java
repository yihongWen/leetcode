package zyj.yihong.leetcode.random_select.seg;

// 1376. 通知所有员工所需的时间
public class NumOfMinutes_M_1376 {
    private int[] times;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        this.times = new int[n];

        for (int i = 0; i < n; i++) {
            dfs(i,manager,informTime);
        }

        int ans = times[0];
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans,times[i]);
        }
        return ans;
    }

    private void dfs(int number,int[] manager,int[] informTime){
        if (manager[number]==-1){
            return ;
        }

        if (times[manager[number]]==0){
            dfs(manager[number], manager, informTime);
        }

        times[number] = times[manager[number]]+informTime[manager[number]];
    }

    public static void main(String[] args) {
//        6
//2
//[2,2,-1,2,2,2]
//[0,0,1,0,0,0]
        NumOfMinutes_M_1376 numOfMinutes_m_1376 = new NumOfMinutes_M_1376();
        int n = 6, headID = 2;
        int[] manager = {2,2,-1,2,2,2};
        int[] informTime = {0,0,1,0,0,0};
        int max = numOfMinutes_m_1376.numOfMinutes(n, headID, manager, informTime);
        System.out.println(max);
    }
}