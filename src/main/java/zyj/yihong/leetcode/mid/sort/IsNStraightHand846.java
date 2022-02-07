package zyj.yihong.leetcode.mid.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
 *
 * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
 */
public class IsNStraightHand846 {

    /**
     *
     * @param hand 牌
     * @param groupSize 分组大小
     * @return
     */
    public static boolean isNStraightHand(int[] hand, int groupSize) {

        // 判断是否能够完成数量上的分组
        if (hand.length%groupSize!=0){
            return false;
        }

        // 排序
        Arrays.sort(hand);

        // k -number  v-numberSize
        Map<Integer,Integer> recordMap = new HashMap<>();
        for (int num : hand) {
            recordMap.put(num,recordMap.getOrDefault(num,0)+1);
        }

        for (int num : hand) {
            // 排除当前已经过滤掉的
            if (!recordMap.containsKey(num)){
                continue;
            }

            // 计算当前值为最小开始的连续分组是否存在
            int endValue = num+groupSize-1;
            for (int i = num; i <= endValue ; i++) {
                if (!recordMap.containsKey(i)){
                    return false;
                }else {
                    recordMap.put(i,recordMap.get(i)-1);
                }

                // 如果key对应的值为0，也就是个数为0，则移除
                if(recordMap.get(i)==0){
                    recordMap.remove(i);
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] testArr = {1,2,3,6,2,3,4,7,8};
        boolean ret = isNStraightHand(testArr, 3);
        System.out.println(ret);
    }
}
