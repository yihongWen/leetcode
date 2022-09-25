package zyj.yihong.leetcode.random_select.seg;

import java.util.Arrays;

//788. 旋转数字

public class RotatedDigits_M_788 {
    String num;
    //    dp(index,limit,state)
    int[][][] dp = new int[5][2][2];
    //    只要数字不包含（3，4，7）并且包含（5，2，6，9）
    int[] check = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};

    public int rotatedDigits(int n) {
        // 数位dp
        num = String.valueOf(n);

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < 2; j++) {
                // 将state设置成为-1，标识为未计算
                Arrays.fill(dp[i][j], -1);
            }
        }

        dfs(0, 1, 0);

        return dp[0][1][0];

    }


    private int dfs(int index, int limit, int state) {
        // 边界条件，如果位数超过num的长度直接返回
        if (index == num.length()) {
            // 返回当前状态，也就是当前的值是否为好数
            return state;
        }

        // 判断当前是否计算过：比如 计算7（56）时在056中已经计算过56的状态
        if (dp[index][limit][state] != -1) {
            return dp[index][limit][state];
        }


        // 递归的计算当前结果
        int ans = 0;
        int bound = limit == 1 ? num.charAt(index) - '0' : 9;
        for (int i = 0; i <= bound; i++) {
            if (check[i] != -1) {
                // 如果当前数字需要限制，并且是为边界值，则next需要限制
                int nextLimit = (limit == 1 && i == num.charAt(index) - '0') ? 1 : 0;
                int nextState = (state != 0 || check[i] == 1) ? 1 : 0;
                int dfs = dfs(index + 1, nextLimit, nextState);
                if (dfs!=0){
                    System.out.println("i:"+i+" nextLimit："+limit+" nextState: "+nextState);
                }
                ans+=dfs;
            }
        }
        dp[index][limit][state] = ans;
        return ans;
    }

    public static void main(String[] args) {
        RotatedDigits_M_788 rotatedDigits_m_788 = new RotatedDigits_M_788();
        int ans = rotatedDigits_m_788.rotatedDigits(10);
        System.out.println(ans);
    }

}
