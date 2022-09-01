package zyj.yihong.leetcode.random_select.seg;

import java.util.LinkedList;
import java.util.Queue;

// 733. 图像渲染
public class FloodFill_S_733 {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // 使用广度优先搜索
        if (image[sr][sc] == color) {
            return image;
        }

        // 定义四个方向
        int[][] direct = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        int originColor = image[sr][sc];

        image[sr][sc] = color;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] d : direct) {
                int nextI = poll[0] + d[0];
                int nextJ = poll[1] + d[1];

                if (nextI >= 0 && nextI < image.length && nextJ >= 0 && nextJ < image[0].length && image[nextI][nextJ] == originColor) {
                    queue.add(new int[]{nextI, nextJ});
                    image[nextI][nextJ] = color;
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
//        用时：0 ms
//输入
//[[1,1,1],[1,1,0],[1,0,1]]
//1
//1
//2
        int[][] arr = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] ints = floodFill(arr, 1, 1, 2);
        System.out.println(ints);
    }
}
