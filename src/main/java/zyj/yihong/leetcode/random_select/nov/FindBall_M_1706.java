package zyj.yihong.leetcode.random_select.nov;

import java.util.Arrays;

public class FindBall_M_1706 {
    public static int[] findBall(int[][] grid) {
        int[] ans = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            int curPosition = i;
            for (int[] curLevel : grid) {
                int direct = curLevel[curPosition];
                curPosition = curPosition + curLevel[curPosition];
                if (curPosition < 0 || curPosition >= grid[0].length || curLevel[curPosition] != direct) {
                    curPosition = -1;
                    break;
                }
            }
            ans[i] = curPosition;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}};
        int[] ball = findBall(grid);
        System.out.println(Arrays.toString(ball));
    }
}
