package zyj.yihong.leetcode;

import java.util.Arrays;

/**
 * 两个元素的交集
 * @author yihong
 */
public class Intersection349 {
    /**
     * 排序+双指针：计算两个数的交集
     * @param nums1 数组1
     * @param nums2 数组2
     * @return
     */
    public static int[] intersection(int[] nums1,int[] nums2){
        if (nums1==null || nums1.length==0 || nums2==null || nums2.length == 0){
            return null;
        }
        // 排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int arr1Length = nums1.length;
        int arr2Length = nums2.length;

        int[] retInt = new int[arr1Length-arr2Length>=0?arr2Length:arr1Length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i<arr1Length&&j<arr2Length){
            if (nums1[i]==nums2[j]) {
                if ((k==0 || (nums1[i]!=retInt[k-1]) )) {
                    retInt[k] = nums1[i];
                    i++;
                    j++;
                    k++;
                }else {
                    i++;
                    j++;
                }
            }else if (nums1[i]<nums2[j]){
                i++;
            }else if (nums1[i]>nums2[j]){
                j++;
            }
        }
        retInt = Arrays.copyOfRange(retInt, 0,k );
        return retInt;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7,9};
        int[] arr2 = {2,3,4,5,6,7,8};
        int[] intersection = intersection(arr1, arr2);
        System.out.println(Arrays.toString(intersection));

    }
}
