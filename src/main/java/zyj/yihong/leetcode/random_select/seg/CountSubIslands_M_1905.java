package zyj.yihong.leetcode.random_select.seg;

// 1905. 统计子岛屿
public class CountSubIslands_M_1905 {
    private boolean flag = true;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int ans = 0;
        // 使用dfs遍历每一个陆地单元格
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j]==1){
                    dfs(grid1,grid2,i,j);
                    if (flag){
                        ans++;
                    }
                    flag = true;
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid1,int[][] grid2,int i,int j){
        // 边界条件
        if (i<0||j<0||i>=grid2.length||j>=grid2[0].length||grid2[i][j]==0){
            return;
        }

        if (flag&&grid1[i][j]!=grid2[i][j]){
            flag = false;
        }
        grid2[i][j] = 0;
        dfs(grid1,grid2,i,j+1);
        dfs(grid1,grid2,i,j-1);
        dfs(grid1,grid2,i+1,j);
        dfs(grid1,grid2,i-1,j);

    }
}
