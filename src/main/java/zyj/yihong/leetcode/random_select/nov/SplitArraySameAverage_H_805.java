package zyj.yihong.leetcode.random_select.nov;

import java.util.HashSet;
import java.util.Set;

// 805. 数组的均值分割
public class SplitArraySameAverage_H_805 {
    public boolean splitArraySameAverage(int[] nums) {
        // 二进制枚举+折半

        // 特殊情况处理
        if (nums==null || nums.length<2){
            return false;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }

        // 将nums中的每个值减去平均值（除法导致浮点数特殊处理）
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums.length*nums[i]-sum;
        }

        // 左侧
        Set<Integer> leftSet = new HashSet<>();
        int halfSize = nums.length/2;
        // 枚举每一种情况
        for (int i = 1; i < (1<<halfSize); i++) {
            int subSum = 0;
            // 将选择的计算到当前总和
            for (int j = 0; j < halfSize; j++) {
                if ((i&(1<<j))!=0){
                    subSum+=nums[j];
                }
            }

            if (subSum==0){
                return true;
            }

            leftSet.add(subSum);
        }


        // 右侧
        int rSum = 0;
        for (int i = halfSize; i < nums.length ; i++) {
            rSum+=nums[i];
        }

        // 枚举每一种情况
        for (int i = 1; i < (1<< (nums.length-halfSize)); i++) {
            int subSum = 0;
            // 将选择的计算到当前总和
            for (int j = halfSize; j < nums.length; j++) {
                if ((i&(1<<(j-halfSize)))!=0){
                    subSum+=nums[j];
                }
            }

            if (subSum==0 || (subSum!=rSum&&leftSet.contains(-subSum))){
                return true;
            }
        }

        return false;

    }
}
