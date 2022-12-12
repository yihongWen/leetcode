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
                    if (selectCurCost>=target ){
                        break;
                    }
                }

                // 当前状态跟target之间的关系
                if ((Math.abs(selectCurCost - target) < Math.abs(ans - target)) || ( Math.abs(selectCurCost-target)==Math.abs(ans-target) && selectCurCost - target < ans - target)) {
                    ans = selectCurCost;
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        ClosestCost_M_1744 closestCost_m_1744 = new ClosestCost_M_1744();
        int[] a = {3,2};
        int[] b = {3};
        int target = 10;
        int i = closestCost_m_1744.closestCostV1(a, b, target);
        System.out.println(i);

    }
}
