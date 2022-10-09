package zyj.yihong.leetcode.random_select.oct;

import java.util.Arrays;
import java.util.Comparator;

// 870. 优势洗牌
public class AdvantageCount_M_870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        // 贪心（排序+双指针）
        Arrays.sort(nums1);

        // 对nums2排序（因为nums2是一个对照数组，所以copy,index）
        Integer[] nums2IndexPackArr = new Integer[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            nums2IndexPackArr[i] = i;
        }
        Arrays.sort(nums2IndexPackArr, Comparator.comparingInt(o -> nums2[o]));

        int[] ans = new int[nums1.length];
        int left = 0;
        int right = nums2.length-1;

        for (int a1 : nums1) {
            int a2 = nums2[nums2IndexPackArr[left]];
            if (a1 > a2) {
                ans[nums2IndexPackArr[left]] = a1;
                left++;
            } else {
                ans[nums2IndexPackArr[right]] = a1;
                right--;
            }
        }
        return ans;
    }
}
