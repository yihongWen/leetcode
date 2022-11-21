package zyj.yihong.leetcode.random_select.nov;

import java.util.Arrays;

// 1710. 卡车上的最大单元数
public class MaximumUnits_S_1710 {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> {
            return o2[1] - o1[1];
        });

        int ans = 0;
        int curSize = 0;

        for (int[] box : boxTypes) {
            int addNum = curSize + box[0] <= truckSize ? box[0] : truckSize - curSize;
            ans += addNum * box[1];
            curSize+=addNum;

            if (curSize==truckSize){
                break;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] boxType = {{1,3},{2,2},{3,1}};
        int truckSize = 4;
        int i = maximumUnits(boxType, truckSize);
        System.out.println(i);
    }
}
