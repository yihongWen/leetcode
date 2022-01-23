package zyj.yihong.leetcode.mid;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 */
public class NumIslands200 {

    /**
     * 深度优先搜索（depth first search）
     * @param grid 二维数组
     * @param oneIndex 当前位置 纵向
     * @param twoIndex 当前位置 横向
     */
    static void dfs(char[][] grid, int oneIndex, int twoIndex) {
        // 判断当前边界值是否有效
        if (oneIndex<0 || twoIndex<0 || oneIndex>= grid.length || twoIndex>=grid[0].length || grid[oneIndex][twoIndex]=='0'){
            return;
        }

        // 将当前节点标记为0
        grid[oneIndex][twoIndex] = '0';

        // 深度搜索
        dfs(grid,oneIndex-1,twoIndex);
        dfs(grid,oneIndex,twoIndex-1);
        dfs(grid,oneIndex+1,twoIndex);
        dfs(grid,oneIndex,twoIndex+1);

    }


    /**
     *
     * @param grid 二维数组
     * @return 岛屿数量
     */
    public static int numIslands(char[][] grid) {
        if (grid==null || grid.length==0){
            return 0;
        }

        int landsNums = 0;

        // 遍历
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]=='1'){
                    landsNums++;
                    dfs(grid,i,j);
                }
            }
        }

        return landsNums;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }

}
