package zyj.yihong.leetcode.random_select.oct;

import java.util.Arrays;
import java.util.Comparator;

// 435. 无重叠区间
public class EraseOverlapIntervals_M_435 {

    // dp的方式会超出时间限制
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2)->{
            int num1 = o1[0];
            int num2 = o2[0];
            return num1-num2;
        });

        int[] dp = new int[intervals.length];
        Arrays.fill(dp,1);
        int max = 1;

        for (int i = 1; i < intervals.length; i++) {
            int[] curNode = intervals[i];
            for (int j = 0; j < i; j++) {
                int[] preNode = intervals[j];
                if (curNode[0]>=preNode[1]){
                    int curMax = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(curMax,max);
                    dp[i] = curMax;
                }
            }
        }
        return intervals.length-max;
    }


    // 使用贪心的思路
    public static int eraseOverlapIntervals1(int[][] intervals) {
        if (intervals.length==0){
            return 0;
        }
        int max = 1;
        Arrays.sort(intervals,(Comparator.comparingInt(o -> o[1])));
        int rightEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0]>=rightEnd){
                max++;
                rightEnd = intervals[i][1];
            }
        }

        return intervals.length-max;
    }



    public static void main(String[] args) {
        int[][] arr = {{1,2},{2,3},{3,4},{1,3}};
        int count = eraseOverlapIntervals(arr);
        System.out.println(count);

    }
}


