package zyj.yihong.leetcode.simple.sort;

/**
 * 1051. 高度检查器
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 */
public class HeightChecker1051 {
    public static int heightChecker(int[] heights) {
        // 使用计数排序进行优化：简单的变形
        int[] temp = new int[101];
        int ans = 0;

        for (int height : heights) {
            temp[height]++;
        }

        int heightIndex = 0;
        for (int i = 1; i < temp.length; ++i) {
            for (int j = 1; j <= temp[i]; ++j) {
                if (heights[heightIndex] != i) {
                    ++ans;
                }
                ++heightIndex;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,4,2,1,3};
        int i = heightChecker(arr);
        System.out.println(i);
    }
}
