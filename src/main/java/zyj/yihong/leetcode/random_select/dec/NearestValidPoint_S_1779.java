package zyj.yihong.leetcode.random_select.dec;

// 1779. 找到最近的有相同 X 或 Y 坐标的点
public class NearestValidPoint_S_1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int cx = point[0];
            int cy = point[1];
            if (cx != x && cy != y) {
                continue;
            }

            int dis = Math.abs(cx - x) + Math.abs(cy - y);
            if (dis < min) {
                min = dis;
                minIndex = i;
            }
        }
        return minIndex;
    }
}
