package zyj.yihong.leetcode.random_select.oct;

// 553. 最优除法
// 使用dp一般化计算
public class OptimalDivision_M_553 {
    public String optimalDivision(int[] nums) {

        // dp(i,j)表示子数组的最优除法
        SubNumsNode[][] dp = new SubNumsNode[nums.length][nums.length];

        // 初始化dp
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                dp[i][j] = new SubNumsNode();
            }
        }

        // 单个值的结果
        for (int i = 0; i < nums.length; i++) {
            SubNumsNode subNumsNode = dp[i][i];
            subNumsNode.max  =nums[i];
            subNumsNode.min = nums[i];
            subNumsNode.maxExpress = String.valueOf(nums[i]);
            subNumsNode.minExpress = String.valueOf(nums[i]);
        }

        int n = nums.length;

//        c对角线开始
        for (int i = 1; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                for (int k = j; k < j + i; k++) {
                    if (dp[j][j + i].max < dp[j][k].max / dp[k + 1][j + i].min) {
                        dp[j][j + i].max = dp[j][k].max / dp[k + 1][j + i].min;
                        if (k + 1 == j + i) {
                            dp[j][j + i].maxExpress = dp[j][k].maxExpress + "/" + dp[k + 1][j + i].minExpress;
                        } else {
                            dp[j][j + i].maxExpress = dp[j][k].maxExpress + "/(" + dp[k + 1][j + i].minExpress + ")";
                        }
                    }
                    if (dp[j][j + i].min > dp[j][k].min / dp[k + 1][j + i].max) {
                        dp[j][j + i].min = dp[j][k].min / dp[k + 1][j + i].max;
                        if (k + 1 == j + i) {
                            dp[j][j + i].minExpress = dp[j][k].minExpress + "/" + dp[k + 1][j + i].maxExpress;
                        } else {
                            dp[j][j + i].minExpress = dp[j][k].minExpress + "/(" + dp[k + 1][j + i].maxExpress + ")";
                        }
                    }
                }
            }
        }
        return dp[0][nums.length-1].maxExpress;
    }


    // 子数组的最优化除法
    static class SubNumsNode{
        public double max = 0;
        public double min = 1000;
        public String maxExpress;
        public String minExpress;
    }

    public static void main(String[] args) {
        OptimalDivision_M_553 optimalDivision_m_553 = new OptimalDivision_M_553();
        int[] arr = {1000,100,10,2};
        String s = optimalDivision_m_553.optimalDivision(arr);
        System.out.println(s);
    }

}
