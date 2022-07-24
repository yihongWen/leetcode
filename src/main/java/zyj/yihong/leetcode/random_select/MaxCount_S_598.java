package zyj.yihong.leetcode.random_select;

/**
 * 给你一个 m x n 的矩阵 M ，初始化时所有的 0 和一个操作数组 op ，其中 ops[i] = [ai, bi] 意味着当所有的 0 <= x < ai 和 0 <= y < bi 时， M[x][y] 应该加 1。
 *
 * 在 执行完所有操作后 ，计算并返回 矩阵中最大整数的个数 。
 */
public class MaxCount_S_598 {
    public int maxCount(int m, int n, int[][] ops) {
        // 每次操作左上角位置的值一定会加一
        int minX = m;
        int minY = n;
        for (int i = 0; i < ops.length; i++) {
            int[] op = ops[i];
            minX = Math.min(op[0],minX);
            minY = Math.min(op[1],minY);
        }
        return minX*minY;
    }
}
