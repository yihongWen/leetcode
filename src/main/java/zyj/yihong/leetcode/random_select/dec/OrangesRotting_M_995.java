package zyj.yihong.leetcode.random_select.dec;

import java.util.LinkedList;
import java.util.Queue;

// 994. 腐烂的橘子
public class OrangesRotting_M_995 {
    public static int orangesRotting(int[][] grid) {
        // bfs，初始化将所有腐烂的添加到队列
        boolean emp = true;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==2){
                    queue.add(i*grid[0].length+j);
                }
                if (grid[i][j]==1){
                    emp = false;
                }
            }
        }

        if (queue.size()==0){
            if (!emp){
                return -1;
            }
            return 0;
        }



        // 搜索
        int[][] dirArr = {{-1,0},{1,0},{0,-1},{0,1}};
        int ans = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                int indexI = poll / grid[0].length;
                int indexJ = poll % grid[0].length;
                for (int[] dir : dirArr) {
                    int x = indexI+dir[0];
                    int y = indexJ+dir[1];
                    if (x>=0&&x<grid.length&&y>=0&&y<grid[0].length&&grid[x][y]==1){
                        queue.add(x*grid[0].length+y);
                        grid[x][y] = 2;
                    }
                }
                grid[indexI][indexJ] = 3;
            }
            ans++;
        }
        ans--;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==1){
                    return -1;
                }
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1}};
        int orangesRotting = orangesRotting(arr);
        System.out.println(orangesRotting);
    }
}
