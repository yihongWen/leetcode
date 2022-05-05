package zyj.yihong.leetcode.mid.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 *
 */
public class FourSumCount454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i1 : nums1) {
            for (int i2 : nums2) {
                map.put(i1+i2,map.getOrDefault(i1+i2,0)+1);
            }
        }

        for (int i3 : nums3) {
            for (int i4 : nums4) {
                if (map.containsKey(-(i3+i4))){
                    count+= map.get(-(i3+i4));
                }
            }
        }

        return count;
    }
}
