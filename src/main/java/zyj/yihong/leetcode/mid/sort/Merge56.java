package zyj.yihong.leetcode.mid.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Merge56 {

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return null;
        }
        // 使用list可以不用int[][]在编译期就确定大小
        List<int[]> retValue = new ArrayList<>();

        // 排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];

            // 断层
            if (retValue.size() == 0 || left > retValue.get(retValue.size()-1)[1]) {
                retValue.add(new int[]{left,right});
            } else if (left <= retValue.get(retValue.size()-1)[1] && right > retValue.get(retValue.size()-1)[1]) {
                // 合并
                retValue.get(retValue.size()-1)[1] = right;
            }
        }

        // 将list转换为int[]
        return retValue.toArray(new int[retValue.size()][]);
    }

    public static void main(String[] args) {
        int[][] testArrays = {{1, 4}, {5, 6}};
        int[][] merge = merge(testArrays);
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
