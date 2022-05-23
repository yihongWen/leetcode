package zyj.yihong.leetcode.mid.arr;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. 插入区间
 */
public class Insert57 {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        List<int[]> ans = new ArrayList<>();
        int flag = 0;

        for (int[] interval : intervals) {
            int i = interval[0];
            int j = interval[1];
            if (i>right){

                // 判断是否已经发生过区间合并，并且下一个区间已经越过新的区间合并
                if (flag!=2){
                    ans.add(new int[]{left,right});
                    flag = 2;
                }
                ans.add(interval);
            }else if (j<left){
                ans.add(interval);
            }else {
                left = Math.min(i,left);
                right = Math.max(j,right);
                flag = 1;
            }
        }

        // 处理边界值，如果输入的intervals为空，或者合并发生在最后一个的时候
        if (flag!=2){
            ans.add(new int[]{left,right});
        }


        int[][] ansInt = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            int[] ints = ans.get(i);
            ansInt[i] = ints;
        }

        return ansInt;
    }

    public static void main(String[] args) {
        int[][] arr = {};
        int[] arr1 = {5,7};

        int[][] insert = insert(arr, arr1);
        System.out.println(insert);

    }
}
