package zyj.yihong.leetcode.random_select.dec;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 939. 最小面积矩形
public class MinAreaRect_M_939 {
    public static int minAreaRect(int[][] points) {
        Set<Integer> set = new HashSet<>();
        for (int[] point : points) {
            set.add(point[0] + 40001 * point[1]);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] aPoint = points[i];
            int ax = aPoint[0];
            int ay = aPoint[1];
            for (int j = i + 1; j < points.length; j++) {
                int[] bPoint = points[j];
                int bx = bPoint[0];
                int by = bPoint[1];

                int cPoint = ax + 40001 * by;
                int dPoint = bx + 40001 * ay;
                if (ax==bx||ay==by){
                    continue;
                }

                if (set.contains(cPoint) && set.contains(dPoint)) {
                    int area = Math.abs(ax - bx) * Math.abs(ay - by);
                    ans = Math.min(ans, area);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    public static void main(String[] args) {
        int[][] arr = {{1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}};
        int i = minAreaRect(arr);
        System.out.println(i);
    }
}
