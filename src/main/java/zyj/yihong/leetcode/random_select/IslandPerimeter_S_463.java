package zyj.yihong.leetcode.random_select;

/**
 * 463. 岛屿的周长
 */
public class IslandPerimeter_S_463 {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        int[][] directs = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==0){
                    continue;
                }

                for (int[] curDirect : directs) {
                    int x = curDirect[0];
                    int y = curDirect[1];
                    int nextI = i + x;
                    int nextJ = j + y;
                    if (nextI<0 || nextI>= grid.length || nextJ<0 || nextJ>=grid[0].length || grid[nextI][nextJ]==0){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
