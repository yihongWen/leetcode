package zyj.yihong.leetcode.simple.arr;


/**
 * 883. 三维形体投影面积
 */
public class ProjectionArea883 {
    public static int projectionArea(int[][] grid) {
        int area = 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            int culRowMax = 0;
            int culColMax = 0;
            for (int j = 0; j < grid[i].length; j++) {
                culRowMax = Math.max(culRowMax,grid[i][j]);
                culColMax = Math.max(culColMax,grid[j][i]);
                count+=grid[i][j]>0?1:0;
            }
            area+=culRowMax;
            area+=culColMax;
        }
        area+= count;
        return area;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,0},{0,2}};
        int area = projectionArea(arr);
        System.out.println(area);
    }
}
