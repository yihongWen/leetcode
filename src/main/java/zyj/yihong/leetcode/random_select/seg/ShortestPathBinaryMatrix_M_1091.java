package zyj.yihong.leetcode.random_select.seg;

import java.util.LinkedList;
import java.util.Queue;

// 1091. 二进制矩阵中的最短路径
public class ShortestPathBinaryMatrix_M_1091 {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int ans = -1;
        if (grid[0][0] == 1) {
            return ans;
        }
        int[][] directs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0, 1});

        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                if (node[0] == grid.length - 1 && node[1] == grid[0].length - 1) {
                    return node[2];
                }
                for (int[] direct : directs) {
                    int newx = node[0] + direct[0];
                    int newy = node[1] + direct[1];
                    if (newx >= 0 && newx < grid.length && newy >= 0 && newy < grid[0].length && grid[newx][newy] == 0) {
                        int path = node[2] + 1;
                        if (newx == grid.length - 1 && newy == grid[0].length - 1) {
                            return path;
                        }
                        grid[newx][newy] = 1;
                        queue.offer(new int[]{newx, newy, path});
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0}};
        int path = shortestPathBinaryMatrix(grid);
        System.out.println(path);
    }
}
