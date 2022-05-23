package zyj.yihong.leetcode.mid.binary_search;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 436. 寻找右区间
 * 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
 *
 * 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。
 *
 * 返回一个由每个区间 i 的 右侧区间 的最小起始位置组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-right-interval
 */
public class FindRightInterval436 {
    public static int[] findRightInterval(int[][] intervals) {
        // 构造用于二分查的数组
        int[][] firstValueIndexArr = new int[intervals.length][2];
        for (int i = 0; i < intervals.length; i++) {
            firstValueIndexArr[i][0] = intervals[i][0];
            firstValueIndexArr[i][1] = i;
        }

        // 排序
        Arrays.sort(firstValueIndexArr,((o1, o2) -> o1[0]-o2[0]));
        int[] ans = new int[intervals.length];

        // 遍历处理每一个结果
        for (int i = 0; i < intervals.length; i++) {
            int left = 0;
            int right = intervals.length-1;
            int handleValue = intervals[i][1];
            int curAns = -1;
            while (left<=right){
                int mid = (right-left)/2+left;
                int compareValue = firstValueIndexArr[mid][0];
                if (compareValue>=handleValue){
                    right = mid-1;
                    curAns = firstValueIndexArr[mid][1];
                }else {
                    left=mid+1;
                }
            }
            ans[i] = curAns;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = {{3,4},{2,3},{1,2}};
        int[] rightInterval = findRightInterval(intervals);
        System.out.println(Arrays.toString(rightInterval));

    }
}
