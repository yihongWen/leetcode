package zyj.yihong.leetcode.special.top.binary_search;

import java.util.Arrays;
import java.util.Random;

/**
 * 前缀和+二分
 * 其中 rects[i] = [ai, bi, xi, yi] 表示 (ai, bi) 是第 i 个矩形的左下角点，(xi, yi) 是第 i 个矩形的右上角点。
 *
 */
public class Pick_M_497 {
    private int[] preSum;
    private int[][] rects;
    private Random random = new Random();
    public Pick_M_497(int[][] rects) {
        // 计算前缀和
        this.rects = rects;
        preSum = new int[rects.length+1];

        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            preSum[i+1] = preSum[i]+(rect[2]-rect[0]+1)*(rect[3]-rect[1]+1);
        }
    }

    public int[] pick() {
        // 在总面积选择一个数(1-all)，确定矩形所在位置
        int selectArea = random.nextInt(preSum[preSum.length - 1]) + 1;

        // 通过二分查找，找到所在的矩形
        int left = 0;
        int right = preSum.length-1;
        while (left<right){
            int mid = left + ((right - left) >> 1);
            if (preSum[mid]>=selectArea){
                right=mid;
            }else if (preSum[mid]<selectArea){
                left = mid+1;
            }
        }

        int[] select = rects[right - 1];
        int pointX = random.nextInt(select[2] - select[0] + 1) + select[0];
        int pointY = random.nextInt(select[3] - select[1] + 1) + select[1];
        return new int[]{pointX,pointY};
    }

    public static void main(String[] args) {
        int[][] arr  = {{-2, -2, 1, 1}, {2, 2, 4, 6}};
        Pick_M_497 pick_m_497 = new Pick_M_497(arr);
        int[] pick = pick_m_497.pick();
        System.out.println(Arrays.toString(pick));
    }
}