package zyj.yihong.leetcode.random_select.seg;

// 1254. 统计封闭岛屿的数目

/**
 * 二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。
 *
 * 请返回 封闭岛屿 的数目。
 */
public class ClosedIsland_M_1254 {
    public int closedIsland(int[][] grid){
        int ans = 0;
        // 遍历每一个陆地，对其进行dfs，判断是否是内陆
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==0&&dfs(grid,i,j)){
                    ans++;
                }
            }
        }

        return ans;
    }

    private boolean dfs(int[][] grid, int i,int j){
        // 如果是越出边界，则不是
        if (i<0||i>=grid.length||j<0||j>=grid[0].length){
            return false;
        }

        // 当前为水
        if (grid[i][j]==1){
            return true;
        }

        // 对当前访问过的节点进行标记,防止其邻居对其处理（传递）
        grid[i][j] = 1;

        // 如果当前不是为水，那么需要对4个方向都进行满足
        return dfs(grid,i+1,j)&dfs(grid,i-1,j)&dfs(grid,i,j+1)&dfs(grid,i,j-1);
    }

    public static void main(String[] args) {
    }
}
