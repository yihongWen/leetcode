package zyj.yihong.leetcode.simple.arr;

/**
 * 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
 */
public class LargestTriangleArea812 {
    public double largestTriangleArea(int[][] points) {
        // 枚举遍历
        double max = 0;
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i+1; j < points.length-1; j++) {
                for (int k = j+1; k < points.length ; k++) {
                    int[] pi = points[i];
                    int[] pj = points[j];
                    int[] pk = points[k];
                    double ans = 0.5*Math.abs((pj[0]-pi[0])*(pk[1]-pi[1])-(pk[0]-pi[0])*(pj[1]-pi[1]));
                    max = Math.max(ans,max);
                }
            }
        }
        return max;
    }

}
