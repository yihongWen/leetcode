package zyj.yihong.leetcode.mid.graph;

import java.util.LinkedList;
import java.util.Queue;

public class MovingCount_J13 {
    private boolean[][] visited;
    private int k;
    private int ans = 0;
    public int movingCount(int m, int n, int k) {
        // 初始化
        this.visited = new boolean[m][n];
        this.k = k;
        return dfs(0,0,0,0,k);
    }

    private int dfs(int i,int j,int sumI,int sumJ,int k){
        // 退出的条件
        if (i<0||i>=visited.length||j<0||j>=visited[0].length||visited[i][j]||(sumI+sumJ)>k){
            return 0;
        }

        // 满足条件
        ans++;
        visited[i][j] = true;

        // 深度搜索
        int nextI = i+1;
        int nextJ = j+1;
        int sumNextI = getSum(nextI);
        int sumNextJ = getSum(nextJ);

        dfs(nextI, j, sumNextI, sumJ, this.k);
        dfs(i, nextJ, sumI, sumNextJ, this.k);
        return ans;

    }

    private int getSum(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        MovingCount_J13 movingCount_j13 = new MovingCount_J13();
        int count = movingCount_j13.movingCount(3, 16, 2);
        System.out.println(count);
    }


    public static int movingCount1(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        // 向右和向下的方向数组
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] vis = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        vis[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; ++i) {
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || get(tx) + get(ty) > k) {
                    continue;
                }
                queue.offer(new int[]{tx, ty});
                vis[tx][ty] = true;
                ans++;
            }
        }
        return ans;
    }

    private static int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }


}
