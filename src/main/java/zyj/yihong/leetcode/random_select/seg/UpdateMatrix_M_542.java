package zyj.yihong.leetcode.random_select.seg;


import java.util.LinkedList;
import java.util.Queue;

// 542. 01 矩阵
class UpdateMatrix_M_542 {

    // bfs
    public static int[][] updateMatrix(int[][] mat) {
        int[][] direct = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] ans = new int[mat.length][mat.length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j, 0});
                }
            }
        }

        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                for (int[] d : direct) {
                    int newx = node[0] + d[0];
                    int newy = node[1] + d[1];
                    if (newx >= 0 && newx < mat.length && newy >= 0 && newy < mat[0].length && mat[newx][newy] != 0) {
                        ans[newx][newy] = node[2] + 1;
                        mat[newx][newy] = 0;
                        queue.offer(new int[]{newx, newy, ans[newx][newy]});
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] matrix = updateMatrix(mat);
        System.out.println("------");
    }
}
