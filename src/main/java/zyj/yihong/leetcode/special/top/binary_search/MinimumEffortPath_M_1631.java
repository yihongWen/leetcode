package zyj.yihong.leetcode.special.top.binary_search;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1631. 最小体力消耗路径
 */
public class MinimumEffortPath_M_1631 {
    public static int minimumEffortPath(int[][] heights) {
        int[][] directs = {{-1,0},{1,0},{0,-1},{0,1}};
        int m = heights.length;
        int n = heights[0].length;
        int ans = 0;
        int left = 0;
        int right =999999;

        while (left<=right){
            int mid = left + ((right - left) >> 1);
            // 使用广度优先搜索判断mid是否符合要求: 二维数组线性化
            boolean[] flag = new boolean[m*n];
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(0);
            flag[0] = true;
            while (!queue.isEmpty()){
                // 对当前的点进行四个方向的遍历
                Integer node = queue.poll();
                for (int[] direct : directs) {
                    int x = node/n;
                    int y = node%n;
                    int nx = x + direct[0];
                    int ny = y + direct[1];

                    // 判断nx、ny是否满足条件
                    if (nx>=0&&nx<m&&ny>=0&&ny<n&&(!flag[nx*n+ny])&&Math.abs(heights[nx][ny]-heights[x][y])<=mid){
                        flag[nx*n+ny] = true;
                        queue.add(nx*n+ny);
                    }
                }
            }

            // 遍历结束，判断（m-1,n-1）是否遍历过
            if (flag[m*n-1]){
                ans = mid;
                right = mid-1;
            }else {
                left=mid+1;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int[][] arr = {{1},{1000000}};
        int i = minimumEffortPath(arr);
        System.out.println(i);
    }
}
