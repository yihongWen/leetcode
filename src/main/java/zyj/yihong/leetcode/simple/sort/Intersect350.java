package zyj.yihong.leetcode.simple.sort;

import java.util.*;

/**
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
 * 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。
 * 可以不考虑输出结果的顺序。
 */
public class Intersect350 {
    /**
     * 使用hash表的方式
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> recordNumMap = new HashMap<>();
        for (int j : nums1) {
            recordNumMap.put(j, recordNumMap.getOrDefault(j, 0) + 1);
        }
        List<Integer> retList = new ArrayList<>();
        for (int i : nums2) {
            if (recordNumMap.containsKey(i)) {
                Integer num = recordNumMap.get(i);
                num--;
                if (num == 0) {
                    recordNumMap.remove(i);
                }else {
                    recordNumMap.put(i,num);
                }
                retList.add(i);
            }
        }
        return retList.stream().mapToInt(Integer::valueOf).toArray();
    }


    /**
     * 排序加双指针
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> retList = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i<nums1.length && j< nums2.length){
            if (nums1[i]==nums2[j]){
                retList.add(nums1[i]);
                i++;
                j++;
            }else if (nums1[i]>nums2[j]){
                j++;
            }else {
                i++;
            }
        }
        return retList.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] intersect = intersect2(nums1, nums2);
        System.out.println(Arrays.toString(intersect));
    }
}
