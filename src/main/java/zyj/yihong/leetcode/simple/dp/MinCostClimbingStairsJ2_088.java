package zyj.yihong.leetcode.simple.dp;

/**
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 *
 * 每当爬上一个阶梯都要花费对应的体力值，一旦支付了相应的体力值，就可以选择向上爬一个阶梯或者爬两个阶梯。
 *
 * 请找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/GzCJIP
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinCostClimbingStairsJ2_088 {
    // cost.length>=2
    public static int minCostClimbingStairs(int[] cost) {

        int pre1Cost = 0;
        int pre2Cost = 0;
        for (int i = 2; i < cost.length; i++) {
            int curCost = Math.min(pre2Cost+cost[i-2],pre1Cost+cost[i-1]);
            pre2Cost = pre1Cost;
            pre1Cost = curCost;
        }
        return Math.min(pre1Cost+cost[cost.length-1],pre2Cost+cost[cost.length-2]);
    }

    public int numWays(int n) {
        int preSte1 = 1;
        int preSte2 = 1;
        for (int i = 2; i <= n ; i++) {
            int curCount = (preSte1+preSte2) % 1000000007;
            preSte2 = preSte1;
            preSte1 =curCount;
        }
        return preSte1;
    }


    public static void main(String[] args) {
        int[] arr = {10,15,20};
        int i = minCostClimbingStairs(arr);
        System.out.println(i);
    }
}
