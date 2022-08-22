package zyj.yihong.leetcode.random_select.aug;

import java.util.Arrays;
import java.util.Comparator;

// 452. 用最少数量的箭引爆气球
public class FindMinArrowShots_M_452 {
    public static int findMinArrowShots(int[][] points) {
        // 根据右边界排序
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        // 贪心策略
        int ans = 1;
        int curPoint = points[0][1];
        for (int[] point : points) {
            if (point[0]>curPoint){
                ans++;
                curPoint = point[1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2},{3,4},{5,6},{7,8}};
        int minArrowShots = findMinArrowShots(arr);
        System.out.println(minArrowShots);

    }
}
