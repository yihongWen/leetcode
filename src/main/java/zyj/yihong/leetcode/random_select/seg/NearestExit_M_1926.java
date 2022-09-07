package zyj.yihong.leetcode.random_select.seg;


import java.util.LinkedList;
import java.util.Queue;

// 1926. 迷宫中离入口最近的出口
public class NearestExit_M_1926 {
    public static int nearestExit(char[][] maze, int[] entrance) {
        // 使用广度优先搜索
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{entrance[0], entrance[1], 0});

        int[][] directs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        maze[entrance[0]][entrance[1]] = '+';

        while (!queue.isEmpty()) {
            int[] curPoint = queue.poll();
            for (int[] direct : directs) {
                int nextI = curPoint[0] + direct[0];
                int nextJ = curPoint[1] + direct[1];

                if (nextI >= 0 && nextI < maze.length && nextJ >= 0 && nextJ < maze[0].length && maze[nextI][nextJ] == '.') {
                    int distant = curPoint[2] + 1;
                    queue.add(new int[]{nextI, nextJ, distant});
                    if (nextI == 0 || nextJ == 0 || nextI == maze.length-1 || nextJ == maze[0].length-1) {
                        return distant;
                    }
                    maze[nextI][nextJ] = '+';
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        char[][] maze = {{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}};
        int[] entrance = {1, 0};
        int i = nearestExit(maze, entrance);
        System.out.println(i);


    }
}
