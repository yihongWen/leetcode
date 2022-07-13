package zyj.yihong.leetcode.special.top.prefix_sum;

import java.util.Random;

/**
 * 528. 按权重随机选择
 */
public class Solution_M_528 {
    int[] preSum;
    Random random;
    public Solution_M_528(int[] w) {
        preSum = new int[w.length+1];
        for (int i = 0; i < w.length; i++) {
            preSum[i+1] = preSum[i]+w[i];
        }
        random = new Random();
    }

    public int pickIndex() {
        int selectNum = random.nextInt(preSum[preSum.length - 1]);
        int i = binarySearch(selectNum);
        return i-1;
    }

    private int binarySearch(int num){
        int left = 0;
        int right = preSum.length;

        while (left<right){
            int mid = left + ((right - left) >> 1);
            if (preSum[mid]<=num){
                left=mid+1;
            }else {
                right = mid;
            }
        }

        return left;
    }
}
