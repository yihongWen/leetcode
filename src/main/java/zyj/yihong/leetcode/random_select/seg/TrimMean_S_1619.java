package zyj.yihong.leetcode.random_select.seg;

import java.util.Arrays;

// 1619. 删除某些元素后的数组均值
public class TrimMean_S_1619 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        double ans = 0;
        for (int i = arr.length/20; i < (19*arr.length/(double)20); i++) {
            ans+=arr[i];
        }
        return ans/ (arr.length*((double)9/10));
    }
}
