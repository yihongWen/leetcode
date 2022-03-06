package zyj.yihong.leetcode.mid.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 你和一群强盗准备打劫银行。给你一个下标从 0 开始的整数数组 security ，其中 security[i] 是第 i 天执勤警卫的数量。日子从 0 开始编号。同时给你一个整数 time 。
 *
 * 如果第 i 天满足以下所有条件，我们称它为一个适合打劫银行的日子：
 *
 * 第 i 天前和后都分别至少有 time 天。
 * 第 i 天前连续 time 天警卫数目都是非递增的。
 * 第 i 天后连续 time 天警卫数目都是非递减的。
 */
public class GoodDaysToRobBank2100 {
    /**
     * 动态规划
     * @param security
     * @param time
     * @return
     */
    public static List<Integer> goodDaysToRobBank(int[] security, int time) {
        // 构造dp数组
        int[] leftGoodDay = new int[security.length];
        int[] rightGoodDay = new int[security.length];

        for (int i = 1; i < security.length; i++) {
            leftGoodDay[i] = security[i]<=security[i-1]?leftGoodDay[i-1]+1:0;
            rightGoodDay[security.length-1-i] =
                    security[security.length-1-i]>security[security.length-i]?0:rightGoodDay[security.length-i]+1;
        }

        // 遍历最佳结果
        List<Integer> retList = new ArrayList<>();
        for (int i = time; i < security.length-time ; i++) {
            if (leftGoodDay[i]>=time && rightGoodDay[i]>=time){
                retList.add(i);
            }
        }
        return retList;
    }

    public static void main(String[] args) {
        int[] arr = {5,3,3,3,5,6,2};
        int time = 2;
        List<Integer> list = goodDaysToRobBank(arr, 2);
        System.out.println(list);
    }
}
