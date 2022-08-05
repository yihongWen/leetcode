package zyj.yihong.leetcode.random_select;


/**
 * 807. 保持城市天际线
 */
public class MaxIncreaseKeepingSkyline_M_807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowMax = new int[grid.length];
        int[] colMax = new int[grid.length];

        // 预处理每行每列的最大值
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                int num = grid[i][j];
                if (num>rowMax[i]){
                    rowMax[i] = num;
                }
                if (num>colMax[j]){
                    colMax[j] = num;
                }
            }
        }

        int ans =0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                int num = grid[i][j];
                if (num<rowMax[i]&&num<colMax[j]){
                   ans+=Math.min(rowMax[i],colMax[j])-num;
                }
            }
        }
        return ans;
    }
}
