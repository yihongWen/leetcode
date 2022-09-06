package zyj.yihong.leetcode.random_select.seg;

// 1020. 飞地的数量
public class NumEnclaves_M_1020 {

    public int numEnclaves(int[][] grid) {
        // 依次对周围的每隔单元格进行dfs，没有遍历到的单元格数量就是飞地的数量
        for (int i = 0; i < grid.length; i++) {
            dfs(grid,i,0);
            dfs(grid,i,grid[0].length-1);
        }

        for (int i = 1; i < grid[0].length-1; i++) {
            dfs(grid,0,i);
            dfs(grid,grid.length-1,i);
        }

        int ans = 0;
        for (int i = 1; i < grid.length-1; i++) {
            for (int j = 1; j < grid[0].length-1; j++) {
                if (grid[i][j]==1){
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid,int i,int j){
        // 边界条件
        if (i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0){
            return;
        }

        grid[i][j] = 0;

        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
    }
}
