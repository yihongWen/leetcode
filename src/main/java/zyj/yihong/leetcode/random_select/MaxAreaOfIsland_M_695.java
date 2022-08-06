package zyj.yihong.leetcode.random_select;

// 695. 岛屿的最大面积
public class MaxAreaOfIsland_M_695 {
    // 上下左右
    private int[][] direct = {{1,0},{-1,0},{0,-1},{0,1}};
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==1) {
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid,int i,int j){
        int curArea = 0;
        // 边界条件
        if (i<0 || i>= grid.length || j<0 || j>=grid[0].length || grid[i][j]==0){
            return 0;
        }

        curArea+=1;
        // 标记已经被处理过
        grid[i][j] = 0;

        // 往四个方向搜索
        for (int[] d : direct) {
            int newI = i+d[0];
            int newJ = j+d[1];
            curArea+=dfs(grid,newI,newJ);
        }
        return curArea;
    }
}
