package zyj.yihong.leetcode.random_select.dec;

import java.util.Arrays;

// 1774. 最接近目标价格的甜点成本
public class ClosestCost_M_1744 {
    private int target;
    private int[] toppingCosts;
    int ans = 0;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        this.toppingCosts = toppingCosts;
        this.target = target;

        // 选择基料中最小的值，此时只能在target的最左侧，或者在最靠近target的右侧，在这个范围内选择配料
        int min = Arrays.stream(baseCosts).min().getAsInt();
        ans = min;

        for (int baseCost : baseCosts) {
            dfs(0, baseCost, 0);
        }
        return ans;
    }

    private void dfs(int toppingIndex, int curCost, int select) {
        System.out.printf("index:%d 、curCost:%d 、select:%d%n", toppingIndex, curCost, select);
        if (curCost - target > Math.abs(ans - target)) {
            return;
        } else {
            if ((Math.abs(curCost - target) == Math.abs(ans - target) && curCost - target < ans - target) || Math.abs(curCost - target) < Math.abs(ans - target)) {
                ans = curCost;
            }
        }

        if (toppingIndex == toppingCosts.length) {
            return;
        }

        dfs(toppingIndex + 1, curCost, 0);
        dfs(toppingIndex + 1, curCost + toppingCosts[toppingIndex], 1);
        dfs(toppingIndex + 1, curCost + toppingCosts[toppingIndex] * 2, 2);
    }


    public int closestCostV1(int[] baseCosts, int[] toppingCosts, int target) {
        // 将dfs的形式写成三进制状态枚举
        int[] preStateSum = new int[toppingCosts.length + 1];
        preStateSum[0] = 1;
        for (int i = 1; i < preStateSum.length; i++) {
            preStateSum[i] = preStateSum[i - 1] * 3;
        }

        int allStateCount = preStateSum[preStateSum.length - 1];
        int ans = Arrays.stream(baseCosts).min().getAsInt();
        for (int baseCost : baseCosts) {
            for (int i = 0; i < allStateCount; i++) {
                // 判断当前状态下，配料i是否需要选择
                int selectCurCost = baseCost;
                for (int j = 0; j < toppingCosts.length; j++) {
                    int selectCount = i / preStateSum[j] % 3;
                    selectCurCost += toppingCosts[j] * selectCount;
                    // 这里还可以继续优化 范围限定在当前ans跟target所在的区间
                    if (selectCurCost >= target) {
                        break;
                    }
                }

                // 当前状态跟target之间的关系
                if ((Math.abs(selectCurCost - target) < Math.abs(ans - target)) || (Math.abs(selectCurCost - target) == Math.abs(ans - target) && selectCurCost - target < ans - target)) {
                    ans = selectCurCost;
                }
            }
        }

        return ans;
    }


    public int closestCostDp(int[] baseCosts, int[] toppingCosts, int target) {
        int min = Arrays.stream(baseCosts).min().getAsInt();
        if (min>=target){
            return min;
        }

        // 使用dp,根据题意定义dp数组的大小：1 <= baseCosts[i], toppingCosts[i] <= pow(10,4)  1 <= target <= pow(10,4)
        int size = (target-min)*2+1+min;
        boolean[] dp = new boolean[size];

        // 用baseCost初始化dp
        for (int i = 0; i < baseCosts.length; i++) {
            if (baseCosts[i]>=dp.length){
                continue;
            }
            dp[baseCosts[i]] = true;
        }

        // 计算dp： dp(j) = dp(j-t(i))
        for (int i = 0; i < toppingCosts.length * 2; i++) {
            for (int k = size-1; k >= 0; k--) {
                if (dp[k]) {
                    continue;
                }

                if (k >= toppingCosts[i / 2] && dp[k - toppingCosts[i / 2]]) {
                    dp[k] = true;
                }

            }
        }

        for (int i = 0; i <= target-min; i++) {
            if (i <= target && dp[target - i]) {
                return target - i;
            }

            // 右侧
            if (dp[target + i]) {
                return target + i;
            }
        }
        return min;
    }


    public static void main(String[] args) {
        ClosestCost_M_1744 closestCost_m_1744 = new ClosestCost_M_1744();
        int[] a = {1,10,10};
        int[] b = {7,5,1,1,1};
        int target = 5;
        int i = closestCost_m_1744.closestCostDp(a, b, target);
        System.out.println(i);

    }
}
